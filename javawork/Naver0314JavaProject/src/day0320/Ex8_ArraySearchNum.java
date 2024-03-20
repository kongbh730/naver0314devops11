package day0320;

import java.util.Scanner;

public class Ex8_ArraySearchNum {

	public static void main(String[] args) 
	{
		/*
		 * 숫자 입력하여 배열에 몇번째에 있는지 출력
		 * 없을경우 없다고 메세지 출력
		 * 반복해서 검색(0입력시 종료)
		 */
		
		Scanner sc = new Scanner(System.in);
		int []data = {12, 3, 6, 1, 7, 10, 8, 5, 16, 19};
		int num, index;
		
		while(true)
		{
			index = -1;
			System.out.print("검색할 숫자 입력 : ");
			num = sc.nextInt();
			if(num == 0)
			{
				System.out.println("종료");
				break;
			}
			for(int i = 0; i < data.length; i++)
			{
				if(num == data[i])
				{
					index = i;
					break;
				}
			}
			if(index == -1)
			{
				System.out.printf("%d는 데이터에 없습니다.\n", num);
			}
			else
			{
				System.out.printf("%d는 %d번째에 있습니다.\n", num, index);
			}
		}
		
		sc.close();
	}

}
