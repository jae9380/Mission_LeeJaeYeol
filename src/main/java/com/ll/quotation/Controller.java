package com.ll.quotation;

import java.util.Scanner;

public class Controller {
    private Scanner sc;
    int count=1;

    public Controller(Scanner sc){
        this.sc=sc;
    }
    public void actionWrite(){
        System.out.print("명언 : ");
        String saying =sc.nextLine();
        System.out.print("작가 : ");
        String author=sc.nextLine();
        System.out.printf("%d번 명언이 등록 되었습니다.\n",count);
        count++;
    }

}
