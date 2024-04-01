package day0401;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ex5_ServerChat extends JFrame implements Runnable{
	JTextArea area;
	Vector<ClientMember> list = new Vector<Ex5_ServerChat.ClientMember>();
	ServerSocket serverSocket;

	public Ex5_ServerChat(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setLocation(100, 100);//시작위치
		this.setSize(500, 500);//창크기
		//this.getContentPane().setBackground(new Color(93, 199, 187));//배경색 변경
		//this.getContentPane().setBackground(Color.yellow);//배경색 변경
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 종료
		this.initDesign();//각종 컴포넌트 생성
		this.setVisible(true);
	}

	//접속하는 클라이언트들을 허용하고 벡터에 저장하는 기능
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("서버소켓 생성후 접속하는 클라이어트들 허용하는 run");

		//서버 소켓 생성
		try {
			serverSocket=new ServerSocket(6000);
			area.append("서버 소켓 생성 성공\n");
			while(true)
			{
				//접속한 클라이언트를 허용하고 소켓을 생성한다.
				Socket socket = serverSocket.accept();
				area.append("접속한 IP : " + socket.getInetAddress().getHostAddress() + "\n");
				this.autoScroll();
			}
		} catch (IOException e) {
			area.append("서버 소켓 생성 오류:"+e.getMessage()+"\n");
		}
	}

	//클라이언트 내부클래스
	class ClientMember extends Thread
	{
		Socket mySocket;
		String nickName;
		BufferedReader br;
		PrintWriter pw;
		//생성자
		public ClientMember(Socket socket) {
			// TODO Auto-generated constructor stub
			//외부의 run 메소드에서 생성시 소켓을 받아서 생성할것임			
			mySocket=socket;

			//네트워크를 통해서 메세지를 읽고 쓸수 있도록 io 클래스 생성
			try {
				br=new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
				pw=new PrintWriter(mySocket.getOutputStream());
			}catch (IOException e) {
				// TODO: handle exception
			}
		}

		//각 클라이언트로부터 들어오는 메세지를 읽어서 모든 클라이언트들한테 보내주는 기능
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
		}
	}
	
	public void autoScroll()
	{
		int n = area.getDocument().getLength();//총 라인수
		area.setCaretPosition(n);//마지막줄로 이동후 출력
	}

	public void initDesign()
	{
		area=new JTextArea();
		this.add(area);
		
		JScrollPane pane = new JScrollPane(area);
		pane.setBounds(10, 40, 470, 350);
		this.add(pane);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex5_ServerChat a=new Ex5_ServerChat("채팅서버");
		Thread th=new Thread(a);
		th.start();

	}

}