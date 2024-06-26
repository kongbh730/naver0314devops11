package day0321;

import java.util.Scanner;

public class Ex9_Array2DimensionBingo {
	public static void main(String[] args) {
		int [][]arr = new int [3][3];
		int bingo;
		Scanner sc = new Scanner(System.in);

		/*
		 * 1부터 3사이의 난수를 발생 후 가로, 세로, 대각선 방향으로 같은 숫자가 나올경우 bingo 변수를 
		 * 1 증가하여 빙고갯수를 구하고, 같은 숫자가 없을 경우 꽈!!! 이라고 출력
		 */
		
		while(true)
		{
			bingo = 0;
			String ans = sc.nextLine();
			
			if(ans.equalsIgnoreCase("X"))
			{
				System.out.println("빙고게임을 종료합니다.");
				break;
			}
			//2차원 배열에 1~3의 값을 임의로 발생
			for(int i = 0; i < arr.length; i++)
			{
				for(int j = 0; j < arr[i].length; j++)
				{
					arr[i][j] = (int)(Math.random()*3) + 1;
				}
			}
				
			//출력
			for(int i = 0; i < arr.length; i++)
			{
				for(int j = 0; j < arr[i].length; j++)
				{
					System.out.printf("%4d", arr[i][j]);
				}
				System.out.println("\n");
			}
			
			//빙고 갯수나 꽝 출력
			
			for(int i = 0; i < arr.length; i++)
			{
				//가로 빙고 개수
				if(arr[i][0] == arr[i][1] && arr[i][1] == arr[i][2])
				{
					bingo++;
				}
				//세로 빙고 개수
				if(arr[0][i] == arr[1][i] && arr[1][i] == arr[2][i])
				{
					bingo++;
				}
			}
			
			//대각선 빙고 개수
			if(arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2])
			{
				bingo++;
			}
			if(arr[0][2] == arr[1][1] && arr[1][1] == arr[2][0])
			{
				bingo++;
			}
			
			System.out.println("=".repeat(12));
			if(bingo == 0)
			{
				System.out.println("꽝!");
			}
			else
			{
				System.out.println("빙고 : " + bingo + "개");
			}
			
			
		}
		
		sc.close();
		
	}
}
