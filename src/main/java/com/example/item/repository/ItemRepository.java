package com.example.item.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.item.model.Item;

public interface ItemRepository extends MongoRepository<Item, String> {
	
	public List<Item> findByListIdAndUsername(String listId, String username);
	public List<Item> findByListIdAndUsernameAndDepartmentId(String listId, String username, String departmentId);
	public Item findByItemIdAndUsername(String itemId, String username);
	
}
