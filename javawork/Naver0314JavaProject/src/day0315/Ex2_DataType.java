package day0315;

public class Ex2_DataType 
{
	public static void main(String[] args) 
	{
	//정수타입
		byte a = 127;
		System.out.println(a);
		byte b = (byte) 200;//cast 연산자 : 강제로 형변환 : 값손실 발생 : 2의 보수값 
		System.out.println(b);//값손실이 발생할 경우 엉뚱한 값이 출력 : 내부적으로는 2의 보수값
		
		//실수 타입
		float f1 = 123.567891234f;//f를 붙여야 4바이트 float으로 저장 // 아니면 double로 저장
		double f2 = 123.567891234;
		System.out.println(f1);//123.567894 //정밀도가 보통 8자리까지 정확히 나옴
		System.out.println(f2);//123.567891234 //정밀도가 보통 15자리까지 정확히 나옴
		
		//문자형
		//한글자 지정은 char, 문자열은 String(객체타입)
		char ch1 = 'A';
		char ch2 = '값';//자바에서는 char가 2바이트라 한글 한 글자도 가능
		System.out.println(ch1);
		System.out.println(ch2);
		
		//문자열 지정하는 방법
		String str1 = new String("happy");//방법1
		String str2 = "hello";//방법2
		System.out.println(str1);
		System.out.println(str2);
		
		//긴 문자열을 지정나는 경우
		String str3 = "나는 오늘도 자바를 공부한다.. 오늘은 즐거운 금요일은데 할일이 없다..어쩌고 저쩌고...";
		String str4 = "나는 오늘도 자바를 공부한다..\n" +
				"오늘은 즐거운 금요일은데 할일이 없다..\n" + 
				"어쩌고 저쩌고...";
		System.out.println(str3);
		System.out.println();
		System.out.println(str4);
		String str5 = """
			나는 오늘도 자바를 공부한다..
			오늘은 즐거운 금요일은데 할일이 없다..
			어쩌고 저쩌고...
			""";
		System.out.println();
		System.out.println(str5);
		
		
	}
}