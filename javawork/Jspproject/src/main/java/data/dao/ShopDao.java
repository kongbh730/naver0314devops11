package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import data.dto.ShopDto;
import db.common.MySqlConnect;

public class ShopDao {
	MySqlConnect connect=new MySqlConnect();
	
	public void insertShop(ShopDto dto)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="""				
				insert into myshop (sname,sprice,scount,scolor,sphoto,writeday)
				values (?,?,?,?,?,now())
				""";
		conn=connect.getConnection();//db 연결
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, dto.getSname());
			pstmt.setInt(2, dto.getSprice());
			pstmt.setInt(3, dto.getScount());
			pstmt.setString(4, dto.getScolor());
			pstmt.setString(5, dto.getSphoto());
			//실행
			pstmt.execute();
			
		} catch (SQLException e) {
			System.out.println("insert 오류:"+e.getMessage());
		}finally {
			connect.dbClose(pstmt, conn);
		}
	}
	
	public List<ShopDto> getShopDatas()
	{
		List<ShopDto> list=new Vector<ShopDto>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from myshop order by shopidx desc";
		
		conn=connect.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				ShopDto dto=new ShopDto();
				//db 에서 가져와서 dto에 넣기
				dto.setShopidx(rs.getString("shopidx"));
				dto.setSname(rs.getString("sname"));
				dto.setSprice(rs.getInt("sprice"));
				dto.setScount(rs.getInt("scount"));
				dto.setScolor(rs.getString("scolor"));
				dto.setSphoto(rs.getString("sphoto"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
				//list 추가
				list.add(dto);				
			}
		} catch (SQLException e) {
			System.out.println("select 오류:"+e.getMessage());
		}finally {
			connect.dbClose(rs, pstmt, conn);
		}
		
		return list;
	}
	
	public ShopDto getSangpum(int shopidx)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from myshop where shopidx=?";
		
		ShopDto dto=new ShopDto();
		
		conn=connect.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setInt(1, shopidx);
			//실행
			rs=pstmt.executeQuery();
			if(rs.next()) {
				dto.setShopidx(rs.getString("shopidx"));
				dto.setSname(rs.getString("sname"));
				dto.setSprice(rs.getInt("sprice"));
				dto.setScount(rs.getInt("scount"));
				dto.setScolor(rs.getString("scolor"));
				dto.setSphoto(rs.getString("sphoto"));
				dto.setWriteday(rs.getTimestamp("writeday"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connect.dbClose(rs, pstmt, conn);
		}
		
		return dto;
	}
	
	//완성 shopupdateaction도 수정
	//수정
	public void updateShop(ShopDto dto)
	{
		/*
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql = "update myshop set sname=?, sprice=?, scount=?, scolor=?, sphoto=? where shopidx=?";
		
		conn=connect.getConnection();//db 연결
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, dto.getSname());
			pstmt.setInt(2, dto.getSprice());
			pstmt.setInt(3, dto.getScount());
			pstmt.setString(4, dto.getScolor());
			pstmt.setString(5, dto.getSphoto());
			pstmt.setString(6, dto.getShopidx());
			//실행
			pstmt.executeUpdate();
		} 
		catch (SQLException e) 
		{
			System.out.println("update 오류:"+e.getMessage());
		}
		finally 
		{
			connect.dbClose(pstmt, conn);
		}
		*/
		
		//강사님 풀이
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = "update myshop set sname=?, sprice=?, scount=?, scolor=?, sphoto=? where shopidx=?";
		conn=connect.getConnection();//db 연결
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, dto.getSname());
			pstmt.setInt(2, dto.getSprice());
			pstmt.setInt(3, dto.getScount());
			pstmt.setString(4, dto.getScolor());
			pstmt.setString(5, dto.getSphoto());
			pstmt.setString(6, dto.getShopidx());
			//실행
			pstmt.execute();
			//pstmt.executeUpdate();
		} 
		catch (SQLException e) 
		{
			System.out.println("update 오류:"+e.getMessage());
		}
		finally 
		{
			connect.dbClose(pstmt, conn);
		}
	}
	
	//삭제
	/*
	public void deleteShop(int shopidx)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = "delete from myshop where shopidx=?";
		
		conn=connect.getConnection();//db 연결
		try {
			pstmt=conn.prepareStatement(sql);//바인딩
			pstmt.setInt(1, shopidx);
			
			pstmt.execute();//실행
		} 
		catch (SQLException e) {
			System.out.println("delete 오류 : "+e.getMessage());
		}
		finally 
		{
			connect.dbClose(pstmt, conn);
		}
	}
	*/
	
	//강사님 풀이
	public void deleteShop(int shopidx)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = "delete from myshop where shopidx=?";
		
		conn=connect.getConnection();//db 연결
		try {
			pstmt=conn.prepareStatement(sql);//바인딩
			pstmt.setInt(1, shopidx);
			pstmt.execute();//실행
		} 
		catch (SQLException e) {
			System.out.println("delete 오류 : "+e.getMessage());
		}
		finally 
		{
			connect.dbClose(pstmt, conn);
		}
	}
	
	//순서변경하기
	public List<ShopDto> getShopDatas(int idx)
	{
		List<ShopDto> list=new Vector<ShopDto>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql = "";
		if(idx == 1)
		{
			sql="select * from myshop order by shopidx asc";//등록순
		}
		else if(idx == 2)
		{
			sql="select * from myshop order by sprice asc";//낮은가격순
		}
		else if(idx == 3)
		{
			sql="select * from myshop order by sprice desc";//높은 가격순
		}
		else
		{
			sql="select * from myshop order by sname asc";//상품명순
		}
		
		conn=connect.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				ShopDto dto=new ShopDto();
				//db 에서 가져와서 dto에 넣기
				dto.setShopidx(rs.getString("shopidx"));
				dto.setSname(rs.getString("sname"));
				dto.setSprice(rs.getInt("sprice"));
				dto.setScount(rs.getInt("scount"));
				dto.setScolor(rs.getString("scolor"));
				dto.setSphoto(rs.getString("sphoto"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
				//list 추가
				list.add(dto);				
			}
		} catch (SQLException e) {
			System.out.println("select 오류:"+e.getMessage());
		}finally {
			connect.dbClose(rs, pstmt, conn);
		}
		
		return list;
	}
}