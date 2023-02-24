package com.study.springboot.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.study.springboot.entity.Emp;
import com.study.springboot.entity.Master;
import com.study.springboot.jdbc.EmpDeptMapper;
import com.study.springboot.repository.EmpRepository;
import com.study.springboot.repository.MasterRepository;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequiredArgsConstructor
@Log4j2
public class MyController {


	@GetMapping("/")
	public String root() {
		return "view/index";
	}
	
	@GetMapping("/list")
	public String ListEmp(Model model) {
		//List<Emp> list = empRepository.findAll();
		List<Emp> list = empDeptMapper.findAllEmp("%", "A");
		model.addAttribute("list", list);
		return "view/list";
	}
	
	@GetMapping("/search")
	public String search(Model model, String search, String type) {
		log.info("---search:"+search+", type:"+type);
		List<Emp> list = empDeptMapper.findAllEmp(search, type);
		model.addAttribute("list", list);
		return "view/list";
	}
	
	@GetMapping("/listMaster")
	public String listMaster(Model model) {
		List<Master>list = masterRepository.findAll();
		model.addAttribute("list", list);
		return "view/ListMaster";
	}
	
	/*emp 리스트 페이징처리 테스트 JPA 
	 * */
	
	@GetMapping("/page/{num}")
	public String page(@PathVariable int num, Model model) {
									//0 = 현재페이지, 5 =5개씩
		Pageable pageable = PageRequest.of( num-1, 5);
		Page<Emp> res = empRepository.findAll(pageable);
		
		log.info("total count emp레코드수 :"+res.getTotalElements());
		log.info("total page :"+res.getTotalPages());
		log.info("page number :"+res.getNumber());
		log.info("page size :"+res.getSize());
		
		model.addAttribute("list",res);
		/*
		 * res.stream().forEach(t -> { log.info(t); });
		 */
		
		return "view/page";
	}
	
	@GetMapping("/realpage")
	public String real(@PageableDefault(page=0, size=5, 
						direction = Sort.Direction.DESC) Pageable pageable, Model model) {
		Page<Emp> res = empRepository.findAll(pageable);
		model.addAttribute("list", res);
		
		return  "view/realpage";
	}
	
	/*test페이지 sequence 테스트*/
	@GetMapping("/test")
	public String test() {
		
		return "view/test";
	}
	
	
}
