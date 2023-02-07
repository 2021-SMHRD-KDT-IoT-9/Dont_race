package controller;

import DTO.GameDTO;
import DTO.HorseInfo;

public class Difficulty {
	
//	GameDTO gd = new GameDTO();
//	HorseInfo hi = new HorseInfo();
	public void getEasy(GameDTO gd) {
		gd.setMax(3);
		gd.setMin(0);
		gd.setFieldSize(30);
		gd.setTrun(1);
		gd.setWin(0);
		gd.setLoss(0);
		gd.setMyMax(4);
		gd.setMyMin(1);
	}
	public void getMiddle(GameDTO gd) {
		gd.setMax(4);
		gd.setMin(1);
		gd.setFieldSize(30);
		gd.setTrun(1);
		gd.setWin(0);
		gd.setLoss(0);
		gd.setMyMax(5);
		gd.setMyMin(1);
	}
	public void getHard(GameDTO gd) {
		gd.setMax(5);
		gd.setMin(1);
		gd.setFieldSize(30);
		gd.setTrun(1);
		gd.setWin(0);
		gd.setLoss(0);
		gd.setMyMax(5);
		gd.setMyMin(1);
	}
	
	
	

}
