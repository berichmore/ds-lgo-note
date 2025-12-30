package Bakjun.team3.week7;


import java.util.Scanner;
import java.util.Stack;

//https://www.acmicpc.net/problem/9012
public class day39 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int i =  0; i < T; i++){
            String str = sc.next();
            System.out.println(solve(str));
        }
    }

    public static String solve(String str){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i< str.length(); i++){
            char ch = str.charAt(i);

            Character c = null;
            if(c == '('){
                stack.push(c);
            }else {
                if(stack.empty()){
                    return "NO";
                }
                stack.pop();
            }
        }
        if(stack.empty()){
            return "YES";
        }else {
            return "NO";
        }
    }
}
