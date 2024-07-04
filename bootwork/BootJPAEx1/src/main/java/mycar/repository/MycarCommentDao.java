package mycar.repository;

import lombok.AllArgsConstructor;
import mycar.data.MyCarCommentDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class MycarCommentDao
{
    private MycarCommentDaoInter commentDaoInter;

    // 댓글저장
    public void insertComment(MyCarCommentDto dto)
    {
        commentDaoInter.save(dto);
    }

    // 댓글 삭제
    public void deleteComment(int idx)
    {
        commentDaoInter.deleteById(idx);
    }

    //댓글들 반환
    public List<MyCarCommentDto> getAllComments(Long num)
    {
        return commentDaoInter.getMyCarCommentList(num);
    }


}
