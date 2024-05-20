package anno.study.ex5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Emp {
	@NonNull
	private Sawon sawon;
	
	@Value("��Ʈķ��")
	private String empName;
	
	@Value("2024-05-17")
	private String ipsaday;
	
	public void sawonInfo()
	{
		System.out.println("��� ����");
		System.out.println("�Ի��� : " + ipsaday);
		System.out.println("ȸ��� : " + empName);
		System.out.println("����� : " + sawon.getName());
		System.out.println("�ּ� : " + sawon.getAddr());
		System.out.println("���� : " + sawon.getAge());
	}
}
