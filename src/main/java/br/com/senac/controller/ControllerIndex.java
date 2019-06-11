package br.com.senac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerIndex {
	
	@GetMapping("index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index.html");
		//mv.addObject(null, null);
		return mv;
	}
}
