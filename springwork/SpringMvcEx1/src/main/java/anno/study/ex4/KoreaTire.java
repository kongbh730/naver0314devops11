package anno.study.ex4;

import org.springframework.stereotype.Component;

@Component//ù���ڰ� �ҹ��ڷ� koreaTire�� ���̵� ��
public class KoreaTire implements Tire {
	@Override
	public String getTireName() {
		return "�ѱ�Ÿ�̾�";
	}
}
