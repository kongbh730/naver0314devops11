package day0319;

public class Ex1_FindingPrimeNum {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int count = 0;
		int i, j;
		boolean prime = true;
		
		//1은 소수가 아닌데....
//		for(i = 1; i <= 100; i++)
//		{
//			for(j = 2; j*j <= i; j++)
//			{
//				if(i % j == 0)//나누어 떨어진다. j는 i의 약수이다.
//				{
//					//소수가 아님
//					prime = false;
//					break;
//				}
//				else
//				{
//					prime = true;
//				}
//			}
//			if(prime && i != 1)
//			{
//				System.out.println(i);
//				count++;
//			}
//		}
		
		//1은 소수가 아닌데...
		Loop:
			for(i = 2; i <= 100; i++)
			{
				for(j = 2; j*j <= i; j++)
				{
					if(i % j == 0)
					{
						continue Loop;
					}
				}
				count++;
				System.out.printf("%5d", i);
				if(count % 5 == 0)
				{
					System.out.printf("\n");
				}
			}
		
		System.out.println("\n소수의 개수 : " + count);
	}
}
