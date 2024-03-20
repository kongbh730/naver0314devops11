package day0315;

public class Ex3_Output {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int year = 2024;
		int month = 3;
		int day = 05;
		
		String msg = "Have a Nice day!!";
		char blood = 'B';
		double avg = 97.4567;
		
		System.out.println("**출력1**");
		System.out.println("날짜 : " + year + "-" +month+ "-"+day);
		System.out.print("혈액형 : " + blood + "형");
		System.out.println("\t평균 : " + avg);
		System.out.println("========================");
		
		//printf를 이용해서 출력
		//변환기호를 이용해서 출력
		//정수: %d, 실수 : %f, 문자 : %c, 문자열 : %s
		System.out.printf("**%40s**\n\n", msg);//40칸의 우측기준
		System.out.printf("**%-40s**\n\n", msg);//40칸의 죄측기준
		System.out.printf("**%s**\n\n", msg);
		System.out.printf("날짜 : %d-%d-%d\n", year, month, day);
		System.out.printf("날짜 : %2d-%2d-%2d\n", year, month, day);//2칸중 비어있는 곳 공백으로 출력
		System.out.printf("날짜 : %02d-%02d-%02d\n", year, month, day);//2칸중 비어있는 곳 0으로 출력
		System.out.printf("나의 혈액형은 %c입니다\n", blood);
		System.out.printf("평균 : %f\n", avg);//%f : 소숫점이하가 6자리로 출력
		System.out.printf("평균 : %3.1f\n", avg);//전체자리수 3자리, 소숫점이하 자리수 1자리
		System.out.printf("평균 %10.2f\n", avg);//전체 자리수 10자리(남을 경우 공백처리), 소숫점이하 자리수 2자리
		System.out.printf("평균 %-10.2f\n", avg);//전체 자리수 10자리(왼쪽으로 출력, 남을 경우 공백처리), 소숫점이하 자리수 2자리
		
	}

}
