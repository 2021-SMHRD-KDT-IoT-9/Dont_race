package horseControll;

import java.util.Random;
import java.util.Scanner;

public class Black implements Horse{
	private int max;
	private int min;
	
	public Black(int max, int min) {
		this.max = max;
		this.min = min;
	}
	
	
	public void setMax(int max) {
		this.max = max;
	}


	public void setMin(int min) {
		this.min = min;
	}


	@Override
	public String name() {
		return "흑토마";
	}

	@Override
	public String move(Horse hs,String input) {
		String line  = "";
		Random rm = new Random();
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
