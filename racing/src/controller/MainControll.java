package controller;

import java.util.ArrayList;
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
    	ArrayList<String> arr = new ArrayList<>();
        while(true) {
        	Scanner sc = new Scanner(System.in);
        	String input = sc.nextLine();
        	
        	bkRuned+=bk.move(bk,input);
        	blRuned+=bl.move(bl,input);
        	rdRuned+=rd.move(rd,input);
        	whRuned+=wh.move(wh,input);
        	
        	if(mhRuned.length()<=19) {
        		mhRuned+=mh.move(mh,input);
        	}else {
        		mhRuned.substring(0,19);
        		arr.add(mh.name());

        	}
        	
        	
        	System.out.println(bkRuned + ">");
        	System.out.println(blRuned + ">");
        	System.out.println(mhRuned + ">");//나의 말
        	System.out.println(rdRuned + ">");
        	System.out.println(whRuned + ">");
        	
        	
        	if(mhRuned.length()>=20||bkRuned.length()>=20||blRuned.length()>=20||rdRuned.length()>=20||whRuned.length()>=20) {
        		break;
        	}
        	
        	
        }
	}
}
