package bit.repository.mycar;

import org.springframework.data.jpa.repository.JpaRepository;

import bit.data.mycar.MycarDto;

public interface MyCarDaoInter extends JpaRepository<MycarDto, Long>{

}