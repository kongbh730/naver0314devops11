package study.ex2;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class MyInfo {
	private String name;
	private int age;
	private String addr;
	
	/*
	//�Һ��� allarguments.constructor����ص� ��
	public MyInfo(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "MyInfo [name = " + name + ", age = " + age + ", addr = " + addr  +"]";
	}
	*/
	
}
