package com.jee.fp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.jee.fp.domain.Jadwal;
import com.jee.fp.domain.Transaksi;
import com.jee.fp.repository.JadwalRepository;

@Controller
@SessionAttributes("transaksiObj")
public class JadwalController {

	@Autowired
	private JadwalRepository jadwalRepository;
	private int kuota;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("jadwals", this.jadwalRepository.getData());
		mv.addObject("jadwalBean", new Jadwal());
		mv.addObject("kotaList", this.jadwalRepository.getKota());
		return mv;
	}

	@RequestMapping(value = "/filterjadwal", method = RequestMethod.POST)
	public ModelAndView filterJadwal(@ModelAttribute Jadwal jadwal) {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("jadwalBean", new Jadwal());
		mv.addObject("kotaList", this.jadwalRepository.getKota());
		mv.addObject("jadwals",
				this.jadwalRepository.getData(null, null, null, 0));
		this.kuota = jadwal.getKuota();
		return mv;
	}

	@RequestMapping(value = "/book/{jadwalId}")
	public ModelAndView bookJadwal(@PathVariable("jadwalId") int jadwalId) {
		ModelAndView mv = new ModelAndView("book");
		mv.addObject("jadwalBean", this.jadwalRepository.getData(jadwalId));
		mv.addObject("transaksiBean",
				new Transaksi(this.jadwalRepository.getData(jadwalId), kuota));
		mv.addObject("kuotaText", kuota);
		return mv;
	}

	@RequestMapping(value = "/book/bookNow")
	public ModelAndView bookTransaksi(@ModelAttribute Transaksi transaksi) {
		ModelAndView mv = new ModelAndView("user");

		SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyy HH:mm");
		Date time1 = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(time1);
		cal.add(Calendar.HOUR_OF_DAY, 1);
		time1 = cal.getTime();
		transaksi.setBatas(parser.format(time1));
		mv.addObject("transaksiBean", transaksi);
		mv.addObject("transaksiObj", transaksi);
		return mv;
	}

	@RequestMapping(value = "/book/batal")
	public ModelAndView batalTransaksi() {
		ModelAndView mv = new ModelAndView("user");
		mv.addObject("transaksiBean", new Transaksi());
		return mv;
	}

	@RequestMapping(value = "/jadwal")
	public ModelAndView bookJadwal() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jadwal");
		mv.addObject("jadwals", this.jadwalRepository.getData());
		mv.addObject("jadwalBean", new Jadwal());
		mv.addObject("kotaList", this.jadwalRepository.getKota());
		return mv;
	}

	@RequestMapping(value = "/jadwal/tambah", method = RequestMethod.POST)
	public ModelAndView tambahJadwal(@ModelAttribute Jadwal jadwal) {
		ModelAndView mv = new ModelAndView("redirect:/jadwal");
		this.jadwalRepository.tambah(jadwal);
		return mv;
	}

	@RequestMapping(value = "/jadwal/hapus/{jadwalId}")
	public ModelAndView hapusJadwal(@PathVariable("jadwalId") int jadwalId) {
		ModelAndView mv = new ModelAndView("redirect:/jadwal");
		this.jadwalRepository.hapus(jadwalId);
		return mv;
	}
}
