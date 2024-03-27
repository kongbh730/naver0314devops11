package day0327;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Ex1_Set 
{

	public static void main(String[] args) 
	{
		/*
		 *Set 인터페이스를 구현한클래스로는, TreeSet, HashSet디 있다.
		 *Set 타입의 특징 : 1. 중복데이터 허용 x
		 *				2. 비순차적
		 *				3. TreeSet은 오름차순
		 *					HashSet은 자기 마음대로 저장
		 *
		 * <Integer>: 제네릭, 해당 컬렉션에는 Integer타입만 넣을수 있고, 다른 타입을 넣으면 컴파일 오류 발생
		 */
		//Set<Integer> set1 = new HashSet<Integer>();
		//Set<Integer> set1 = new HashSet<>();//뒷부분 제네릭은 생략가능
		Set<Integer> set1 = new TreeSet<>();//오름차순 정렬로 저장
		set1.add(100);
		set1.add(78);
		set1.add(78);
		set1.add(100);
		set1.add(65);
		System.out.println("set1의 데이터 갯수 : " + set1.size());
		System.out.println("** 출력1 **");
		for(int n : set1)
		{
			System.out.println(n);
			//오름차순정렬도 아니고...그냥 자기 멋대로 저장
		}
		System.out.println("** 출력2 **");
		Iterator<Integer> iter = set1.iterator();
		while(iter.hasNext())//다음값이 있다면 true, 없다면 false
		{
			System.out.println(iter.next());
		}
		//System.out.println("** 출력3 **");
		//나중에 
	}

}
