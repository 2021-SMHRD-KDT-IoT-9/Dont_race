package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.HorseInfo;



public class HorseDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	int row = 0;
	boolean result;

	// 말이름, 기록 저장
	
	public int insert(HorseInfo dto) {
		connection();
		try {
			row = 0;
			String sql = "insert into 말 values(?, ?, ?, ?, ?, ?)";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, dto.getName());
			psmt.setInt(2, dto.getGame());
			psmt.setInt(3, dto.getMin());
			psmt.setInt(4, dto.getMax());
			psmt.setString(5, dto.getId());
			psmt.setInt(6, dto.getRank());

			row = psmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("SQL오류 발생");
		} finally {
			close(); // 객체 닫기 메소드화

		}

		return row;
	}
	// 기록 조회
	public String recode () {
		String data = "NAME\tGAME\tMIN\tMAX\tRANK\n";
		connection();
		try {
			String sql = "select * from 말";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String name= rs.getString(1);
				int game = rs.getInt(2);
				int min = rs.getInt(3);
				int max = rs.getInt(4);
				int rank = rs.getInt(5);
				data += String.format("%s\t%d\t%d\t%d\t%d\n", name, rank, min, max, game);
			}
			
			
		} catch (SQLException e) {
			System.out.println("SQL 오류");
		}finally {
			close();
		}return data;
	}
	
		// 리더보드
	public String leaderboard() {
		String data = "이름\t1위횟수";
		connection();
		try {
			String sql = "select 말이름, 전적, 랭킹, count(랭킹) as 일위횟수 from 말 where 랭킹 = 1 group by 말이름,전적,랭킹 order by 랭킹 desc";
		psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				String name = rs.getString(1);
				int rank = rs.getInt(2);
				data += String.format("%s\t%d\n", name, rank);
			}
		}catch (SQLException e) {
			System.out.println("SQL 오류");
		}finally {
			close();
		}return data;
	}
		
	
	

	private void connection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String db_id = "c##horsegame";
			String db_pw = "12345";
			conn = DriverManager.getConnection(url, db_id, db_pw);

		} catch (ClassNotFoundException e) {
			System.out.println("클래스 오류");
		} catch (SQLException e) {
			System.out.println("DB연동 실패");
		}
	}
	
	
	private void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("닫기 실패");
		}
	}

	
}


