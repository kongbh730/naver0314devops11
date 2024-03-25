package day0325;

public class Shop 
{
	//변수
	private String sang;
	private int su;
	private int dan;
	
	//생성자
	public Shop()
	{
		sang = "미입력";
		su = 0;
		dan = 0;
	}
	public Shop(String sang)
	{
		this.sang = sang;
		su = 0;
		dan = 0;
	}
	public Shop(int su, int dan)
	{
		this("미입력", su, dan);//이렇게도 됨
//		sang = "미입력";
//		this.su = su;
//		this.dan = dan;
	}
	public Shop(String sang, int su, int dan)
	{
		this.sang = sang;
		this.su = su;
		this.dan = dan;
	}
	
	//getter
	public String getSang()
	{
		return sang;
	}
	public int getSu()
	{
		return su;
	}
	public int getDan()
	{
		return dan;
	}
	
	//setter
	public void setSang(String sang)
	{
		this.sang = sang;
	}
	public void setSu(int su)
	{
		this.su = su;
	}
	public void setDan(int dan)
	{
		this.dan = dan;
	}
	public void setSangpum(String sang, int su, int dan)
	{
		setSang(sang);
		setSu(su);
		setDan(dan);
	}
}
