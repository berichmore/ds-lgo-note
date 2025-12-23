package Bakjun.team3.week6;

import java.util.Arrays;
import java.util.Scanner;


//https://www.acmicpc.net/problem/1037
public class day33 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();

        }

        Arrays.sort(arr);

//        int result = arr[0] * arr[count-1];
//        System.out.println(result);
    }
}


// 1. 약수문제는 정렬해서 양 끝을 곱한다.
// 2. Arrays.sort는 오름차순 정렬
// 3. 문제 속에 힌트가 반드시 있다.
