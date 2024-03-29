package day0329;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ex4_SwingTable extends JFrame
{
	JTable table;
	JLabel lblMessage;//라벨메세지
	//메세지 라벨을 south에 추가
	
	public Ex4_SwingTable(String title)
	{
		super(title);
		this.setLocation(100, 100);//시작위치
		this.setSize(500, 400);//창크기
		//this.getContentPane().setBackground(new Color(255, 255, 0));//RGB순서 맞음
		this.getContentPane().setBackground(Color.CYAN);//Color의 상수도 가능
		//유일하게 color의 클래스만 pane을 얻어야 가능함
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 종료
		this.initDesign();//각종 컴포넌트 생성
		this.setVisible(true);
	}

	public void initDesign()
	{
		String []title = {"이름", "나이", "혈액형", "핸드폰", "주소"};
		String [][]data = {
				{"이영자", "32세", "B", "010-1234-1234", "서울"},
				{"강호동", "45세", "O", "010-8989-9999", "부산"},
				{"유재석", "29세", "AB", "010-2222-3333", "제주도"},
				{"제니", "23세", "A", "010-6767-7878", "뉴욕"}
		};

		table = new JTable(data, title);
		this.add("North", new JLabel("701 멤버 현황", JLabel.CENTER));
		//이대로 출력하면 title이 안보인다.	
//		this.add("Center", table);

		//이대로 출력하면 title이 보인다.
		this.add("Center", new JScrollPane(table));//테이블도 스크롤바가 생겨야 한다.(제목포함)
	
		//클릭하면 정보 나열하는 기능 추가
		lblMessage = new JLabel("결과 나올 곳...", JLabel.CENTER);
		lblMessage.setFont(new Font("", Font.BOLD, 20));
		this.add("South", lblMessage);

	}

	public static void main(String[] args) 
	{
		Ex4_SwingTable a = new Ex4_SwingTable("테이블");

	}
}
