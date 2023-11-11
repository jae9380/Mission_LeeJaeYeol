package com.ll.base;

public class DistinguishOfStr {
    String mainAction,remain;
    String[]halfstr;
    public DistinguishOfStr(String inputData){
        if (!inputData.contains("?")){
            mainAction=inputData;
            return;
        }
        // 명령어를 잘못 입력 시 예외처리
        try {
            halfstr=inputData.split("\\?",2);
            mainAction= halfstr[0].trim();
            remain=halfstr[1].trim();

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("명령어를 다시 입력 바랍니다.");
        }


    }
    public String getAction(){return mainAction;}
    public int idNum() {

        try {
            String intRemain = remain.replaceAll("[^\\d]", "");
            int result = Integer.parseInt(intRemain);
            return result;
        } catch (NullPointerException e) {
            return 0;
        }
    }
}
