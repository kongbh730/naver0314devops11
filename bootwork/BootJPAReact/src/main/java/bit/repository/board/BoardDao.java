package bit.repository.board;

import bit.data.board.BoardDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class BoardDao {

    private BoardDaoInter boardDaoInter;

    public void insertBoard(BoardDto dto)
    {
        boardDaoInter.save(dto);
    }

    public List<BoardDto> getAllDatas()
    {
        return boardDaoInter.findAll(Sort.by(Sort.Direction.DESC, "board_num"));
    }

    public void updateReadCount(Long boardNum)
    {
        boardDaoInter.updateReadCount(boardNum);
    }

    public BoardDto getData(Long boardNum)
    {
        return boardDaoInter.getReferenceById(boardNum);
    }

    public boolean isEqualPass(Long boardNum, String pass)
    {
        return boardDaoInter.isEqualPass(boardNum, pass) == 1 ? true : false;
    }

    public void deleteBoard(Long boardNum)
    {
        boardDaoInter.deleteById(boardNum);
    }

    public void updateBoard(BoardDto dto)
    {
        if(dto.getPhoto().equals("no"))
        {
            boardDaoInter.updateBoardNoPhoto(dto);
        }
        else
        {
            boardDaoInter.save(dto);
        }
    }
}
