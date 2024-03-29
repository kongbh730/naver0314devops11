package day0328;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ex8_SwingFileImage extends JFrame
{
	final static String PHOTO[] = 
		{ 
				"C:\\naver0314\\workall\\image\\연예인사진\\1.jpg",
				"C:\\naver0314\\workall\\image\\연예인사진\\2.jpg",
				"C:\\naver0314\\workall\\image\\연예인사진\\3.jpg",
				"C:\\naver0314\\workall\\image\\연예인사진\\4.jpg"
		};
	JButton btnOpen;
	
	int photoIndex = (int)(Math.random() * 4);//초기 사진은 랜덤
	MyDraw draw = new MyDraw();

	public Ex8_SwingFileImage(String title)
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

	//캔바스 내부 클래스
	class MyDraw extends Canvas
	{
		@Override
		public void paint(Graphics g) 
		{
			super.paint(g);

			Image image = null;
			switch(photoIndex)
			{
			case 0:
				image = new ImageIcon(PHOTO[photoIndex]).getImage();
				break;
			case 1:
				image = new ImageIcon(PHOTO[photoIndex]).getImage();
				break;
			case 2:
				image = new ImageIcon(PHOTO[photoIndex]).getImage();
				break;
			case 3:
				image = new ImageIcon(PHOTO[photoIndex]).getImage();
				break;
			}
			g.drawImage(image, 20, 20, 400, 400, this);
		}
	}

	public void initDesign()
	{
		this.add("Center", draw);//초기 사진 출력
		
		//프레임의 상단에 추가
		JPanel p = new JPanel();
		btnOpen = new JButton("사진 불러오기");
		p.add(btnOpen);
		this.add("North", p);
		
		//파일열기 이벤트
		btnOpen.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				//파일 다이얼로그(열기모드)
				FileDialog dlg = new FileDialog(Ex8_SwingFileImage.this,
						"파일열기", FileDialog.LOAD);//열때는 LOAD, 넣을땐 SAVE
				dlg.setVisible(true);//다이얼로그 보이게하기
				//창크기 보다 큰게 들어올때 문제가 생긴다.

				if(dlg.getDirectory() == null)
				{
					return;
				}
				String path = dlg.getDirectory() + dlg.getFile();
				//path : 에 파일명 저장
				FileReader fr = null;
				//BufferedReader br = null;//버퍼리더도 필요 없지
				try 
				{
					fr = new FileReader(path);					
				}
				catch (FileNotFoundException e1) 
				{
					e1.printStackTrace();
				} 
				finally
				{
					try 
					{
						fr.close();
					} 
					catch (IOException|NullPointerException e1) 
					{

					}
				}

			}
		});
	}

	public static void main(String[] args) 
	{
		Ex8_SwingFileImage a = new Ex8_SwingFileImage("이미지 불러오기");
		//저장 필요없음
		//초기사진 출력하기 + 사진 불러오기
	}
}
