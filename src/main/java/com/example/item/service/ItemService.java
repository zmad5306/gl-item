package com.example.item.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.item.dto.ItemDto;
import com.example.item.model.Item;
import com.example.item.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository repo;
	
	public List<ItemDto> getAllItems(String username, Long listId) {
		return repo.fetchByListId(listId, username).stream().map(i -> new ItemDto(i)).collect(Collectors.toList());
	}
	
	public List<ItemDto> getAllItems(String username, Long listId, Long departmentId) {
		return repo.fetchByListIdAndDepartmentId(listId, departmentId, username).stream().map(i -> new ItemDto(i)).collect(Collectors.toList());
	}
	
	public ItemDto newItem(String username, Long listId, Long departmentId, ItemDto item) {
		return new ItemDto(repo.save(listId, departmentId, new Item(null, listId, departmentId, username, item.getActive(), item.getQuantity(), item.getName()), username));		
	}
	
	public void changeItem(String username, Long itemId, ItemDto item) {		
		repo.update(username, itemId, new Item(itemId, item.getListId(), item.getDepartmentId(), username, item.getActive(), item.getQuantity(), item.getName()));
	}
	
	public void deleteItem(String username, Long itemId) {
		repo.delete(username, itemId);
	}

}
