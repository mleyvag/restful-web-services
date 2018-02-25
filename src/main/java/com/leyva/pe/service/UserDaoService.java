package com.leyva.pe.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.leyva.pe.model.User;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	private static int count = 3;
	static {
		users.add(new User(1, "Messi", new Date()));
		users.add(new User(2, "Suarez", new Date()));
		users.add(new User(3, "Coutinho", new Date()));
	}
	public List<User> findAll() {
		return users;
	}
	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++count);
		}
		users.add(user);
		return user;
	}
	public User findOne(int id) {
		for(User user : users) {
			if (user.getId()==id) {
				return user;
			}
		}
		return null;
	}
}
