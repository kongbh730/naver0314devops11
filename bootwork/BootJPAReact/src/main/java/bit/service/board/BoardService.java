package bit.service.board;

import bit.data.board.BoardDto;
import bit.repository.board.BoardDao;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BoardService {

   private BoardDao boardDao;

    public void insertBoard(BoardDto dto)
    {
        boardDao.insertBoard(dto);
    }

    public List<BoardDto> getAllDatas()
    {
        return boardDao.getAllDatas();
    }

    public void updateReadCount(Long boardNum)
    {
        boardDao.updateReadCount(boardNum);
    }

    public BoardDto getData(Long boardNum)
    {
        return boardDao.getData(boardNum);
    }

    public boolean isEqualPass(Long boardNum, String pass)
    {
        return boardDao.isEqualPass(boardNum, pass);
    }

    public void deleteBoard(Long boardNum)
    {
        boardDao.deleteBoard(boardNum);
    }

    public void updateBoard(BoardDto dto)
    {
        boardDao.updateBoard(dto);
    }




}
