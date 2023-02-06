package model;

import java.util.Random;
import java.util.Scanner;

public class Blue implements Horse{
	private int max;
	private int min;
	private String line = ""; 
	
	public Blue(int max, int min) {
		super();
		this.max = max;
		this.min = min;
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "청마";
	}

	@Override
	public String move() {
		Scanner sc = new Scanner(System.in);
		Random rm = new Random();
		String input = sc.nextLine();
		if(input.equals("")){
			int ran1 = 0;
			ran1 = rm.nextInt(max);
			for(int i =min; i< ran1; i++){
				line+="-";
			}
		}
		return line;
	}

}
