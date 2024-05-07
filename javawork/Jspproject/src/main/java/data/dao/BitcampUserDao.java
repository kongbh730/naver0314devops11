package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.dto.BitcampUserDto;
import db.common.MySqlConnect;


public class BitcampUserDao 
{
	MySqlConnect db=new MySqlConnect();
	
	//회원가입에 사용되는 insert문!!! 완성!!!
	public void insertBitcampUser(BitcampUserDto dto)
	{
		String sql="""
				insert into BitcampUser (id, password, name, email)
				values (?, ?, ?, ?)
				""";
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;

		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getEmail());

			//실행
			pstmt.execute();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	public void loginBitcampUser(String id, String password)
	{
		String sql = "select password from users where id = ?";
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		try 
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
		    rs = pstmt.executeQuery();
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			db.dbClose(rs, pstmt, conn);
		}
	}
	
}
