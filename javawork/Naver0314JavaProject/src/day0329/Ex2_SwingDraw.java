package day0329;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class Ex2_SwingDraw extends JFrame implements MouseMotionListener, MouseListener
{
	//초기 선 색상
	Color color = Color.green;
	int x, y, prex, prey;// 곡선을 그릴 현재좌표 x,y와 직전좌표 prex, prey;
	
	//=============== MouseMotionListner 인터페이스 ======================
	@Override
	public void mouseDragged(MouseEvent e) 
	{
		//현재 좌표를 직전좌표로 저장
		prex = x;
		prey = y;
		
		//현재좌표는 다시 마우스위치로 저장
		x = e.getX();
		y = e.getY();
		
		//paint 다시 호출
		this.repaint();//this생략가능
		//repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) 
	{
		x = e.getX();
		y = e.getY();
	}
	//================================================================
	//======================== MouseListner 인터페이스 ======================
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		//클릭시 x, y 변경
		x = e.getX();
		y = e.getY();
		
		// MousePressed 발생시 선색을 랜덤하게 바꿔보자
		int r, g, b;
		
		r = (int)(Math.random() * 256);
		g = (int)(Math.random() * 256);
		b = (int)(Math.random() * 256);
		
		color = new Color(r, g, b);
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{

	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		
	}

	@Override
	public void mouseExited(MouseEvent e) 
	{
		
	}
	//================================================================

	public Ex2_SwingDraw(String title)
	{
		super(title);
		this.setLocation(100, 100);//시작위치
		this.setSize(600, 600);//창크기
		//this.getContentPane().setBackground(new Color(255, 255, 0));//RGB순서 맞음
		//this.getContentPane().setBackground(Color.CYAN);//Color의 상수도 가능
		//유일하게 color의 클래스만 pane을 얻어야 가능함
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 종료
		//마우스 이벤트 추가
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
		
		this.initDesign();//각종 컴포넌트 생성
		this.setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) 
	{
		//super.paint(g);
		
		//선 색상
		g.setColor(color);
		
		//선 굵기 지정//Graphics에는 없고 Graphics2D에 있음
		Graphics2D g2 =(Graphics2D)g;
		g2.setStroke(new BasicStroke(5));
		
		//선 그리기
		//g.drawLine(10, 100, 400, 100);//시작위치x, 시작위치y, 끝위치x, 끝위치y
		
		//곡선은 마우스를 드래그시 직전좌표부터 현재좌표까지 선을 그리면 곡선이 된다.
		g.drawLine(prex, prey, x, y);
		
	}
	
	public void initDesign()
	{
		
	}
	
	public static void main(String[] args) 
	{
		Ex2_SwingDraw a = new Ex2_SwingDraw("곡선그리기");
		

		
		
	}
	
	
}
