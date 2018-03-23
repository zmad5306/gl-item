package com.example.item.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.item.dto.ItemDto;
import com.example.item.dto.ItemInputDto;
import com.example.item.service.ItemService;

@RestController
public class ItemController {
	
	@Autowired
	private ItemService service;
	
	@RequestMapping(
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE,
			value="/{listId}"
		)
	public List<ItemDto> getItems(@RequestHeader("sso_user") String username, @PathVariable String listId) {
		List<ItemDto> items = service.getAllItems(username, listId);
		for (ItemDto item: items) {
			Link selfLink = linkTo(ItemController.class).slash(item.getItemId()).withSelfRel();
			item.add(selfLink);
			
			Link listLink = new Link("/api/list/" + item.getListId()).withTitle("list");
			item.add(listLink);
			
			Link deptLink = new Link("/api/dept/" + item.getDepartmentId()).withTitle("dept");
			item.add(deptLink);
		}
		return items;
	}
	
	@RequestMapping(
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE,
			value="/{listId}/{departmentId}"
		)
	public List<ItemDto> getItems(@RequestHeader("sso_user") String username, @PathVariable String listId, @PathVariable String departmentId) {
		List<ItemDto> items = service.getAllItems(username, listId, departmentId);
		for (ItemDto item: items) {
			Link selfLink = linkTo(ItemController.class).slash(item.getItemId()).withSelfRel();
			item.add(selfLink);
			
			Link listLink = new Link("/api/list/" + item.getListId()).withTitle("list");
			item.add(listLink);
			
			Link deptLink = new Link("/api/dept/" + item.getDepartmentId()).withTitle("dept");
			item.add(deptLink);
		}
		return items;
	}
	
	@RequestMapping(
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			value="/{listId}/{departmentId}"
		)
	public ItemDto saveItem(@RequestHeader("sso_user") String username, @PathVariable String listId, @PathVariable String departmentId, @RequestBody ItemInputDto item) {
		ItemDto it = service.insertItem(username, listId, departmentId, item);
		
		Link selfLink = linkTo(ItemController.class).slash(it.getItemId()).withSelfRel();
		it.add(selfLink);
		
		Link listLink = new Link("/api/list/" + it.getListId()).withTitle("list");
		it.add(listLink);
		
		Link deptLink = new Link("/api/dept/" + it.getDepartmentId()).withTitle("dept");
		it.add(deptLink);
		
		return it;
	}
	
	@RequestMapping(
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE,
			value="/{itemId}"
		)
	public ResponseEntity<?> updateItem(@RequestHeader("sso_user") String username, @PathVariable String itemId, @RequestBody ItemInputDto item) {
		service.saveItem(username, itemId, item);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE,
			value="/{itemId}"
		)
	public ResponseEntity<?> deleteItem(@RequestHeader("sso_user") String username, @PathVariable String itemId) {
		service.deleteItem(username, itemId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
