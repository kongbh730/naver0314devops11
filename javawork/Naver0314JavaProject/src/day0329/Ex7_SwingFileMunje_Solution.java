package day0329;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ex7_SwingFileMunje_Solution extends JFrame
{
	JTable table;//사원 정보 출력에 필요한 테이블
	DefaultTableModel tableModel;//테이블 클래스에는 default와 abstract가 있다
	JButton btnAdd, btnDelete;//사원추가, 삭제에 필요한 버튼
	JTextField name;//사원 이름 적을 텍스트필드
	JComboBox<String> blood, region, position;//혈액형, 지역, 직급
	String[] comboLabelBlood = {"A", "B", "O", "AB"};//혈액형 콤보박스에 들어갈 문자열모음
	String[] comboLabelregion = {"경기도", "경상도", "전라도", "충청도", "강원도"};//지역 콤보박스에 들어갈 문자열모음
	String[] comboLabelPosition = {"수습", "대리", "차장", "과장", "부장", "사장"};//직급 콤보박스에 들어갈 문자열모음
	//textfield와 textArea의 차이?
	final static String FILENAME = "c:/naver0314/companymemberinfo.txt"; // 정보텍스트

	//윈도우 종료시 테이블의 내용을 파일에 저장 후 종료
	public Ex7_SwingFileMunje_Solution(String title)
	{
		super(title);
		this.setLocation(100, 100);//시작위치
		this.setSize(600, 600);//창크기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 종료

		//종료시 테이블의 내용을 파일에 저장 후 종료
		this.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e) 
			{
				super.windowClosing(e);
				FileWriter fw = null;
				try {
					fw = new FileWriter(FILENAME);
					for(int i = 0; i < table.getRowCount(); i++)
					{
						String name = table.getValueAt(i, 0).toString();
						String blood = table.getValueAt(i, 1).toString();
						String region = table.getValueAt(i, 2).toString();
						String position = table.getValueAt(i, 3).toString();
						String str = name + "," + blood + "," + region + "," + position + "\n";
						fw.write(str);
					}
				} catch (IOException e1) {
					// TODO: handle exception
				}
				finally
				{
					try {
						fw.close();
					} catch (IOException e1) 
					{
						// TODO: handle exception
					}
					System.exit(0);
				}
			}
		});
		
		this.initDesign();//각종 컴포넌트 생성
		this.sawonFileRead();//파일 불러오기
		this.setVisible(true);
	}

	//파일 불러와서 테이블에 출력 
	public void sawonFileRead()
	{
		FileReader fr = null;
		BufferedReader br = null;
		
		try 
		{
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			while(true)
			{
				String s = br.readLine();
				if(s == null)
				{
					break;
				}
				String []data = s.split(",");
				tableModel.addRow(data);
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("파일이 존재하지 않습니다. " + e.getMessage());
			// TODO: handle exception
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try
			{
				br.close();
				fr.close();
			}
			catch (IOException|NullPointerException e)
			{
				;
			}
		}
	}

	public void initDesign()
	{
		//====================== 상단 =======================
		JPanel pTop = new JPanel();//pTop이라는 패널생성

		//사원정보 추가 버튼
		btnAdd = new JButton("사원정보 추가");
		pTop.add(btnAdd);

		//사원정보 삭제 버튼
		btnDelete = new JButton("사원정보 삭제");
		pTop.add(btnDelete);

		this.add("North", pTop);
		//==================================================
		//====================== 중단 =======================
		//사원정보 출력 테이블
		String []title = {"이름","혈액형","지역","직급"};//테이블의 레이블
		tableModel = new DefaultTableModel(title, 0);//일단은 생성만		
		table = new JTable(tableModel);//tableModel에 맞게끔 JTable 생성
		this.add("Center", new JScrollPane(table));//JScrollPane은 스크롤과 함께 테이블 제목이 보인다.
		//==================================================
		//====================== 하단 =======================
		JPanel p = new JPanel();//하단 패널

		//사원이름 입력 텍스트필드
		name = new JTextField(5);//텍스트 필드 생성
		p.add(new JLabel("이름 : "));//패널에 레이블 추가
		p.add(name);//패널에 name 텍스트필드 추가
		this.add("South", p);//패널추가0

		//혈액형 콤보박스
		blood = new JComboBox<>(comboLabelBlood);
		p.add(new JLabel("혈액형 : "));
		p.add(blood);
		this.add("South", p);

		//지역 콤보박스
		region = new JComboBox<>(comboLabelregion);
		p.add(new JLabel("지역 : "));
		p.add(region);
		this.add("South", p);

		//직급 콤보박스
		position = new JComboBox<>(comboLabelPosition);
		p.add(new JLabel("직급 : "));
		p.add(position);
		this.add("South", p);
		//==================================================
		//==================== 버튼 이벤트 ====================
		//==================== 추가 버튼 ======================
		btnAdd.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String sawonName = name.getText();//이름 입력은 먼저해
				//이름 입력이니까 뭐가 들어와도 상관 없어//입력 안한 경우만 확인해
				if(name.getText().length() == 0)
				{
					//이 파일에 메세지 출력
					JOptionPane.showMessageDialog(Ex7_SwingFileMunje_Solution.this, "이름을 입력하세요.");
					return;
				}
				//============== 이름과 콤보박스 조합 ==============
				Vector<String> data = new Vector<String>();
				String sawonBlood = (String) blood.getSelectedItem();//콤보박스 결과 문자열로
				String sawonRegion = (String) region.getSelectedItem();//콤보박스 결과 문자열로
				String sawonPosition = (String) position.getSelectedItem();//콤보박스 결과 문자열로

				data.add(sawonName);//사원 이름
				data.add(sawonBlood);//혈액형
				data.add(sawonRegion);//지역
				data.add(sawonPosition);//직급
				//String 형태로 바꿔서 data 벡터에 추가

				tableModel.addRow(data);
				name.setText("");//텍스트필드 초기화
				//각 콤보박스 초기화
				
			}
		});

		//==================== 삭제 버튼 ======================
		btnDelete.addActionListener(new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row == -1)//클릭한 정보가 없을 경우
				{
					//이 파일에 메세지 출력
					JOptionPane.showMessageDialog(Ex7_SwingFileMunje_Solution.this, "삭제할 사원정보를 선택해주세요.");
				}
				else
				{
					tableModel.removeRow(row);
				}
			}
		});
	}

	public static void main(String[] args) 
	{
		Ex7_SwingFileMunje_Solution sawonInfo = new Ex7_SwingFileMunje_Solution("사원정보");
	}
}
