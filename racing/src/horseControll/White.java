package horseControll;

import java.util.Random;
import java.util.Scanner;

import DTO.GameDTO;

public class White implements Horse{
	private int max;
	private int min;
	public White(GameDTO gd) {
		this.max = gd.getMax();
		this.min = gd.getMin();
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "백마";
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

