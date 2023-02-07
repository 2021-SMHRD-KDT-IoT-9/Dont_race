package horseControll;

import java.util.Random;
import java.util.Scanner;

import DTO.GameDTO;
import DTO.HorseInfo;

public class MyHorse implements Horse{
	private int max;
	private int min;
	
	public MyHorse(GameDTO gd) {
		super();
		this.max = gd.getMyMax();
		this.min = gd.getMyMin();
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "사용자";          //HorseInfo.getName;


	}
	

	@Override
	public String move(Horse hs,String input) {

		Random rm = new Random();
		String line  = "";
		if(input.equals("")){
			int ran = 0;
			while(true) {
				ran = rm.nextInt(max);
				if(ran>min) break;
			}
			for(int i =0; i<= ran; i++){
				line+="-";
			}
	
		}
		return line;
	}

}
