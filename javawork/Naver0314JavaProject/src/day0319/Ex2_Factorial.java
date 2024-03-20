package day0319;

public class Ex2_Factorial {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int i;
//		int j;
		int factorial = 1;
		
		for(i = 1; i <= 10; i++)
		{
//			factorial = 1;
//			for(j = 1; j <= i; j++)
//			{
//				factorial = factorial * j;
//			}
//			System.out.printf("%d! = %d\n", i, factorial);
			factorial *= i;
			System.out.printf("%d! = %d\n", i, factorial);
		}
	}

}
