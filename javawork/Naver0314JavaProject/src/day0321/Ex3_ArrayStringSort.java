package day0321;

public class Ex3_ArrayStringSort {
	public static void main(String[] args) {
		System.out.println("aaaaa".compareTo("apple"));//a는 p보다 15만큼 앞에 있음
		System.out.println("apple".compareTo("apple"));//apple와 apple는 동일함 0
		System.out.println("computer".compareTo("apple"));//c는 a보다 2만큼 뒤에 있음

		String []arr = {"하석진", "강호동", "강호마", "candy", "손석구"};
		//candy, 강호동, 강호마, 손석구, 하석진 : 오름차순 결과
		int i, j;

		//==============================================================
		//오름차순정렬
		for(i = 0; i < arr.length-1; i++)
		{
			for(j = i+1; j < arr.length; j++)
			{
				//기준값이 더 클 경우 양수값이 발생
				//기준값이 아스키코드에서 더 뒤에 있을 경우, 양수값이 발생
				if(arr[i].compareTo(arr[j]) > 0)
				{
					String stemp = arr[i];
					arr[i] = arr[j];
					arr[j] = stemp;
				}
			}
		}
		System.out.println("오름차순 정렬 순서대로 출력하기");
		for(String a : arr)
		{
			System.out.print(a + "\t");
		}
		System.out.println();

		//==============================================================
		//내림차순정렬
		for(i = 0; i < arr.length-1; i++)
		{
			for(j = i+1; j < arr.length; j++)
			{
				//기준값이 더 작을 경우 음수값이 발생
				//기준값이 아스키코드에서 앞에 있을 경우, 음수값이 발생
				if(arr[i].compareTo(arr[j]) < 0)
				{
					String stemp = arr[i];
					arr[i] = arr[j];
					arr[j] = stemp;
				}
			}
		}
		System.out.println("내림차순 정렬 순서대로 출력하기");
		for(String a : arr)
		{
			System.out.print(a + "\t");
		}
		System.out.println();
		//==============================================================






	}
}
