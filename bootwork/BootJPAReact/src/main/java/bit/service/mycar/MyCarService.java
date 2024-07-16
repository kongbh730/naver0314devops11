package bit.service.mycar;

import java.util.List;

import org.springframework.stereotype.Service;

import bit.data.mycar.MycarDto;
import bit.repository.mycar.MyCarDao;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MyCarService {

    private MyCarDao myCarDao;

    //전체 데이터 호출
    public List<MycarDto> getAllDatas()
    {
        return myCarDao.getAllDatas();
    }

    //저장
    public void insertMycar(MycarDto dto)
    {
        myCarDao.insertMycar(dto);
    }

    //삭제
    public void deleteMycar(Long num)
    {
        myCarDao.deleteMycar(num);
    }

    //버킷에 사진삭제를 위해 사진파일명 받기
    public MycarDto getData(Long num)
    {
        return myCarDao.getData(num);
    }


    //수정 : 구입일, 사진, 등록일 제외 수정
    public void updateMycar(MycarDto dto)
    {
        myCarDao.updateMycar(dto);//num 포함 수정
    }





}