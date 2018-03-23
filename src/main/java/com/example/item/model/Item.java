package com.example.item.model;

public class Item {
	
	private Long itemId;
	private Long listId;
	private Long departmentId;
	private String username;
	private Boolean active = true;
	private Integer quantity = 1;
	private String name;
	
	public Item() {
		super();
	}

	public Item(Long itemId, Long listId, Long departmentId, String username, Boolean active, Integer quantity,
			String name) {
		super();
		this.itemId = itemId;
		this.listId = listId;
		this.departmentId = departmentId;
		this.username = username;
		this.active = active;
		this.quantity = quantity;
		this.name = name;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Long getListId() {
		return listId;
	}

	public void setListId(Long listId) {
		this.listId = listId;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
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
