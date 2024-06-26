package day0325;

public class Employee 
{
	private String name;
	private String position;
	private int age;
	private int gibon;
	private int sudang;
	
	//생성자
	public Employee() 
	{
		super();
	}
	public Employee(String name, int age) 
	{
		super();
		this.name = name;
		this.age = age;
	}
	public Employee(String name, String position, int age) 
	{
		super();
		this.name = name;
		this.position = position;
		this.age = age;
	}
	
	//getter & setter
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getPosition() 
	{
		return position;
	}
	public void setPosition(String position) 
	{
		this.position = position;
	}
	public int getAge() 
	{
		return age;
	}
	public void setAge(int age) 
	{
		this.age = age;
	}
	public int getGibon() 
	{
		return gibon;
	}
	public void setGibon(int gibon) 
	{
		this.gibon = gibon;
	}
	public int getSudang() 
	{
		return sudang;
	}
	public void setSudang(int sudang) 
	{
		this.sudang = sudang;
	}
	
	//getter 직접 생성
	public int getNetPay()
	{
		return getGibon() + getSudang();
	}
	
	//setter 직접 생성
	public void setPay(int gibon, int sudang)
	{
		setGibon(gibon);
		setSudang(sudang);
	}
	public void setSawon(String name, String position, int age)
	{
		setName(name);
		setPosition(position);
		setAge(age);
	}
	
	//그냥 추가해 본 거
	private char c;
	public char getC() 
	{
		return c;
	}
	public void setC(char c) 
	{
		this.c = c;
	}
}
