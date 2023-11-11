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
        controller.actionLoad();
        System.out.println("===== 명 언 앱 ====");
        while (true){
            System.out.print("명령어 ) ");
            String inputdata = sc.nextLine();
            DistinguishOfStr ds= new DistinguishOfStr(inputdata);

            switch (ds.getAction()){
                case "등록": controller.actionWrite();
                    break;
                case "목록": controller.actionList();
                    break;
                case "삭제": controller.actionRemove(ds);
                    break;
                case "수정": controller.actionModify(ds);
                    break;
                case "빌드": controller.actionBuild();
                    break;
                case  "종료": controller.actionSave();
                    return;
                default:
                    System.out.println("명령어를 다시 입력 해주세요.");
                    break;
            }
        }
    }
}
