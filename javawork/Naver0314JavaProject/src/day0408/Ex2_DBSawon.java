package day0408;

/*
 * 이름 : 텍스트박스 / 점수 : 텍스트박스 / 성별 : 콤보박스 / 부서 : 콤보박스
 * -------------------------------------------------------------
 * 						
 * 
 * 								TABLE
 * 
 * 
 * -------------------------------------------------------------
 * 추가	삭제		부서선택:콤보		전체ㅇ:라디오	남자ㅇ:라디오	여자ㅇ:라디오
 */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import db.common.DbConnect;

public class Ex2_DBSawon extends JFrame
{
	DbConnect db=new DbConnect();//DB연결
	JTable table;//테이블
	DefaultTableModel tableModel;//테이블 모델
	JTextField tfName,tfScore;//텍스트 필드
	JButton btnAdd,btnDel;//추가 삭제 버튼
	JComboBox<String> cbGender, cbBuseo, cbBuseoSearch;//콤보박스 3개, 성별, 부서, 부서정렬
	JRadioButton rbMale, rbFemale, rbEntire;//라디오버튼
	
	//int buseoIndex = 1;//부서 전체
	//int genderIndex = 1;//성별 전체
	String buseo = "전체부서";
	String gender = "전체";

	public Ex2_DBSawon(String title)
	{
		super(title);
		this.setLocation(100, 100);//시작위치
		this.setSize(600, 600);//창크기
		//this.getContentPane().setBackground(new Color(255, 255, 0));//RGB순서 맞음
		//this.getContentPane().setBackground(Color.CYAN);//Color의 상수도 가능
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 종료
		this.initDesign();//각종 컴포넌트 생성
		this.setVisible(true);
		this.writeSawon();
	}

	public void initDesign()
	{
		//====================== 상단패널 =======================
		JPanel p1 = new JPanel();

		//이름 입력 텍스트필드
		p1.add(new JLabel("이름"));
		tfName = new JTextField(5);
		p1.add(tfName);

		//점수 입력 텍스트필드
		p1.add(new JLabel("점수"));
		tfScore = new JTextField(5);
		p1.add(tfScore);

		//성별 콤보박스
		String []cbGenderStr = {"남성", "여성"};
		p1.add(new JLabel("성별"));
		cbGender = new JComboBox<String>(cbGenderStr);
		p1.add(cbGender);

		//부서 콤보박스
		String []cbTeamStr = {"교육부", "인사부", "홍보부"};
		p1.add(new JLabel("부서"));
		cbBuseo = new JComboBox<String>(cbTeamStr);
		p1.add(cbBuseo);

		this.add("North", p1);
		//========================================================

		//==================중단패널================================
		String []title = {"사원번호", "사원이름", "점수", "성별", "부서"};
		tableModel = new DefaultTableModel(title, 0);
		table = new JTable(tableModel);
		this.add("Center",new JScrollPane(table));
		//========================================================

		//==================하단패널================================
		JPanel p2 = new JPanel();

		//추가 버튼
		btnAdd = new JButton("추가");
		p2.add(btnAdd);

		//삭제 버튼
		btnDel = new JButton("삭제");
		p2.add(btnDel);

		//부서 정렬 콤보박스
		String []cbBuseoSearchStr = {"전체부서", "홍보부", "교육부", "인사부"};
		p2.add(new JLabel("부서"));
		cbBuseoSearch = new JComboBox<String>(cbBuseoSearchStr);
		p2.add(cbBuseoSearch);

		//라디오 버튼
		rbEntire = new JRadioButton("전체");
		rbMale = new JRadioButton("남자");
		rbFemale = new JRadioButton("여자");
		rbEntire.setSelected(true);

		//라디오 버튼은 그룹 지정 필요
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rbEntire);
		buttonGroup.add(rbMale);
		buttonGroup.add(rbFemale);

		p2.add(rbEntire);
		p2.add(rbMale);
		p2.add(rbFemale);

		this.add("South", p2);
		//========================================================

		//======이벤트 처리==========================================
		
		//추가버튼 이벤트
		btnAdd.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				//입력 없을 경우 이벤트 종료
				if(tfName.getText().length() == 0 || tfScore.getText().length() == 0)
				{
					return;
				}
				
				Connection conn = db.getConnection();
				PreparedStatement pstmt = null;
				String sql = "insert into sawon (name, score, gender, buseo) values (?, ?, ?, ?)";//사번, 이름, 점수, 성별, 부서
				
				try 
				{
					pstmt = conn.prepareStatement(sql);
					
					//? 개수만큼 바인딩
					pstmt.setString(1, tfName.getText());
					pstmt.setInt(2, Integer.parseInt(tfScore.getText()));
					pstmt.setString(3, (String)cbGender.getSelectedItem());//성별
					//pstmt.setString(4, (String)cbTeam.getSelectedItem());//부서
					
					//쿼리문 실행 
					pstmt.execute();
					
					//입력값 초기화
					tfName.setText("");
					tfScore.setText("");
					cbGender.setSelectedIndex(0);
					//cbTeam.setSelectedIndex(0);
					
					writeSawon();
				} 
				catch (SQLException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally
				{
					db.dbClose(pstmt, conn);
				}
				
				writeSawon();
			}
		});

		//삭제버튼 이벤트
		btnDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		});

		//부서검색 콤보박스 이벤트
		cbBuseoSearch.addItemListener(new ItemListener() 
		{
			@Override
			public void itemStateChanged(ItemEvent e) 
			{
				buseo = (String)cbBuseoSearch.getSelectedItem();
				writeSawon();
			}
		});

		//성별 라디오박스 이벤트
		rbEntire.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				gender = "전체";
				writeSawon();
			}
		});
		
		rbFemale.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				gender = "여자";
				writeSawon();
			}
		});
		
		rbMale.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				gender = "남자";
				writeSawon();
			}
		});
	}
	
	//출력 메서드
	public void writeSawon()
	{
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		
		try 
		{
			pstmt = conn.prepareStatement(sql);
			
			//전체, 전체
			//!전체, 전체
			//전체, !전체
			//!전체, !전체
			
			rs = pstmt.executeQuery(); // rs에 실행 결과 저장
			tableModel.setRowCount(0);
			while(rs.next())
			{
				Vector<String> data = new Vector<String>();
				data.add(rs.getString("num"));
				data.add(rs.getString("name"));
				data.add(rs.getString("score"));
				data.add(rs.getString("gender"));
				data.add(rs.getString("buseo"));
				tableModel.addRow(data);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			db.dbClose(pstmt, conn, rs);
		}
	}

	public static void main(String[] args) 
	{
		Ex2_DBSawon ex2 = new Ex2_DBSawon("사원정보관리");
	}
}
