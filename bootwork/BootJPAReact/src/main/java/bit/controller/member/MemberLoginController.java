package bit.controller.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bit.data.member.MemberDto;
import bit.service.member.MemberService;
import jwt.setting.JwtTokenProvider;
import jwt.setting.UserAuthentication;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boot")
public class MemberLoginController {

    final private MemberService memberService;
    final private PasswordEncoder passwordEncoder;

//	@PostMapping("/member/insert")
//	public String insertMember(@RequestBody MemberDto dto)
//	{
//		System.out.println(dto);
//		//passwd 는 암호화해서 db 저장
//		String passwd=passwordEncoder.encode(dto.getPasswd());
//		//암호화된 값을 다시 dto 에 넣기
//		dto.setPasswd(passwd);
//		//db 저장
//		memberService.insertMember(dto);
//		return "success";
//	}

    @GetMapping("/member/insert")
    public String insertMember(@RequestParam("userid") String userid,
                               @RequestParam("passwd") String passwd,
                               @RequestParam("hp") String hp)
    {
        System.out.println(userid);
        //passwd 는 암호화해서 db 저장
        String passwd2=passwordEncoder.encode(passwd);
        //암호화된 값을 다시 dto 에 넣기
        MemberDto dto=MemberDto.builder().userid(userid).passwd(passwd2).hp(hp).build();

        //db 저장
        memberService.insertMember(dto);
        return "success";
    }

    //중복 아이디 체크
    @GetMapping("/member/check")
    public String isIdCheck(@RequestParam("userid") String userid)
    {
        if(memberService.getIdCheck(userid))
            return "success";
        else
            return "fail";
    }

    @GetMapping("/member/login")
    public Map<String, Object> login(@RequestParam("userid") String userid,
                                     @RequestParam("passwd") String passwd)
    {
        Map<String, Object> map=new HashMap<>();
        //아이디에 해당하는 dto 얻기
        MemberDto dto=memberService.getLoginId(userid);
        if(dto==null)
            map.put("result", "noid");
        else {
            //해당 아이디로 저장된 암호화된 비번 얻기
            String encodePass=dto.getPasswd();
            boolean b=passwordEncoder.matches(passwd, encodePass);
            if(b) {//비번이 맞는경우
                map.put("result", "success");
                //아이디와 비번이 맞으므로 토큰을 얻어서 map 에 저장
                Authentication auth=new UserAuthentication(userid,null,null);
                String token=JwtTokenProvider.generateToken(auth, userid);
                System.out.println(token.length());
                map.put("token", token);
            }else {
                map.put("result", "fail");
            }
        }

        return map;
    }

    @GetMapping("/member/list")
    public List<MemberDto> list()
    {
        return memberService.getAllMembers();
    }
}