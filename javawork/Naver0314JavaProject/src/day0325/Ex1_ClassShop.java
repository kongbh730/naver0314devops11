package day0325;

public class Ex1_ClassShop 
{
	//showTitle
	public static void showTitle()
	{
		System.out.println("** 상품정보 **");
		System.out.println();
	}
	//writeTitle
	public static void writeShop(Shop s[])
	{
		int i;
		
		for(i = 0; i < s.length; i++)
		{
			System.out.println("상품명 : " + s[i].getSang());
			System.out.println("수량 : " + s[i].getSu());
			System.out.println("단가 : " + s[i].getDan());
			System.out.println();
		}
	}
	
	public static void main(String[] args)
	{
		Shop []myShop = new Shop[4];//객체배열 메모리 할당, 초기값은 null
		myShop[0] = new Shop();
		myShop[1] = new Shop("딸기");
		myShop[2] = new Shop(3, 2000);
		myShop[3] = new Shop("사과", 5, 3000);

		showTitle();//제목을 출력하는 static method
		writeShop(myShop);//배열형태로 전달 ...전달법 사용

		System.out.println();
		System.out.println("0번의 상품명, 수량, 단가 변경");
		myShop[0].setSang("포도");
		myShop[0].setSu(3);
		myShop[0].setDan(2000);

		System.out.println();
		System.out.println("1번의 상품명, 수량, 단가 변경");
		myShop[1].setSangpum("오렌지", 5, 1200);

		System.out.println("** 변경된 값으로 다시 출력 **");
		showTitle();
		writeShop(myShop);
	}
}
