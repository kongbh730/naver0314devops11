package day0401;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex3_ThreadSwingCanvas extends JFrame implements Runnable
{
	JButton btnStart, btnStop;
	MyDraw draw = new MyDraw();
	
	public Ex3_ThreadSwingCanvas(String title)
	{
		super(title);
		this.setLocation(100, 100);//시작위치
		this.setSize(500, 500);//창크기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 종료
		this.initDesign();//각종 컴포넌트 생성
		this.setVisible(true);
	}
	
	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		System.out.println("원그리기");
		if(draw == null)
		{
			return;
		}
//		while(true)
//		{
//			draw.repaint();
//			//draw.paint(getGraphics());
//		}
	}
	
	class MyDraw extends Canvas
	{
		@Override
		public void paint(Graphics g) 
		{
			// TODO Auto-generated method stub
			//super.paint(g);
			System.out.println("paint");
			
			//랜덤색상 생성
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			
			g.setColor(new Color(red, green, blue));
			
			int xpos = (int)(Math.random()*400) + 50;
			int ypos = (int)(Math.random()*400) + 50;
			
			g.fillOval(xpos, ypos, 70, 70);
		}
	}
	
	public void initDesign()
	{
		//캔버스를 센터에 배치
		this.add("Center", draw);
	}
	
	public static void main(String[] args)
	{
		Ex3_ThreadSwingCanvas a = new Ex3_ThreadSwingCanvas("쓰레드 예제");
		//Thread th = new Thread(a);
		//th.start();
		
		
		
		
	}
}