package com.lzq.sbt.web;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lzq.sbt.domain.User;
import com.lzq.sbt.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@ApiOperation(
			value="获取用户列表",
			notes="获取所有用户列表",
			response = User.class,
			responseContainer = "List")
	@RequestMapping(value="/",method=RequestMethod.GET)
	public Map<String,Object> findAllUser(){
		Map<String,Object> map = new HashMap<String,Object>();
		List<User> userList = userService.findAllUser();
		map.put("data", userList);
		return map;
	}
	
	@ApiOperation(value="新增用户",notes="根据User对象创建用户")
	@RequestMapping(value="/",method=RequestMethod.POST)
	public Integer insertUser(@RequestBody  User user){
		String name = user.getName();
		Integer age = user.getAge();
		return userService.insertUser(name,age);
	}
	
	@ApiOperation(value="根据用户名获取用户",notes="根据用户名获取用户")
	@ApiImplicitParam(name = "name", value = "用户名", required = true, dataType = "String")
	@RequestMapping(value="/{name}",method=RequestMethod.GET)
	public Map<String,Object> findUserByName(@PathVariable String name) {
		Map<String,Object> map = new HashMap<String,Object>();
		User user = userService.findUserByName(name);
		map.put("data", user);
		return map;
	}
	
	
	@ApiOperation(value="更新用户信息",notes="更新用户信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "int"),
		@ApiImplicitParam(name = "name", value = "用户名", required = true, dataType = "String"),
		@ApiImplicitParam(name = "age", value = "年龄", required = true, dataType = "int")
	})
	@RequestMapping(value="/{id}/{name}/{age}",method=RequestMethod.PUT)
	public int updateUser(@PathVariable Integer id,@PathVariable String name,@PathVariable Integer age){
		return userService.updateUser(id,name,age);
	}
}
