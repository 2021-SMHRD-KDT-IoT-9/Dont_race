package horseControll;

import java.util.Random;
import java.util.Scanner;

import DTO.HorseInfo;

public class MyHorse implements Horse{
	private int max;
	private int min;
	HorseInfo hi = new HorseInfo();
	
	public MyHorse(int max, int min) {
		super();
		this.max = max;
		this.min = min;
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return hi.getName();          //HorseInfo.getName;




	}
	
	public void setMax(int max) {
		this.max = max;
	}


	public void setMin(int min) {
		this.min = min;
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
