package day0405;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ex2ShopCartJoin {

	static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL = "jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
	static final String USERNAME = "root";
	static final String PASSWORD = "1234";

	public Ex2ShopCartJoin()
	{
		try 
		{
			Class.forName(MYSQL_DRIVER);
			System.out.println("Mysql8 드라이버 성공!");
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.println("Mysql8 드라이버 오류 : " + e.getMessage());
		}
	}

	public void writeCartJoin()
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		//		String sql = """
		//				select 
		//					cartnum, 
		//					username,
		//					sangpum, 
		//					price, 
		//					color, 
		//					date_format(guipday, '%Y-%m-%d %H : %i') guipday
		//				from shop, cart
		//				where shop.shopnum = cart.shopnum;
		//				""";

		String sql = """
				select 
					cartnum, 
					username,
					sangpum, 
					price, 
					color, 
					date_format(guipday, '%Y-%m-%d %H : %i') guipday
				from shop
				inner join cart
				where shop.shopnum = cart.shopnum
				""";

		try 
		{
			conn = DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);//stmt와 사용방법 다름 주의
			rs = pstmt.executeQuery();

			System.out.println("\t\t** 나의 장바구니 **");
			System.out.println("시퀀스\t이름\t상품명\t가격\t색상\t구입일");
			System.out.println("=".repeat(60));

			while(rs.next())
			{
				int cn = rs.getInt("cartnum");
				String s = rs.getString("sangpum");
				String u = rs.getString("username");
				int p = rs.getInt("price");
				String c = rs.getString("color");
				//String g = rs.getString("date_format(guipday, '%Y-%m-%d %H : %i')");//sql 바꾼걸 못봄
				String g = rs.getString("guipday");

				System.out.println(cn + "\t" + u + "\t" + s + "\t" + p + "\t" + c + "\t" + g );
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
			catch (SQLException |NullPointerException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) 
	{
		Ex2ShopCartJoin ex2 = new Ex2ShopCartJoin();
		ex2.writeCartJoin();
	}
}
