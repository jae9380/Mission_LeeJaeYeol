package com.ll.base;

public class DistinguishOfStr {
    String mainAction,remain;
    public DistinguishOfStr(String inputData){
        if (inputData.length()==2){
            mainAction=inputData;
            return;
        }
        String[]halfstr=inputData.split("\\?",2);
        mainAction= halfstr[0].trim();
        remain=halfstr[1].trim();


    }
    public String getAction(){return mainAction;}
    public int idNum(){
        String intRemain= remain.replaceAll("[^\\d]","");
        int result = Integer.parseInt(intRemain);
        return result;
    }
}
