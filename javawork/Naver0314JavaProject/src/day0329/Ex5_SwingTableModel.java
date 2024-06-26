package day0329;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Ex5_SwingTableModel extends JFrame
{
	
	JLabel lblTitle;
	JTable table;
	DefaultTableModel tableModel;
	JButton btnDelete;

	public Ex5_SwingTableModel(String title)
	{
		super(title);
		this.setLocation(100, 100);//시작위치
		this.setSize(300, 300);//창크기
		//this.getContentPane().setBackground(new Color(255, 255, 0));//RGB순서 맞음
		//this.getContentPane().setBackground(Color.CYAN);//Color의 상수도 가능
		//유일하게 color의 클래스만 pane을 얻어야 가능함
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 종료
		this.initDesign();//각종 컴포넌트 생성
		this.setVisible(true);
	}

	public void initDesign()
	{
		//상단에는 제목넣기
		lblTitle = new JLabel("강남구 학생 정보", JLabel.CENTER);
		lblTitle.setFont(new Font("", Font.BOLD, 30));
		this.add("North", lblTitle);

		//테이블을 행갯수 0, 제목만 넣어서 생성 후 Center에 추가
		String []title = {"이름", "나이", "Java", "Spring", "Html", "총점", "평균"};
		tableModel = new DefaultTableModel(title, 0);
		table = new JTable(tableModel);
		this.add("Center", new JScrollPane(table));
		this.addStudentFile();
		this.process();
		
		//삭제버튼 생성 및 이벤트
		btnDelete = new JButton("학생정보 삭제하기");
		//패널을 안쓰면 버튼이 전체 크기로 들어감
		//패널 사용하면 작게 가운데로 들어감
		this.add("South", btnDelete);
		
		btnDelete.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				//선택한 행
				int row = table.getSelectedRow();
				System.out.println(row);
				
				if(row == -1)
				{
					JOptionPane.showMessageDialog(Ex5_SwingTableModel.this, "먼저 삭제할 행을 선택해주세요.");
				}
				else
				{
					tableModel.removeRow(row);
				}
			}
		});
	}

	private void process() 
	{
		for(int i = 0; i < tableModel.getRowCount(); i++)
		{
			int java = Integer.parseInt(table.getValueAt(i, 2).toString());
			int spring = Integer.parseInt(table.getValueAt(i, 3).toString());
			int html = Integer.parseInt(table.getValueAt(i, 4).toString());
		
			//총점구하기
			int tot = java + spring + html;
			//5번열에 출력
			table.setValueAt(tot , i, 5);
			//평균
			double avg = tot/3.0;
			//table.setValueAt((avg), i, 6);
			NumberFormat nf = NumberFormat.getInstance();
			nf.setMaximumFractionDigits(2);
			table.setValueAt(nf.format(avg), i, 6);
			
			
		
		
		}

	}

	private void addStudentFile()
	{
		FileReader fr = null;
		BufferedReader br = null;
		try
		{
			fr = new FileReader("c:/naver0314/studentsInfo.txt");
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
		catch(FileNotFoundException e)
		{
			System.out.println("파일을 못찾었요");
		}
		catch(IOException e)
		{
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

			}
		}


	}

	public static void main(String[] args) 
	{
		Ex5_SwingTableModel a = new Ex5_SwingTableModel("student파일 읽기");
		

	}


}
