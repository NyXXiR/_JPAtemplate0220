package com.study.springboot.jdbc;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.study.springboot.entity.Movie;

@Mapper
public interface MovieMapper {
	public List<Movie>findMovies
	( @Param("search") String search, 
			@Param("type") String type);

}
