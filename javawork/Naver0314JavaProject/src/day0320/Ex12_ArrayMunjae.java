package day0320;

import java.util.Scanner;

public class Ex12_ArrayMunjae {
	public static void main(String[] args) {
		/*
		 * 처음에 인원수(inwon)수를 입역받은 후 해당 인원수만큼 
		 * name, kor, eng, tot, rank변수를 배열할당하고
		 * 인원수만큼 이름, 국어점수, 영어점수를 입력하면 
		 * 총점과 등수를 계산해서 출력하는 프로그램 작성
		 * 
		 * 
		 * ------------------------------------
		 * 번호   이름   국어   영어   총점   등수
		 * ------------------------------------
		 * 1.	강호동	90	100		190	1
		 * 2.	이영자 	100	70		170	3
		 * 3.	유재석	90	90		180	2
		 *
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("사람 수를 입력 :");
		//int inwon = sc.nextInt();
		int inwon = Integer.parseInt(sc.nextLine());
		int i, j;
		String[] name = new String[inwon];
//		int[] kor = new int[inwon];
//		int[] eng = new int[inwon];
//		int[] tot = new int[inwon];
//		int[] rank = new int[inwon];
		
		int [] kor, eng, tot, rank;//이렇게 선언도 가능하다.
		kor = new int[inwon];
		eng = new int[inwon];
		tot = new int[inwon];
		rank = new int[inwon];		
		
		for(i = 0; i < inwon; i++)
		{
			//입력방법 복습...
			System.out.print("이름 : "); 
			name[i] = sc.nextLine();
			System.out.print("국어성적 : ");
			kor[i] = Integer.parseInt(sc.nextLine());
			//kor[i] = sc.nextInt();
			System.out.print("영어성적 : ");
			eng[i] = Integer.parseInt(sc.nextLine());
			//eng[i] = sc.nextInt();
			tot[i] = kor[i] + eng[i];
			//sc.nextLine();
		}
		
		for(i = 0; i < inwon; i++)
		{
			rank[i] = 1;
			for(j = 0; j < inwon; j++)
			{
				if(tot[i] < tot[j])
				{
					rank[i]++;
				}
			}
		}
		
		System.out.println("=".repeat(50));
		System.out.println("번호\t이름\t국어\t영어\t총점\t등수");
		System.out.println("=".repeat(50));
		for(i = 0; i < inwon; i++)
		{
			System.out.printf("%4d\t%s\t%4d\t%4d\t%4d\t%4d\n", i+1, name[i], kor[i], eng[i], tot[i], rank[i]);
		}
		
		sc.close();
	}
}
