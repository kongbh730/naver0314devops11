package day0328;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

//자바는 다중속성이 불가 -> 내부클래스 or 인터페이스로 극복
public class Ex5_SwingCanvas extends JFrame
{
	//캔버스 변수 선언
	MyDraw draw = new MyDraw();
	//음식사진경로
	//자바에서 주소는 \ 두번
	String foodImage = "C:\\naver0314\\workall\\image\\음식사진\\11.jpg";
	String foodImage2 = "C:\\naver0314\\workall\\image\\음식사진\\1.jpg";
	
	public Ex5_SwingCanvas(String title)
	{
		super(title);
		this.setLocation(100, 100);//시작위치
		this.setSize(500, 500);//창크기
		//this.getContentPane().setBackground(new Color(255, 255, 0));//RGB순서 맞음
		//this.getContentPane().setBackground(Color.CYAN);//Color의 상수도 가능
		//유일하게 color의 클래스만 pane을 얻어야 가능함
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 종료
		this.initDesign();//각종 컴포넌트 생성
		this.setVisible(true);
	}
	
	//캔버스 상속받음
	class MyDraw extends Canvas
	{
		//처음 시작시, 그리고 프레임 크기 변경시에 자동호출
		//그 이외에는 강제호출(repaint)
		@Override
		public void paint(Graphics g) 
		{
			// TODO Auto-generated method stub
			super.paint(g);
			
			//색상변경
			g.setColor(Color.magenta);
			//타원 그리기
			g.drawOval(30, 30, 100, 100); //x, y, 너비, 높이
			
			g.setColor(Color.orange);
			g.fillOval(150, 30, 100, 100);
			
			//테두리만 있는 사각형
			g.setColor(new Color(8, 207, 7));
			g.drawRect(30, 150, 100, 100);
			
			//채워진 사각형
			g.setColor(new Color(200, 100, 100));
			g.fillRect(150, 150, 100, 100);
			
			//글꼴 출력
			g.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
			g.drawString("Good Day!!", 50, 350);
			
			g.setColor(new Color(50, 150, 50));
			g.setFont(new Font("궁서체", Font.BOLD, 30));
			g.drawString("안녕하세요", 50, 400);
			
			//음식 이미지출력하기 //방법1
			Image image1 = new ImageIcon(foodImage).getImage();
			g.drawImage(image1, 300, 50, 130, 130, this);
			
			//음식 이미지출력하기 //방법2
			Image image2 = Toolkit.getDefaultToolkit().getImage(foodImage2);
			g.drawImage(image2, 300, 200, 130, 130, this);
			//이미지이름, x좌표, y좌표, 너비, 높이
			
		}
	}
	
	public void initDesign()
	{
		//기본 레이아웃의 center에 캔바스 추가
		this.add("Center", draw);
	}
	
	public static void main(String[] args) 
	{
		Ex5_SwingCanvas a = new Ex5_SwingCanvas("캔버스");
		
	}
	
}
