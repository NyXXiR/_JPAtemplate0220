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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/* spring JPA Entity와 ID는 꼭 써야한다. */
@Getter
@Setter// getter setter 대신에 Data로 사용할수 있다.
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Movie {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private long mno;
  private String title;
  private String content;



  @ManyToOne(fetch = FetchType.LAZY)
  private Genre genre;

}
