package controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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
		ArrayList<String> rank = new ArrayList<>();
		while (true) {
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();

			bkRuned += bk.move(bk, input);
			blRuned += bl.move(bl, input);
			mhRuned += mh.move(mh, input);
			rdRuned += rd.move(rd, input);
			whRuned += wh.move(wh, input);
			
			
			
			if(bkRuned.length() >= 30) {
				bkRuned = "------------------------------";
				rank.add(bkRuned);
			}
			if(blRuned.length() >= 30) {
				blRuned = "------------------------------";
			}
			if(mhRuned.length() >= 30) {
				mhRuned = "------------------------------";
			}
			if(rdRuned.length() >= 30) {
				rdRuned = "------------------------------";
			}
			if(whRuned.length() >= 30) {
				whRuned = "------------------------------";
			}

			System.out.println(bkRuned + ">");
			System.out.println(blRuned + ">");
			System.out.println(mhRuned + ">");// 나의 말
			System.out.println(rdRuned + ">");
			System.out.println(whRuned + ">");

			if (mhRuned.length() >= 30 && bkRuned.length() >= 30 && blRuned.length() >= 30 && rdRuned.length() >= 30
					&& whRuned.length() >= 30) {
				break;
			}

		}
		min++;
		max++;
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
