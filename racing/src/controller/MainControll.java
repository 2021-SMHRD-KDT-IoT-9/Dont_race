package controller;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;

import DTO.GameDTO;
import DTO.HorseInfo;
import horseControll.Black;
import horseControll.Blue;
import horseControll.MyHorse;
import horseControll.Red;
import horseControll.White;

public class MainControll {
	private int max = 4;
	private int min = 1;
	private int myMax = 5;
	private int myMin = 1;
	private int fieldSize = 20;
	private int trun;
	private int win;
	private int loss;
	public int getTrun() {
		return trun;
	}
	public void run(HorseInfo hi, GameDTO gd) {
		ArrayList<String> rank = new ArrayList<>();
		MyHorse mh = new MyHorse(hi.getMax(), hi.getMin());
		Black bk = new Black(gd.getMax(), gd.getMin());
		Blue bl = new Blue(max, min);
		Red rd = new Red(max, min);
		White wh = new White(max, min);
		
//		HorseInfo hi = new HorseInfo();
		String mhRuned = "";
		String bkRuned = "";
		String blRuned = "";
		String rdRuned = "";
		String whRuned = "";
		while (true) {
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			
			bkRuned += bk.move(bk, input);
			blRuned += bl.move(bl, input);
			mhRuned += mh.move(mh, input);
			rdRuned += rd.move(rd, input);
			whRuned += wh.move(wh, input);
			
			
			
			if(bkRuned.length() >= fieldSize) {
				bkRuned = extracted(fieldSize);
				rank.add(bk.name());
			}
			
			if(blRuned.length() >= fieldSize) {
				blRuned = extracted(fieldSize);
				rank.add(bl.name());
			}
			
			if(mhRuned.length() >= fieldSize) {
				mhRuned = extracted(fieldSize);
				rank.add(hi.getName());
			}
			
			if(rdRuned.length() >= fieldSize) {
				rdRuned = extracted(fieldSize);
				rank.add(rd.name());
			}
			
			if(whRuned.length() >= fieldSize) {
				whRuned = extracted(fieldSize);
				rank.add(wh.name());
			}
		

			System.out.println(bkRuned + "> "+bk.name());
			System.out.println(blRuned + "> "+bl.name());
			System.out.println(mhRuned + "> "+hi.getName());// 나의 말
			System.out.println(rdRuned + "> "+rd.name());
			System.out.println(whRuned + "> "+wh.name());
			
		   

			if (mhRuned.length() >= fieldSize && bkRuned.length() >= fieldSize && blRuned.length() >= fieldSize && rdRuned.length() >= fieldSize
					&& whRuned.length() >= fieldSize) {
				break;
			}

		}
		

		min++;
		
		max++;
		gd.setMax(gd.getMax()+1);
		fieldSize+=2;
		trun++;
		LinkedHashSet<String> rank_Hs = new LinkedHashSet<>(rank);	
		rank.clear();
		rank.addAll(rank_Hs);	
		if(rank.get(0).equals(hi.getName())) {
			win++;
		}else loss++;
		for(int i = 0; i<rank.size(); i++) {
			System.out.println((i+1)+ " 등 : " + rank.get(i));
		}
		
	}

	public void ranked() {

	}

	private String extracted(int fieldSize) {
		String bar = "";
		for(int i = 0 ; i<= fieldSize ; i++) {
			bar += "-";
		}
		return bar;
	}


	public int trainMin() {
		Random rm = new Random();
		int ran = rm.nextInt(3);
		myMin += ran;
		min++;
		trun++;
		return ran;

	}

	public int trainMax() {
		Random rm = new Random();
		int ran = rm.nextInt(3);
		myMax += ran;
		max++;
		trun++;
		return ran;
	}
	public int getMyMax() {
		return myMax;
	}
	public int getMyMin() {
		return myMin;
	}
	public int getWin() {
		return win;
	}
	public int getLoss() {
		return loss;
	}
	




}
