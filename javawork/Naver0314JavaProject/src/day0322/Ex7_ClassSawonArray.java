package day0322;

import java.util.Scanner;

//call By Reference
public class Ex7_ClassSawonArray
{
	//입력 메서드
	static public void inputSawonArray(Sawon []sa)//객체 배열
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("총 " + sa.length + "명의 사원정보를 입력하세요.");
		for(int i = 0; i < sa.length; i++)
		{
			System.out.print("사원명은?");
			String name = sc.nextLine();
			System.out.print("기본급은?");
			int gibon = Integer.parseInt(sc.nextLine());
			System.out.print("수당은?");
			int sudang = Integer.parseInt(sc.nextLine());

			sa[i] = new Sawon();//초기값이 null이므로 new로 생성을 해야 method 호출이 가능하다!!!!
			sa[i].setSawon(name, gibon, sudang);//생성 안하고 호출 시 널포인트 오류 발생
			System.out.println();
		}

		sc.close();
	}

	//출력 메서드
	static public void outputSawonArray(Sawon []sa)
	{
		System.out.println("\t\t[사원 급여 현황]\n");
		System.out.println("번호\t사원명\t기본급\t수당\t실수령액");
		System.out.println("=".repeat(60));
		for(int i = 0; i < sa.length; i++)
		{
			System.out.println((i+1) + "\t" 
					+ sa[i].getName() + "\t" 
					+ sa[i].getGibon() + "\t"
					+ sa[i].getSudang() + "\t"
					+ sa[i].getNetPay());
		}
	}

	//Sawon.java와 함께
	public static void main(String[] args) 
	{
		Sawon []sawon = null;
		int inwon;

		Scanner sc = new Scanner(System.in);
		System.out.println("직원 인원수는?");
		inwon = Integer.parseInt(sc.nextLine());
		//인원수만큼 메모리 할당
		sawon = new Sawon[inwon];//인원수만큼 객체 할당, 초기값은 null;

		inputSawonArray(sawon);
		outputSawonArray(sawon);



		sc.close();
	}
}
