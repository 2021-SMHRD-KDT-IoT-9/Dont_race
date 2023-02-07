package horseControll;

import java.util.Random;
import java.util.Scanner;

public class Blue implements Horse{
	private int max;
	private int min;
	
	
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
			int ran1 = 0;
			while(true) {
				ran1 = rm.nextInt(max);
				if(ran1>min) break;
			}
			for(int i =min; i< ran1; i++){
				line+="-";
			}
		}
		return line;
	}

}
