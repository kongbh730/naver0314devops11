package day0319;

public class Ex4_Gugudan {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		/*
		 * 2*1 = 2  3*1 = 3 .....9*1 = 9
		 * 2*2 = 4  3*2 = 6 .....9*2 = 18
		 */
		System.out.printf("%30s\n\n", "[구구단]");
		System.out.println("=".repeat(63));
		for(int dan = 2; dan <= 9; dan++)
		{
			System.out.printf("**%d단**\t", dan);
		}
		System.out.println();
		for(int i=1; i <= 9; i++)
		{
			for(int j = 2; j <= 9; j++)
			{
				System.out.printf("%d * %d = %2d\t", j, i, i*j);
			}
			System.out.printf("\n");
		}
	}

}
