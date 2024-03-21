package day0321;

public class Ex8_Array2Dimension {
	public static void main(String[] args) {
		int [][]arr;
		arr = new int[2][3];
		
		System.out.println("행갯수 : " + arr.length);
		System.out.println("0번행의 열갯수 : " + arr[0].length);
		
		arr[0][0] = 3;
		arr[0][0] = 10;
		
		arr[1][1] = 30;
		arr[1][2] = 50;
	}

}
