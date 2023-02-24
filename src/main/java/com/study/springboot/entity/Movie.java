package com.study.springboot.entity;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/*spring JPA Entity와 ID는 꼭 써야한다.*/
@Data   //getter setter 대신에 Data로 사용할수 있다.
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long mno;
	private String title;
	
	/*mappedby는 Poster class에 필드명 movie가 주인이다.
	 * posterList라는 테이블이 생성되지 않게 한다.*/
	@OneToMany(fetch = FetchType.LAZY, mappedBy= "movie",
			cascade =CascadeType.ALL) 
	private List<Poster>posterList = new ArrayList<>();
	
}
