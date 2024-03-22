package day0322;

class Orange
{
	//private 접근 지정자는 같은 클래스내에서만 접근 가능
	//외부에서는 인식조차 불가
	//class 멤버변수는 자동초기화
	private String name;//null로 자동 초기화
	private int age; //0으로 자동초기화
	
	private static String company = "삼성";//private인데 static?
	
	//getter 메서드 : 멤버변수값을 반환하는 메서드 (규칙 getName, getAge)//get'N'ame 대문자 중요! //거의 public으로 접근제한
	public String getName()// [ 접근제한자 데이터타입 메서드명() ]
	{
		//return name;//생략 가능//같은 구역 안에 같은 이름이 없을 경우에만 this 생략 가능
		return this.name;//this : 자기자신을 의미하는 인스턴스 변수(일반 멤버메서드에만 존재, static 메서드에는 없음)	
	}
	public int getAge()// [ 접근제한자 데이터타입 메서드명() ]
	{
		return this.age;//this : 자기자신을 의미하는 인스턴스 변수(일반 멤버메서드에만 존재, static 메서드에는 없음)	
		//return age;//this.생략가능 : 근데 그냥 this. 쓸래
	}
	
	//setter 메서드 : 외부로부터 값을 받아서 멤버변수의 값을 변경//접근 제한은 주로 public, 반환형은 반환할 필요가 없으니 주로 void
	public void setName(String name)//setter의 경우 this.멤버변수를 하는 이유는 자동생성을 할때 인자명이 멤버변수명과 동일하게 만들어지기 때문이다.
	{
		this.name = name;//멤버변수 name에 인자 name값을 저장
		//this.name : 멤버변수
		//name : 파라미터로 전달된 인자 name
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	
	//static 변수를 반환하는 메서드
	public static String getCompany()
	{
		return company;
	}
	
	
}

public class Ex2_Object {
	public static void main(String[] args) 
	{
		System.out.println("회사 : " +  Orange.getCompany());//static이면 new 생성 안하고도 출력 가능
		
		Orange or = new Orange();
		System.out.println("\n초기값 확인");
		//System.out.println("name : " + or.name());//인식조차 불가
		//System.out.println("Age : " + or.age());//인식조차 불가
		System.out.println("name : " + or.getName());
		System.out.println("Age : " + or.getAge());
		
		System.out.println("\n이름과 나이 변경 후 출력");
		or.setName("옥순이");
		or.setAge(23);
		System.out.println("name : " + or.getName());
		System.out.println("Age : " + or.getAge());
		
		System.out.println("회사 : " +  Orange.getCompany());
	}
}
