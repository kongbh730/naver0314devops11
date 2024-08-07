package day0325;

class Member
{
	private String memberName;
	private  int memberCount;
	
	Member()
	{
		this("동창회", 10);
	}
	
	Member(String memberName, int memberCount)
	{
		this.memberName = memberName;
		this.memberCount = memberCount;
	}
	
	public void writeMember()
	{
		System.out.println("모임 이름 : " + memberName);
		System.out.println("모임 정원 : " + memberCount);
	}
}

//sub
class SubMember extends Member
{
	private String myName;
	private int myAge;
	
	SubMember()
	{
		super();//생략되어 있음, 숨어있음, 주석처리 한다고 안 수행되는거 아님
		myName = "이름없음";
		myAge = 20;
	}
	
	SubMember(String memberName, int memberCount, String myName, int myAge)
	{
		super(memberName, memberCount);
		this.myName = myName;
		this.myAge = myAge;
	}
	
	//똑같은 이름으로 오버라이드 됨
	@Override
	public void writeMember() 
	{
		// TODO Auto-generated method stub
		super.writeMember();//먼저 출력
		System.out.println("내 이름 : " + myName);
		System.out.println("내 나이 : " + myAge);
		System.out.println("=".repeat(20));
	}
}

public class Ex7_Inheri 
{
	public static void main(String[] args) 
	{
		Member m = new Member();
		m.writeMember();
		System.out.println("=".repeat(20));
		
		//부모 기본생성자 -> 자식 기본생성자
		SubMember s = new SubMember();
		s.writeMember();
		
		//부모 기본생성자 -> 자식 인자전달 생성자
		SubMember sub2 = new SubMember("701모임", 30, "이영자", 35);
		sub2.writeMember();
		
	}
}
