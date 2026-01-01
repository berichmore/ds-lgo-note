package Bakjun.team3.week8;

import java.util.ArrayList;

public class EnhacncedFor {
    public static void main(String[] args){
        ArrayList<String> members = new ArrayList<>();

        members.add("jay");
        members.add("hong");

        for(String member : members){
            System.out.println("회원 : " + member);
        }

    }
}
