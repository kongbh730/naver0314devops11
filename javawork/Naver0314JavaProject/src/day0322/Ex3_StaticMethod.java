package day0322;

class MyShop
{
	private String sangpum;
	private int su, dan;
	private static String message;//공유되는 값

	public static final String SHOP = "24시간 이마트";

	//setter method
	public void setSangpum(String sangpum)
	{
		this.sangpum = sangpum;
	}
	public void setSu(int su)
	{
		this.su = su;
	}
	public void setDan(int dan)
	{
		this.dan = dan;
	}
	public static void setMessage(String message)
	{
		//static 멤버변수는 같은 구역에 같은 이름의 변수가 있을 경우 앞에 클래스명을 생략하지 말고 써준다.
		MyShop.message = message;//클래스명으로 접근//static은 this가 없음
	}

	//getter method
	public String getSangpum()
	{
		return this.sangpum;
	}
	public int getSu()
	{
		return this.su;
	}
	public int getDan()
	{
		return this.dan;
	}
	public static String getMessage()
	{
		//static 멤버변수는 같은 구역에 같은 이름의 변수가 있을 경우 앞에 클래스명을 생략하지 말고 써준다.
		return MyShop.message;//클래스명으로 접근//static은 this가 없음
	}

	//오버로딩에 관한 내용
	//상품, 수량, 단가를 한번에 변경하고 싶을 경우
	public void setData(String sangpu, int su, int dan)
	{
		//메서드 안에서 같은 멤버 메서드느 this로 호출이 가능
		this.setSangpum(sangpum);
		this.setSu(su);
		this.setDan(dan);
	}
	
	//setData의 오버로딩 메서드 //중복함수 : 메서드명은 같으나 인자가 달라야함
	//같은 이름으로 다른 기능을 수행함
	//인자 개수, 인자 타입이 달라야함
	public void setData(String sangpu,int su, int dan, String message)
	{
		//메서드 안에서 같은 멤버 메서드는 this로 호출이 가능
		this.setSangpum(sangpum);
		this.setSu(su);
		this.setDan(dan);
		
		//1. 인스턴스 메서드에서 static 메서드 호출 가능?
		//일반메서드에서 static 메서드 호출 가능!
		setMessage(message);//앞에 클래스명은 같은 클래스라 생략가능
		//MyShop.setMessage(message);
		
		//2. static 메서드에서 인스턴스 메서드 호출 가능?
		//호출 불가!
		
		//3. static 메서드에서 같은 static 메서드는 호출 가능?
		//호출 가능!	
	}
	
	//출력은 getter가 아닌 일반 멤버 메서드로 만들어 보자
	public void writeData()
	{
		System.out.println("상품명 : " + sangpum);
		System.out.println("수량 : " + su  +  " , 단가 : " + dan);
		System.out.println("총금액 : " + (su*dan));
		System.out.println("오늘의 메세지 : " + message);
		System.out.println("=".repeat(20));
	}
}

public class Ex3_StaticMethod 
{
	public static void main(String[] args) 
	{
		//static : 모든 객체들이 사용할 수 있는 공유영역
		//instance : 모든 객체들이 각각 가지는 고유영역
		//MyShop A = new MyShop();
		//MyShop B = new MyShop();
		MyShop sang1 = new MyShop();
		MyShop sang2 = new MyShop();
		MyShop sang3 = new MyShop();
		
		System.out.println("** 상품 1 **");
		sang1.setSangpum("딸기");
		sang1.setSu(3);
		sang1.setDan(2300);
		MyShop.setMessage("오늘 각종 과일 세입합니다.");//static 메서드는 클래스명으로 호출
		//공유데이터 static 메서드는 모든 객체가 공유!!!

		sang1.writeData();
		
		System.out.println("** 상품 2 **");
		sang2.setData("수박", 2, 30000);
		sang2.writeData();
		
		System.out.println("** 상품 3 **");
		sang2.setData("참외", 5, 2000, "오늘 세일 마감!!");
		sang2.writeData();

		System.out.println("** 상품 1 다시 출력 **");
		sang1.writeData();
		
		System.out.println("** 상품 2의 수량만 변경 **");
		sang2.setSu(5);
		sang2.writeData();
	}
}
