package data.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor //디폴트 생성자
@Data
@Alias("MemberDto")//마이바티스에 있는 어노테이션 -> 주석해제해야함
@Builder // AllArgsConstructor가 필수로 필요함 //setter로 데이터 넣을 때 사용
@AllArgsConstructor //생성자
public class MemberDto {
	private int num;
	private String myid;
	private String passwd;
	private String name;
	private String addr;
	private String hp;
	private String email;
	private String photo;
	private String birthday;
	private Timestamp gaipday;
}
