package day0328;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Ex6_SwingCanvasRadio extends JFrame
{
	final static String PHOTO1 = "C:\\naver0314\\workall\\image\\연예인사진\\19.jpg";
	final static String PHOTO2 = "C:\\naver0314\\workall\\image\\연예인사진\\18.jpg";
	final static String PHOTO3 = "C:\\naver0314\\workall\\image\\연예인사진\\15.jpg";
	final static String PHOTO4 = "C:\\naver0314\\workall\\image\\연예인사진\\2.jpg";

	Color boxColor = new Color(67, 196, 207);//초기 박스 색상
	JRadioButton rbBox1, rbBox2, rbBox3, rbBox4;
	//JRadioButton rbPhoto1, rbPhoto2, rbPhoto3, rbPhoto4;
	JRadioButton []rbPhoto = new JRadioButton[4];//배열로 해보기
	
	int photoIndex = 1;// 처음에 수지사진

	MyDraw draw = new MyDraw();

	public Ex6_SwingCanvasRadio(String title)
	{
		super(title);
		this.setLocation(100, 100);//시작위치
		this.setSize(400, 500);//창크기
		//this.getContentPane().setBackground(new Color(255, 255, 0));//RGB순서 맞음
		//this.getContentPane().setBackground(Color.CYAN);//Color의 상수도 가능
		//유일하게 Color의 클래스만 pane을 얻어야 가능함
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

			//채워진 박스 그리기
			g.setColor(boxColor);
			g.fillRect(30, 30, 320, 350);

			Image image = null;
			switch(photoIndex)
			{
			case 1:
				image = new ImageIcon(PHOTO1).getImage();
				break;
			case 2:
				image = new ImageIcon(PHOTO2).getImage();
				break;
			case 3:
				image = new ImageIcon(PHOTO3).getImage();
				break;
			case 4:
				image = new ImageIcon(PHOTO4).getImage();
				break;
			}
			g.drawImage(image, 60, 50, 250, 300, this);
		}
	}

	public void initDesign()
	{
		this.add("Center", draw);
		//상단에 색상 라디오버튼 추가
		JPanel pTop = new JPanel();
		ButtonGroup bg1 = new ButtonGroup();
		rbBox1 = new JRadioButton("초록색");
		bg1.add(rbBox1);
		pTop.add(rbBox1);

		rbBox2 = new JRadioButton("하늘색");
		bg1.add(rbBox2);
		pTop.add(rbBox2);

		rbBox3 = new JRadioButton("분홍색");
		bg1.add(rbBox3);
		pTop.add(rbBox3);

		rbBox4 = new JRadioButton("오렌지색");
		bg1.add(rbBox4);
		pTop.add(rbBox4);

		//rbBox1에 대한 이벤트//초록색
		rbBox1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				boxColor = Color.green;
				//캔바스의 paint 메서드 강제 호출ㄴ6ㅇ
				draw.repaint();
			}
		});

		//rbBox2에 대한 이벤트//하늘색
		rbBox2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				boxColor = new Color(50, 150, 255);
				draw.repaint();
			}
		});

		//rbBox3에 대한 이벤트//분홍색
		rbBox3.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				boxColor = Color.pink;
				draw.repaint();
			}
		});

		//rbBox4에 대한 이벤트//오렌지색
		rbBox4.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				boxColor = Color.orange;
				draw.repaint();
			}
		});

		//프레임 상단에 Panel 추가
		this.add("North", pTop);
		
		//프레임 하단에는 사진선택하는 라디오 버튼 추가
		JPanel pBottom = new JPanel();
		ButtonGroup bg2 = new ButtonGroup();
		String []s = {"수지", "신세경", "설현", "김우빈"};
		for(int i = 0; i < rbPhoto.length; i++)
		{
			final int n = i + 1;
			rbPhoto[i] = new JRadioButton(s[i], i == (photoIndex - 1)?true:false);
			//그룹변수에 추가
			bg2.add(rbPhoto[i]);
			//패널에도 추가
			pBottom.add(rbPhoto[i]);
			
			//이벤트
			rbPhoto[i].addActionListener(new ActionListener() 
			{
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					photoIndex = n;
					draw.repaint();//캔버스 내부클래스의 repaint 강제호출
				}
			});
		}
		
		this.add("South", pBottom);
	}

	public static void main(String[] args) 
	{
		Ex6_SwingCanvasRadio a = new Ex6_SwingCanvasRadio("캔버스2");
	}
}
