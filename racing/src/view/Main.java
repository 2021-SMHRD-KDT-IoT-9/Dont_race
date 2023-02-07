package view;

import java.util.Scanner;

import DTO.HorseInfo;
import DTO.joinInformation;
import controller.LoginCon;
import controller.MainControll;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MainControll mc = new MainControll();
        LoginCon lc= new LoginCon(); 
        HorseInfo hi = new HorseInfo();
        
        System.out.println("------경마 시뮬레이션------");
        
        while(true){
            System.out.println("[1]로그인 [2]회원가입 [3]종료 ");
            int choice = sc.nextInt();
            if(choice == 1){                //로그인 시퀀스
            	System.out.print("ID : ");
            	String id = sc.next();
            	System.out.print("PW : ");
            	String pw = sc.next();
            	lc.Login(id, pw);
                break;                      //DTO - > DAO  
            }else if(choice == 2){          //회원가입 시퀀스
            	System.out.print("ID : ");
            	String id = sc.next();
            	System.out.print("PW : ");
            	String pw = sc.next();
            	System.out.print("NAME : ");
            	String name = sc.next();
            	lc.Join(id, pw, name);
            	
            }else if(choice == 3){
                System.out.println("종료합니다.");
                break;
            }else System.out.println("입력오류");
        }
        

        while(true){      //lc.getIslogIn()               //경마(육성)-->
            System.out.println("      ------------Main--------------  ");
            System.out.println("[1]게임시작! [2]리더보드 [3]설정 [4]종료");
            int choice = sc.nextInt();
            if(choice == 1){
                // game ending 조건 -- 일정 경기수를 도달하면 종료 || 계획된 경기수를 도달 못하면 종료 
                while(true){
                    System.out.println("          =======Game Start=======");
                    System.out.println("[1]내 말 만들기 [2]경기Start [3]말 확인(경기 이력+) [4]말 훈련 [5]저장하고 Main 으로 돌아가기");
                    // 1 이나 3 입력시 정해진 턴수를 차감.
                    // 턴수가 지나감에따라 computer의 말들의 data 수정 (random의 범위 , 최소값)
                    int select = sc.nextInt();
                    if(select == 1){			//경기 시퀀스(각 경기마다 도달 등수를 저장)
                        System.out.print("말이름을 입력하세요>>");
                        String name = sc.next();
                        hi.setName(name);
                        hi.setId(lc.getLoginId());

                    }else if(select==2){  
                    	System.out.println("======경기를 시작합니다======");
                    	System.out.println("press enter to continu");                  	
                    	mc = new MainControll();
                    	mc.run();
                    }else if(select==3){        
                        
                    }else if(select==4){        
                    	mc = new MainControll();
                    	System.out.println("[1]최소 속도 훈련 [2]최대 속도 훈련");
                    	int temp = sc.nextInt();
                    	if(temp==1) {
                    		int temp1 = mc.trainMin();
                    		System.out.println("최소 속도가" +temp1 + "만큼 올랐습니다.");
                    	}else if(temp==2) {
                    		int temp1 = mc.trainMax();
                    		System.out.println("최대 속도가" +temp1 + "만큼 올랐습니다.");
                    	}else System.out.println("입력오루");
                    }else System.out.println("입력오류");
                }
                
            }else if(choice == 2){          //DB 에서 사용자 id 와 기록 출력
                
            }else if(choice == 3){          //설정? ---> 난이도 설정
                System.out.println("난이도 설정 : [1]어려움 [2]보통 [3]쉬움"); // 선택한 난이도에 따라 입력된 말의정보(com) 을 수정
                
            }else if(choice == 4){      //종료
                System.out.println("종료합니다.");
                break;
            }else System.out.println("입력오류!");

        }

    }
}
