package member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import member.dto.MemberDto;
import member.service.MemberService;

@Controller
@RequestMapping("/member") //공통 매핑
@RequiredArgsConstructor
public class MemberListController 
{
	
	//@Autowired//이거 쓰던가
	@NonNull//이거로 쓰고 @RequiredArgsConstructor 추가하던가
	private MemberService memberService;
	
	@GetMapping("/list")
	public String list(Model model)
	{
		int totalCount; //총 개수
		List<MemberDto> list = memberService.getAllMembers();
		
		totalCount = memberService.getTotalCount();
		
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		
		return "member/memberlist";
	}
}
