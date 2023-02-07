package controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import DTO.HorseInfo;
import DTO.Rank;
import horseControll.Black;
import horseControll.Blue;
import horseControll.MyHorse;
import horseControll.Red;
import horseControll.White;

public class MainControll {
	private int max = 4;
	private int min = 1;
	private int myMax = 4;
	private int myMin = 1;
	private int fieldSize = 30;
	ArrayList<String> rank = new ArrayList<>();
	
	public void run() {
		MyHorse mh = new MyHorse(myMax, myMin);
		Black bk = new Black(max, min);
		Blue bl = new Blue(max, min);
		Red rd = new Red(max, min);
		White wh = new White(max, min);

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
				String temp = "";
				temp = extracted(fieldSize);
				bkRuned = temp;
				rank.add(bk.name());
			}
			if(blRuned.length() >= fieldSize) {
				String temp = "";
				temp = extracted(fieldSize);
				blRuned = temp;
				rank.add(bl.name());
			}
			if(mhRuned.length() >= fieldSize) {
				String temp = "";
				temp = extracted(fieldSize);
				mhRuned = temp;
				rank.add(mh.name());
			}
			if(rdRuned.length() >= fieldSize) {
				String temp = "";
				temp = extracted(fieldSize);
				rdRuned = temp;
				rank.add(rd.name());
			}
			if(whRuned.length() >= fieldSize) {
				String temp = "";
				temp = extracted(fieldSize);
				whRuned = temp;
				rank.add(wh.name());
			}
		

			System.out.println(bkRuned + ">");
			System.out.println(blRuned + ">");
			System.out.println(mhRuned + ">");// 나의 말
			System.out.println(rdRuned + ">");
			System.out.println(whRuned + ">");

			if (mhRuned.length() >= fieldSize && bkRuned.length() >= fieldSize && blRuned.length() >= fieldSize && rdRuned.length() >= fieldSize
					&& whRuned.length() >= fieldSize) {
				break;
			}

		}

		min++;
		max++;
		fieldSize+=2;
	}
	private void sortedArray() {
		for(int i = 0; i<rank.size(); i++) {
			
			
		}
		
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
		return ran;

	}

	public int trainMax() {
		Random rm = new Random();
		int ran = rm.nextInt(3);
		myMax += ran;
		max++;
		return ran;
	}
	
	public void name() {
		// 게임진행 메서드.
	}



}
