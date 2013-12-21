package com.jee.fp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jee.fp.domain.Anggota;
import com.jee.fp.domain.Jadwal;

@Controller
public class RegisterController {

	@RequestMapping(value="/register", method = RequestMethod.GET)
	public ModelAndView registerAnggota() {
		ModelAndView mv=new ModelAndView("register");
		mv.addObject("anggotaBean",new Anggota());
		return mv;
	}
	
	@RequestMapping(value="/registeranggota", method = RequestMethod.GET)
	public ModelAndView submitRegister(@ModelAttribute Anggota anggota) {
		ModelAndView mv=new ModelAndView("redirect:/");
		// beda form gimana ngeaddnya kalo masih pake fake repository -_-
		return mv;
	}
}
