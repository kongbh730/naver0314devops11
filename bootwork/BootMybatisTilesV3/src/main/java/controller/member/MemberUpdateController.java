package controller.member;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import data.dto.MemberDto;
import data.service.MemberService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import naver.cloud.NcpObjectStorageService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberUpdateController {
	
	@NonNull
	private MemberService memberService;
	
	//==========================================================================
	//NCP사용을 위해 추가된 것들!!!!
	private String bucketName = "bitcamp-bucket-56";
	private String folderName = "photocommon";
	
	@Autowired
	private NcpObjectStorageService storageService;
	//==========================================================================
	
	@ResponseBody
	@PostMapping("/upload")
	public Map<String, String> uploadPhoto(
			@RequestParam("upload") MultipartFile upload,
			@RequestParam int num,
			HttpServletRequest request
			)//여기 매개변수 필요없는거 지워야 함
	{
		//기존 코드 주석처리
		/*
		//업로드 위치 지정
		String savePath = request.getSession().getServletContext().getRealPath("/save");
		
		//업로드한 파일의 확장자 분리
		String ext = upload.getOriginalFilename().split("\\.")[1];
		
		//업로드할 파일명 
		String photo = UUID.randomUUID()+ "." + ext;//확장자에 맞춤
		
		//실제 업로드
		try {
			upload.transferTo(new File(savePath + "/" + photo));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		//==========================================================================
		//스토리지에 업로드하기//NCP 사용을 위해 새로 추가
		String photo = storageService.uploadFile(bucketName, folderName, upload);
		//==========================================================================
		
		//db에서 photo 수정
		memberService.updatePhoto(num, photo);
		
		Map<String, String> map = new HashMap<>();
		map.put("photoname", photo);
		
		return map;
	}
	
	//update
	//수정폼-이름,핸드폰,이메일,주소,생년월일 만 폼에 나타나도록
	@GetMapping("/updateform")
	public String updateForm(@RequestParam int num,Model model)
	{
		//db로부터 dto 얻기
		MemberDto dto=memberService.getData(num);
		model.addAttribute("dto", dto);
		return "member/updateform";
	}	
	//수정후 디테일 페이지로 이동
	@PostMapping("/update")
	public String update(@ModelAttribute MemberDto dto)
	{
		//수정
		memberService.updateMember(dto);
		return "redirect:./detail?num="+dto.getNum();
	}

	//delete
	//{"status":"success" or "fail"}
	@ResponseBody
	@GetMapping("/delete")
	public Map<String, String> delete(@RequestParam int num,@RequestParam String passwd)
	{
		Map<String, String> map=new HashMap<String, String>();
		//비번이 맞을경우 데이타 삭제
		boolean b=memberService.isEqualPassCheck(num, passwd);
		if(b) {
			memberService.deleteMember(num);
		}
		map.put("status", b?"success":"fail");
		return map;
	}
}
