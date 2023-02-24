package com.study.springboot.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * product와 One to One 관계
 * */

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name ="product_detail")

public class ProductDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String content;
	
	@OneToOne (cascade = CascadeType.ALL)
	@JoinColumn(name="product_num")
	/*일대일관계는 fetch lazy같은게 안되고 테이블이 같이 올라와야 조인이가능*/
	@ToString.Exclude
	/*객체에 담을 변수만 만들어놓은거라 ToString에서 제외해야 나온다*/
	private Product product;
}
