package bit.controller.board;

import bit.data.board.BoardDto;
import bit.service.board.BoardCommentService;
import bit.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boot/board/")
public class BoardController {

    final private BoardService boardService;
    final private NcpObjectStorageService storageService;
    final private BoardCommentService boardCommentService;

    String bucketName="bitcamp-kbh-37";
    String folderName="reactboard";


    @PostMapping("/upload")
    public String photoUpload(@RequestParam("upload") MultipartFile upload )
    {
        System.out.println("upload >> " + upload.getOriginalFilename());
        String photoName = storageService.uploadFile(bucketName, folderName, upload);

        return photoName;
    }

    @PostMapping("/insert")
    public void boardInsert(@RequestBody BoardDto dto)
    {
        System.out.println("insert >> " + dto);
        boardService.insertBoard(dto);
    }

    @GetMapping("/list")
    public List<BoardDto> boardList()
    {
        System.out.println("list >> ");
        List<BoardDto> list= boardService.getAllDatas();
        for(BoardDto dto:list)
        {
            //댓글 갯수 구하기
            int answercount = boardCommentService.getCommentList(dto.getBoardnum()).size();
            dto.setAnswercount(answercount);
        }

        //return boardService.getAllDatas();
        return list;
    }

    @GetMapping("/detail")
    public BoardDto detail(@RequestParam("boardnum") Long boardnum)
    {
        System.out.println("detail >> " + boardnum);
        //조회수 증가 후 dto 반환
        boardService.updateReadCount(boardnum);

        return boardService.getData(boardnum);
    }

    @GetMapping("/updatecheckpass")
    public Map<String, Object> checkPass(@RequestParam Long boardnum, @RequestParam String pass)
    {
        System.out.println("checkPass >> " + boardnum);
        Map<String, Object> map = new HashMap<>();
        boolean flag = boardService.isEqualPass(boardnum, pass);

        if(flag){
            //BoardDto boardDto = boardService.getData(boardnum);
            //map.put("dto", map);
            map.put("result", "success");
        }
        else
        {
            map.put("result", "fail");
        }

        return map;
    }

    @GetMapping("/updateform")
    public BoardDto select(@RequestParam ("boardnum") Long boardnum)
    {
        return boardService.getData(boardnum);
    }

    @PostMapping("/update")
    public void update(@RequestBody BoardDto dto)
    {
        boardService.updateBoard(dto);
    }

    @GetMapping("/deletecheckpass")
    public Map<String, Object> delcheckPass(@RequestParam("boardnum") Long boardnum, @RequestParam("pass") String pass)
    {
        System.out.println("deletepass >> " + boardnum + ", " + pass);
        Map<String, Object> map = new HashMap<>();
        boolean flag = boardService.isEqualPass(boardnum, pass);

        if(flag)
        {
            //비번이 맞으면
            String oldPhotoName = boardService.getData(boardnum).getPhoto(); //사진 정보 가져와서
            storageService.deleteFile(bucketName, folderName, oldPhotoName); //버켓에서 사진 삭제
            boardService.deleteBoard(boardnum);

            map.put("result", "success");
        }
        else
        {
            map.put("result", "fail");
        }

        return map;
    }
}
