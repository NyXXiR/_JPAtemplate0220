package com.study.springboot.jdbc;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MovieMapper {
	public List<Emp> findAllEmp
	( @Param("search") String search, 
			@Param("type") String type);
	public List<Dept> findAllDept();
}
