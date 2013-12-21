package com.jee.fp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jee.fp.domain.Anggota;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView registerAnggota() {
		ModelAndView mv=new ModelAndView("login");
		mv.addObject("anggotaBean",new Anggota());
		return mv;
	}
}
