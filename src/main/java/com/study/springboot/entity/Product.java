package com.study.springboot.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * One to One 관계
 * */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "product")
@ToString

public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long num;
	private String name;
	private Integer price;
	private Integer stock;
	
	@OneToOne(mappedBy = "product")
	/* 주가 되어지는 곳에 쓰고 주가 주인이 아니다*/
	private ProductDetail productDetail;
}
