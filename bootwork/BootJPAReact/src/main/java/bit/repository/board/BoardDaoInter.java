package bit.repository.board;

import bit.data.board.BoardDto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardDaoInter extends JpaRepository<BoardDto, Long> {

    //사진 수정을 안할경우
    @Query(value = """
        update reactboard set writer=:#{#dto.writer},
        subject=:#{#dto.subject},
        content=:#{#dto.content}
        where boardnum=:#{#dto.boardnum}
        """, nativeQuery = true)
    @Modifying //update,delete 에 필수 추가
    @Transactional //update,delete 에 필수 추가
    public void updateBoardNoPhoto(@Param("dto") BoardDto dto);

    @Query(value = """
        update reactboard set readcount=readcount+1 where boardnum=:boardnum
        """, nativeQuery = true)
    @Modifying //update,delete 에 필수 추가
    @Transactional //update,delete 에 필수 추가
    public void updateReadCount(@Param("boardnum") Long boardnum);

    @Query(value = """
        select count(*) from reactboard
        where boardnum=:boardnum and pass=:pass
        """, nativeQuery = true)
    public int isEqualPass(@Param("boardnum") Long boardnum, @Param("pass") String pass);




}
