package member.dao;

import java.util.List;

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
	@NonNull//���� �������ϱ� �̰� �ᵵ �ǰ�
	private SqlSession session;
	
	private String namespace ="member.dao.MemberDao.";
	
	public int getTotalCount()
	{
		return session.selectOne(namespace + "memberTotalCount");
	}
	
	public int getSearchId(String searchid)
	{
		return session.selectOne(namespace + "selectIdCheck", searchid);//memberMapper.xml�� selectIdCheck�� ������ ������ �̸��̾�� �� 
	}
	
	public void insertMember(MemberDto dto)
	{
		session.insert(namespace + "inserMember", dto);
	}
	
	public List<MemberDto> getAllMembers()
	{
		return session.selectList(namespace + "selectAllMembers");
	}
	
}
