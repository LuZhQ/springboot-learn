package com.lzq.sbt.domain;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.lzq.sbt.domain.Car;

@Mapper
public interface CarMapper {
	
	@Select("SELECT * FROM CAR WHERE userId = #{userId}")
	List<Car> getCarByUserId(@Param("userId") Integer userId);

}
