package com.example.item.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalLong;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.example.item.model.Item;

@Repository
public class ItemRepository {
	
	private List<Item> items;
	
	@PostConstruct
	public void init() {
		items = new ArrayList<>();
		
		Item i1 = new Item(1L, 2L, 1L, "sue", true, 1, "pizza 1");
		Item i2 = new Item(2L, 2L, 1L, "sue", true, 1, "pizza 2");
		Item i3 = new Item(3L, 2L, 1L, "sue", true, 1, "pizza 3");
		
		items.add(i1);
		items.add(i2);
		items.add(i3);
	}
	
	List<Item> getListItemsItemId(Long itemId, String username) {
		return this.items.stream().filter(i -> i.getItemId() == itemId).filter(i -> i.getUsername().equalsIgnoreCase(username)).collect(Collectors.toList());
	}
	
	List<Item> getListItems(Long listId, String username) {
		return this.items.stream().filter(i -> i.getListId() == listId).filter(i -> i.getUsername().equalsIgnoreCase(username)).collect(Collectors.toList());
	}
	
	List<Item> getListItems(Long itemId) {
		return this.items.stream().filter(i -> i.getItemId() == itemId).collect(Collectors.toList());
	}
	
	Long getNextItemId() {
		OptionalLong max = this.items.stream().map(i -> i.getItemId()).mapToLong(Long::longValue).max();
		return max.getAsLong() + 1L;
	}

	public List<Item> fetchByListId(Long listId, String username) {
		return getListItems(listId, username);
	}
	
	public List<Item> fetchByListIdAndDepartmentId(Long listId, Long departmentId, String username) {
		return getListItems(listId, username).stream().filter(i -> i.getDepartmentId() == departmentId).collect(Collectors.toList());
	}
	
	public Item save(Long listId, Long departmentId, Item item, String username) {
		item.setDepartmentId(departmentId);
		item.setItemId(getNextItemId());
		item.setUsername(username);
		items.add(item);
		return item;
	}
	
	public void update(String username, Long itemId, Item item) {
		List<Item> items = getListItemsItemId(itemId, username);
		if (!items.isEmpty()) {
			Item listItem = items.get(0);
			listItem.setActive(item.getActive());
			listItem.setName(item.getName());
			listItem.setQuantity(item.getQuantity());
		}
	}
	
	public void delete(String username, Long itemId) {
		List<Item> items = getListItemsItemId(itemId, username);
		if (!items.isEmpty()) {
			Item listItem = items.get(0);
			this.items.remove(listItem);
		}
	}
	
}
