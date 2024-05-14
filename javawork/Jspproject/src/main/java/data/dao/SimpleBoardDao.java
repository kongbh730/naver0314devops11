package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import data.dto.SimpleBoardDto;
import db.common.MySqlConnect;

public class SimpleBoardDao {
	MySqlConnect db = new MySqlConnect();//DB연결
	
	//삽입 insert
	public void insertBoard(SimpleBoardDto dto)
	{
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		String sql = """
				insert into simpleboard (writer, avata, subject, content, writeday) values (?,?,?,?,now())
				""";
		
		try {
			pstmt = conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1,  dto.getWriter());
			pstmt.setString(2,  dto.getAvata());
			pstmt.setString(3,  dto.getSubject());
			pstmt.setString(4,  dto.getContent());
			
			pstmt.execute();
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	//update 수정
	public void updateBoard(SimpleBoardDto dto)
	{
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		String sql = """
				update simpleboard set writer = ?, avata = ?, subject = ?, content = ? where num = ?
				""";
		
		try {
			pstmt = conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1,  dto.getWriter());
			pstmt.setString(2,  dto.getAvata());
			pstmt.setString(3,  dto.getSubject());
			pstmt.setString(4,  dto.getContent());
			pstmt.setInt(5,  dto.getNum());
			
			pstmt.execute();
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	//list 목록 나열
	public List<SimpleBoardDto> getAllDatas(int start, int persize)
	{
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = """
				selert * form simpleboard order by num desc limit ?, ?
				""";
		List<SimpleBoardDto> list = new Vector<SimpleBoardDto>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			//바인딩
			pstmt.setInt(1,  start);
			pstmt.setInt(2,  persize);
			
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				SimpleBoardDto dto = new SimpleBoardDto();
				dto.setNum(rs.getInt("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setAvata(rs.getString("avata"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setChu(rs.getInt("chu"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
				//list에 추가
				list.add(dto);
			}
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			db.dbClose(pstmt, conn);
		}
		
		return list;
	}
}
