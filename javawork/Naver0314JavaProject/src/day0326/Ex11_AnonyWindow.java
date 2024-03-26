package day0326;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

class NewFrame extends JFrame
{
	public NewFrame()
	{
		super("Hello");
		this.setLocation(300, 100);//시작위치
		this.setSize(300, 300);
		this.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				super.windowClosing(e);
				System.out.println("윈도우를 종료합니다.");
				System.exit(0);
			}
		});
		//프레임 보이게
		this.setVisible(true);
	}
}
public class Ex11_AnonyWindow
{
	public static void main(String[] args) {
		NewFrame f = new NewFrame();
	}
}