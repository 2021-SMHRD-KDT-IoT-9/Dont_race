package model;

import java.util.Random;
import java.util.Scanner;

public class Black implements Horse{
	private int max;
	private int min;
	private String line;
	
	
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
              System.out.print(line+">");
              System.out.println();
	} 
          return line;

}
}
