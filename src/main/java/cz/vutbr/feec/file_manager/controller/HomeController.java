package cz.vutbr.feec.file_manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.vutbr.feec.file_manager.entities.Item;
import cz.vutbr.feec.file_manager.services.ItemService;

@Controller
public class HomeController {

	@Autowired
	ItemService itemService;
	
	@ModelAttribute("allItems")
	public List<Item> modelItems(){
		return itemService.findAll();
	}
	
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
