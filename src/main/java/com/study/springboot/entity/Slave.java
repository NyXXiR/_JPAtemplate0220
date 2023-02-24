package com.study.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude ="master")
public class Slave {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sid;		//PK
	private String title;
	private String content;
	private int idx;		//순서를 위해 만든 필드
	
	@ManyToOne(fetch = FetchType.LAZY)	//노예가 여러명 많은것을 먼저 선언 
	private Master master;
}
