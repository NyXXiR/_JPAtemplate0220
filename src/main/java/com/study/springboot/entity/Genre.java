package com.study.springboot.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
public class Genre {
	@Id
	
	private Long gno;
	private String genre;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy= "movie",
			cascade =CascadeType.ALL) 
	private Movie movie;
}