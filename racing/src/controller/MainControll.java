package controller;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;

import DAO.RankDAO;
import DTO.GameDTO;
import DTO.HorseInfo;
import horseControll.Black;
import horseControll.Blue;
import horseControll.MyHorse;
import horseControll.Red;
import horseControll.White;

public class MainControll {
   RankDAO rdao = new RankDAO();
   public void run(HorseInfo hi,GameDTO gi) {
      MyHorse mh = new MyHorse(gi);
      Black bk = new Black(gi);
      Blue bl = new Blue(gi);
      Red rd = new Red(gi);
      White wh = new White(gi);
      String mhRuned = "";
      String bkRuned = "";
      String blRuned = "";
      String rdRuned = "";
      String whRuned = "";
      ArrayList<String> rank = new ArrayList<>();
      while (true) {
         Scanner sc = new Scanner(System.in);
         String input = sc.nextLine();

         bkRuned += bk.move(bk, input);
         blRuned += bl.move(bl, input);
         mhRuned += mh.move(mh, input);
         rdRuned += rd.move(rd, input);
         whRuned += wh.move(wh, input);
         
         
         
         if(bkRuned.length() >= gi.getFieldSize()) {
            bkRuned = extracted(gi.getFieldSize());
            rank.add(bk.name());
         }
         
         if(blRuned.length() >= gi.getFieldSize()) {
            blRuned = extracted(gi.getFieldSize());
            rank.add(bl.name());
         }
         
         if(mhRuned.length() >= gi.getFieldSize()) {
            mhRuned = extracted(gi.getFieldSize());
            rank.add(hi.getName());
         }
         
         if(rdRuned.length() >= gi.getFieldSize()) {
            rdRuned = extracted(gi.getFieldSize());
            rank.add(rd.name());
         }
         
         if(whRuned.length() >= gi.getFieldSize()) {
            whRuned = extracted(gi.getFieldSize());
            rank.add(wh.name());
         }
      

         System.out.println(mhRuned + "> "+hi.getName());// 나의 말
         System.out.println(bkRuned + "> "+bk.name());
         System.out.println(blRuned + "> "+bl.name());
         System.out.println(rdRuned + "> "+rd.name());
         System.out.println(whRuned + "> "+wh.name());
         
         

         if (mhRuned.length() >= gi.getFieldSize() && bkRuned.length() >= gi.getFieldSize() && blRuned.length() >= gi.getFieldSize() && rdRuned.length() >= gi.getFieldSize()
               && whRuned.length() >= gi.getFieldSize()) {
            break;
         
         }
         
      }
      gi.setGameCount(gi.getGameCount()+1);
      gi.setMin(gi.getMin()+1);
      gi.setMax(gi.getMax()+1);
      gi.setFieldSize(gi.getFieldSize()+2);
      gi.setTrun(gi.getTrun()+1);      
      LinkedHashSet<String> rank_Hs = new LinkedHashSet<>(rank);   
      rank.clear();
      
      rank.addAll(rank_Hs);   
      
      for(int i = 0; i<rank.size(); i++) {
    	  System.out.println((i+1)+ "등 : " + rank.get(i));
      }
      rdao.leaderboard(rank.get(0), rank.get(1), rank.get(2), rank.get(3), rank.get(4),gi);
      if(rank.get(0).equals(hi.getName())) {
         gi.setWin(gi.getWin()+1);
      }else {
         gi.setLoss(gi.getLoss()+1);
      }
      

   }

   private String extracted(int fieldSize) {
      String bar = "";
      for(int i = 0 ; i<= fieldSize ; i++) {
         bar += "-";
      }
      return bar;
   }




}