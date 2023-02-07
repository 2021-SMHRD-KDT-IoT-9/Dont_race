package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.GameDTO;
import DTO.HorseInfo;
import controller.LoginCon;



public class HorseDAO {
   Connection conn = null;
   PreparedStatement psmt = null;
   ResultSet rs = null;
   int row = 0;
   boolean result;

   // 말이름, 기록 저장
   
   public int insert(HorseInfo dto, String loginId,GameDTO gd) {
      connection();
      try {
         row = 0;
         String sql = "insert into 말 values(?, ?, ?, ?, ?, ?)";
         psmt = conn.prepareStatement(sql);

         // setting
//         psmt.setString(1, dto.getName());
//         // 전적psmt.setInt(2, dto.getGame());
//         psmt.setInt(3, dto.getMin());
//         psmt.setInt(4, dto.getMax());
//         psmt.setString(5, dto.getId());
         // setting
         
         psmt.setString(1, dto.getName());
         psmt.setString(2, dto.getRank() + "승");
         psmt.setInt(3, dto.getMin());
         psmt.setInt(4, dto.getMax());
         psmt.setString(5, loginId);
         psmt.setInt(6, 3);
         
         row = psmt.executeUpdate();

      } catch (SQLException e) {
         System.out.println("SQL오류 발생");
      } finally {
         close(); // 객체 닫기 메소드화

      }

      return row;
   }
   // 리더보드 모든 정보 출력
   public String recode () {
      String data = "NAME\tGAME\tMIN\tMAX\tID\tRank\n";
      connection();
      try {
         String sql = "select * from 말";
         psmt = conn.prepareStatement(sql);
         rs = psmt.executeQuery();
         
         while(rs.next()) {
            String name= rs.getString(1);
            String game = rs.getString(2);
            int min = rs.getInt(3);
            int max = rs.getInt(4);
            String id = rs.getString(5);
            int rank = rs.getInt(6);
            data += String.format("%s\t%s\t%d\t%d\t%s\t%d\n", name, game, min, max, id,rank);
         }
         
         
      } catch (SQLException e) {
         System.out.println("SQL 오류");
      }finally {
         close();
      }return data;
   }
   
   

   
   

   private void connection() {
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         String url = "jdbc:oracle:thin:@ project-db-stu3.ddns.net :1525:xe";
         String db_id = "campus_b_0203_3";
         String db_pw = "smhrd3";
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


