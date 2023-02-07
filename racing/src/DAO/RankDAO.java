package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.GameDTO;
import DTO.HorseInfo;
import controller.MainControll;

public class RankDAO {
   Connection conn = null;
   PreparedStatement psmt = null;
   ResultSet rs = null;
   int row = 0;
   boolean result;
//   MainControll mc = new MainControll();

   // 경기결과테이블에 순위 입력
   public int leaderboard(String a, String b, String c, String d, String e,GameDTO gd) {
      // 1번경기 
      row = 0;
      connection();
      try {
         String sql = "insert into 경기결과 values(?, ?, ?, ?, ?, ?)";
         psmt = conn.prepareStatement(sql);
         psmt.setString(1,  "["+gd.getGameCount() + "경기]" );
         psmt.setString(2, a);
         psmt.setString(3, b);
         psmt.setString(4, c);
         psmt.setString(5, d);
         psmt.setString(6, e);
         
      
         
         row = psmt.executeUpdate();

      } catch (SQLException error) {
         System.out.println("SQL 오류");
      } finally {
         close();
      }
      return row;
   }

   public String rank(HorseInfo hi) {
      String data = "경기\t1등\t2등\t3등\t4등\t5등\n";
      connection();
      try {
         String sql = "select * from 경기결과 where NUM1 = ? OR NUM2 = ? OR NUM3 = ? OR NUM4 = ? OR NUM5 = ?";
         psmt = conn.prepareStatement(sql);
         psmt.setString(1, hi.getName());
         psmt.setString(2, hi.getName());
         psmt.setString(3, hi.getName());
         psmt.setString(4, hi.getName());
         psmt.setString(5, hi.getName());
         rs = psmt.executeQuery();

         while (rs.next()) {
            String gameName = rs.getString(1);
            String name = rs.getString(2);
            String name1 = rs.getString(3);
            String name2 = rs.getString(4);
            String name3 = rs.getString(5);
            String name4 = rs.getString(6);
            
            data += String.format("%s\t%s\t%s\t%s\t%s\t%s\n", gameName, name, name1, name2, name3, name4);

         }
      } catch (SQLException e) {
         System.out.println("SQL 오류");
      } finally {
         close();
      }
      return data;

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