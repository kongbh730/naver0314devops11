package bit.controller.board;

import bit.data.board.BoardDto;
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
        return boardService.getAllDatas();
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
        Map<String, Object> map = new HashMap<>();

        boolean flag = boardService.isEqualPass(boardnum, pass);
        if(flag){
            map.put("dto", map);
            map.put("result", "success");
        }
        else
        {
            map.put("result", "fail");
        }

        return map;
    }

    @PostMapping("/update")
    public void update(@RequestBody BoardDto dto)
    {
        boardService.updateBoard(dto);
    }

    @GetMapping("/deletecheckpass")
    public Map<String, Object> delcheckPass(@RequestParam Long boardnum, @RequestParam String pass)
    {
        Map<String, Object> map = new HashMap<>();

        boolean flag = boardService.isEqualPass(boardnum, pass);
        if(flag)
        {
            //비번이 맞으면
            String oldPhotoName = boardService.getData(boardnum).getPhoto(); //사진 정보 가져와서
            storageService.deleteFile(bucketName, folderName, oldPhotoName); //버켓에서 사진 삭제
            map.put("result", "success");
        }
        else
        {
            map.put("result", "fail");
        }

        return map;
    }
}
