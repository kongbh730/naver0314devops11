package day0320;

public class Ex7_Array 
{
	public static void main(String[] args)
	{
		int []data = {25, 100, -1, -100, 0, 1, 4, -30, 30, 200, 450, -600, 1200, -1250};
		System.out.println(data.length);
		int max, min;
		
		max = min = data[0];
		for(int i = 1; i < data.length; i++)
		{
			if(max < data[i])
			{
				max = data[i];
			}
			if(min > data[i])
			{
				min = data[i];
			}
		}
		System.out.println("max : " + max + " / min : " + min);
		
		//예제
		int pcnt = 0, mcnt = 0;
		//배열 데이터 중 양수의 갯수와 음수의 갯수를 구하여 출력
		int []data2 = {-1,0,1, -2,3,-5,4,3,6,-4,10, -10,30, -2, 4, -10, 3, 2, -2};
		max = min = data2[0];
		for(int i = 0; i < data2.length; i++)
		{
			if(data2[i] > 0)
			{
				pcnt++;
			}
			else if(data2[i] < 0)
			{
				mcnt++;
			}
			else
			{
				;
			}
			if(max < data2[i])
			{
				max = data2[i];
			}
			if(min > data2[i])
			{
				min = data2[i];
			}
		}
		System.out.printf("pcnt : %2d / mcnt : %2d\n", pcnt, mcnt);
		System.out.println("max : " + max + " / min : " + min);
		
	}
}
