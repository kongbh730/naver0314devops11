package day0318;

public class Ex9_For {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int i;

		for(i = 1; i <= 10; i++)
		{
			System.out.printf("%4d", i);
		}
		System.out.println();
		System.out.println(i);

		for(i = 10; i >= 1; i--)
		{
			System.out.printf("%4d", i);
		}
		System.out.println();
		for(i = 1; i <= 30; i+=3)
		{
			System.out.printf("%4d", i);
		}
		System.out.println();
//		for(i = 'A'; i <= 'Z'; i++)
//		{
//			System.out.printf("%c", (char)i);
//		}
		for(i = 65; i <= 90; i++)
		{
			System.out.printf("%c", (char)i);
		}
		System.out.println();
		for(i = 'a'; i <= 'z'; i++)
		{
			System.out.printf("%c", (char)i);
		}
		System.out.println();
		
		for(i = 1; i <= 10; i++)
		{
			System.out.printf("%3d", i);
			if(i == 5)
			{
				break;
			}
		}
		System.out.println();
		for(i = 1; i <= 10; i++)
		{
			if(i % 2 == 0)
			{
				continue;
			}
			System.out.printf("%3d", i);
		}
		
	}

}
