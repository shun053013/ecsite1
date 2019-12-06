package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.OrderItem;

@Repository
public class OrderItemRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	public void insert(OrderItem orderItem) {
		String sql = "INSERT INTO order_items (item_id,order_id,quantity,size) VALUES(:itemId,:orderId,:quantity,:size)";
		SqlParameterSource param = new BeanPropertySqlParameterSource(orderItem);
		template.update(sql, param);
	}
	
	public void delete(Integer id) {
		String sql = "DELETE FROM order_items WHERE id=:id";
		SqlParameterSource param =  new MapSqlParameterSource().addValue("id", id);
		template.update(sql, param);
	}
	public void delete1(Integer id) {
		String sql = "DELETE FROM order_toppings WHERE id =:id";
		SqlParameterSource param =  new MapSqlParameterSource().addValue("id", id);
		template.update(sql, param);
	}

}
