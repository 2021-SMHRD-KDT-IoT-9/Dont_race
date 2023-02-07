package controller;

import java.util.Random;

import DTO.GameDTO;

public class Train {
	   public int trainMin(GameDTO gd) {
		      Random rm = new Random();
		      int ran = rm.nextInt(4);
		      gd.setMyMin(gd.getMyMin()+ran);
//		      gi.setMin(gi.getMin()+1);
//		      gi.setTrun(gi.getTrun()+1);
		      gd.setTrun(gd.getTrun()+1);
		      return ran;

		   }

		   public int trainMax(GameDTO gd) {
		      Random rm = new Random();
		      int ran = rm.nextInt(4);
		      gd.setMyMax(gd.getMyMax()+ran);   
//		      gi.setMax(gi.getMax()+1);
//		      gi.setTrun(gi.getTrun()+1);
		      gd.setTrun(gd.getTrun()+1);
		      return ran;
		   }
}
