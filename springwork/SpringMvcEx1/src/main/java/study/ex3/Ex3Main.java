package study.ex3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex3Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("appex3.xml");
		
		MyCart myCart = (MyCart)context.getBean("mycart");//id �����ϰ�
		myCart.showInfo();
		
		MyCart myCart2 = (MyCart)context.getBean("mycart");//id �����ϰ�
		myCart2.showInfo();
		
		System.out.println("�̱���� ���� ������ �����ص� �ּҰ� ����, prototype�� ���� ���� ������ ������ ���ο� �ּҿ� �����ȴ�.");
		
		System.out.println(myCart.hashCode());
		System.out.println(myCart2.hashCode());
	}
}
