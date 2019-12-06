package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Item;
import com.example.domain.Topping;
import com.example.repository.ItemRepository;
import com.example.repository.ToppingRepository;

@Service
public class ShowItemDetail {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private ToppingRepository toppingRepository;
	
	
	public Item showItemDetail(Integer id) {
		
		return itemRepository.load(id);
	}
	
	public List<Topping> showToppingList(){
		return toppingRepository.findAll();
	}
	
	
	

}
