package com.study.springboot.entity;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
	private String content;

	
	
	@ManyToOne(fetch = FetchType.LAZY)
	private List<Genre>genreList = new ArrayList<>();
	
}
