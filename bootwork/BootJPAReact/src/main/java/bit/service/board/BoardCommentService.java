package bit.service.board;

import bit.data.board.BoardCommentDto;
import bit.repository.board.BoardCommentDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BoardCommentService {
    private BoardCommentDao boardCommentDao;

    //추가
    public void insertComment(BoardCommentDto dto)
    {
        boardCommentDao.insertComment(dto);
    }

    //목록
    public List<BoardCommentDto> getCommentList(Long boardnum)
    {
        return boardCommentDao.getCommentList(boardnum);
    }

    //수정
    public void updateComment(Long idx, String comment)
    {
        boardCommentDao.updateComment(idx,comment);
    }

    //삭제
    public void deleteComment(Long idx)
    {
        boardCommentDao.deleteComment(idx);
    }

}
