package controller.member;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import data.dto.MemberDto;
import data.service.MemberService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberListController {
	
	@NonNull
	private MemberService memberService;
	
	@GetMapping({"/member/list"})// "http://localhost:9000/", "http://localhost:9000/memberlist/"가 모두 뜸
	public String memberList(Model model)
	{
		int totalCount = memberService.getTotalCount();
		List<MemberDto> list = memberService.getAllMembers();
		
		model.addAttribute("list", list);
		model.addAttribute("totalCount", totalCount);
		
		return "member/memberlist";//prefix + "member/memberlist" + suffix 로 이동
	}
	
	//detailpage 매핑 주기
	@GetMapping("/member/detail")
	public String detail(@RequestParam int num, Model model)
	{
		MemberDto dto = memberService.getData(num);
		model.addAttribute("dto", dto);
		return "member/detailpage";
	}
}
