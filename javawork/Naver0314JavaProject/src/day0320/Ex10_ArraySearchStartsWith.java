package day0320;

import java.util.Scanner;

public class Ex10_ArraySearchStartsWith 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String []members = {"강호동","한가인","유재석","이승민","강하나",
				"손미나","이영자","박남정","한지혜","손창민"};
		/*
		 * 검색할 이름은? 강
		 * 1번째 : 강호동
		 * 2번째 : 강하나
		 * 	총 2명 검색
		 * 
		 * 검색할 이름은? 박이
		 * "박이"로 시작하는 멩버는 없습니다.
		 * 
		 * 검색할 이름은? Q
		 * **검색을 종료합니다.**
		 */
		String name;
		int index, count;
		boolean find;
		
		while(true)
		{
			index = 0;
			count = 0;
			find = false;
			System.out.print("검색할 이름은? : ");
			name = sc.nextLine();
			if(name.equalsIgnoreCase("q"))
			{
				System.out.println("\t** 검색을 종료합니다 **");
				break;
			}
			for(int i = 0; i < members.length; i++)
			{
				if(members[i].startsWith(name))
				{
					find = true;
					System.out.printf("\t%d번째 : %s\n", i + 1, members[i]);
					count++;
				}
				else
				{
					;
				}
			}
			//탐색완료
			if(find)
			{
				System.out.printf("\t총 %d명 검색\n\n", count);
			}
			else
			{
				System.out.printf("\t\"%s\"로 시작하는 멤버는 없습니다.\n\n", name);
			}	
		}

		sc.close();
		
	}
}
