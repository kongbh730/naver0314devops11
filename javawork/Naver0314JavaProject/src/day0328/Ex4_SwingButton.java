package day0328;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ex4_SwingButton extends JFrame
{
	JButton btn1, btn2;
	public Ex4_SwingButton(String title)
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
		this.setLayout(null);//기본 레이아웃 없애기

		//버튼 1 생성
		btn1 = new JButton("Hello!!!");
		//프레임에 추가
		btn1.setBounds(10, 10, 100, 30);//시작위치 x, 시작위치 y, 너비 w, 높이 h
		this.add(btn1);
		//btn1에 이벤트 처리
		//btn1에 이벤트 추가-익명 내부 클래스 형태로 이벤트 구현

		btn1.addActionListener(new ActionListener() 
		{
			//익명 내부클래스 형태로 생성
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(Ex4_SwingButton.this, "버튼 1을 눌렀어요");
			}
		});

		//버튼 2 생성 후 프레임에 추가해보세요
		//버튼 2 생성
		btn2 = new JButton("button2");
		//프레임에 추가
		btn2.setBounds(10, 60, 150, 50);//시작위치 x, 시작위치 y, 너비 w, 높이 h
		this.add(btn2);
		//btn2에 이벤트 처리
		//btn2에 이벤트 추가-익명 내부 클래스 형태로 이벤트 구현

		//버튼 2 이벤트
//		btn2.addActionListener(new ActionListener() 
//		{
//			//익명 내부클래스 형태로 생성
//			@Override
//			public void actionPerformed(ActionEvent e) 
//			{
//				JOptionPane.showMessageDialog(Ex4_SwingButton.this, "버튼 2을 눌렀어요");
//			}
//		});

		//버튼 2 이벤트
		btn2.addActionListener(new Button2Event());	
	}
	
	버튼2의 이벤트에 대한 내부클래스
	class Button2Event implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			JOptionPane.showMessageDialog(Ex4_SwingButton.this, "맛있는 점심 먹고 오세요");
		}
		
	}

	public static void main(String[] args) 
	{
		Ex4_SwingButton a = new Ex4_SwingButton("스윙버튼");


	}

}