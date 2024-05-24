package data.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper //자동으로 bean으로 등록
public interface MemberMapperInter {
	
	@Select("select count(*) from memberdb")//mapper에서 주석 처리하고, 짧은거는 @Select로 지정할 수 있다.
	public int getTotalCount();
}

//xml - mapper - service - controller