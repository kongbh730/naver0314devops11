package day0327;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex2_Set {
	public static void main(String[] args) {
		Set<String> set1 = new HashSet<String>();
		set1.add("이청아");
		set1.add("유지태");
		set1.add("이미자");
		set1.add("한가인");
		set1.add("강호동");//여기까지 set1의 개수 5개
		set1.add("이청아");//여기까지 set1의 개수 5개 : 중복을 허용하지 않으니까!
		
		System.out.println("set1의 개수 : " + set1.size());
		System.out.println("** 출력1 **");
		for(String n : set1)
		{
			System.out.println(n);
		}
		
		System.out.println("** 출력2 **");
		Iterator<String> iter = set1.iterator();
		while(iter.hasNext())//다음값이 있다면 true, 없다면 false
		{
			System.out.println(iter.next());
		}
	}
}
