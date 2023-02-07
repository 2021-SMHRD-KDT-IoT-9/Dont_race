package horseControll;

import java.util.Random;
import java.util.Scanner;

import DTO.GameDTO;

public class Black implements Horse{
	private int max;
	private int min;
	public Black(GameDTO gd) {
		this.max = gd.getMax();
		this.min = gd.getMin();
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
              for(int i =0; i<= ran1; i++){
                  line+="-";
              }
	} 
          return line;

}
}
