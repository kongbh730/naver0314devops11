package anno.study.ex6;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor //�ƹ� ���� ���� ������
@AllArgsConstructor	//��� ���� �ִ� ������
@Data //getter, setter

public class ShopDto {
	private String sang;
	private int su;
	private int dan;

}
