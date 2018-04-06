package com.example.item.model;

import org.springframework.data.annotation.Id;

import com.example.item.dto.ItemInputDto;

public class Item {
	
	@Id
	private String itemId;
	private String listId;
	private String departmentId;
	private String username;
	private Boolean active = true;
	private Integer quantity = 1;
	private String name;
	
	public Item() {
		super();
	}

	public Item(String listId, String departmentId, String username, Boolean active, Integer quantity,
			String name) {
		super();
		this.listId = listId;
		this.departmentId = departmentId;
		this.username = username;
		this.active = active;
		this.quantity = quantity;
		this.name = name;
	}
	
	public Item(ItemInputDto list, String username, String listId, String departmentId) {
		super();
		this.departmentId = departmentId;
		this.username = username;
		this.active = list.getActive();
		this.quantity = list.getQuantity();
		this.name = list.getName();
		this.listId = listId;
	}
	
	public void apply(ItemInputDto list) {
		this.active = list.getActive();
		this.quantity = list.getQuantity();
		this.name = list.getName();
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getListId() {
		return listId;
	}

	public void setListId(String listId) {
		this.listId = listId;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
