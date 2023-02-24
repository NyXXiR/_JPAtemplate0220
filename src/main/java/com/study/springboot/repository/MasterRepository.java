package com.study.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.springboot.entity.Master;

//데이터베이스에 액세스하는 애들을 여기서 관리한다
public interface MasterRepository extends JpaRepository<Master, Long>{

}
