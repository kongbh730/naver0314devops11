package day0320;

import java.util.Scanner;

public class Ex9_ArraySearchString {
	public static void main(String[] args) {
		
		/*
		 * 검색할 이름을 입력하면 몇번째 있는지 출력
		 * 없을경우 없다고 출력
		 * 'q'or 'Q'입력시 종료
		 */
		
		Scanner sc = new Scanner(System.in);
		String []members = {"강호동","한가인","유재석","이승민","강하나",
				"손미나","이영자","박남정","한지혜","손창민"};
		String memberName = "";
		int index;
		
		while(true)
		{
			index = -1;
			System.out.print("검색할 이름 입력 : ");
			memberName = sc.nextLine();
			if(memberName.equalsIgnoreCase("q"))
			{
				System.out.println("종료합니다.");
				break;
			}
			for(int i = 0; i < members.length; i++)
			{
				if(memberName.equals(members[i]))
				//if(memberName.equalsIgnoreCase(members[i]))
					//한글의 경우 아무거나 상관 없음
				{
					index = i;
					break;
				}
			}
			if(index == -1)
			{
				System.out.printf("%s는 데이터에 없습니다.\n", memberName);
			}
			else
			{
				System.out.printf("%s은 %d번째에 있습니다.\n", memberName, index);
			}
		}
		
		sc.close();
		
		
		
	}
}
