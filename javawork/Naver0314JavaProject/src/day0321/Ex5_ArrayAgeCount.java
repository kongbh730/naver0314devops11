package day0321;

public class Ex5_ArrayAgeCount {
	public static void main(String[] args) {
		int []memberAges = {12, 56, 34, 45, 27, 23, 34, 59, 46, 6, 11, 29, 32, 49, 51, 38, 44, 55, 5, 7};
		System.out.println("인원수 : " + memberAges.length);
		
		int i, temp;
		int []ageCount = new int[6];
		/*
		 * 연령별 인원수를 구해서 출력
		 * 
		 * 10세미만 	: 3명
		 * 10대		: 5명
		 * 20대		: 2명
		 * ...		:
		 * 50대		: 1명....
		 */
		
		for(i  = 0; i < memberAges.length; i++)
		{
			temp = memberAges[i]/10;
			ageCount[temp]++;
		}
		System.out.println("** 연령별 인원 수 구하기 **");
		System.out.printf("10세미만\t:%3d명\n", ageCount[0]);
		for(i = 1; i < ageCount.length; i++)
		{
			System.out.printf("%2d대\t:%3d명\n", i*10, ageCount[i]);
		}
		System.out.println();
	}
}