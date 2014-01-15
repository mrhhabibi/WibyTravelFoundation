package com.jee.fp;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.jee.fp.domain.Anggota;
import com.jee.fp.domain.Booking;
import com.jee.fp.domain.Jadwal;
import com.jee.fp.repository.AnggotaRepository;
import com.jee.fp.repository.BankRepository;
import com.jee.fp.repository.BookingRepository;
import com.jee.fp.repository.JadwalRepository;
import com.jee.fp.repository.TransaksiRepository;

@Controller
@SessionAttributes("anggotaObj")
public class AnggotaController {

	@Autowired
	private AnggotaRepository anggotaRepository;
	@Autowired
	private JadwalRepository jadwalRepository;
	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	private TransaksiRepository transaksiRepository;
	@Autowired
	private BankRepository bankRepository;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginAnggota() {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("anggotaBean", new Anggota());
		return mv;
	}

	@RequestMapping(value = "/anggota", method = RequestMethod.GET)
	public ModelAndView manageAnggota() {
		ModelAndView mv = new ModelAndView("anggota");
		mv.addObject("anggotas", this.anggotaRepository.getData());
		return mv;
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(@ModelAttribute Anggota anggota) {
		ModelAndView mv = new ModelAndView();
		Anggota temp = anggotaRepository.login(anggota);
		if (temp != null) {
			mv.addObject("anggotaObj", temp);
			if (temp.getTipe() == "user") {
				mv.setViewName("redirect:/user");
			} else {
				mv.setViewName("redirect:/");
				mv.addObject("jadwalBean", new Jadwal());
			}
		} else {
			mv.setViewName("login");
			mv.addObject("anggotaBean", new Anggota());
		}
		return mv;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registerAnggota() {
		ModelAndView mv = new ModelAndView("register");
		mv.addObject("anggotaBean", new Anggota());
		return mv;
	}

	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	public ModelAndView registerProcess(@ModelAttribute Anggota anggota) {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("anggotaBean", new Anggota());
		this.anggotaRepository.tambah(anggota);
		return mv;
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ModelAndView userProfile(
			@ModelAttribute("anggotaObj") Anggota anggota) {
		ModelAndView mv = new ModelAndView("user");
		mv.addObject("bookingBean",
				this.bookingRepository.getData(anggota.getEmail()));
		mv.addObject("transaksis",this.transaksiRepository.getHistory(anggota.getEmail()));
		return mv;
	}

	@RequestMapping(value = "/logout")
	public ModelAndView logoutProcess() {
		ModelAndView mv = new ModelAndView("redirect:/");
		mv.addObject("anggotaObj", new Anggota());
		mv.addObject("jadwalBean", new Jadwal());
		return mv;
	}

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
		return mv;
	}

	@RequestMapping(value = "/book/{jadwalId}", method = RequestMethod.GET)
	public ModelAndView bookJadwal(@PathVariable("jadwalId") int jadwalId) {
		ModelAndView mv = new ModelAndView("book");
		mv.addObject("jadwalBean", this.jadwalRepository.getData(jadwalId));
		mv.addObject("bookingBean",
				new Booking(null, this.jadwalRepository.getData(jadwalId), "",
						"", "", 2));
		return mv;
	}

	@RequestMapping(value = "/book/bookNow")
	public ModelAndView bookTransaksi(
			@ModelAttribute("anggotaObj") Anggota anggota,
			@ModelAttribute Booking booking) {
		ModelAndView mv = new ModelAndView("redirect:/user");

		SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyy HH:mm");
		Date time1 = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(time1);
		cal.add(Calendar.HOUR_OF_DAY, 1);
		time1 = cal.getTime();
		booking.setBatas(parser.format(time1));
		booking.setAnggota(anggota);
		this.bookingRepository.tambah(booking);
		mv.addObject("bookingBean",
				this.bookingRepository.getData(anggota.getEmail()));
		return mv;
	}

	@RequestMapping(value = "/book/konfirmasi")
	public ModelAndView konfirmasiTransaksi(
			@ModelAttribute("anggotaObj") Anggota anggota) {
		ModelAndView mv = new ModelAndView("redirect:/user");
		if (this.bankRepository.validate(this.bookingRepository.getData(anggota
				.getEmail())) == true)
			this.bookingRepository.hapus(anggota.getEmail());
		mv.addObject("transaksiBean",
				this.bookingRepository.getData(anggota.getEmail()));
		return mv;
	}

	@RequestMapping(value = "/book/batal")
	public ModelAndView batalTransaksi(
			@ModelAttribute("anggotaObj") Anggota anggota) {
		ModelAndView mv = new ModelAndView("redirect:/user");
		this.bookingRepository.hapus(anggota.getEmail());
		mv.addObject("transaksiBean",
				this.bookingRepository.getData(anggota.getEmail()));
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

	@RequestMapping(value = "/laporan")
	public ModelAndView laporanKeuangan() {
		ModelAndView mv = new ModelAndView("laporan");
		mv.addObject("transaksis", this.transaksiRepository.getData());
		return mv;
	}
}
