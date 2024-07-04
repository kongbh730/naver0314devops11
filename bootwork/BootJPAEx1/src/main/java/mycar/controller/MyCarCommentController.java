package mycar.controller;

import lombok.RequiredArgsConstructor;
import mycar.data.MyCarCommentDto;
import mycar.data.MycarDto;
import mycar.repository.MycarCommentDao;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mycar")
public class MyCarCommentController
{
    final private MycarCommentDao commentDao;

    @GetMapping("/addcomment")
    public void addComment(@RequestParam("num") Long num,
                           @RequestParam("comment") String comment)
    {
        //먼저 MyCarDto에 num값을 넣은 후 MyCarCommentDto 에 넣는다(외부키로 지정된 값)
        MycarDto dto = MycarDto.builder().num(num).build();

        MyCarCommentDto commentDto =MyCarCommentDto.builder()
                .comment(comment)
                .mycar(dto)
                .build();

        //댓글 추가
        commentDao.insertComment(commentDto);
    }

    @GetMapping("/commentlist")
    public List<MyCarCommentDto> commentList(@RequestParam("num") Long num)
    {

        return commentDao.getAllComments(num);
    }
}
