package com.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.model.Item;

@Component
public class ItemDAO {

	private static List<Item> items;

	{
		items = new ArrayList<Item>();
		items.add(new Item(1, "Toothpaste", 10.00));
		items.add(new Item(2, "Soap", 20.00));
		items.add(new Item(3, "Shampoo", 40.00));
		items.add(new Item(4, "Hair Oil", 25.00));
	}

	public List<Item> list() {
		return items;
	}

	public Item get(Long id) {

		for (Item item : items) {
			if (item.getId().equals(id)) {
				return item;
			}
		}
		return null;
	}

	public Item create(Item item) {
		item.setId(System.currentTimeMillis());
		items.add(item);
		return item;
	}

	public Long delete(Long id) {

		for (Item item : items) {
			if (item.getId().equals(id)) {
				items.remove(item);
				return id;
			}
		}

		return null;
	}

	public Item update(Long id, Item updatedItem) {

		for (Item item : items) {
			if (item.getId().equals(id)) {
				item.setId(item.getId());
				items.remove(item);
				items.add(updatedItem);
				return updatedItem;
			}
		}

		return null;
	}

}
