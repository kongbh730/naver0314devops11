package day0318;

public class Ex10_Multiple_for {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i, j;
		
		for(i = 1; i <= 5; i++)
		{
			System.out.println("Hello");
			for(j = 1; j <= 3; j++)
			{
				System.out.printf("\tkitty");
			}
			System.out.println();
		}
		System.out.println("---------------------------");
		
		for(i = 1; i <= 5; i++)
		{
			System.out.println("Hello");
			for(j = 1; j <= 3; j++)
			{
				System.out.printf("i = %d, j = %d\n", i, j);
			}
			System.out.println();
		}
		System.out.println("---------------------------");
		
		//레이블명은 마음대로 준다.
		Exit:
		for(i = 1; i <= 5; i++)
		{
			for(j = 1; j <= 3; j++)
			{
				System.out.printf("i = %d, j = %d\n", i, j);
				if(j == 2)
				{
					break Exit;
				}
			}
			System.out.println();
		}
		
	}

}
