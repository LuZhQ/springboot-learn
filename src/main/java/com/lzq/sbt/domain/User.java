package com.lzq.sbt.domain;

import io.swagger.annotations.ApiModel;

import java.util.List;
@ApiModel
public class User {
	
	private Integer id;
	private String name;
	private Integer age;
	
	private List<Car> carList;
	
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public List<Car> getCarList() {
		return carList;
	}
	public void setCarList(List<Car> carList) {
		this.carList = carList;
	}
	
	
	

}
