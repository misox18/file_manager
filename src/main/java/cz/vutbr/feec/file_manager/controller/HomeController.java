package cz.vutbr.feec.file_manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String root() {
		return "redirect:/user/index";
	}

	@RequestMapping(value = "/user/index", method = RequestMethod.GET)
	public String userIndex() {
		return "user/index";
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/login-error", method = RequestMethod.GET)
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		return "login";
	}
}
