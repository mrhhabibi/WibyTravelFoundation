package com.jee.fp;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jee.fp.domain.Jadwal;
import com.jee.fp.repository.AnggotaRepository;
import com.jee.fp.repository.JadwalRepository;
import com.jee.fp.repository.impl.FakeAnggotaRepository;
import com.jee.fp.repository.impl.FakeJadwalRepository;

@Controller
public class HomeController {
	
	@Autowired
	private JadwalRepository jadwalRepository;
	@Autowired
	private AnggotaRepository anggotaRepository;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mv=new ModelAndView("home");

		mv.addObject("jadwals",this.jadwalRepository.getData());
		mv.addObject("anggotas",this.anggotaRepository.getData());
		mv.addObject("jadwalBean",new Jadwal());
		mv.addObject("kotaList",getKota());
		return mv;
	}

	@RequestMapping(value="/tambahjadwal", method=RequestMethod.POST)
	public ModelAndView tambahJadwal(@ModelAttribute Jadwal jadwal) {
		ModelAndView mnv = new ModelAndView("redirect:/");
		this.jadwalRepository.tambah(jadwal);
		return mnv;
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
