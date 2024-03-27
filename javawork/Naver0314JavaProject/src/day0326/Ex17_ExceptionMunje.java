package day0326;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;

/*
 * score.txt를 읽어서 총갯수와 총점, 평균을 구하시오
 * 단, 점수에 문자가 있는 경우 갯수에서 제외하고 총점에서도 제외하고 출력이 되도록 하기
 * numformatexception : hint
 * 
 * 갯수 : 13개
 * 총점 990
 * 평균 :78.99
 * ....
 */

public class Ex17_ExceptionMunje 
{
	static final String SCORE = "c:/naver0314/score.txt";

	static public void readScore() throws IOException
	{
		BufferedReader br = null;
		FileReader fr = null;
		int current_score;
		int count = 0, total_score = 0;
		double avg = 0.0;

		try//파일이 존재함
		{
			fr = new FileReader(SCORE);
			br = new BufferedReader(fr);
			System.out.println("** score 파일을 읽습니다. **");

			while(true)
			{
				//파일의 내용을 한 줄 씩 읽어온다.
				String line = br.readLine();
				//만약 더 이상 데이터가 없을 경우 null값이 반환된다.
				if(line == null)
				{
					break;
				}
				try// 읽은 문자열을 정수형태로 바꿔보기
				{
					current_score = Integer.parseInt(line);//만약 정수형으로 바꿀수 없다면 catch로 이동
					System.out.println(current_score);
					count++;
					total_score += current_score;
				}
				catch(NumberFormatException e)//정수형태로 바꿀 수 없는 경우
				{
					continue;//그냥 통과
				}
			}
			avg = (double)total_score/count;
			System.out.printf("갯수 : %d개\n", count);
			System.out.printf("총점 : %d점\n", total_score);
			//소숫점 이하 2자리까지 출력
			NumberFormat nf = NumberFormat.getInstance();
			nf.setMaximumFractionDigits(2);
			System.out.println("평균 : " + nf.format(avg));
			//System.out.printf("평균 : %.2f점\n", avg);
		} 
		catch (FileNotFoundException e) //파일이 존재하지 않음
		{
			System.out.println("** score 파일이 없어요 **");
		} 
		finally//어쨌건 무조건 실행할 명령
		{
			//나중에 열린 자원을 먼저 닫는다.
//			try 
//			{
//				br.close();
//				fr.close();
//			} 
//			catch (IOException e) 
//			{
//				e.printStackTrace();
//			}
//			System.out.printf("갯수 : %d개\n", count);
//			System.out.printf("총점 : %d점\n", total_score);
//			System.out.printf("평균 : %.2f점\n", (double)total_score/count);
			br.close();
			fr.close();
		}
	}

	public static void main(String[] args)
	{
		//score를 읽어서 콘솔에 출력하기
		try 
		{
			readScore();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
