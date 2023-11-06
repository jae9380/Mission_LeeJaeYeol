package com.ll.base;

import java.util.Scanner;

public class App {
    Scanner sc =new Scanner(System.in);
    public  void  run(){
        System.out.println("===== 명 언 앱 ====");
        while (true){
            System.out.print("명령어 ) ");
            String inputdata = sc.nextLine();
            if (inputdata.equals("종료")){
                return;
            }
        }
    }
}
