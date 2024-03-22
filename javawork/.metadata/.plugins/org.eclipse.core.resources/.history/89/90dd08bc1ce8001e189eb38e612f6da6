package day0322;

public class Sawon 
{
	private String name;
	private int gibon;
	private int sudang;

	//메서드가 public이면 패키지 외부에서 접근이 가능
	//setter method
	public void setName(String name)
	{
		this.name = name;
	}
	public void setGibon(int gibon)
	{
		this.gibon = gibon;
	}
	public void setSudang(int sudang)
	{
		this.sudang = sudang;
	}
	
	//한번에 이름, 기본, 수당을 입력받는 메서드
	public void setSawon(String name, int gibon, int sudang)
	{
		setName(name);
		setGibon(gibon);
		setSudang(sudang);
	}

	//getter method
	public String getName()
	{
		//return this.name;
		return name;
	}
	public int getGibon()
	{
		//return this.gibon;
		return gibon;
	}
	public int getSudang()
	{
		//return this.sudang;
		return sudang;
	}
	
	//실 수령액을 반환하는 메서드
	public int getNetPay()
	{
		int pay = 0;
		
		pay = gibon - (gibon * 3/100) + sudang;
		
		return pay;
	}


}
