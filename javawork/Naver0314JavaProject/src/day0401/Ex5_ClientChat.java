package day0401;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex5_ClientChat extends JFrame implements ActionListener, Runnable
{
	JButton btnConnect;
	JLabel lblMessage;
	JTextArea area;
	JTextField tfMessage;
	JButton btnSend;
	BufferedReader br;
	PrintWriter pw;
	static String nickName;
	Socket socket;
	
	public Ex5_ClientChat(String title)
	{
		super(title);
		this.setLocation(100, 100);//시작위치
		this.setSize(500, 500);//창크기
		//this.getContentPane().setBackground(new Color(255, 255, 0));//RGB순서 맞음
		this.getContentPane().setBackground(Color.YELLOW);//Color의 상수도 가능
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 종료
		this.initDesign();//각종 컴포넌트 생성
		this.setVisible(true);
	}
	
	//서버가 보내오는 메세지를 받아서 출력하기 위한 쓰레드 메서드
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("클라이언트의 run()");
		
		while(true)
		{
			try {
				String msg=br.readLine();
				area.append(msg+"\n");
				this.autoScroll();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	//메세지 전송 텍스트필드와 전송버튼을 동시에 처리하기 위한 메서드
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		Object ob = e.getSource();
		if(ob == tfMessage || ob == btnConnect);
		{
			pw.write("2|"+tfMessage.getText() + "\n");
			pw.flush();//입력창의 데이터 지우고 커서보내기
			tfMessage.setText("");//입력창의 데이터 지우고  
			tfMessage.requestFocus();//커서보내기
		}
	}
	
	public void autoScroll()
	{
		int n = area.getDocument().getLength();//총 라인수
		area.setCaretPosition(n);//마지막줄로 이동후 출력
	}
	
	public void initDesign()
	{
		this.setLayout(null);//기본 레이아웃을 없애야 직접 수정 가능
		btnConnect = new JButton("서버 접속하기");
		btnConnect.setBounds(50,10,150,30);
		this.add(btnConnect);
		
		lblMessage = new JLabel("접속여부 : 접속안함");
		lblMessage.setBounds(220, 10, 100, 30);
		this.add(lblMessage);
		
		area = new JTextArea();
		//area.setBounds(10, 140, 400, 400);
		JScrollPane pane = new JScrollPane(area);
		pane.setBounds(10, 40, 470, 350);
		this.add(pane);
		
		tfMessage = new JTextField(30);
		tfMessage.setBounds(10, 410, 350, 30);
		this.add(tfMessage);
		
		btnSend= new JButton("전송");
		btnSend.setBounds(370, 410, 100, 30);
		this.add(btnSend);
		
		//현재 클래스 내에 구현한 메서드 호출
		tfMessage.addActionListener(this);
		btnSend.addActionListener(this);
		
		//서버 접속 이벤트
		btnConnect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//접속하기 누를때 바로 접속
				String serverIp = JOptionPane.showInputDialog("접속할 서버 아이피를 입력하세요.", "192.168.0.57");//초기값은 로칼 IP
				nickName = JOptionPane.showInputDialog("접속할 닉네임을 입력하세요", "공병현");//초기값은 각가 자기 이름으로
				
				//서버 접속하기
				try 
				{
					socket = new Socket(serverIp, 6000);
					System.out.println("서버 접속 성공!");
					br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					pw = new PrintWriter(socket.getOutputStream());
					Ex5_ClientChat.this.setTitle(nickName+ "님의 채팅창");//창제목 병경
					lblMessage.setText("서버접속중..." + nickName);
					
					//접속하는 순간 스레드 열기
					Thread th = new Thread(Ex5_ClientChat.this);
					th.start();//run 메서드 호출
					
					// 서버로 "1|닉네임" 이 형태로 보내기
					pw.write("1|" + nickName + "\n");
					pw.flush(); //flush를 해야 비로소 서버로 전송이 된다.
					
					
				}
				catch (IOException e1)
				{
					// TODO Auto-generated catch block
					System.out.println("서버 접속 오류 : " + e1.getMessage());
				}
			}
		});
		
		
	}
	
	public static void main(String[] args) 
	{
		Ex5_ClientChat a = new Ex5_ClientChat("클라이언트");

		
		
	}
	
	
}
