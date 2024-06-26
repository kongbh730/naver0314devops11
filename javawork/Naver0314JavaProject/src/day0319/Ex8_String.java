package day0319;

import java.util.StringTokenizer;

public class Ex8_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("** String 객체의 Method 공부하기 **");
		String str1 = "Have a Nice Day";
		String str2 = "apple";
		String str3 = "Apple";
		
		System.out.println(str1.charAt(7));//7번 인덱스의 문자 : N
		System.out.println(str1.charAt(0));//0번 인덱스의 문자 : H;
		System.out.println(str1.indexOf('a'));//0부터 시작해서 첫번째 'a'의 위치 : 1
		System.out.println(str1.indexOf('X'));//없는 문자의 경우 : -1 // 없는 문자를 찾고 싶을경우 -1이 나오는 경우 확인
		
		System.out.println(str1.lastIndexOf('a'));//마지막 'a'의 위치 : 13
		System.out.println(str1.length());//str1의 총 길이 : 15글자
		
		System.out.println(str2.concat("***"));// str2문자에 ***추가해서 반환
		System.out.println(str2 + "***");//위와 동일
		System.out.println(str1.toLowerCase());
		System.out.println(str1.toUpperCase());
		
		//문자열 비교
		System.out.println("apple".equals(str2));//true
		System.out.println("apple".equals(str3));//false
		System.out.println(str2.equals(str3));//false;//대소문자 다르므로 false
		System.out.println(str2.equalsIgnoreCase(str3));//true//대소문자 상관없이 비교
		System.out.println(str2 == str3);//객체시 주소를 비교 : 주소가 다르므로 false (==동등연산자는 값비교시에만 사용)
		
		//문자열 추출
		System.out.println(str1.substring(7));//Nice Day
		System.out.println(str1.substring(7, 10));//Nic
		
		
		System.out.println(str1.startsWith("have"));//str1이 Have로 시작하면 true : true
		System.out.println(str1.startsWith("Nice)"));//str1이 Nice로 시작하면 true : false
		
		System.out.println(str1.endsWith("Day"));//str1이 Day로 끝나면 true : true
		System.out.println(str1.endsWith("day"));//str1이 day로 끝나면 true : false	
		System.out.println(str1.toLowerCase().endsWith("day"));//str1을 소문자로 변환 후 day로 끝나는지 비교 : true
		
		//반복
		System.out.println(str2.repeat(3));
		System.out.println("*".repeat(10));
		
		//일부변경
		System.out.println(str1.replace('a', '*'));//일부 변경 H*ve * Nice D*y
		System.out.println(str1.replace("Nice", "Good"));//Have a Good day
		
		//compareTo를 사용한 비교
		System.out.println("apple".compareTo("append"));// 'l','e' : 7차이 (양수, 첫 문자열이 더 크다), 첫 문자열이 작을 경우 음수가 나옴
		System.out.println("apple".compareTo("banana"));// 'a','b' : -1차이 (음수, 첫 문자열이 더 작다), 첫 문자열이 작을 경우 음수가 나옴
		System.out.println("apple".compareTo("apple"));// 0 (끝까지 완전히 같은 경우)		
		
		//문자열 분리(결과값이 배열타입)
		String colors = "red, blue, green, yellow, pink";
		//,로 분리하고 싶을 경우
		String []a1 = colors.split(", ");//" "안은 임의로 지정가능
		System.out.println("분리된 배열의 갯수 : "+ a1.length);
		for(int i = 0; i < a1.length; i++)
		{
			System.out.println(a1[i]);
		}
		System.out.println(a1[0] + ", " + a1[4]);//0번값과 4번 배열값 출력
		
		//분리하는 또 다른 방법
		StringTokenizer st = new StringTokenizer(colors, ", ");
		System.out.println("분리할 토큰 수 : " + st.countTokens());
		while(st.hasMoreTokens())//더 이상 토큰이 없을 경우 false가 되면서 while문을 빠져나간다
		{
			System.out.println(st.nextToken());
		}
		
		//trim
		String msg = "   hello   ";
		System.out.println(msg.length());//11글자...사실은 5글자인데...
		System.out.println(msg.trim().length());//양쪽 공백 제거 후 5글자 출력
		System.out.println(msg);// "   hello   "
		System.out.println(msg.trim());// "hello"
		
		//valueOf //어떤 타입이던 간에 string 형태로 변환하고 싶을 경우
		System.out.println(String.valueOf(3));//정수 3이 문자열 "3"으로 반환
		System.out.println(3 + "");//이 방법도 가능 //이럴거면 valueOf 왜 씀
		
		
		
		
		
	}

}
