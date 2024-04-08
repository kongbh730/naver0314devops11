package day0405;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex12Student 
{
	static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL = "jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
	static final String USERNAME = "root";
	static final String PASSWORD = "1234";

	public Ex12Student()
	{
		try 
		{
			Class.forName(MYSQL_DRIVER);
			//System.out.println("Mysql8 드라이버 성공!");
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.println("Mysql8 드라이버 오류 : " + e.getMessage());
		}
	}

	public void insertStudent(String name, int java, int html, int spring)//db 삽입
	{
		String sql = "insert into student (name, java, html, spring, testday) values (?,?,?,?, now())";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try
		{
			conn = DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, java);
			pstmt.setInt(3, html);
			pstmt.setInt(4, spring);
			pstmt.execute();// insert니까 수행만 하면 됨!
			System.out.println("insert 성공!");
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				pstmt.close();
				conn.close();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}

		System.out.println(name + "님의 성적을 등록하였습니다.");
	}

	public void deleteStudent(String name)//db 삭제
	{
		String sql = "delete from student where name = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		//해당 학생이 없을 경우 "xxx님은 명단에 없어요!"
		//있을 경우 "xxx 님의 성적정보를 삭제하였습니다."
		try 
		{
			conn = DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);//sql을 준비하고
			//바인딩 먼저
			pstmt.setString(1, name);
			int n = pstmt.executeUpdate();//sql 실행, 반환값이 필요함!
			if(n == 0)
			{
				System.out.println(name + "님은 명단에 없습니다.");
			}
			else
			{
				System.out.println(name + "님의 성적정보를 삭제했습니다.");
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				pstmt.close();
				conn.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}

	public void writeStudent()
	{
		String sql = """
				select 
					num, name, java, html, spring, 
					java + html + spring tot, round((java + html + spring)/3,1) avg,
					date_format(testday, '%Y-%m-%d %H:%i') testday
				from student;
				""";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try 
		{
			conn = DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			System.out.println("번호\t이름\t자바\thtml\tspring\t총점\t평균\t시험날짜");
			System.out.println("=".repeat(80));
			while(rs.next())//rs에 값이 남았다면 반복
			{
				int num = rs.getInt("num");
				String name = rs.getString("name");
				int java = rs.getInt("java");
				int html = rs.getInt("html");
				int spring = rs.getInt("spring");
				int tot = rs.getInt("tot");
				double avg = rs.getDouble("avg");
				String date = rs.getString("testday");

				System.out.println(
						num + "\t" + 
								name + "\t" + 
								java + "\t" + 
								html + "\t" + 
								spring + "\t" + 
								tot + "\t" + 
								avg + "\t" + 
								date
						);
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				rs.close();
				pstmt.close();
				conn.close();
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		Ex12Student ex12 = new Ex12Student();
		int menu = 0;
		String name;
		int java, html, spring;

		while(true)
		{
			System.out.print("1. 학생정보 추가   2. 이름으로 삭제    3. 전체 출력    4. 종료\n >> ");
			menu = Integer.parseInt(sc.nextLine());
			if(menu == 1)
			{
				System.out.print("추가할 이름은? >> ");
				name = sc.nextLine();
				System.out.print("자바 점수는? >> ");
				java = Integer.parseInt(sc.nextLine());
				System.out.print("HTML 점수는? >> ");
				html = Integer.parseInt(sc.nextLine());
				System.out.print("Spring 점수는? >> ");
				spring = Integer.parseInt(sc.nextLine());

				ex12.insertStudent(name, java, html, spring);
			}
			else if(menu == 2)
			{
				System.out.print("삭제할 학생의 이름은? >>");
				name = sc.nextLine();
				ex12.deleteStudent(name);
			}
			else if(menu == 3)
			{
				ex12.writeStudent();
			}
			else 
			{
				System.out.println("** 프로그램을 종료합니다. **");
				break;
			}
			System.out.println("=".repeat(80));
		}
		sc.close();
	}
}
