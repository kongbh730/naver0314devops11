package day0327;

import java.util.Stack;

public class Ex5_Stack {

	public static void main(String[] args) {
		//List 인터페이스를 구현한 클래스 중 하나
		//LIFO 방식 : 나중에 들어간게 먼저 나옴
		
		Stack<String> stack1 = new Stack<String>();
		stack1.push("사과");
		stack1.push("바나나");
		stack1.push("사과");
		stack1.push("오렌지");
		stack1.push("딸기");
		
		System.out.println("총 갯수 : " + stack1.size());
		
		while(!stack1.isEmpty())//isEmpty()가 아닐 동안
		{	
			System.out.println(stack1.pop());//마지막으로 추가한 딸기가 먼저 출력됨
		}
	}
}