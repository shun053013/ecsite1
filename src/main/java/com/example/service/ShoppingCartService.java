package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Order;
import com.example.domain.OrderItem;
import com.example.domain.OrderTopping;
import com.example.form.OrderItemForm;
import com.example.repository.OrderItemRepository;
import com.example.repository.OrderRepository;
import com.example.repository.OrderToppingRepository;

@Service
@Transactional
public class ShoppingCartService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Autowired
	private OrderToppingRepository orderToppingRepository;

	public void insertOrderItem(OrderItem orderItem) {
		orderItemRepository.insert(orderItem);
	}

	/**
	 * 注文商品を追加するメソッド
	 * 
	 * @param userId
	 * @param orderItemForm
	 */
	public void addItem(Integer userId, OrderItemForm orderItemForm) {
		Order order = orderRepository.findByUserIdAndStatus(userId, 0);
		
		if (order == null) {
			order = new Order();
			order.setUserId(userId);
			order.setStatus(0);
			order.setTotalPrice(0);
			orderRepository.insert(order);
		}
		OrderItem orderItem = new OrderItem();
		orderItem.setOrderId(order.getId());
		orderItem.setItemId(orderItemForm.getItemId());
		orderItem.setQuantity(orderItemForm.getQuantity());
		orderItem.setSize(orderItemForm.getSize());
		orderItemRepository.insert(orderItem);

		if (orderItemForm.getOrderToppingList() != null) {
			OrderTopping orderTopping = new OrderTopping();

			for (Integer toppingId : orderItemForm.getOrderToppingList()) {

				orderTopping.setToppingId(toppingId);
				orderTopping.setOrderItemId(orderItem.getId());
				orderToppingRepository.insert(orderTopping);

			}
		}

	}

	/**
	 * カートの中身を表示するメソッド
	 * @param userId　ユーザーID
	 * @return　オーダー情報
	 */
	public Order showCart(Integer userId) {
		Order order = orderRepository.findByUserIdAndStatus(userId, 0);
		return order;

	}
	
	/**
	 * カートの中身を削除するメソッド
	 * @param id
	 */
	public void deletedCart(Integer id) {
		orderRepository.deleteById(id);
	}
}
