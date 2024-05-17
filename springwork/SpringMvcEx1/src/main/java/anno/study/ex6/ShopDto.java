package anno.study.ex6;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor //아무 변수 없는 생성자
@AllArgsConstructor	//모든 변수 있는 생성자
@Data //getter, setter

public class ShopDto {
	private String sang;
	private int su;
	private int dan;

}
