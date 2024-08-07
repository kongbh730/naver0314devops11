package day0319;

public class Ex3_FindingXY {

	public static void main(String[] args)
	{
		int i, j;
		int temp;
		
		//부르트 포스
//		for(i = 1; i <= 9; i++)
//		{
//			for(j = 1; j <= 9; j++)
//			{
//				temp = (i * 10 + j) + (j * 10 + i);
//				if(temp == 121)
//				{
//					System.out.printf("x = %d, y = %d\n", i, j);
//					System.out.printf("%d%d + %d%d = %d\n\n", i,j,j,i, temp);
//				}
//			}
//		}
		
		//ad-hoc알고리즘
		//두 수를 더해서 11인 경우, 수의 자릿수를 바꾸어 더할 경우 121이 됨
		temp = 121;
		for(i = 2; i <= 9; i++)
		{
			j = 11 - i;
			System.out.printf("x = %d, y = %d\n", i, j);
			System.out.printf("%d%d + %d%d = %d\n\n", i,j,j,i, temp);
		}
	}

}
