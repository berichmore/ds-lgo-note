package Bakjun.team3.week7;

import java.util.Scanner;

public class day37 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for(int i = 1; i <= n; i++){
            count++;
        }
        System.out.println(count);

        System.out.println(count/n);
    }
}

