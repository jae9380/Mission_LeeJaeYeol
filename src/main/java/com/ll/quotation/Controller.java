package com.ll.quotation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Controller {
    private Scanner sc;
    static int count=1;
    private static Map<Integer,Model> map;

    public Controller(Scanner sc){
        this.sc=sc;
        map=new HashMap<>();
    }
    public void actionWrite(){
        System.out.print("명언 : ");
        String saying =sc.nextLine();
        System.out.print("작가 : ");
        String author=sc.nextLine();
        System.out.printf("%d번 명언이 등록 되었습니다.\n",count);
        actionUpload(saying,author);
    }

    private void actionUpload(String saying,String author){
        Model model=new Model(saying,author);
        map.put(count,model);
        count++;
    }

    public void actionList(){
        System.out.printf("\t%s\t/\t%s\t/\t%s\n","순번","작가","명언");
        System.out.println("----------------------------------------------");
        if (map.isEmpty()){
            System.out.println("등록된 명언이 없습니다.");
        }else {
            for (Integer key: map.keySet()) {
                try {
                    System.out.printf("\t%1$d\t\t/ \t%2$s\t / \t%3$s\n", key, map.get(key).author, map.get(key).saying);
                }catch (NullPointerException e){

                }
            }
        }
    }

}
