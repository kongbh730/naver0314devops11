package bit.repository.member;

import java.util.List;

import org.springframework.stereotype.Repository;

import bit.data.member.MemberDto;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class MemberDao {
    private MemberDaoInter memberDaoInter;

    public void insertMember(MemberDto dto)
    {
        memberDaoInter.save(dto);
    }

    public List<MemberDto> getAllMembers()
    {
        return memberDaoInter.findAll();
    }

    public int getIdCheck(String userid)
    {
        return memberDaoInter.getIdCheck(userid);
    }

    public MemberDto getLoginId(String userid)
    {
        return memberDaoInter.getLoginId(userid);
    }
}