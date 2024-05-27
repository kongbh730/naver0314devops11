package data.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import data.dto.MemberDto;

@Mapper //자동으로 bean으로 등록
public interface MemberMapperInter {

	@Select("select count(*) from memberdb")//mapper에서 주석 처리하고, 짧은거는 @Select로 지정할 수 있다.
	public int getTotalCount();

	@Select("select count(*) from memberdb where myid = #{searchid}")
	public int getIdCheckCount(String searchid);

	@Insert("""
			insert into memberdb (name, myid, passwd, addr, hp, email, photo, birthday, gaipday)
			values (#{name}, #{myid}, #{passwd}, #{addr}, #{hp}, #{email}, #{photo}, #{birthday}, now())
			""")
	public void insertMember(MemberDto dto);

	@Select("select * from memberdb order by num desc")
	public List<MemberDto> getAllMembers();
	
	@Select("select * from memberdb where num = #{num}")
	public MemberDto getData(int num);
	
	@Update("update memberdb set photo = #{photo} where num = #{num}")
	public void updatePhoto(Map<String, Object> map);
	
	@Update("""
			update memberdb set name=#{name},hp=#{hp},email=#{email},
		addr=#{addr},birthday=#{birthday} where num=#{num}
			""")
	public void updateMember(MemberDto dto);
	
	@Delete("delete from memberdb where num=#{num}")
	public void deleteMember(int num);
	
	@Select("select count(*) from memberdb where num=#{num} and passwd=#{passwd}")
	public int isEqualPassCheck(Map<String, Object> map);
	
	@Select("""
			select count(*) from memberdb where myid = #{myid} and passwd = #{pass}
			""")//일부러 passwd = #{pass} 적어봄
	public int isLoginCheck(String myid, String pass);
}

//xml - mapper - service - controller