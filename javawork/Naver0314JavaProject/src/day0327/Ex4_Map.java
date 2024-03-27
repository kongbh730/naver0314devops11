package day0327;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Ex4_Map {
	public static void main(String[] args) {
		//key와 value를 매핑
		//key와 value의 쌍으로 저장되는 형태
		//이때 key 타입이 Set이므로 중복된 데이터를 허용안하고, 비순차적으로 들어감
		
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("name", "김태희");
		map1.put("age", "35세");
		map1.put("addr", "서울");
		
		System.out.println("map1의 갯수 : " + map1.size());
		System.out.println("이름 : " + map1.get("name"));//"name"이라는 키값으로 저장된 value값을 가져오기
		System.out.println("나이 : " + map1.get("age"));
		System.out.println("주소 : " + map1.get("addr"));
		System.out.println("핸드폰 : " + map1.get("hp"));//없는 키값을 넣을 경우 null값 반환
	
		map1.put("name", "한가인");//기존에 key값이 존재하면, 해당 key의 value에 새로운 value를 저장한다.
		System.out.println("이름 : " + map1.get("name"));
		
		System.out.println("=".repeat(50));
		
		//키값을 모두 얻어서 거기에 매핑된 value 값을 출력하고자 할 경우
		Set<String> keys = map1.keySet();
		for(String k : keys)
		{
			String v = map1.get(k);
			System.out.println(k + " : " + v);
		}
		
		
	}
}
