package com.ll.quotation;

import java.util.Scanner;

public class Controller {
    private Scanner sc;

    public Controller(Scanner sc){
        this.sc=sc;
    }
    public void actionWrite(){
        System.out.print("명언 : ");
        String saying =sc.nextLine();
        System.out.print("작가 : ");
        String author=sc.nextLine();

    }

}