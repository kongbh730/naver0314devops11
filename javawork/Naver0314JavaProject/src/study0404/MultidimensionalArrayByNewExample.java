package study0404;

public class MultidimensionalArrayByNewExample 
{

	public static void main(String[] args)
	{
		int[][] mathScores = new int[2][3];//2행 3열의 int형 배열 mathScores 선언, 할당
		
		for(int i = 0; i < mathScores.length; i++)//mathScores의 행만큼 반복수행
		{
			for(int k = 0; k < mathScores[i].length; k++)//mathScores의 i행의 열 개수만큼 반복
			{
				System.out.println("mathScores[" + i + "][" + k + "] : " + mathScores[i][k]);//mathScores[i][k]를 순차출력
				//출력 결과는 전부 0, 왜냐하면 할당만 됐지, 값이 초기화되지 않아 초기값 0이 들어가있기 때문이다.
			}
		}
		System.out.println();//줄넘김
		
		mathScores[0][0] = 80;//mathScores[0][0]에 80 저장
		mathScores[0][1] = 83;//mathScores[0][1]에 83 저장
		mathScores[0][2] = 85;//mathScores[0][2]에 85 저장
		mathScores[1][0] = 86;//mathScores[1][0]에 86 저장
		mathScores[1][1] = 90;//mathScores[1][1]에 90 저장
		mathScores[1][2] = 92;//mathScores[1][2]에 92 저장
		
		int totalStudent = 0;//모든 학생수를 저장할 변수 선언
		int totalMathSum = 0;//모든 수학점수의 합을 저장할 변수 선언
		for(int i = 0; i < mathScores.length; i++)//mathScores의 행만큼 반복
		{
			totalStudent += mathScores[i].length;//mathScores의 i번째 행의 열 개수를 누적합-> 매 행의 공간개수를 누적합해서 총인원수를 구할 수 있다.
			for(int k = 0; k < mathScores[i].length; k++)//mathScores의 i번째 행의 열 개수만큼 반복
			{
				totalMathSum += mathScores[i][k];// totalMathSum에 mathScores[i][k]를 누적합하여 총 점수 합을 구함
			}
		}
		double totalMathAvg = (double)totalMathSum / totalStudent;//총점수의 평균을 구하기 위한 변수 선언, 평균은 실수형이므로 기존 변수를 실수형으로 형변환하여 계싼
		System.out.println("전체 학생의 수학 평균 점수 : " + totalMathAvg);//평균 출력
		System.out.println();//줄넘김
		
		int[][]englishScores = new int[2][];//영어점수를 저장할 int형 2행배열 선언, 할당. 근데 열은 할당을 안함->가변배열로 할당할 거임
		englishScores[0] = new int[2];//0행은 2열짜리 배열로
		englishScores[1] = new int[3];//1행은 3열짜리 배열로
		
		for(int i = 0; i < englishScores.length; i++)//englishScores의 행개수만큼 반복수행->2번 반복
		{
			for(int k = 0; k < englishScores[i].length; k++)//englishScores의 i번째 행의 열 개수만큼 반복수행 -> i=0일때는 2번 반복, i=1일때는 3번 반복
			{
				System.out.println("englishScores[" + i + "][" + k + "] : " + englishScores[i][k]);//englishScores 배열 원소값 출력
			}
			//출력결과는 전부 0, 위에서와 마찬가지로 생성, 할당만 했지 초기화는 안해서 초기값 0으로 저장됨
		}
		System.out.println();//줄넘김
		
		englishScores[0][0] = 90;//englishScores[0][0]에 90 저장
		englishScores[0][1] = 91;//englishScores[0][1]에 91 저장
		englishScores[1][0] = 92;//englishScores[1][0]에 92 저장
		englishScores[1][1] = 93;//englishScores[1][1]에 93 저장
		englishScores[1][2] = 94;//englishScores[1][2]에 94 저장
		
		totalStudent = 0;//총 학생수
		int totalEnglishSum = 0; //총 점수합
		for(int i = 0; i < englishScores.length; i++)//englishScores의 행 개수만큼 반복
		{
			totalStudent += englishScores[i].length;//i번째 행의 열 개수를 누적합해서 총학생수 구하기
			for(int k = 0; k < englishScores[i].length; k++)//englishScores의 i번째 행의 개수만큼 반복
			{
				totalEnglishSum += englishScores[i][k];//총영어점수의 누적합 구하기
			}
		}
		double totalEnglishAvg = (double) totalEnglishSum / totalStudent;//영어점수의 평균값이 실수형이므로 int로 선언된 영어총점을 실수형으로 형변환해서 계산
		System.out.println("전체 학생의 영어 평균 점수 : " + totalEnglishAvg);//평균값 출력
	}

}
