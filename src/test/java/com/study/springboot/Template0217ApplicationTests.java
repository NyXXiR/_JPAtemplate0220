package com.study.springboot;

import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.study.springboot.entity.Movie;
import com.study.springboot.jdbc.MovieMapper;
import com.study.springboot.repository.GenreRepository;
import com.study.springboot.repository.MovieRepository;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class TMovielate0217ApplicationTests {

  @Autowired
  MovieMapper movieMapper;

  @Autowired
  GenreRepository genreRepository;

  /* repository를 쓸수있게 객체생성을 알아서 해준다 */
  @Autowired
  MovieRepository movieRepository;


  @Test
  void contextLoads() {}

  @Test
  @Disabled
  public void testMyBatisFindAllMovie() {
    List<Movie> list = movieMapper.findAllMovie("78", "S");
    log.info(list);
  }

  @Test
  public void testFindAllMovie() {
    // List<Movie> list = MovieRepository.findAll();
    // log.info(list);
  }

  @Test
  @Disabled
  public void insertMovie() {
    // Movie movie = Movie.builder().title("영화제목 1").build();
    /*
     * 위랑 아래랑 똑같은 얘기인데 builder패턴을 쓴건지, builder패턴은 new를 했음에도 arrayList 객체생성해주지 않는다 getter setter 를 쓰면
     * 배열의 빈값으로 나온다. 객체생성을 해준다.
     */
    Movie movie = new Movie();
    movie.setTitle("영화제목1");
    log.info(movie);
  }
}


/*
 * poster 부분 posterRepository를 만들지않으면 insert가 되지않아서 movieRepository에 옵션으로 cascade =CascadeType.ALL
 */

/*
 * Poster poster =
 * Poster.builder().idx(movie.getPosterList().size()).name("영화1포스터").movie(movie).build();
 * log.info(poster);
 * 
 * Poster poster2 =
 * Poster.builder().idx(movie.getPosterList().size()).name("영화2포스터").movie(movie).build();
 * log.info(poster2); movie.getPosterList().add(poster2); log.info(movieRepository.save(movie)); }
 */

//
// @Test
// @Disabled
// public void insertMasterSalve() {
// Master master = new Master();
// master.setCode("9");
// master.setComment("연습2");
// master.addSlave(Slave.builder().title("연습2").idx(2).content("이것은연습2").build());
// master.addSlave(Slave.builder().title("연습3").idx(3).content("이것은연습3").build());
// masterRepository.save(master);
// log.info(master.getMid());
// }
//
// @Test
// @Disabled
// public void selectMasterSlave() {
// Master master = masterRepository.findById(3L).orElseThrow(); // 3번이 안나오면 던진다.
// List<Slave> slaveList = master.getSlaveList();
// log.info(slaveList);
// }
//
// @Test
// @Disabled
// public void testInsProduct() {
// Product product = Product.builder().name("책3").price(50000).stock(3).build();
//
// ProductDetail pd = ProductDetail.builder().content("아주 좋은책").build();
//
// /*
// * product.setProductDetail(pd); productRepository.save(product);
// */
//
// pd.setProduct(product);
// productDetailRepository.save(pd);
//
// }
//
// @Test
// public void testSelectProduct() {
// Product product = productRepository.findById(2L).orElseThrow();
// log.info(product);
// log.info(product.getProductDetail());
// }
// }
