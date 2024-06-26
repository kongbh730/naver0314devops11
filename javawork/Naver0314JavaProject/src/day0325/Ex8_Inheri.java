package day0325;

class Phone2
{
	private String model;
	private String color;
	
	public Phone2(String model, String color) 
	{
		super();
		this.model = model;
		this.color = color;
	}

	public String getModel() 
	{
		return model;
	}

	public void setModel(String model) 
	{
		this.model = model;
	}

	public String getColor() 
	{
		return color;
	}

	public void setColor(String color)
	{
		this.color = color;
	}
}

class SmartPhone2 extends Phone2
{
	private String wifi;

	//왜냐면 부모클래스 Phone2에 기본 생성자가 없으니까
	public SmartPhone2(String model, String color, String wifi) 
	{
		super(model, color);
		this.wifi = wifi;
	}
	
	public void info()
	{
		System.out.println("모델명 : " + this.getModel());
		System.out.println("색상 : "+ this.getColor());
		System.out.println("와이파이 : " + wifi);
	}
	
}

public class Ex8_Inheri 
{
	public static void main(String[] args) 
	{
		SmartPhone2 s1 = new SmartPhone2("갤럭시", "실버", "KT");
		s1.info();
		
		SmartPhone2 s2 = new SmartPhone2("아이폰", "핑크", "SK");
		s2.info();
	}
}
