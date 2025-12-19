package Bakjun.team3.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class day35 {
    public static void main(String[] args) throws IOException {
        // 1. 수의 개수 N
        // 2.  소수가 몇 개인지
        // 1, 숫자 입력, 2. 그 수의 소수의 갯수
        // N 으로 받고
        // N의 소수를 배열로 하고 처리를
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N =  Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0; // 소수의 개수를 셀 변수

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());

            //소수 판별
            if(num == 1){
                continue;
            }
            // num이 소수인지 확인할 "스위치"같은 변수
            boolean isPrime = true;

            for(int j = 2; j < num; j++){
                if(num % j == 0){
                    isPrime = false;
                    break;
                }
            }

            if(isPrime){
                count++;
            }
        }

        System.out.println(count);

    }
}
