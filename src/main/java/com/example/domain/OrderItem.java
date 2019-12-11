package com.example.domain;

import java.util.List;

public class OrderItem {
	private Integer id;
	private Integer itemId;
	private Integer orderId;
	private Integer quantity;
	private Character size;
	private Item item;
	private List<OrderTopping> orderToppingList;

	public int getSubTotal() {
		int subtotal = 0;
		int toppingtotal = 0;

		if (size.equals('M')) {
			if (orderToppingList != null) {
				for (OrderTopping ordertopping : orderToppingList) {
					toppingtotal += ordertopping.getTopping().getPriceM();

				}
			}
			if (item != null) {
				subtotal = (item.getPriceM() + toppingtotal) * quantity;
			}

		}else {
			if(orderToppingList !=null) {
				for(OrderTopping ordertopping : orderToppingList ) {
					toppingtotal += ordertopping.getTopping().getPriceL();
				}
			}if(item!=null) {
				subtotal=(item.getPriceL()+toppingtotal)*quantity;
			}
		}return subtotal;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Character getSize() {
		return size;
	}

	public void setSize(Character size) {
		this.size = size;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public List<OrderTopping> getOrderToppingList() {
		return orderToppingList;
	}

	public void setOrderToppingList(List<OrderTopping> orderToppingList) {
		this.orderToppingList = orderToppingList;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", itemId=" + itemId + ", orderId=" + orderId + ", quantity=" + quantity
				+ ", size=" + size + ", item=" + item + ", orderToppingList=" + orderToppingList + "]";
	}

}
