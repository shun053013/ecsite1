package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.LoginUser;
import com.example.domain.Order;
import com.example.form.OrderForm;
import com.example.service.ShowOrderService;

/**
 * 注文内容を表示するメソッド
 * 
 * @author shun053012
 *
 */
@Controller
@RequestMapping("")
public class ShowOrderController {
	@Autowired
	private ShowOrderService showOrderService;

	@RequestMapping("/showOrder")
	public String showOrder(Integer useId, OrderForm orderForm, @AuthenticationPrincipal LoginUser loginUser,
			Model model) {
		Order order = showOrderService.ShowOrder(loginUser.getUser().getId());
//		if(order==null || order.getOrderItemList().size()==0) {
//			return "redirect:/cart_list";
//		}
//		orderForm.setDestinationName(loginUser.getUser().getName());
//		orderForm.setDestinationEmail(loginUser.getUser().getEmail());
//		orderForm.setDestinationZipcode(loginUser.getUser().getZipcode());
//		orderForm.setDestinationAddress(loginUser.getUser().getAddress());
//		orderForm.setDestinationTel(loginUser.getUser().getTelephone());

		model.addAttribute("order", order);

		return "order_confirm";

	}
	

}
