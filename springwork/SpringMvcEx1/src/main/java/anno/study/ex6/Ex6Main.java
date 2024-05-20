package anno.study.ex6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex6Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("appex6.xml");
		ShopController shopCont = (ShopController)context.getBean("shopcont");
		
		shopCont.insert("û����", 2, 25000);
		System.out.println("-".repeat(50));
		shopCont.delete("û����");
		System.out.println("-".repeat(50));
		shopCont.update("����", 1, 120000);
	}
}