package day0321;

public class Ex1_RandomRedundancy {
	public static void main(String[] args) {
		/*
		 * 1부터 30까지 난수 10개를 발생하는데 중복처리하기
		 * 
		 */
		int i, j, n;
		int[] rand = new int[10];

		Loop:
			for(i = 0; i < rand.length; i++)
			{
				n = (int)(Math.random() * 30) + 1;
				rand[i] = n;

				//중복처리
				for(j = 0; j < i; j++)
				{
					if(rand[i] == rand[j])
					{
						i--;//제자리로 가기 위해 일단 1을 빼고 이동
						continue Loop;//i++로 이동
					}
				}
			}

		System.out.println("1~30사이의 중복되지 않은 난수 구하기");
		for(i = 0; i < rand.length; i++)
		{
			System.out.printf("%4d", rand[i]);
		}
		System.out.println();

		//순차적 정렬 (오름차순)
		for(i = 0; i < rand.length-1; i++)
		{
			for(j = i + 1; j < rand.length; j++)
			{
				if(rand[i] > rand[j])
				{
					int temp = rand[i];
					rand[i] = rand[j];
					rand[j] = temp;
				}
			}
		}		
		System.out.println("오름차순 정렬 후 난수 배열");
		for(i = 0; i < rand.length; i++)
		{
			System.out.printf("%4d", rand[i]);
		}
		System.out.println();



	}
}
