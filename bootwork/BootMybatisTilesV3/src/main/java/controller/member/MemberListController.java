package controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberListController {
	@GetMapping({"/", "/member/list"})// "http://localhost:9000/", "http://localhost:9000/memberlist/"가 모두 뜸
	public String memberList()
	{
		return "member/memberlist";//prefix + "member/memberlist" + suffix 로 이동
	}
}
