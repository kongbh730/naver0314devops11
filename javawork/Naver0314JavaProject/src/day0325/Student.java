package day0325;

public class Student 
{
	private String name;
	private int java;
	private int spring;
	//double total;
	//double average;
	//String grade;

	//constructor
	//자동으로 만들어지는 생성자
	//menu or 에디터상 마우스 오른쪽클릭 -> source -> generate Constructor using fields
	public Student() 
	{
		//super();//부모클래스의 디폴트 생성자 호출하는 명령어, 생략가능
		this("아무개", 10, 10);//초기값을 주고 싶은 경우
	}
	public Student(String name) 
	{
		super();
		this.name = name;
	}
	public Student(int java, int spring)//이름인자가 없으니 이름이 null로 저장됨
	{
		super();
		this.java = java;
		this.spring = spring;
	}
	public Student(String name, int java, int spring)
	{
		super();
		this.name = name;
		this.java = java;
		this.spring = spring;
	}

	//menu or 에디터상 마우스 오른쪽클릭 -> source -> generate Getters and Setters
	//자동으로 만들어지는 getter
	public String getName() 
	{
		return name;
	}
	//자동으로 만들어지는 setter
	public void setName(String name) 
	{
		this.name = name;
	}
	//자동으로 만들어지는 getter
	public int getJava() 
	{
		return java;
	}
	//자동으로 만들어지는 setter
	public void setJava(int java) 
	{
		this.java = java;
	}
	//자동으로 만들어지는 getter
	public int getSpring() 
	{
		return spring;
	}
	//자동으로 만들어지는 setter
	public void setSpring(int spring) 
	{
		this.spring = spring;
	}

	//추가로 필요한 메서드
	//직접 만들어야 하는 getter
	public int getTotal()
	{
		return java + spring;
	}
	public double getAverage()
	{
		return getTotal() / 2.0;
		//getTotal은 정수형이기 때문에 분모를 실수형으로 하여 반환값을 실수형으로 반환한다.
	}
	public String getGrade()
	{
		if(getAverage() >= 90.0)
		{
			return "장학생";
		}
		else if(getAverage() >= 80.0)
		{
			return "우등생";
		}
		else
		{
			return "재시험";
		}
	}

	//직접 만들어야 하는 setter
	public void setScore(int java, int spring)
	{
		this.java = java;
		this.spring = spring;
	}









}