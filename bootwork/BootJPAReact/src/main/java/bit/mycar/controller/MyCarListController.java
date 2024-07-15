package bit.mycar.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import bit.mycar.data.MycarDto;
import bit.mycar.service.MyCarService;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class MyCarListController {
    final MyCarService myCarService;
    final NcpObjectStorageService storageService;

    private String bucketName="bitcamp-kbh-37";
    private String folderName="mycar";

    @GetMapping("/mycar/list")
    public List<MycarDto> list()
    {
        return myCarService.getAllDatas();
    }

    //day0715
    //업로드
    @PostMapping("/mycar/upload")
    public Map<String, String> uploadPhoto(@RequestParam("upload") MultipartFile upload)
    {
        System.out.println("photo upload >> " + upload.getOriginalFilename());

        //스토리지에 업로드 후 업로드된 파일명 반환
        String carphoto = storageService.uploadFile(bucketName, folderName, upload);
        Map<String, String> map = new HashMap<String, String>();
        map.put("carphoto", carphoto);
        return map;
    }

    // dto 데이터 DB 저장
    // RequestBody : DTO를 클래스로 변환(json을 dto로 변환해서 받을 때 <-> RequestParam)
    @PostMapping("/mycar/insert")
    public void insert(@RequestBody MycarDto dto)
    {
        System.out.println("insert dto >> " + dto);//toString 호출
        myCarService.insertMycar(dto);
    }
    
    //삭제
    @DeleteMapping("/mycar/delete")
    public void delete(Long num)
    {
        System.out.println("delete >> "+num);

        String oldPhotoname=myCarService.getData(num).getCarphoto();//사진파일명 호출
        storageService.deleteFile(bucketName, folderName, oldPhotoname);//사진 파일 삭제
        
        myCarService.deleteMycar(num);// sql 삭제
    }
    
    

}