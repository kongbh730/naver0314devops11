package day0322;

class Member
{
	private String name;
	private String hp;
	private String addr;

	/*
	Member()//생성자1
	{
		name = "박지성";
		hp = "010-3333-3333";
		addr = "서울";
	}
	Member(String name)//생성자2
	{
		this.name = name;
		hp = "010-0000-0000";
		addr = "미입력";
	}
	Member(String name, String hp)//생성자3
	{
		this.name = name;
		this.hp = hp;
		addr = "미입력";
	}
	Member(String name, String hp, String addr)//생성자4
	{
		this.name = name;
		this.hp = hp;
		this.addr = addr;
	}
	*/
	
	//생성자
	public Member()//생성자1
	{
		this("미입력", "010-0000-0000", "미입력");
	}
	public Member(String name)//생성자2
	{
		this(name, "010-0000-0000", "미입력");
	}
	public Member(String name, String hp)//생성자3
	{
		this(name, hp, "미입력");
	}
	//재귀방식으로 생성되므로 전달인자가 제일 많은 생성자만 잘 만들면 나머지는 this로 해결 가능하다.
	public Member(String name, String hp, String addr)//생성자4
	{
		this.name = name;
		this.hp = hp;
		this.addr = addr;
	}

	//getter
	//외부에서 private를 접근할 수 없으므로 getter를 통해 접근한다.
	public String getName()
	{
		return name;
		//return this.name; //return this.변수도 가능
	}
	public String getHp()
	{
		return hp;
	}
	public String getAddr()
	{
		return addr;
	}

	//setter
	public void setName(String name)
	{
		this.name = name;
	}
	public void setHp(String hp)
	{
		this.hp = hp;
	}
	public void setAddr(String addr)
	{
		this.addr = addr;
	}
	
	//클래스 메서드
	public void show()
	{
		System.out.println("이름 : " + getName());
		System.out.println("번호 : " + getHp());
		System.out.println("주소 : " + getAddr());
		System.out.println("멤버변수 name : " + name);
		System.out.println("멤버변수 hp : " + hp);
		System.out.println("멤버변수 addr : " + addr);
		System.out.println();
	}
}

public class Ex10_ClassMunje
{
	//writeMember는 Member class의 메서드가 아니다
	//클래스 메서드는 클래스변수명.클래스메서드명 형태로 호출됨
	//getter은 외부 클래스에서 private 변수를 가져오기 위함
	//setter은 외부 클래스에서 private 변수를 고치기 위함
	public static void writeMember(Member m)
	{
		System.out.println("이름 : " + m.getName());
		System.out.println("번호 : " + m.getHp());
		System.out.println("주소 : " + m.getAddr());
		System.out.println();
	}
	
	public static void main(String[] args) 
	{
		Member m1 = new Member();
		Member m2 = new Member("이강인");
		Member m3 = new Member("손흥민", "010-2222-3333");
		Member m4 = new Member("Candy", "010-444-5555", "제주도");

		System.out.println("** 멤버 명단 출력 **");
		writeMember(m1);
		writeMember(m2);
		writeMember(m3);
		writeMember(m4);

		System.out.println("** m1 멤버의 값 변경하기 **");
		m1.setName("이영자");
		m1.setHp("011-2323-6767");
		m1.setAddr("부산");
		
		//static 메서드 호출로 클래스 정보 출력
		System.out.println("일반 메서드 호출");
		writeMember(m1);
		
		//클래스 메서드 호출로 클래스 정보 출력
		System.out.println("클래스의 메서드 호출");
		m1.show();
		
		System.out.println("\"m1 = m2;\" 식 수행");
		m1 = m2;
		m1.show();
	}
}
