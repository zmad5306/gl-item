package com.example.item.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.item.dto.ItemDto;
import com.example.item.dto.ItemInputDto;
import com.example.item.model.Item;
import com.example.item.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository repo;
	
	public List<ItemDto> getAllItems(String username, String listId) {
		return repo.findByListIdAndUsername(listId, username).stream().map(i -> new ItemDto(i)).collect(Collectors.toList());
	}
	
	public List<ItemDto> getAllItems(String username, String listId, String departmentId) {
		return repo.findByListIdAndUsernameAndDepartmentId(listId, username, departmentId).stream().map(i -> new ItemDto(i)).collect(Collectors.toList());
	}
	
	public ItemDto insertItem(String username, String listId, String departmentId, ItemInputDto item) {
		return new ItemDto(repo.insert(new Item(item, username, listId, departmentId)));		
	}
	
	public void saveItem(String username, String itemId, ItemInputDto item) {
		Item i = repo.findByItemIdAndUsername(itemId, username);
		i.apply(item);
		repo.save(i);
	}
	
	public void deleteItem(String username, String itemId) {
		Item i = repo.findByItemIdAndUsername(itemId, username);
		repo.delete(i);
	}

}
