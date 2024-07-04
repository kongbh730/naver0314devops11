package mycar.repository;

import jakarta.transaction.Transactional;
import mycar.data.MycarDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MyCarDaoInter extends JpaRepository<MycarDto, Long> {

    //사진을 선택 안했을 경우는 사진하고 구입날짜는 빼고 수정하는 걸로 sql을 작성해보자
    //@Query? : repository에 원하는 쿼리를 작성하게 해주는 어노테이션
    //nativeQuery? : JPA에서 지정한 규칙을 모두 무시할 수 있다
    @Query(value = """
                update mycar set carname=:carname, carprice=:carprice, carcolor=:carcolor where num=:num
            """, nativeQuery = true)
    @Modifying //@Modifying은 insert, update, delete뿐 아니라 DDL 구무을 사용할 때도 표기 해야 함
    @Transactional //@Transactional은 update, delete를 할 때 표기를 해줘야 정상 실행 됨
    public void updateMycarNoPhoto(@Param("num") Long num,
                                   @Param("carname") String carname,
                                   @Param("carprice") int carprice,
                                   @Param("carcolor") String carcolor);


    //파리미터를 dto로 받은 경우
    @Query(value = """
                update mycar set carname=:#{#dto.carname}, carprice=:#{#dto.carprice}, carcolor=:#{#dto.carcolor} where num=:#{#dto.num}
            """, nativeQuery = true)
    @Modifying
    @Transactional
    public void updateMycarNoPhoto(@Param("dto") MycarDto dto);


}
