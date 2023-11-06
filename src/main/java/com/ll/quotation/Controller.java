package com.ll.quotation;

import com.ll.base.DistinguishOfStr;

import java.io.*;
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
    private int searchMap(int key){
        int result= map.containsKey(key)?key:-1;
        return result;
    }

    public void actionRemove(DistinguishOfStr ds){
        int removeId= searchMap(ds.idNum());
        if (removeId==-1){
            System.out.printf("해당 %d 번의 명언은 존재하지 않습니다.\n",ds.idNum());
            return;
        }
        map.remove(ds.idNum());
        System.out.printf("%d번의 명언을 삭제 했습니다.\n",ds.idNum());
    }

    public void actionModify(DistinguishOfStr ds){
        int modtifyId= searchMap((ds.idNum()));
        if (modtifyId==-1){
            System.out.printf("해당 %d 번의 명언은 존재하지 않습니다.",ds.idNum());
            return;
        }
        System.out.println("명언(기존) : "+map.get(ds.idNum()).saying);
        System.out.print("명언 : ");
        map.get(ds.idNum()).saying=sc.nextLine();
        System.out.println("작가(기존) : "+map.get(ds.idNum()).author);
        System.out.print("작가 : ");
        map.get(ds.idNum()).author=sc.nextLine();
    }

    public void actionSave(){
        try {
            BufferedWriter bw=new BufferedWriter(new FileWriter("Test.txt"));
            for (Integer key: map.keySet()) {
                String object = String.format("%1$d/%2$s/%3$s",key,map.get(key).author,map.get(key).saying);
                bw.write(object);
                bw.newLine();
            }
            bw.close();
        }catch (IOException e){

        }
    }

    public void actionLoad(){
        try {
            BufferedReader br =new BufferedReader(new FileReader("Test.txt"));
            boolean dataFound = false;
            String line;
            while ((line=br.readLine())!=null){
                dataFound=true;
                String[] wiseSet=line.split("/");
                if (wiseSet.length==3){
                    int count_load=Integer.parseInt(wiseSet[0]);
                    String author_load= wiseSet[1];
                    String saying_load= wiseSet[2];

                    Model model=new Model(saying_load,author_load);
                    map.put(count_load,model);
                    count=count_load+1;
                }
            }
            br.close();
            if (dataFound){
                System.out.println("저장된 데이터를 갖고 옵니다.");
            }
        } catch (IOException e) {
            System.out.println("저장된 데이터가 없습니다.");
        }
    }

}
