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

    final private BoardCommentService boardCommentService;

//    @GetMapping("/insert")
//    public void insertComment(@RequestParam("boardnum") Long boardnum,
//                              @RequestParam("nickname") String nickname,
//                              @RequestParam("comment") String comment)
//    {
//        System.out.println("comment insert >> " + boardnum);
//        BoardDto boardDto = BoardDto.builder().boardnum(boardnum).build();
//
//        BoardCommentDto dto = BoardCommentDto.builder()
//                .nickname(nickname)
//                .comment(comment)
//                .boardDto(boardDto)
//                .build();
//
//        boardCommentService.insertComment(dto);
//    }

    @PostMapping("/insert")
    public void insertComment(@RequestBody BoardCommentDto boardCommentDto)
    {
        System.out.println(boardCommentDto);
        BoardDto boardDto = BoardDto.builder().boardnum(boardCommentDto.getBoardnum()).build();
        System.out.println(boardDto);
        boardCommentDto.setBoardDto(boardDto);
        
        boardCommentService.insertComment(boardCommentDto);//이걸 왜 몰랐냐
    }

    @GetMapping("/list")
    public List<BoardCommentDto> list(@RequestParam("boardnum") Long boardnum)
    {
        return boardCommentService.getCommentList(boardnum);
    }

    @DeleteMapping("/delete")
    public void deleteComment(@RequestParam("idx") Long idx)
    {
        boardCommentService.deleteComment(idx);
    }

    @GetMapping("/update")
    public void updateComment(@RequestParam("idx") Long idx,
                              @RequestParam("comment") String comment)
    {
        boardCommentService.updateComment(idx, comment);
    }


}
