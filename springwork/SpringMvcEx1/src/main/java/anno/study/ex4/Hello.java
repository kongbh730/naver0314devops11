package anno.study.ex4;

import org.springframework.stereotype.Component;

//@Component // �� ���� Ŭ���� �̸��� �� ���̵� �ȴ�(�� ù���ڴ� �ҹ��ڷ� ����)

@Component("h") //h�� ���̵� ��
public class Hello {
	public void showMessage() {
		System.out.println("Hello class�� ���� �޼ҵ��Դϴ�.");
	}
}
