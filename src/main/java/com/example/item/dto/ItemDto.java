package com.example.item.dto;

import org.springframework.hateoas.ResourceSupport;

import com.example.item.model.Item;

public class ItemDto extends ResourceSupport {
	
	private String itemId;
	private String listId;
	private String departmentId;
	private String username;
	private Boolean active = true;
	private Integer quantity = 1;
	private String name;
	
	public ItemDto() {
		super();
	}
	
	public ItemDto(Item item) {
		super();
		this.active = item.getActive();
		this.departmentId = item.getDepartmentId();
		this.itemId = item.getItemId();
		this.listId = item.getListId();
		this.name = item.getName();
		this.quantity = item.getQuantity();
		this.username = item.getUsername();
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
