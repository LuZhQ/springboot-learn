package com.lzq.sbt.domain;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.lzq.sbt.domain.User;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USER WHERE NAME = #{name}")
    User findUserByName(@Param("name") String name);

    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
    int insertUser(@Param("name") String name, @Param("age") Integer age);
    
    @Select("SELECT * FROM USER")
    List<User> findAllUser();
    
    @Update("UPDATE USER SET NAME = #{name} ,AGE = #{age} WHERE ID = #{id}")
    int updateUser(@Param("id") Integer id,@Param("name") String name, @Param("age") Integer age);

}