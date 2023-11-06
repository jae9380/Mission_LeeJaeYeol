package com.ll.base;

import com.ll.quotation.Controller;

import java.util.Scanner;

public class App {
    private Scanner sc;

    public App(){
        sc=new Scanner(System.in);
    }
    public  void  run(){
        Controller controller=new Controller(sc);
        System.out.println("===== 명 언 앱 ====");
        while (true){
            System.out.print("명령어 ) ");
            String inputdata = sc.nextLine();
            switch (inputdata){
                case "등록": controller.actionWrite();
                    break;
                case  "종료":
                    return;
            }
        }
    }
}
