package Doit.chapter2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * 자료구조는 데이터를 효율적으로 저장할 수 있는 방법!!
 *
 */

//     int[] a = new int[5];
//     int[] A 구성 요소의 자료형이 int인 배열
//    a = new int[5];
//int[] a = new int[5];
// 구성요소 자료형이 int인 배열 변수 a에 5개의 int 변수를 넣음

public class Array {
    public static void main(String[] args) {

    }
}
class IntArray {
    public static void main(String[] args) {
        int[] a = new int[5];  // 배열의 선언

        a[1] = 37;
        a[2] = 51;
        a[4] = a[1] * 2;

        for (int i = 0; i < a.length; i++)
            System.out.println("a[" + i + "] =" + a[i]);
    }
}

class IntArrayIntIt {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};  //배열 초기화에 의해 생성

        for (int i = 0; i < a.length; i++)
            System.out.println("a[" + i + "] =" + a[i]);

        int max = a[0];

        if (a[1] > max) max = a[1];
        if (a[2] > max) max = a[2];   // 요솟수가 3이면 if 문을 2회 실행

    }
}

class MaxOfArray {
    // 배열 a의 최댓값을 반환합니다.
    static int maxOf(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++)
            if (a[i] > max)
                max = a[i];
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("키의 최댓값을 구해보자");
        System.out.print("사람 수 : ");
        int num = sc.nextInt();  // 배열의 요솟수

        int[] height = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.print("height[" + i + "] = ");
            height[i] = sc.nextInt();
        }

        System.out.println("최댓값은" + maxOf(height) + "입니다.");
    }
}

class MaxOfArrayRand {
    static int maxOf(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++)
            if (a[i] > max)
                max = a[i];

        return max;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        System.out.println("키의 최댓값을 구합니다.");
        System.out.print("사람 수 : ");

        int num = sc.nextInt();

        int[] height = new int[num];

        System.out.println("킷값은 아래와 같습니다.");
        for (int i = 0; i < num; i++) {
            height[i] = 100 + rand.nextInt(90); //요솟값을 난수로 결정
            System.out.println("height[" + i + "]: " + height[i]);
        }
        System.out.println("최댓값은 + " + maxOf(height) + "입니다.");
    }
}
class MaxOfArrayRand2 {
    static int maxOf(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max)
                max = a[i];
        }
        return max;
    }
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        System.out.println("키의 최댓값을 구합니다.");
        System.out.print("사람 수 : ");
        int num = sc.nextInt();

        int[] people = new int[num];
        for (int i = 1; i < num; i++) {
            people[i] = 100 + rand.nextInt(80);
        }

    }
}

class reverseArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 리버스 전
        int[] arrays = {1, 4, 5, 6, 10, 4, 11};
        for (int i = 0; i < arrays.length; i++){
            System.out.print(" " + arrays[i] + " ");
        }

        // 리버스 후


//        for (int i = 1; i < arrays.length; i++) {
//
//            int temp;
//
//            if (arrays[i] == arrays[arrays.length - i]){
//                temp = arrays[i];
//                arrays[i] = arrays[arrays.length -i];
//                arrays[arrays.length -i] = temp;
//            }else if (arrays[i] == arrays[arrays.length - i]){}
//        }

//        for ( int i = 0; i < arrays.length/ 2;  i++) {
//            temp = arrays[i];
//        }
        // 고민의 흔적들
    }
}

class ReverseArray {
    // 배열 요소 a[idx1]과 a[idx2]의 값을 바꿈
    static void swap(int[] a, int idx1, int idx2) {
        int t  = a[idx1]; a[idx1] = a[idx2]; a[idx2] = t;
    }

    // 배열 a의 요소를 역순으로 정렬
    static void reverse(int[] a) {
        for (int i = 0; i < a.length / 2; i++){
            swap(a, i,a.length - i - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("요소수: ");
        int num = sc.nextInt();     // 요소수

        int[] x = new int[num];     // 요소수가 num인 배열

        for (int i = 0; i < num; i++) {
            x[i] = sc.nextInt();
        }
        reverse(x); // 배열 a의 요소를 역순으로 정렬

        System.out.println("요소를 역순으로 정렬했습니다.");
        System.out.println("x = " + Arrays.toString(x));
    }
}

// 260209 복습

// random 난수
class rand {

    public static void main(String[] args) {
        Random rand = new Random();
        rand.nextFloat(); // 0.0 이상 1.0 미만
        rand.nextDouble(); // 0.0 이상 1.0 미만
        rand.nextInt(); //  +- 21억
        rand.nextInt(); // 0 ~ n - 1
    }
}

class ReversArray2 {

    static void swap (int[] a, int idx1, int idx2) {
        int t = a[idx1]; a[idx1] = a[idx2];  a[idx2] = t;
    }

    // 배열 a의 요소를 역순으로 정렬
    static void reverse(int[] a) {
        for (int i = 0; i < a.length / 2; i++)
            swap(a, i, a.length - i - 1);
    }

    public static void main(String[] args) {


        switch (true){

           case1:  Scanner sc = new Scanner(System.in);

            System.out.print("요소수");
            int num = sc.nextInt(); // 요소수
            int[] x = new int[num];  //요소수가 num일 때

            for (int i = 0; i < num; i++) {
                System.out.print("x[" + i + "] ");
                x[i] = sc.nextInt();
            }

            reverse(x);

            System.out.println("역순 정렬");
            System.out.println("x = " + Arrays.toString(x));
        }
    }
}
// p.51 ~ p. 69


// 기수 변환  p. 72

class CardConv {
    // 정숫값 x를 r진수로 변환하여 배열 d에 아랫자리부터 넣어두고 자릿수를 변환
    static int cardConv(int x, int r, char[] d) {
        int digits = 0; // 변환후의 자릿수
        String dchar = "012356789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        do {
            d[digits++] = dchar.charAt(x % r);  //r로 나눈 나머지를 저장
            x /= r;
        } while (x != 0);

        for (int i = 0; i < digits / 2; i++) {  //배열 d의 숫자 문자열을 역순으로 정렬
            char t = d[i];
            d[i] = d[digits - i - 1];
            d[digits - i - 1] = t;
        }
    }
}


// 클래스로 건너뛰기
// p. 86

// 클래스는 서로 다른 여러 데이터형을 자유로이 조합하여 만들 수 있는 자료구조

// 실습 2-10 p.88
class PhysicalExamination {
    static final int VMAX = 21; //시력 분포(0.0 ~ 0.1 단위로 21개)

    static class PhyscData {
        String name;
        int height;
        double vision;

        //생성자
        PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }
    }

    // 키의 평균값을 구함
    static double aveHeight(PhyscData[] dat) {
        double sum = 0;

        for (int i = 0; i < dat.length; i++)
            sum += dat[i].height;

        return sum / dat.length;
    }

    // 시력 분포를 구함
    static void distVision(PhyscData[] dat. int[] dist) {
        int i = 0;
        dist[i] = 0;
        for (i = 0; i < dat.length; i++)
            if (dat[i].vision >= 0.0 && dat[i].vision <= VMAX / 10.0)
                dist[(int)(dat[i].vision * 10)]++;
    }
}






