package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Topping;
import com.example.repository.ToppingRepository;

@Service
public class ShowToppingService {
	
	@Autowired private ToppingRepository toppingRepository;
	
	public List<Topping> ShowTopping(){
		List<Topping> toppingList = toppingRepository.findAll();
		return toppingList;
 		
	}
	
}
