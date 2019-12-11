package com.example.controller;

import java.math.BigInteger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.LoginUser;
import com.example.domain.Order;
import com.example.form.OrderItemForm;
import com.example.service.ShoppingCartService;

@Controller
@RequestMapping("")
public class ShoppingCartController {
	@Autowired
	private HttpSession session;

	@Autowired
	private ShoppingCartService shoppingCartService;

	/**
	 * カートを追加するボタンを押すと商品が追加されるメソッド
	 * @param orderItemform
	 * @param loginUser
	 * @return　ショッピングカートの中身を表示するメソッド
	 */
	@RequestMapping("/insertOrderItem")
	public String insertOrderItem(OrderItemForm orderItemform, @AuthenticationPrincipal LoginUser loginUser) {
		Integer userId;
		if (loginUser != null) {
			userId = loginUser.getUser().getId();

		}
		if (session.getAttribute("userId") != null) {
			userId = (Integer) (session.getAttribute("userId"));
		} else {
			userId = new BigInteger(session.getId(), 16).intValue();
			session.setAttribute("userId", userId);
		}
		shoppingCartService.addItem(userId, orderItemform);
		return "redirect:/showCartList";

	}

	/**
	 * ショッピングカートの中身を表示するメソッド
	 * @param orderItemform
	 * @param loginUser
	 * @param model
	 * @return　中身が空ならメッセージを返し、中身があれば注文内容を渡す
	 */
	@RequestMapping("/showCartList")
	public String showCartList(OrderItemForm orderItemform, @AuthenticationPrincipal LoginUser loginUser, Model model) {

		Integer userId;
		if (loginUser != null) {
			userId = loginUser.getUser().getId();
		} else if (session.getAttribute("userId") != null) {
			userId = (Integer) (session.getAttribute("userId"));
		} else {
			userId = new BigInteger(session.getId(), 16).intValue();
			session.setAttribute("userId", userId);
		}
		Order order = shoppingCartService.showCart(userId);

		if (order == null || order.getOrderItemList().size() == 0) {
			model.addAttribute("message", "カートの中身が空です");
		} else {
			model.addAttribute("order", order);
		}
		return "cart_list";

	}
	@RequestMapping("/delete")
	public String deleteCartList(OrderItemForm orderItemForm) {
		shoppingCartService.deletedCart(orderItemForm.getId());
		return "redirect:/showCartList";
	}
}