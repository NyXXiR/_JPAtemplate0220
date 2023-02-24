package com.study.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Poster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long ino;
	private String name;
	private int idx;
	
	/*영화하나당 포스터가 여러개이므로 poster입장에서 Many 다대일관계*/
	/*fetch 에 fetchType.Lazy가 default 기본 지연로딩 (실제 객체가 사용되는 시점에
	 * 초기화디어 DB에 쿼리가 간다.  */
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Movie movie;
}
