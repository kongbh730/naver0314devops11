package member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import member.dto.MemberDto;

@Repository
@RequiredArgsConstructor
public class MemberDao {
	
	//@Autowired
	@NonNull//변수 여러개니까 이거 써도 되고
	private SqlSession session;
	
	private String namespace ="member.dao.MemberDao.";
	
	public int getTotalCount()
	{
		return session.selectOne(namespace + "memberTotalCount");
	}
	
	public int getSearchId(String searchid)
	{
		return session.selectOne(namespace + "selectIdCheck", searchid);//memberMapper.xml의 selectIdCheck의 변수와 동일한 이름이어야 함 
	}
	
	public void insertMember(MemberDto dto)
	{
		session.insert(namespace + "inserMember", dto);
	}
	
	public List<MemberDto> getAllMembers()
	{
		return session.selectList(namespace + "selectAllMembers");
	}
	
	public MemberDto getData(int num)
	{
		return session.selectOne(namespace + "selectByNumData", num);
	}
	
	public void updatePhoto(Map<String, Object> map)
	{
		session.update(namespace + "updatePhoto", map);
	}
	
	public void updateMember(MemberDto dto)
	{
		session.update(namespace + "updateMember", dto);
	}
	
	public boolean isEqualPassCheck(Map<String, Object> map)
	{
		int n = session.selectOne(namespace + "equalPassCheck", map);
		
		return n == 1 ? true : false; //1이면 비번이 맞은 경우니까 true 반환
	}
	
	public void deleteMember(int num)
	{
		session.delete(namespace + "deleteMember", num);
	}
}
