package bit.controller.board;

import bit.data.board.BoardCommentDto;
import bit.data.board.BoardDto;
import bit.service.board.BoardCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boot/comment")
public class BoardCommentController {

    private BoardCommentService boardCommentService;

    @GetMapping("/insert")
    public void insertComment(@RequestParam("boardnum") Long boardnum,
                              @RequestParam("nickname") String nickname,
                              @RequestParam("comment") String comment)
    {
        BoardDto boardDto = BoardDto.builder().boardnum(boardnum).build();

        BoardCommentDto dto = BoardCommentDto.builder()
                .nickname(nickname)
                .comment(comment)
                .boardDto(boardDto)
                .build();

        boardCommentService.insertComment(dto);
    }

    @GetMapping("/list")
    public List<BoardCommentDto> list(@RequestParam("boardnum") Long boardnum)
    {
        return boardCommentService.getCommentList(boardnum);
    }




}
