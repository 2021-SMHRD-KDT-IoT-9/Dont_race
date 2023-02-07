package horseControll;

import java.util.Random;
import java.util.Scanner;

import DTO.GameDTO;

public class Red implements Horse{
	private int max;
	private int min;
	

	public Red(GameDTO gd ) {
		this.max = gd.getMax();
		this.min = gd.getMin();
	}
	

	@Override
	public String name() {
		return "적토마";
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
              for(int i =0; i<= ran1; i++){
                  line+="-";
              }

	}
          return line;

}
}