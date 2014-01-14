package com.jee.fp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.jee.fp.domain.Anggota;
import com.jee.fp.domain.Transaksi;
import com.jee.fp.repository.AnggotaRepository;

@Controller
@SessionAttributes("anggotaObj")
public class AnggotaController {

	@Autowired
	private AnggotaRepository anggotaRepository;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginAnggota() {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("anggotaBean", new Anggota());
		return mv;
	}
	
	@RequestMapping(value = "/anggota", method = RequestMethod.GET)
	public ModelAndView manageAnggota() {
		ModelAndView mv = new ModelAndView("anggota");
		mv.addObject("anggotas",this.anggotaRepository.getData());
		return mv;
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(@ModelAttribute Anggota anggota) {
		ModelAndView mv = new ModelAndView();
		Anggota temp = anggotaRepository.login(anggota);
		if (temp != null) {
			mv.addObject("anggotaObj", temp);
			mv.setViewName("user");
		} else {
			mv.setViewName("login");
			mv.addObject("anggotaBean", new Anggota());
		}
		return mv;
	}
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public ModelAndView registerAnggota() {
		ModelAndView mv=new ModelAndView("register");
		mv.addObject("anggotaBean",new Anggota());
		return mv;
	}

	@RequestMapping(value="/registerProcess", method = RequestMethod.POST)
	public ModelAndView registerProcess(@ModelAttribute Anggota anggota) {
		ModelAndView mv=new ModelAndView("login");
		mv.addObject("anggotaBean",new Anggota());
		this.anggotaRepository.tambah(anggota);
		return mv;
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ModelAndView userProfile() {
		ModelAndView mv = new ModelAndView("user");
		mv.addObject("transaksiBean",new Transaksi());
		return mv;
	}
	
	@RequestMapping(value = "/logout")
	public ModelAndView logoutProcess() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("anggotaObj",null);
		mv.addObject("bookObj",null);	
		return mv;
	}
}
