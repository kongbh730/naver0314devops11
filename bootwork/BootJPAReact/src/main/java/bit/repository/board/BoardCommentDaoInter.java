package bit.repository.board;

import bit.data.board.BoardCommentDto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardCommentDaoInter extends JpaRepository<BoardCommentDto, Long> {

    //게시글에 달린 모든 댓글 목록
    @Query(value= """
        select * from boardanswer where boardnum=:boardnum order by idx desc
        """, nativeQuery = true)
    public List<BoardCommentDto> getCommentList(@Param("boardnum") Long boardnum);

    //수정은 comment만
    @Query(value = """
        update boardanswer set comment=:comment where idx=:idx
        """, nativeQuery = true)
    @Modifying
    @Transactional
    public void updateComment(@Param("idx") Long idx,@Param("comment") String comment);
}
