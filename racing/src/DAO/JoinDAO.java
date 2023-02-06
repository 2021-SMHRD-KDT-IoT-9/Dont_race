package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.joinInformation;

public class JoinDAO {
	PreparedStatement psmt = null;
	Connection conn = null;
	ResultSet rs = null;
	
	public int join(joinInformation dto) {
		int row = 0;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String db_id = "system";
				String db_pw = "12345";
				conn = DriverManager.getConnection(url, db_id,db_pw);
				
				
				String sql = "insert into join values (?, ?, ?)";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, dto.getName());
				psmt.setString(2, dto.getId());
				psmt.setString(3, dto.getPw());
				
				row = psmt.executeUpdate(); 
				
			} catch (ClassNotFoundException e) {
				System.out.println("로딩 실패");
			} catch (SQLException e) {
				System.out.println("권한 실패");
				
			}finally {
				// 3. 자원 반납 : 사용한 역순으로 
				try {
					if(psmt != null) {
						psmt.close();
					}
					if(conn != null)
						conn.close();
				} catch (SQLException e) {
					System.out.println("자원 반납의 오류");
					e.printStackTrace();
				}
			}return row;
			
	}
}
