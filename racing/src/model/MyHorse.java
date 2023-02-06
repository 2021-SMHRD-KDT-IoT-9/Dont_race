package model;

import java.util.Random;
import java.util.Scanner;

public class MyHorse implements Horse{
	private int max;
	private int min;
	private String line = ""; 
	
	public MyHorse(int max, int min) {
		super();
		this.max = max;
		this.min = min;
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return HorseInfo.getName;
	}

	@Override
	public String move() {
		Scanner sc = new Scanner(System.in);
		Random rm = new Random();
		String input = sc.nextLine();
		if(input.equals("")){
			int ran = 0;
			ran = rm.nextInt(max);
			for(int i =min; i< ran; i++){
				line+="-";
			}
	
		}
		return line;
	}

}
