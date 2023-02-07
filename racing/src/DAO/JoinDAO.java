package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.joinInformation;

public class JoinDAO {
	PreparedStatement psmt;
	Connection conn;
	ResultSet rs;
	boolean result;
	int row = 0;
	/* 회원가입 */
	public int join(joinInformation dto) {
		connection();
		row = 0;
		try {

			String sql = "insert into 회원정보 values (?, ?, ?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());
			psmt.setString(3, dto.getName());

			row = psmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("권한 실패");

		} finally {
			close();
		}
		return row;

	}
	/* 로그인 */
	public boolean Login(joinInformation dto) {
		connection();
		try {
			String sql = "select * from 회원정보 where 회원id=? and 패스워드=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				result = true;
			}else {
				result = false;
			}
			
			
		} catch (SQLException e) {
			System.out.println("DB 오류");
		}finally {
			close();
		}
		return result;
	}

	
	
	
	
	
	
	private void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			System.out.println("자원 반납의 오류");
			e.printStackTrace();
		}
	}


	private void connection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@222.102.104.228:1521:xe";
			String db_id = "c##horsegame";
			String db_pw = "12345";
			conn = DriverManager.getConnection(url, db_id, db_pw);

		} catch (ClassNotFoundException e) {
			System.out.println("클래스 오류");
		} catch (SQLException e) {
			System.out.println("DB연동 실패");
		}
	}
}
