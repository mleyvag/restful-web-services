package com.leyva.pe.model;

import java.util.Date;

public class User {
	private Integer id;
	private String name;
	private Date birthday;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer id, String name, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, birthday=%s]", id, name, birthday);
	}
	
}
