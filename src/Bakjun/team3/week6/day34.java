package Bakjun.team3.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2609
public class day34 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();

        StringTokenizer st = new StringTokenizer(str, " ");
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int gResult = gcd(a, b);
        int lResult = (a * b ) / gResult;

        System.out.println(gResult);
        System.out.println(lResult);
    }

    public static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}



//public class day34 {
//    public static void main(String[] args) {
//        //연속으로  두 개를 받는다라
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//
//        // 1. 최대공약수
//        int gResult = g(a, b);
//
//        // 2. 최소공배수
//        int lResult = (a * b)/gResult;
//        System.out.println(gResult);
//        System.out.println(lResult);
//
//    }
//
//    public static int g(int a, int b){
//        if(b == 0){
//            return a; // b가 0이면 a가 최대공약수
//        }
//        // b가 0이 아니면, (b)와 (a를 b로 나눈 나머지)로 다시 수행
//        return g(b, a % b);
//    }
//}

/*
유클리드 호제법
A와 B의 최대공약수는  B와 A를 B로 나눈
나머지(R)의 최대공약수와 같다

1. A % B = R -> B, R 의 최대공약수를 구하면 됨
2.  최대공약수
    ex) 18 % 6 = 0 (R) -> 나누어떨어졌으니 6이 최대공약수

3. 관계를 이용한 확장 (최소공배수)


 */

