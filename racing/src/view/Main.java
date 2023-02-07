package view;

import java.util.Scanner;

import DTO.HorseInfo;
import DTO.joinInformation;
import controller.Difficulty;
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
            if(choice == 1){                //로그인 시퀀스 , (배팅게임일시) 파산계정으로 로그인시 로그인 거부

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
            }else System.out.println("올바른 번호를 입력하세요.");
        }
        

        while(true){      //lc.getIslogIn()               //경마(육성)-->
            System.out.println(" ------------Main--------------  ");
            System.out.println("[1]게임시작! [2]리더보드 [3]설정 [4]종료");
            int choice = sc.nextInt();
            if(choice == 1){
                // game ending 조건 -- 일정 경기수를 도달하면 종료 || 계획된 경기수를 도달 못하면 종료 
            	System.out.println("          =======Game Start=======");
            	System.out.print("말이름을 입력하세요>>");
            	String name = sc.next();
            	hi.setName(name);
            	hi.setId(lc.getLoginId());
            	
            	while(true){
                	if(mc.getTrun()>=10) {
                		System.out.println("10턴이 지나 게임이 종료되었습니다.");
                		hi.setMax(mc.getMyMax());
                		hi.setMin(mc.getMyMin());
                		//hi.setRank(mc.getWin()+"승/"+mc.getLoss()+"패");
                		if(mc.getWin()>=5) {
                			System.out.println("게임에서 승리하셨습니다.");
                			break;
                		}else {
                			System.out.println("분발하세요.");
                			break;
                		}
                	}
                	if(mc.getLoss()>=5) {
                		System.out.println("게임에서 패배하였습니다.");
                		break;
                	}
            		System.out.println("[1]경기Start [2]말 확인(경기 이력+) [3]말 훈련 [4]저장하고 Main 으로 돌아가기");
            		int select = sc.nextInt();
            		if(select==1){  
            			System.out.println("======경기를 시작합니다======");
            			System.out.println("press enter to continu");                 	
            			mc = new MainControll();
            			mc.run();
            			mc.ranked();
            		}else if(select==2){  
            			
            			
            			//  말 확인
            			
            			
            			
            		}else if(select==3){        
            			System.out.println("[1]최대속도 훈련 [2]최소속도 훈련" );
            			int choice2 = sc.nextInt();
            			if(choice2==1) {
            				int temp = mc.trainMax();
            				System.out.println("최대속도 " + temp + " 증가");
            			}else if(choice2 == 2) {
            				int temp = mc.trainMin();
            				System.out.println("최소속도 " + temp + " 증가");
            			}
            		}else if(select==4) {
            			continue ;
            			
            		}else System.out.println("올바른 번호를 입력하세요.");
            	}
                    
                
            }else if(choice == 2){          //DB 에서 사용자 id 와 기록 출력
                
            	
            	// 리더보드
            	
            	
            	
            }else if(choice == 3){          //설정? ---> 난이도 설정
                System.out.println("난이도 설정 : [1]쉬움 [2]보통 [3]어려움"); // 선택한 난이도에 따라 입력된 말의정보(com) 을 수정
                 int ch = sc.nextInt();
                 Difficulty dc = new Difficulty();
                 if(ch==1) {
                	 dc.getEasy();
                 }else if(ch==2) {
                	 dc.getMiddle();
                 }else if(ch==3) {
                	 dc.getHard();
                 }else {
                	 System.out.println("올바른 번호를 입력하세요.");
                 }
            }else if(choice == 4){      //종료
                System.out.println("종료합니다.");
                break;
            }else System.out.println("올바른 번호를 입력하세요.");

        }

    }
}
