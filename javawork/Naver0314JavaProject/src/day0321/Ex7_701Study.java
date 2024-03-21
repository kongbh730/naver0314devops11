package day0321;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex7_701Study 
{
	public static void main(String[] args) {
		String []members= {
				"강하윤","공병현","김도훈","김우형","김정호",
				"김창인","민경진","박민지","박보민","박주용",
				"박한경","배동우","서정현","손가원","시바타유니",
				"신완철","우태형","유상곤","이가현","이병현",
				"이장우","이현성","정민석","정상혁","정진욱",
				"정환용","최시현","허승필","황재웅", "꽝!!"
		};
		
		//2차원 배열에 5명씩 총 6조
		String [][]team = new String[6][5];
		int [] list = new int[30];
		int i, j, temp;
		
		
		//다시 풀어보기
		for(i = 0; i < members.length; i++)
		{
			temp = (int)(Math.random() * 30);
			Loop:
			for(j = 0; j < i; j++)
			{
				if(temp == list[j])
				{
					i--;
					break Loop;
				}
			}
			list[i] = temp;
			team[i/5][i%5] = members[temp];	//[0~5][0~4]
		}
//		for(i = 0; i < members.length; i++)
//		{
//			//중복없는 난수 0부터 29까지 30개
//			temp = (int)(Math.random() * 30);
//			list[i] = temp;
//			for(j = 0; j < i; j++)
//			{
//				if(temp == list[j])
//				{
//					i--;
//					break;
//				}
//			}
//			team[i/5][i%5] = members[temp];
//		}
		
		for(i = 0; i < team.length; i++)
		{
			for(j = 0; j < team[0].length; j++)
			{
				System.out.print(team[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();

		//====================================================
		//강사님 풀이
		//int i, j;
		int []rnd = new int[30];
		//String [][]team = new String[6][5];
		Loop:
			for(i = 0; i < members.length; i++)
			{
				rnd[i] = (int)(Math.random()*30);
				for(j = 0; j < i; j++)
				{
					if(rnd[i] == rnd[j])
					{
						i--;
						continue Loop;
					}
				}
			}
		int index = 0;
		for(i = 0; i < team.length;i++)
		{
			for(j = 0; j < team[i].length; j++)
			{
				team[i][j] = members[rnd[index++]];
			}
		}
		//====================================================
		
		System.out.println("\t\t현재 날짜");
		Date date = new Date();
		//SimpleDateFormat sdf1 = new SimpleDateFormat("\tyyyy-MM-dd HH:mm:ss EEE");//EEE는 화, EEEE는 화요일
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy년  MM월  dd일");
		System.out.println(sdf1.format(date) + "\t 701 스터디 팀");

		for(i = 0; i < team.length; i++)
		{
			for(j = 0; j < team[0].length; j++)
			{
				System.out.print(team[i][j] + "\t");
			}
			System.out.println();
		}
		
	}
}
