package day0520.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Form1WriteController {

	@GetMapping("/read1")
	public String read1(
			//form �±��� name�� �о�� �������� ���� ��� ���������� �κ�
			@RequestParam String name,
			//@RequestParam("name") String name,//@RequestParam(form�±��� name) Ÿ�� ������(�о�� ������)
			//String name, //@RequsetParam�� ���� ����
			@RequestParam("addr") String a,//������� form �±��� name�� ������ ���� ���������� �׳� �ۼ�
			@RequestParam("age") int myage,//������� ���±� name�� �ٸ��� ���� �Ұ�! //���±׿� �ٸ� �̸����� ���� ��� ���� �Ұ�
			Model model
			)
	{
		model.addAttribute("name", name);
		model.addAttribute("addr", a);
		model.addAttribute("age", myage);
		model.addAttribute("info", (myage >= 20) ? "�����Դϴ�.":"�̼������Դϴ�.");
			
		return "form1/result1";
	}
}
