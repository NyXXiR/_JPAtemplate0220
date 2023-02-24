package com.study.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.study.springboot.entity.Movie;

/*
 * repository가 필요한 이유 : 데이터베이스 테이블을 끌어다가 객체지향해서 쓰고 가져다놓는거라 mybatis 는 mapping해서 crud를 하는것과 다른것이다.
 */

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
