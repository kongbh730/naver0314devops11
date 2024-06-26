package day0321;

public class Ex2_ArraySort 
{
	public static void main(String[] args) 
	{
		//두 값을 바꿀경우 / swap 연습
//		int a = 10, b = 20, temp;
//		System.out.println("a = " + a + ", b = " + b);
//		temp = a;
//		a = b;
//		b = temp;
//		System.out.println("a = " + a + ", b = " + b);

		int[] arr = {5, 8,2, 1, 10};
		int i, j;
		//selection sort
		System.out.println("정렬 전");
		for(i = 0; i < arr.length; i++)
		{
			System.out.printf("%4d", arr[i]);
		}
		System.out.println();
		
		//==============================================================
		//오름차순
		for(i = 0; i < arr.length-1; i++)//기준
		{
			for(j = i + 1; j < arr.length; j++)
			{
				if(arr[i] > arr[j])//<<===== 정렬 조건
				{
					//swap
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println("오름차순 정렬 후");
		//콜렉션식 출력방법
		for(int a : arr)
		{
			System.out.printf("%4d", a);
		}
		System.out.println();

		//==============================================================
		//내림차순
		for(i = 0; i < arr.length-1; i++)//기준
		{
			for(j = i + 1; j < arr.length; j++)
			{
				if(arr[i] < arr[j])//<<===== 정렬 조건
				{
					//swap
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println("내림차순 정렬 후");
		//콜렉션식 출력방법
		for(int a : arr)
		{
			System.out.printf("%4d", a);
		}
		System.out.println();

		
		
		//bubble sort//나중에 해보기
		
		//insertion sort//나중에 해보기
		
	}
}
