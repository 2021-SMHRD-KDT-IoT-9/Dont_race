package controller;

import java.util.Scanner;

import horseControll.Black;
import horseControll.Blue;
import horseControll.Horse;
import horseControll.MyHorse;
import horseControll.Red;
import horseControll.White;

public class MainControll {
	private int max = 4;
	private int min = 1;
	private int myMax = 4;
	private int myMin = 1;
	
	public void run() {
		MyHorse mh = new MyHorse(myMax,myMin);
    	Black bk = new Black(max, min);
    	Blue bl = new Blue(max, min);
    	Red rd = new Red(max, min);
    	White wh = new White(max, min);
    	
    	String mhRuned = "";
    	String bkRuned = "";
    	String blRuned = "";
    	String rdRuned = "";
    	String whRuned = "";
    	
        while(true) {
        	Scanner sc = new Scanner(System.in);
        	String input = sc.nextLine();
        	mhRuned+=mh.move(mh,input);
        	bkRuned+=bk.move(bk,input);
        	blRuned+=bl.move(bl,input);
        	rdRuned+=rd.move(rd,input);
        	whRuned+=wh.move(wh,input);
        	
        	System.out.println(mhRuned + ">");
        	System.out.println();
        	System.out.println(bkRuned + ">");
        	System.out.println();
        	System.out.println(blRuned + ">");
        	System.out.println();
        	System.out.println(rdRuned + ">");
        	System.out.println();
        	System.out.println(whRuned + ">");
        	System.out.println();
        	if(mhRuned.length()>=20||bkRuned.length()>=20||blRuned.length()>=20||rdRuned.length()>=20||whRuned.length()>=20) {
        		break;
        	}
        	
        }
	}
}
