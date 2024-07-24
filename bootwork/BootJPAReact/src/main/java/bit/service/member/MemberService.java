package bit.service.member;

import java.util.List;

import org.springframework.stereotype.Service;

import bit.data.member.MemberDto;
import bit.repository.member.MemberDao;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberService {

    private MemberDao memberDao;

    public void insertMember(MemberDto dto)
    {
        memberDao.insertMember(dto);
    }

    public List<MemberDto> getAllMembers()
    {
        return memberDao.getAllMembers();
    }

    public boolean getIdCheck(String userid)
    {
        return memberDao.getIdCheck(userid)==1?true:false;
    }

    public MemberDto getLoginId(String userid)
    {
        return memberDao.getLoginId(userid);
    }
}