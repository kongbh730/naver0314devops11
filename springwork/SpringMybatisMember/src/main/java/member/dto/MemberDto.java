package member.dto;

import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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
