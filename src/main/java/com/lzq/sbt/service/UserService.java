package com.lzq.sbt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.lzq.sbt.domain.Car;
import com.lzq.sbt.domain.CarMapper;
import com.lzq.sbt.domain.User;
import com.lzq.sbt.domain.UserMapper;

@Configuration
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private CarMapper carMapper;
	
	public List<User> findAllUser(){
		List<User> userList = userMapper.findAllUser();
		userList.forEach(user -> {
			List<Car> carList = carMapper.getCarByUserId(user.getId());
			user.setCarList(carList);
		});
		return userList;
	}
	
	public int insertUser(String name, Integer age){
		return userMapper.insertUser(name,age);
	}
	
	public User findUserByName(String name){
		User user = userMapper.findUserByName(name);
		List<Car> carList = carMapper.getCarByUserId(user.getId());
		user.setCarList(carList);
		return user;
	}
	
	public int updateUser(Integer userId,String name,Integer age){
		return userMapper.updateUser(userId, name, age);
	}

	
}
