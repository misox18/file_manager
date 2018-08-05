package cz.vutbr.feec.file_manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cz.vutbr.feec.file_manager.entities.Item;
import cz.vutbr.feec.file_manager.services.ItemService;

@RestController
public class RestHomeController {
	
	@Autowired
	ItemService itemService = new ItemService();
	
	@RequestMapping(value= "/allItems", method = RequestMethod.GET)
	public List<Item> getItems() {
		return itemService.findAll();
	}

}
