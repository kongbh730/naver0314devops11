package day0327;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Ex6_List 
{
	public static void main(String[] args)
	{
		//List<String> list1 = new Vector<String>();
		List<String> list1 = new ArrayList<String>();
		//List<String> list2 = new Vector<String>(5);//5개가 넘을경우 2배인 10개로 할당값 변경
		List<String> list2 = new Vector<String>(5, 3);//5개가 넘을경우 8개로 할당값 변경
		
		
		System.out.println("list1 데이터 갯수 : " + list1.size());
		//System.out.println("list1의 할당된 갯수 : " + ((Vector<String>)list1).capacity());
		//capacity는 오버라이드 메서드가 아니고 Vector만 갖고 있는 메서드임
		
		System.out.println("list2 데이터 갯수 : " + list2.size());
		System.out.println("list2의 할당된 갯수 : " + ((Vector<String>)list2).capacity());
		
		String []str = {"red", "blue", "green", "white", "red", "yellow", "pink"};
		
		//list1, list2에 배열 데이터 추가
		for(String s:str)
		{
			list1.add(s);
			list2.add(s);
		}
		
		System.out.println("=".repeat(50));
		System.out.println("list1 데이터 갯수 : " + list1.size());
		//System.out.println("list1의 할당된 갯수 : " + ((Vector<String>)list1).capacity());
		
		System.out.println("list2 데이터 갯수 : " + list2.size());
		System.out.println("list2의 할당된 갯수 : " + ((Vector<String>)list2).capacity());
		
		//출력방법1
		System.out.println("=".repeat(50));
		System.out.println("** 출력1 **");
		for(String s : list1)
		{
			System.out.println(s);
		}
		System.out.println();
		
		//출력방법2
		System.out.println("=".repeat(50));
		System.out.println("** 출력2 **");
		for(int i = 0; i < list1.size(); i++)
		{
			System.out.println(i + " : " + list1.get(i));
		}
		System.out.println();
		
		//출력방법3
		System.out.println("=".repeat(50));
		System.out.println("** 출력3 **");
		Iterator<String> iter = list1.iterator();
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
		System.out.println();
		
		//출력방법4
		System.out.println("=".repeat(50));
		System.out.println("** 출력4 **");
		Object []ob = list1.toArray();
		for(Object s : ob)
		{
			System.out.println((String)s);
		}
		System.out.println();
	}
}
