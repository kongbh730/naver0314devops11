package day0322;

public class Ex5_CallBy 
{
	public static void changeNum(int n)
	{
		n = 10;
	}
	public static void changeArray(int []a)
	{
		a[1] = 200;
	}
	public static void changeArray(String Home)
	{
		Home = "제주도";
	}

	public static void main(String[] args)
	{
		int n = 50;
		changeNum (n);//값만 전달//call by value;
		System.out.println("n = " + n);//50

		int []arr = {3, 5, 7};//배열은 객체로 인식
		changeArray(arr);//인자 전달 방식이 call by reference
		for(int a : arr)
		{
			System.out.printf("%4d", a);//3 200 7
		}
		System.out.println();

		String home = "서울";
		changeArray(home);
		System.out.println(home);//이경우는 call by value
	}
}
