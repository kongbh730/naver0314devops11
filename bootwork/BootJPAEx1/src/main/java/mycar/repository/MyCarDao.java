package mycar.repository;

import lombok.AllArgsConstructor;
import mycar.data.MycarDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class MyCarDao{

    private MyCarDaoInter daoInter;

    //DB 저장
    public void insertCar(MycarDto dto)
    {
        daoInter.save(dto);//id 타입(num)이 포함되어 있을 경우 자동으로 update 실행, 없을 경우 자동으로 insert 실행
    }

    //전체 목록
    public List<MycarDto> getAllCars()
    {
        //return daoInter.findAll(); //추가된 순서로 반환
        //return daoInter.findAll(Sort.by(Sort.Direction.DESC, "carprice"));//가격이 비싼거부터 출력
        //return daoInter.findAll(Sort.by(Sort.Direction.ASC, "carname"));//자동차명 오름차순
        return daoInter.findAll(Sort.by(Sort.Direction.DESC,"num")); //나중에 추가됐을 수록 위로
    }

    //=======================================================================================================

    //num에 해당하는 이미지 가져오기
    public MycarDto getData(Long num)
    {
        return daoInter.getReferenceById(num); // 나머지는 deprecated 상태
    }

    //수정
    public void updateCar(MycarDto dto)
    {
        if(dto.getCarphoto().equals("no"))
        {
            daoInter.updateMycarNoPhoto(dto.getNum(), dto.getCarname(), dto.getCarprice(), dto.getCarcolor());//다른 표기법
            //daoInter.updateMycarNoPhoto(dto);//다른 표기법
        }
        else
        {
            daoInter.save(dto);//num이 포함되어 있을 경우 모든 컬럼 수정
        }
    }

    //삭제
    public void deleteCar(Long num)
    {
        daoInter.deleteById(num);
    }

    //전체 갯수 구하기
    public Long getTotalCount()
    {
        return daoInter.count();
    }

    //페이지 출력
    public Page<MycarDto> getAllCars(Pageable pageable)
    {
        return daoInter.findAll(pageable);//페이지에 필요한 만큼만 데이터 반환;
    }

}
