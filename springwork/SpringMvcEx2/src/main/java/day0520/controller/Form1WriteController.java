package day0520.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Form1WriteController {

	@GetMapping("/read1")
	public String read1(
			//form 태그의 name과 읽어올 변수명이 같을 경우 생략가능한 부분
			@RequestParam String name,
			//@RequestParam("name") String name,//@RequestParam(form태그의 name) 타입 변수명(읽어올 변수명)
			//String name, //@RequsetParam도 생략 가능
			@RequestParam("addr") String a,//변수명과 form 태그의 name이 같으면 생략 가능하지만 그냥 작성
			@RequestParam("age") int myage,//변수명과 폼태그 name이 다르면 생략 불가! //폼태그와 다른 이름으로 읽을 경우 생략 불가
			Model model
			)
	{
		model.addAttribute("name", name);
		model.addAttribute("addr", a);
		model.addAttribute("age", myage);
		model.addAttribute("info", (myage >= 20) ? "성인입니다.":"미성년자입니다.");
			
		return "form1/result1";
	}
}
