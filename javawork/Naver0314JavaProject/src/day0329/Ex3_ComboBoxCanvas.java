package day0329;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex3_ComboBoxCanvas extends JFrame
{
	JComboBox<String> combo;
	int selectCombo = 5;//이미지 기본값
	static final String PATH = "C:\\naver0314\\workall\\image\\연예인사진\\";
	Random rand = new Random();//랜덤클래스 선언
	String [] comboLabel = {"선", "원", "사각형", "문자열", "이미지"}; 
	Draw draw = new Draw();
	
	public Ex3_ComboBoxCanvas(String title)
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
	
	public void initDesign()
	{
		JPanel p = new JPanel();
		combo = new JComboBox<>(comboLabel);
		p.add(new JLabel("메뉴를 선택하세요"));
		p.add(combo);
		
		combo.setSelectedIndex(selectCombo - 1);//콤보박스 초기값 지정
	
		//이벤트
		combo.addItemListener(new ItemListener() 
		{
			//이게 왜 두번 호출?
			@Override
			public void itemStateChanged(ItemEvent e) 
			{
				selectCombo = combo.getSelectedIndex() + 1;
				//paint호출
				draw.repaint();
			}
		});
		//프레임에 패널추가
		this.add("North", p);
		
		//중앙에는 캔버스를 배치
		this.add("Center", draw);
		
		
		
	}
	
	//랜덤한 색상을 반환하는 메서드
	public Color getRandomColor()
	{
		int red = rand.nextInt(256);
		int green = rand.nextInt(256);
		int blue = rand.nextInt(256);
		
		return new Color(red, green, blue);
	}
	
	class Draw extends Canvas
	{
		@Override
		public void paint(Graphics g) 
		{
			super.paint(g);
			
			if(selectCombo == 1)
			{
				//랜덤한 색상의 랜덤한 위치에 총 50개의 선을 그려보자
				for(int i = 1; i <= 50; i++)
				{
					int x, y, x2, y2;
					
					x = rand.nextInt(500);
					y = rand.nextInt(500);
					x2 = rand.nextInt(500);
					y2 = rand.nextInt(500);
					Color color = getRandomColor();
					
					g.setColor(color);
					g.drawLine(x, y, x2, y2);
				}
			}
			else if(selectCombo == 2)
			{
				//랜덤한 색상의 랜덤한 위치에 총 50개의 채워진 원을 그려보자
				for(int i = 1; i <= 50; i++)
				{
					int x, y, width;
					
					x = rand.nextInt(500);
					y = rand.nextInt(500);
					width = rand.nextInt(40) + 20;
					Color color = getRandomColor();
					
					g.setColor(color);
					g.fillOval(x, y, width, width);
				}
			}
			else if(selectCombo == 3)
			{
				//랜덤한 색상의 랜덤한 위치에 총 50개의 채워진 사각형을 그려보자
				for(int i = 1; i <= 50; i++)
				{
					int x, y, width;
					
					x = rand.nextInt(500);
					y = rand.nextInt(500);
					width = rand.nextInt(40) + 20;
					Color color = getRandomColor();
					
					g.setColor(color);
					g.fillRect(x, y, width, width);
				}
			}
			else if(selectCombo == 4)
			{
				//랜덤한 색상의 랜덤한 위치에 총 50개의 문자열을 그려보자
				//나타낼 문자열
				String msg = "Hava a Nice Day!!!";
				g.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
				for(int i = 1; i <= 30; i++)
				{
					int x, y, width;
					
					x = rand.nextInt(200);
					y = rand.nextInt(400)+ 20;
					Color color = getRandomColor();
					g.setColor(color);
					
					g.drawString(msg, x, y);
				}
			}
			else if(selectCombo == 5)
			{
				//1부터 20 사이의 난수를 발생시킨 후  PATH+난수값.jpg 생성후 나타내보세요
				int temp = rand.nextInt(19) + 1;
				String fileName = PATH + temp + ".jpg";
				//System.out.println(fileName);
				Image image = new ImageIcon(fileName).getImage();
				g.drawImage(image, 100, 10, 300, 400, this);
			}
			else
			{
				
			}
			
		}
	}
	
	public static void main(String[] args) 
	{
		Ex3_ComboBoxCanvas a = new Ex3_ComboBoxCanvas("ComboBox메뉴");
		
	}
	
	
}
