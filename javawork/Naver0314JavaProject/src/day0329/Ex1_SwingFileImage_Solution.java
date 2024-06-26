package day0329;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex1_SwingFileImage_Solution extends JFrame
{
	static String photo = "C:\\naver0314\\workall\\image\\연예인사진\\1.jpg";
	JButton btnImageOpen;
	MyPhoto myPhoto = new MyPhoto();//캔버스 내부 클래스//멤버변수처럼 사용가능
	
	public Ex1_SwingFileImage_Solution(String title)
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
	
	//캔바스를 상속받는 내부클래스
	class MyPhoto extends Canvas
	{
		@Override
		public void paint(Graphics g) 
		{
			super.paint(g);
			Image image = new ImageIcon(photo).getImage();
			g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
		
		}
	}
	
	public void initDesign()
	{
		//패널에 버튼을 생성 수 패널을 North에 추가
		JPanel p = new JPanel();
		btnImageOpen = new JButton("이미지 불러오기");
		p.add(btnImageOpen);
		this.add("North", p);
		
		//캔버스는 center에 배치
		this.add("Center", myPhoto);
		
		//버튼이벤트 
		btnImageOpen.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				FileDialog dlg = new FileDialog(Ex1_SwingFileImage_Solution.this, "이미지 불러오기", FileDialog.LOAD);
				dlg.setVisible(true);
				if(dlg.getFile() == null)
				{
					return;//취소를 클릭시 메서드 종료
				}
				//불러올 경로와 파일명
				photo = dlg.getDirectory() + dlg.getFile();
				//캔바스의 paint 메서드 다시 호출
				myPhoto.repaint();
				
				//진짜?
				//이렇게 짧다고?
			}
		});
	}
	
	public static void main(String[] args) 
	{
		Ex1_SwingFileImage_Solution a = new Ex1_SwingFileImage_Solution("사진 불러오기");
	}
	
}
