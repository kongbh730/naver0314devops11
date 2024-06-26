package day0408;

/*
 * 이름 : 텍스트박스 / 점수 : 텍스트박스 / 성별 : 콤보박스 / 부서 : 콤보박스
 * -------------------------------------------------------------
 * 						TABLE
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import db.common.DbConnect;

public class Ex2_DBSawonSolution extends JFrame
{
	DbConnect db=new DbConnect();//DB연결
	JTable table;//테이블
	DefaultTableModel tableModel;//테이블 모델
	JTextField tfName,tfScore;//텍스트 필드
	JButton btnAdd,btnDel;//추가 삭제 버튼
	JComboBox<String> cbGender, cbBuseo, cbBuseoSearch;//콤보박스 3개, 성별, 부서, 부서검색
	JRadioButton rbMale, rbFemale, rbEntire;//라디오버튼
	JRadioButton []rb=new JRadioButton[3];//라디오 버튼

	int buseoIndex = 1;//부서 전체
	int genderIndex = 1;//성별 전체

	public Ex2_DBSawonSolution(String title)
	{
		super(title);
		this.setLocation(100, 100);//시작위치
		this.setSize(600, 600);//창크기
		//this.getContentPane().setBackground(new Color(255, 255, 0));
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
		tfName = new JTextField(5);//정수는 열 크기
		p1.add(tfName);

		//점수 입력 텍스트필드
		p1.add(new JLabel("점수"));
		tfScore = new JTextField(5);
		p1.add(tfScore);

		//성별 콤보박스
		String []cbGenderStr = {"남자", "여자", "아파치 전투헬리콥터"};
		p1.add(new JLabel("성별"));
		cbGender = new JComboBox<String>(cbGenderStr);
		p1.add(cbGender);

		//부서 콤보박스
		String []cbBuseoStr = {"교육부", "인사부", "홍보부"};
		p1.add(new JLabel("부서"));
		cbBuseo = new JComboBox<String>(cbBuseoStr);
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
		String []cbbuseoSearchstr = {"전체부서", "홍보부", "교육부", "인사부"};
		p2.add(new JLabel("부서"));
		cbBuseoSearch = new JComboBox<String>(cbbuseoSearchstr);
		p2.add(cbBuseoSearch);

		//RadioButton
		ButtonGroup bg=new ButtonGroup();
		String []g2= {"전체","남자","여자"};
		for(int i=0;i<rb.length;i++)
		{
			rb[i]=new JRadioButton(g2[i], i==0?true:false);
			bg.add(rb[i]);
			p2.add(rb[i]);

			final int idx=i;
			//라디오버튼 이벤트
			rb[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					genderIndex=idx+1;
					writeSawon();
				}
			});
		}
		this.add("South", p2);

		//부서검색 이벤트
		cbBuseoSearch.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				buseoIndex=cbBuseoSearch.getSelectedIndex()+1;
				writeSawon();
			}
		});

		//추가버튼 이벤트
		btnAdd.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
				//입력 안했을 경우 이벤트 종료
				if(tfName.getText().length() == 0)
				{
					return;
				}
				if(tfScore.getText().length() == 0)
				{
					return;
				}

				//입력값을 db에 insert
				Connection conn = db.getConnection();
				PreparedStatement pstmt = null;
				String sql = "insert into sawon values(null, ?, ?, ?, ?)";

				try 
				{
					pstmt= conn.prepareStatement(sql);

					//?갯수만큼 바인딩
					pstmt.setString(1,  tfName.getText());
					pstmt.setInt(2,  Integer.parseInt(tfScore.getText()));
					pstmt.setString(3, cbGender.getSelectedItem().toString());
					pstmt.setString(4, cbBuseo.getSelectedItem().toString());

					//실행
					pstmt.execute();
					//입력값 초기화
					tfName.setText("");
					tfScore.setText("");
					cbGender.setSelectedIndex(0);
					cbBuseo.setSelectedIndex(0);

					//다시 출력
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
			}
		});

		//삭제버튼
		btnDel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//테이블의 선택한 행번호 row를 얻는다
				int row = table.getSelectedRow();
				//row가 -1이면 경고메세지 후 이벤트 종료
				if(row == -1)
				{
					JOptionPane.showMessageDialog(Ex2_DBSawonSolution.this, "삭제할 행을 선택해주세요");
					return;
				}
				//row행의 0번열에 있는 시퀀스 값을 얻는다 getVauleAr
				String num = table.getValueAt(row, 0).toString();

				//그 시퀀스에 해당하는 db데이터를 삭제하는 sql문 작성
				String sql = "delete from sawon where num = ?";

				//Connection,PreparedStatement 생성 후 sql문 실행
				Connection conn = db.getConnection();
				PreparedStatement pstmt = null;

				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, num);
					pstmt.execute();//db에서 삭제

					//db 다시 불러오기
					writeSawon();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally {
					db.dbClose(pstmt, conn);
				}
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
		if(genderIndex == 1 && buseoIndex == 1)
		{
			sql = "select * from sawon order by num";
		}
		else if(genderIndex != 1 && buseoIndex == 1)
		{
			sql = "select * from sawon where gender = ? order by num";
		}
		else if(genderIndex == 1 && buseoIndex != 1)
		{
			sql = "select * from sawon where buseo = ? order by num";
		}
		else
		{
			sql = "select * from sawon where buseo = ? and gender = ? order by num";
		}

		try 
		{
			pstmt = conn.prepareStatement(sql);
			if(genderIndex != 1 && buseoIndex == 1)
			{
				pstmt.setString(1,  (genderIndex == 2) ? "남자" : (genderIndex == 3) ? "여자" : (genderIndex == 4) ? "아파치 전투헬리콥터" : "");
			}
			else if(genderIndex == 1 && buseoIndex != 1)
			{
				pstmt.setString(1, (buseoIndex == 2) ? "홍보부" : (buseoIndex == 3) ? "교육부" : (buseoIndex == 4) ? "인사부" : "");
			}
			else if(genderIndex != 1 && buseoIndex != 1)
			{
				pstmt.setString(1,  (genderIndex == 2) ? "남자" : (genderIndex == 3) ? "여자" : (genderIndex == 4) ? "아파치 전투헬리콥터" : "");
				pstmt.setString(1, (buseoIndex == 2) ? "홍보부" : (buseoIndex == 3) ? "교육부" : (buseoIndex == 4) ? "인사부" : "");
			}

			//쿼리 실행
			rs = pstmt.executeQuery();
			tableModel.setRowCount(0);

			while(rs.next())
			{
				Vector<String> data = new Vector<String>();
				data.add(rs.getString("num"));
				data.add(rs.getString("name"));
				data.add(rs.getString("score"));
				data.add(rs.getString("gender"));
				data.add(rs.getString("buseo"));
				tableModel.addRow(data);//행 추가
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			db.dbClose(pstmt, conn, rs);
		}
	}

	public static void main(String[] args) 
	{
		Ex2_DBSawonSolution ex2 = new Ex2_DBSawonSolution("사원정보관리");
	}
}
