package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Order;
import com.example.repository.OrderRepository;

@Service
public class ShowOrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	public Order ShowOrder(Integer userId) {
		Order order = orderRepository.findByUserIdAndStatus(userId,0);
		
		return order;
	}

}
