package mycar.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import mycar.data.MycarDto;
import mycar.repository.MyCarDao;
import naver.storage.NcpObjectStorageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MycarController {

    private final MyCarDao myCarDao;
    private final NcpObjectStorageService storageService;

    //bucket 명
    String bucketName = "bitcamp-kbh-37";
    //업로드할 폴더 명
    String folderName = "mycar";

    @GetMapping("/")
    public String home()
    {
        return "redirect:./mycar/list";
    }

    @GetMapping("/mycar/list")
    public String list(Model model)
    {
        List<MycarDto> list = myCarDao.getAllCars();

        model.addAttribute("list", list);
        model.addAttribute("count", list.size());

        return "mycar/mycarlist";
    }

    @GetMapping("/mycar/form")
    public String form()
    {
        return "mycar/mycarform";
    }

    @PostMapping("/mycar/insert")
    public String insertCar(@ModelAttribute MycarDto dto,
                            @RequestParam("carupload") MultipartFile carupload)
    {
        //사진을 업로드 후 업로드된 파일명 반환
        String carphoto = storageService.uploadFile(bucketName, folderName, carupload);
        dto.setCarphoto(carphoto);

        //db insert
        myCarDao.insertCar(dto);

        return "redirect:./list";
    }
}
