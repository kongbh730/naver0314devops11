package day0328;

import java.awt.Color;
import javax.swing.JFrame;

public class SwingGibon extends JFrame
{
	public SwingGibon(String title)
	{
		super(title);
		this.setLocation(100, 100);//시작위치
		this.setSize(300, 300);//창크기
		this.getContentPane().setBackground(new Color(255, 255, 0));//RGB순서 맞음
		this.getContentPane().setBackground(Color.CYAN);//Color의 상수도 가능
		//유일하게 color의 클래스만 pane을 얻어야 가능함
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 종료
		this.initDesign();//각종 컴포넌트 생성
		this.setVisible(true);
	}
	
	public void initDesign()
	{
		
	}
	
	public static void main(String[] args) 
	{
		SwingGibon a = new SwingGibon("기본창");
		
		
		
		
		
	}
	
	
	
	
	
	
}