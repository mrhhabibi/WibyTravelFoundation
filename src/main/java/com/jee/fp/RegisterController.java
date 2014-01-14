package com.jee.fp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jee.fp.domain.Anggota;
import com.jee.fp.domain.Jadwal;
import com.jee.fp.repository.AnggotaRepository;

@Controller
public class RegisterController {

	@Autowired
	private AnggotaRepository anggotaRepository;
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public ModelAndView registerAnggota() {
		ModelAndView mv=new ModelAndView("register");
		mv.addObject("anggotaBean",new Anggota());
		return mv;
	}
	
	@RequestMapping(value="/registeranggota", method = RequestMethod.POST)
	public ModelAndView submitRegister(@ModelAttribute Anggota anggota) {
		ModelAndView mv=new ModelAndView("home");
		this.anggotaRepository.tambah(anggota);
		mv.addObject("jadwalBean",new Jadwal());
		return mv;
	}
}
