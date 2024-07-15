package bit.mycar.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import bit.mycar.data.MycarDto;
import bit.mycar.service.MyCarService;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;

@RestController
@RequiredArgsConstructor
public class MyCarListController {
    final MyCarService myCarService;
    final NcpObjectStorageService storageService;

    private String bucketName="bitcamp-bucket-56";
    private String folderName="mycar";

    @GetMapping("/mycar/list")
    public List<MycarDto> list()
    {
        return myCarService.getAllDatas();
    }


}