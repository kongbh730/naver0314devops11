package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import data.dto.MovieDto;
import db.common.MySqlConnect;

public class MovieDao 
{
	MySqlConnect db=new MySqlConnect();

	//insert
	public void insertMovie(MovieDto dto)
	{
		Connection conn = db.getConnection();
		PreparedStatement pstmt=null;
		String sql="insert into movie (title, poster, announcementyoutube, genre, introduce, director, actors) values (?,?,?,?,?,?,?)";

		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getPoster());
			pstmt.setString(3, dto.getAnnouncementyoutube());
			pstmt.setString(4, dto.getGenre());
			pstmt.setString(5, dto.getIntroduce());
			pstmt.setString(6, dto.getDirector());
			pstmt.setString(7, dto.getActors());
			//pstmt.setTimestamp(8, dto.getReleaseday());
			//실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}

	//update
	public void updateMovie(MovieDto dto)
	{
		Connection conn = db.getConnection();
		PreparedStatement pstmt=null;
		String sql="update movie set title=?, poster=?, announcementyoutube=?, genre=?, introduce=?, director=?, actors=? where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getPoster());
			pstmt.setString(3, dto.getAnnouncementyoutube());
			pstmt.setString(4, dto.getGenre());
			pstmt.setString(5, dto.getIntroduce());
			pstmt.setString(6, dto.getDirector());
			pstmt.setString(7, dto.getActors());
			pstmt.setInt(8, dto.getNum());
			//pstmt.setTimestamp(8, dto.getReleaseday());
			//실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}

	//delete
	public void deleteMovie(int num)
	{
		String sql="delete from movie where num=?";
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;

		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setInt(1, num);
			//실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}

	//전체반환
	public List<MovieDto> getAllMovies()
	{
		List<MovieDto> list=new Vector<MovieDto>();

		String sql="""
				select * from movie order by num asc
				""";

		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		try {
			pstmt=conn.prepareStatement(sql);
			//실행
			rs=pstmt.executeQuery();

			while(rs.next()) {
				MovieDto dto=new MovieDto();
				dto.setNum(rs.getInt("num"));
				dto.setTitle(rs.getString("title"));
				dto.setPoster(rs.getString("poster"));
				dto.setAnnouncementyoutube(rs.getString("announcementyoutube"));
				dto.setGenre(rs.getString("genre"));
				dto.setIntroduce(rs.getString("introduce"));
				dto.setDirector(rs.getString("director"));
				dto.setActors(rs.getString("actors"));
				//dto.setReleaseday(rs.getTimestamp("releaseday"));
				//list 에 추가
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}

		return list;
	}

	//한개반환
	public MovieDto getData(int num)
	{
		MovieDto dto=new MovieDto();
		String sql="""
				select * from movie where num=?
				""";
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setInt(1, num);
			//실행
			rs=pstmt.executeQuery();

			if(rs.next()) {
				dto.setNum(rs.getInt("num"));
				dto.setTitle(rs.getString("title"));
				dto.setPoster(rs.getString("poster"));
				dto.setAnnouncementyoutube(rs.getString("announcementyoutube"));
				dto.setGenre(rs.getString("genre"));
				dto.setIntroduce(rs.getString("introduce"));
				dto.setDirector(rs.getString("director"));
				dto.setActors(rs.getString("actors"));
				//dto.setReleaseday(rs.getTimestamp("releaseday"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		return dto;
	}
}
