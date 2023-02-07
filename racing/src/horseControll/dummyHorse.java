package horseControll;

import java.util.Random;
import java.util.Scanner;

public class dummyHorse {
    public static void main(String[]aStrings) {
        System.out.println("===시작===");
        Scanner sc = new Scanner(System.in);
        Random rm = new Random();
        String line1 = "";
        String line2 = "";
        String line3 = "";
        int h1 =0;
        int h2 =0;
        int h3 =0;
        String[][] array = new String[3][2];
        while(h1 <= 20 || h2 <= 20 || h3 <= 20){        // 20 == 경기장 길이.
            System.out.println("반복문 시작");
            String input = sc.nextLine();
            if(input.equals("")){
                int ran1 = 0;
                ran1 = rm.nextInt(4)+1;
                for(int i =1; i< ran1; i++){
                    line1+="-";
                }
                h1+=ran1;
                System.out.print(line1+">");
                System.out.println();

//============================================================================
                int ran2 = 0;
                ran2 = rm.nextInt(4)+1;
                for(int i =0; i< ran2; i++){
                    line2+="-";
                }
                h2+=ran2;
                System.out.print(line2+">");
                System.out.println();

//============================================================================
                int ran3= 0;
                ran3 = rm.nextInt(4);
                for(int i =0; i< ran3; i++){
                    line3+="-";
                }
                h3+=ran3;
                System.out.print(line3+">");
                System.out.println();
            }else{
                System.out.println("오류");
                break;
            }
        }
        array[0][0] = "h1";
        array[0][1] = Integer.toString(h1);
        array[1][0] = "h2";
        array[1][1] = Integer.toString(h2);
        array[2][0] = "h3";
        array[2][1] = Integer.toString(h3);
        int big = 0;
        for(int i = 0; i<array.length; i++){
            if(Integer.valueOf(array[i][1])>=big){
                big = Integer.valueOf(array[i][1]);
            }
        }
        System.out.println("*******************Fin!************************");
        for(int i = 0; i<array.length; i++){
            if(big == Integer.valueOf(array[i][1])){
                System.out.println("우승마 : " + array[i][0]);
            }
        }
        System.out.println("====순위 정렬====");   // temp 에서 정렬후 출력
            // bubble sort
            for(int j = 0; j<array.length-1; j++){
                if( Integer.valueOf(array[j][1])< Integer.valueOf(array[j+1][1])){
                    String temp = array[j][0];
                    array[j][0] = array[j+1][0];
                    array[j+1][0] = temp;
                    String temp1 = array[j][1];
                    array[j][1] = array[j+1][1];
                    array[j+1][1] = temp1;
                }
            }

        for(int i = 0; i <array.length; i ++){
            System.out.println((i+1)+"위 :" + array[i][0]);
        }
    }
}
