package com.study.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.study.springboot.entity.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

}
