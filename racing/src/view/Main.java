package view;

import java.util.Scanner;

import DAO.HorseDAO;
import DAO.RankDAO;
import DTO.GameDTO;
import DTO.HorseInfo;
import controller.Difficulty;
import controller.LoginCon;
import controller.MainControll;
import controller.Train;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MainControll mc = new MainControll();
        LoginCon lc= new LoginCon(); 
        HorseInfo hi = new HorseInfo();
        GameDTO gd = new GameDTO();
        Difficulty dc = new Difficulty();
        HorseDAO dao = new HorseDAO();
        RankDAO rdao = new RankDAO();
        Train tr = new Train();
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
        

        while(lc.getIslogIn()){      //로그인 성공했을때 프로그램이 실행

            System.out.println(" ------------Main--------------  ");
            System.out.println("[1]게임시작! [2]리더보드 [3]종료");
            int choice = sc.nextInt();
            if(choice == 1){
            	mc = new MainControll();
            	 System.out.println("난이도 설정 : [1]쉬움 [2]보통 [3]어려움"); // 선택한 난이도에 따라 입력된 말의정보(com) 을 수정
                 int ch = sc.nextInt();
                 if(ch==1) {
                	 dc.getEasy(gd);
                	 gd.setDif(ch);
                 }else if(ch==2) {
                	 dc.getMiddle(gd);
                	 gd.setDif(ch);
                 }else if(ch==3) {
                	 dc.getHard(gd);
                	 gd.setDif(ch);
                 }else {
                	 System.out.println("올바른 번호를 입력하세요.");
                 }

                // game ending 조건 -- 일정 경기수를 도달하면 종료 || 계획된 경기수를 도달 못하면 종료 
            	System.out.println("          =======Game Start=======");
            	System.out.print("말이름을 입력하세요>>");
            	String name = sc.next();
            	hi.setName(name);
            	hi.setId(lc.getLoginId());
            	dao.insert(hi, lc.getLoginId(),gd);
            	
            	while(true){
                	if(gd.getTrun()>=10) {
                		System.out.println("10턴이 지나 게임이 종료되었습니다.");
                		System.out.println(gd.getWin()+"승/"+gd.getLoss()+"패");
                		hi.setRank(gd.getWin());
                		hi.setMax(gd.getMax());
                		hi.setMin(gd.getMin());
                		dao.update(hi);
                		if(gd.getWin()>=3) {
                			System.out.println("게임에서 승리하셨습니다.");
                			break;
                		}else {
                			System.out.println("분발하세요.");
                			break;
                		}
                	}
                	if(gd.getLoss()>=5) {
                		System.out.println("게임에서 패배하였습니다.");
                		break;
                	}
            		System.out.println("[1]경기Start [2]말 확인(경기 이력+) [3]말 훈련 [4]종료");
            		System.out.println("====현제 "+gd.getTrun() +"턴 입니다.====");
            		int select = sc.nextInt();
            		if(select==1){  
            			System.out.println("======경기를 시작합니다======");
            			System.out.println("press enter to continue");                 	
            			mc.run(hi,gd);
            			
            		}else if(select==2){  
            			System.out.println("현제말의 최대 속도:" + gd.getMyMax());
            			System.out.println("현제말의 최소 속도:" + gd.getMyMin());
            			System.out.println(rdao.rank(hi));
            		}else if(select==3){        
            			System.out.println("[1]최대속도 훈련 [2]최소속도 훈련" );
            			int choice2 = sc.nextInt();
            			if(choice2==1) {
            				int temp = tr.trainMax(gd);
            				System.out.println("최대속도 " + temp + " 증가");
            			}else if(choice2 == 2) {
            				int temp = tr.trainMin(gd);
            				System.out.println("최소속도 " + temp + " 증가");
            			}
            		}else if(select==4) {
            			System.out.println("종료합니다.");
            			break;
            			
            		}else System.out.println("올바른 번호를 입력하세요.");
            	}
                    
                
            }else if(choice == 2){          //DB 에서 사용자 id 와 기록 출력
                
            	
            	// 리더보드
            	System.out.println(dao.recode());
            	
            	
            }else if(choice == 3){       
            	System.out.println("종료합니다.");
            	break;
            
            }else System.out.println("입력오류");

        }

    }
}
