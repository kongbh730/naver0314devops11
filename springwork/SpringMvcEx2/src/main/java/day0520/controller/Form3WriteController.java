package day0520.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import day0520.dto.FoodDto;

@Controller
public class Form3WriteController {
	@PostMapping("/read3")
	public String read3(
			/* 폼태그에서 같은 이름을 자동으로 읽어옴
			 * Model에 foodDto라는 이름으로 저장됨 */
			//@ModelAttribute FoodDto dto

			//dto클래스명이 너무 긴 경우 간단하게 모델에 저장
			@ModelAttribute("fdto") FoodDto dto//foodDto가 아니라 fdto로 저장됨
			
			//@ModelAttribute도 생략가능 그냥 foodDto로...
			//FoodDto dto
			)
	{
		return "form3/result3";
	}
}
