package day0328;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class Ex3_LambdaForEach 
{
	public static void main(String[] args)
	{
		//List에 데이터 넣는 방법1
		List<String> list1 = new Vector<>();
		list1.add("빨강색");
		list1.add("노랑색");
		list1.add("분홍색");
		list1.add("초록색");
		for(String s : list1)
		{
			System.out.println(s);
		}
		System.out.println("==============================");
		
		//List에 데이터를 넣고 출력하는 방법 2
		List<String> list2 = Arrays.asList("장미꽃", "다알리아", "칸나", "안개꽃", "프리지아");
		list2.forEach(s->System.out.println(s));
		
		
		
		
		
		
	}
}
