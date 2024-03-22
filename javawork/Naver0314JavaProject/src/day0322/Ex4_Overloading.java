package day0322;

class Oper
{
	//메서드 오버로딩
	//메서드 명만 같으면 됨
	static public int sum(int a, int b)
	{
		return a + b;
	}
	static public double sum(double a, double b)
	{
		return a + b;
	}
	static public String sum(String a, String b)
	{
		return a + b;
	}
	//Variable Argument JDK5에서 추가된 기능
	static public int hap(int ...n)
	{
		System.out.println("전달받은 숫자의 개수 : " + n.length);
		int s = 0;
		for(int i = 0; i < n.length; i++)
		{
			System.out.printf("%4d", n[i]);
			s += n[i];
		}
		System.out.println();
		return s;
	}
	public static void writeColor(String ...color)
	{
		System.out.println("총" + color.length + "개의 색상 전잘받음!" );
		for(int i = 0; i < color.length; i++)
		{
			System.out.println(color[i]);
		}
	}

	
}
public class Ex4_Overloading 
{
	public static void main(String[] args) 
	{
		//static이기 때문에 클래스명으로 접근 가능
		System.out.println(Oper.sum(5,  100));
		System.out.println(Oper.sum(1.2,  5.6));
		System.out.println(Oper.sum("apple", "banana"));
		
		System.out.println("총합계 : " + Oper.hap(3,6));
		System.out.println("총합계 : " + Oper.hap(78, 90, 100, 88, 56));
		
		Oper.writeColor("red");
		Oper.writeColor ("yello", "gray", "blue");
		Oper.writeColor ("빨간색", "분홍색", "검정색", "흰색", " 노랑색");
	}
}
