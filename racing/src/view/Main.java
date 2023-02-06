package view;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isLogin = false;
        System.out.println("------경마 시뮬레이션------");
        while(true){
            System.out.println("[1]로그인 [2]회원가입 [3]종료 ");
            int choice = sc.nextInt();
            if(choice == 1){                //로그인 시퀀스 , (배팅게임일시) 파산계정으로 로그인시 로그인 거부
                isLogin = true;
                break;                      //DTO - > DAO  
            }else if(choice == 2){          //회원가입 시퀀스

            }else if(choice == 3){
                System.out.println("종료합니다.");
                isLogin = false;
                break;
            }else System.out.println("입력오류");
        }
        
        
        while(isLogin){                     //경마(배팅)--> // 토너먼트 점수게임 |
            System.out.println("      ------------Main--------------  ");
            System.out.println("[1]게임시작! [2]리더보드 [3]설정 [4]종료");
            int choice = sc.nextInt();
            if(choice == 1){
                // game ending 조건 -- 일정 경기수(or 금액)를 도달하면 종료 || 파산 || 기록을 남기고 종료. 
                while(true){
                    System.out.println("                  =======Game Start=======");
                    System.out.println("[1]경기Start [2]소지금 확인 [3]대출(?) [4]저장하고 Main 으로 돌아가기");
                    int select = sc.nextInt();
                    if(select == 1){
                        
                    }else if(select==2){        //돈을 걸고 경기의 결과에따라 설정된 배당에 따라 소지금에서 추가하거나 감산하여 model 에 저장
                        
                    }else if(select==3){        //setter 를 이용하여 금액 ++ , 겅마를 할때마다 이자 누적 
                        
                    }else if(select==4){        //model 에 입력된 값을 db 에 저장.
                        
                    }else System.out.println("입력오류");
                }
                
            }else if(choice == 2){          //DB 에서 사용자 id 와 기록(금액) 출력
                
            }else if(choice == 3){          //초기 투자금 설정 , 경기에서 뛸 말의 수?
                
            }else if(choice == 4){
                
            }
            
        }
        while(isLogin){                     //경마(육성)-->
            System.out.println("      ------------Main--------------  ");
            System.out.println("[1]게임시작! [2]리더보드 [3]설정 [4]종료");
            int choice = sc.nextInt();
            if(choice == 1){
                // game ending 조건 -- 일정 경기수를 도달하면 종료 || 계획된 경기수를 도달 못하면 종료 
                while(true){
                    System.out.println("                  =======Game Start=======");
                    System.out.println("[1]경기Start [2]말 확인(경기 이력+) [3]말 훈련 [4]저장하고 Main 으로 돌아가기");
                    // 1 이나 3 입력시 정해진 턴수를 차감.
                    // 턴수가 지나감에따라 computer의 말들의 data 수정 (random의 범위 , 최소값)
                    int select = sc.nextInt();
                    if(select == 1){
                        
                    }else if(select==2){        //경기 시퀀스(각 경기마다 도달 등수를 저장)
                        
                    }else if(select==3){        //setter 를 이용하여 말의 정보를 수정 (random의 범위 , 최소값)
                        
                    }else if(select==4){        //model 에 입력된 값을 db 에 저장.
                        
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
