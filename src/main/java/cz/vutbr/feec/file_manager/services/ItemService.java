package cz.vutbr.feec.file_manager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.vutbr.feec.file_manager.entities.Item;
import cz.vutbr.feec.file_manager.entities.repositories.ItemRepository;

@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepository;

	public ItemService() {
		super();
	}

	public List<Item> getItems() {
		return itemRepository.getAll();
	}
	
	public List<String> getPath(){
		return itemRepository.getPath();
	}

}
