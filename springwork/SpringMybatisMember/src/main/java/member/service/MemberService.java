package member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import member.dao.MemberDao;
import member.dto.MemberDto;

@Service 
@AllArgsConstructor//이거 쓰던가
public class MemberService {
	
	//@Autowired//이거쓰던가
	private MemberDao memberDao;
	
	public int getTotalCount()
	{
		return memberDao.getTotalCount();
	}
	
	public int getSearchId(String searchid)
	{
		return memberDao.getSearchId(searchid);
	}
	
	public void insertMember(MemberDto dto)
	{
		memberDao.insertMember(dto);
	}
	
	public List<MemberDto> getAllMembers()
	{
		return memberDao.getAllMembers();
	}
}
