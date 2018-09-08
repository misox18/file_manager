package cz.vutbr.feec.file_manager.entities.repositories;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Repository;

import cz.vutbr.feec.file_manager.entities.Item;

@Repository
public class ItemRepository {

	private final List<Item> allItems = new ArrayList<>();
	private final List<String> splitPath = new ArrayList<>();
	private final String path = System.getProperty("user.home");
			
	public ItemRepository() {
		super();
	}
	
	public List<String> getPath(){
		splitPath.clear();
		splitPath();
		return splitPath;
	}
	
	public List<Item> getAll() {
		allItems.clear();
		List<Item> tempList= new ArrayList<>();
		final File folder = new File(path);
		for (File i : folder.listFiles()) {
			Item item = new Item();

			item.setName(getName(i));
			item.setPath(i.getPath());
			item.setSuffix(getSuffix(i));
			item.setParent(i.getParent());
			item.setSize(getSize(i));

			tempList.add(isFileOrFoleder(item, i));
		}
		allItems.addAll(tempList);
		return allItems;
	} 
	
	private void splitPath() {
		splitPath.addAll(Arrays.asList(path.split("\\\\")));
	}

	private Item isFileOrFoleder(Item item, File i) {
		if (i.isFile()) {
			item.setIsFile(true);
			item.setIsFolder(false);
		} else {
			item.setIsFile(false);
			item.setIsFolder(true);
		}
		return item;
	}

	private String getName(File i) {
		return FilenameUtils.removeExtension(i.getName());
	}

	private String getSuffix(File i) {
		return FilenameUtils.getExtension(i.getName());
	}

	private String getSize(File i) {
		Long size = i.length();
		List<String> list = Arrays.asList("B", "kB", "MB", "GB");
		int counter = 0;

		while (size >= 1028) {
			size = size / 1028;
			counter++;
		}

		return size.toString() + " " + list.get(counter); 
	}

}
