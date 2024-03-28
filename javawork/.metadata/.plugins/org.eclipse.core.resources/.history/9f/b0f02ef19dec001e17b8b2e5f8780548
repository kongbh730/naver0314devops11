package day0327;

public class StudentDto 
{
	private String name;
	private int age;
	private int java;
	private int spring;
	private int html;
	
	
	//디폴트 생성자
	public StudentDto() 
	{
		super();
	}
	
	//매개변수 있는 생성자
	public StudentDto(String name, int age, int java, int spring, int html) 
	{
		super();
		this.name = name;
		this.age = age;
		this.java = java;
		this.spring = spring;
		this.html = html;
	}

	//setter, getter
	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public int getAge() 
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public int getJava() 
	{
		return java;
	}

	public void setJava(int java) 
	{
		this.java = java;
	}

	public int getSpring() 
	{
		return spring;
	}

	public void setSpring(int spring)
	{
		this.spring = spring;
	}

	public int getHtml() 
	{
		return html;
		
	}

	public void setHtml(int html) 
	{
		this.html = html;
	}
	
	//여기서부터는 직접제작//setter는 필요 없잖아
	//java + spring + html의 합을 반환하는 메서드 getTotal
	public int getTotal()
	{
		return java + spring + html;
	}
	
	//getTotal()/3.0을 반환하는 메서드(getAvg())
	public double getAvg()
	{
		return getTotal() / 3.0;
	}
	
	//getAvg()의 값이 90 이상이면 *****
	//80이상이면 ****
	//70이상이면 ***
	//나머지는 * 반환하는 메서드 getGrade()
	public String getGrade()
	{
		int star;
		double grade = getAvg();
		
		if(grade >= 90)
		{
			star = 5;
		}
		else if(grade >= 80)
		{
			star = 4;
		}
		else if(grade >= 70)
		{
			star = 3;
		}
		else
		{
			star = 1;
		}
		
		return "*".repeat(star);
	}
}
