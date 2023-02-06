package controller;

import java.util.ArrayList;
import java.util.Scanner;

import DAO.JoinDAO;
import DTO.joinInformation;
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
        		
        	
        	whRuned+=wh.move(wh,input);
        	
        	if(mhRuned.length()<=19) {
        		mhRuned+=mh.move(mh,input);
        	}else {
        		mhRuned.substring(0,19);
        		arr.add(mh.name());
        	}
        	if(bkRuned.length()<=19) {
        		bkRuned+=bk.move(bk,input);
        	}else {
        		bkRuned.substring(0,19);
        		arr.add(bk.name());
        	}
        	if(blRuned.length()<=19) {
        		blRuned+=bl.move(bl,input);
        	}else {
        		blRuned.substring(0,19);
        		arr.add(bl.name());
        	}
        	if(rdRuned.length()<=19) {
        		rdRuned+=rd.move(rd,input);
        	}else {
        		rdRuned.substring(0,19);
        		arr.add(rd.name());
        	}
        	if(whRuned.length()<=19) {
        		whRuned+=wh.move(wh,input);
        	}else {
        		whRuned.substring(0,19);
        		arr.add(wh.name());
        	}
        	
        	
        	System.out.println(bkRuned + ">");
        	System.out.println(blRuned + ">");
        	System.out.println(mhRuned + ">");//나의 말
        	System.out.println(rdRuned + ">");
        	System.out.println(whRuned + ">");
        	
        	
        	if(mhRuned.length()>=20 && bkRuned.length()>=20 && blRuned.length()>=20 && rdRuned.length()>=20 && whRuned.length()>=20) {
        		break;
        	}
        	
        	
  
        	
        }
	}
		// 회원가입
		public void Join(String id, String pw, String name) {
			joinInformation dto = new joinInformation(id, pw, name);
			JoinDAO dao = new JoinDAO();
			int row = dao.join(dto);
			if (row > 0) {
				System.out.println("회원가입 성공!");
			} else {
				System.out.println("회원가입 실패!");
			}
		}
		
		// 로그인
		public void Login(String id, String pw) {
			joinInformation dto = new joinInformation(id, pw);
			JoinDAO dao = new JoinDAO();
			boolean result = dao.Login(dto);
			if(result) {
				System.out.println("로그인 성공!");
			}else {
				System.out.println("아이디나 비밀번호를 확인해주세요!");
			}
		}

}
