package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Item;
import com.example.service.ShowItemService;

@Controller
@RequestMapping("")
public class ShowItemListController {

	@Autowired
	private ShowItemService showItemService;

	@RequestMapping("/showItem")
	public String showItemList(Model model) {
		List<Item> itemList = showItemService.ShowItem();
		model.addAttribute("itemList", itemList);
		return "item_list";

	}
	
	@RequestMapping("/searchByName")
	public String searchByName(String name,Model model) {
		System.out.println("name : " + name);
		List<Item> itemList = showItemService.searchByName(name);
		model.addAttribute("itemList",itemList);
		return "item_list";
		
	}

}
