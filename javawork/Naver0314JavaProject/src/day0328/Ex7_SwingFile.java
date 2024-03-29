package day0328;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//file dialog
//text area

public class Ex7_SwingFile extends JFrame
{
	JButton btnOpen, btnSave;
	JTextArea memoArea;
	
	public Ex7_SwingFile(String title)
	{
		super(title);
		this.setLocation(100, 100);//시작위치
		this.setSize(500, 500);//창크기
		this.getContentPane().setBackground(new Color(255, 255, 0));//RGB순서 맞음
		this.getContentPane().setBackground(Color.CYAN);//Color의 상수도 가능
		//유일하게 color의 클래스만 pane을 얻어야 가능함
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 종료
		this.initDesign();//각종 컴포넌트 생성
		this.setVisible(true);
	}
	
	public void initDesign()
	{
		JPanel p = new JPanel();
		btnOpen = new JButton("파일열기");
		btnSave = new JButton("파일저장");
		p.add(btnOpen);
		p.add(btnSave);
		
		//프레임의 상단에 추가
		this.add("North", p);
		//메모장은 가운데 추가
		memoArea = new JTextArea();

		//this.add("Center", memoArea);//메모장크기보다 큰 내용을 불러올 경우 안보임
		this.add("Center", new JScrollPane(memoArea));//메모장 크기보다 큰 내용 불러올 경우 스크롤 생성
		
		//파일열기 이벤트
		btnOpen.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				//파일 다이얼로그(열기모드)
				FileDialog dlg = new FileDialog(Ex7_SwingFile.this,
						"파일열기", FileDialog.LOAD);//열때는 LOAD, 넣을땐 SAVE
				dlg.setVisible(true);//다이얼로그 보이게하기
				//창크기 보다 큰게 들어올때 문제가 생긴다.
				
				
				if(dlg.getDirectory() == null)
				{
					return;
				}
				String path = dlg.getDirectory() + dlg.getFile();
				
				FileReader fr = null;
				BufferedReader br = null;
				
				try 
				{
					fr = new FileReader(path);
					br = new BufferedReader(fr);
					//기존의 메모장 내용 모두 지우기
					memoArea.setText("");
					
					while(true)
					{
						//파일의 내용을 한줄씩 읽는다.
						String line = br.readLine();
						if(line == null)
						{
							break;
						}
						memoArea.append(line + "\n");
					}
				}
				catch (FileNotFoundException e1) 
				{
					e1.printStackTrace();
				} 
				catch (IOException e1) 
				{
					e1.printStackTrace();
				}
				finally
				{
					try 
					{
						br.close();
						fr.close();
					} 
					catch (IOException|NullPointerException e1) 
					{
						
					}
				}
				
			}
		});
		
		//파일 저장 이벤트
		btnSave.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				FileDialog dlg = new FileDialog(Ex7_SwingFile.this,
						"파일저장", FileDialog.SAVE);//열때는 LOAD, 넣을땐 SAVE
				dlg.setVisible(true);//다이얼로그 보이게하기
				//창크기 보다 큰게 들어올때 문제가 생긴다.
				
				if(dlg.getDirectory() == null)
				{
					return;
				}
				String path = dlg.getDirectory() + dlg.getFile();
				
				FileWriter fw = null;
				try 
				{
					fw = new FileWriter(path);
					fw.write(memoArea.getText());//한번에 저장됨
				}
				catch (IOException e1) 
				{
					e1.printStackTrace();
				}
				finally
				{
					try 
					{
						fw.close();
					}
					catch (IOException e1)
					{
						e1.printStackTrace();
					}
				}
			}
		});	
	}
	
	public static void main(String[] args) 
	{
		Ex7_SwingFile a = new Ex7_SwingFile("간단메모장");
	}
}
