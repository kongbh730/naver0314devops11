package bit.repository.mycar;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import bit.data.mycar.MycarDto;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class MyCarDao {

    private MyCarDaoInter myCarDaoInter;

    //전체 데이터 호출
    public List<MycarDto> getAllDatas()
    {
        return myCarDaoInter.findAll(Sort.by(Sort.Direction.DESC,"num"));//번호의 내림차순
    }

    //저장
    public void insertMycar(MycarDto dto)
    {
        myCarDaoInter.save(dto);
    }

    // sql 삭제
    public void deleteMycar(Long num)
    {
        myCarDaoInter.deleteById(num);
    }

    //버킷에 사진삭제를 위해 사진파일명 받기
    public MycarDto getData(Long num)
    {
        return myCarDaoInter.getReferenceById(num);
    }

    //수정 : 구입일, 사진, 등록일 제외 수정
    public void updateMycar(MycarDto dto)
    {
        myCarDaoInter.save(dto);//num 포함 수정
    }


}