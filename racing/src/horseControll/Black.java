package horseControll;

import java.util.Random;
import java.util.Scanner;

public class Black implements Horse{
	private int max;
	private int min;
	private String line = "";
	
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
