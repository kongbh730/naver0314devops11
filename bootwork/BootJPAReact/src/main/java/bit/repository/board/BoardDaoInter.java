package bit.repository.board;

import bit.data.board.BoardDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardDaoInter extends JpaRepository<BoardDto, Long> {

    //사진 수정을 안할경우
    @Query(value = """
        update reactboard set writer=:#{#dto.writer},
        subject=:#{#dto.subject},
        content=:#{#dto.content}
        where board_num=:#{#dto.boardNum}
        """, nativeQuery = true)
    public void updateBoardNoPhoto(@Param("dto") BoardDto dto);

    @Query(value = """
        update reactboard set readcount=readcount+1 where board_num=:boardNum
        """, nativeQuery = true)
    public void updateReadCount(@Param("boardNum") Long boardNum);

    @Query(value = """
        select count(*) from reactboard
        where board_num=:boardNum and pass=:pass
        """, nativeQuery = true)
    public int isEqualPass(@Param("boardNum") Long boardNum, @Param("pass") String pass);




}
