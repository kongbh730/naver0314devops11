package day0326;

public class Ex12_Exception {
	public static void main(String[] args) {
		int []arr = {3, 5, 7, 10};
		
		for(int i = 0; i <= arr.length; i++)
		{
			//예외처리 결과는 일단은 프로그램의 끝까지 간다.
			try
			{
				System.out.println(i + " : " + arr[i]);	
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				//e.printStackTrace();//에러추적-라인번호 출력
				System.out.println("배열 인덱스 오류 : " + e.getMessage());//메시지출력
			}
		}
		System.out.println("** 종료 **");
	}

}
