package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.User;

@Repository
public class UserRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	public final static RowMapper<User> USER_ROW_MAPPER = (rs,i)->{
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setAddress(rs.getString("address"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		user.setTelephone(rs.getString("telephone"));
		user.setZipcode(rs.getString("zipcode"));
		return user;
		
	};
	
	public void insert(User user) {
		String sql = "INSERT INTO users(name,address,email,password,telephone,zipcode) VALUES(:name,:address,:email,:password,:telephone,:zipcode)";
		SqlParameterSource param = new BeanPropertySqlParameterSource(user);
		template.update(sql, param);
		
	}
	

	

}
