package com.jee.fp;

import java.util.ArrayList;
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
@SessionAttributes("bookObj")
public class JadwalController {

	@Autowired
	private JadwalRepository jadwalRepository;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("jadwals",this.jadwalRepository.getData());
		mv.addObject("jadwalBean",new Jadwal());
		mv.addObject("kotaList",getKota());
		return mv;
	}

	@RequestMapping(value="/filterjadwal", method=RequestMethod.POST)
	public ModelAndView tambahJadwal(@ModelAttribute Jadwal jadwal) {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("jadwalBean",new Jadwal());
		mv.addObject("kotaList",getKota());
		mv.addObject("jadwals",this.jadwalRepository.getData(null,null,null,0));
		return mv;
	}
	
	@RequestMapping(value="/book/{jadwalId}")
	public ModelAndView bookJadwal(@PathVariable("jadwalId") int jadwalId) {
		ModelAndView mv = new ModelAndView("book");
		mv.addObject("bookObj", jadwalRepository.getData(jadwalId));
		mv.addObject("transaksiBean", new Transaksi());
		mv.addObject("viaList", getVia());
		return mv;
	}

	private List<String> getVia() {
		List<String> vias = new ArrayList<String>();
		vias.add("ATM");
		vias.add("Teller");
		return vias;
	}
	
	private List<String> getKota() {
		List<String> kotas = new ArrayList<String>();
		kotas.add("Surabaya");
		kotas.add("Kediri");
		kotas.add("Gresik");
		kotas.add("Malang");
		kotas.add("Jakarta");
		kotas.add("Sidoarjo");
		kotas.add("Bandung");
		kotas.add("Semarang");
		kotas.add("Bojonegoro");
		return kotas;
	}
}
