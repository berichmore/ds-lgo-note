package Bakjun.team3.week7;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class day38 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] arr= new String[N];

        for(int i = 0; i< N; i++){
            arr[i] =br.readLine();
        }

        StringBuilder sb = new StringBuilder();

        int ref = arr[0].length();

        for(int i = 0; i < ref; i++){

            char target = arr[0].charAt(i);

            boolean isSame = true;

            for( int j = 1; j< N; j++){
                if(target != arr[j].charAt(i)){
                    isSame = false;
                    break;
                }
            }
            if(isSame){
                sb.append(target);
            }else {
                sb.append('?');
            }
        }
        System.out.println(sb.toString());
        br.close();
    }
}

/*
        1. 겹치는 글자는 그대로 표현하고
        2. 안 겹치는 글자는 ?으로 표시
        3. 안 겹치는 부분들을 따로 글자마다 ?로 표시하는 방법은?
 */