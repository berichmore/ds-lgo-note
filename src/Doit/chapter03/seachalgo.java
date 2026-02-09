package Doit.chapter03;

import java.util.Scanner;

// 선형 검색 (linear search) p. 98
public class seachalgo {

    public static void main(String[] args) {

    }
}

class SeqSearch {
    // 요솟수가 n인 배열 a에서 key와 값이 같은 요소를 선형 검색

    static int seqSearch(int[] a, int n, int key) {
        int i = 0;

        while (true) {
            if (i == n)
                return  -1; //검색 실패 (-1을 반환)
            if (a[i] == key)
                return i;   //검색 성공(인덱스를 반환)
            i++;
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.print("요소수 : ");
        int num = sc.nextInt();
        int[] x = new int[num]; // 요솟수가 num인 배열

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "] ");
            x[i] = sc.nextInt();
        }

        System.out.print("검색할 값 : " );  //키값을 입력 받음
        int ky = sc.nextInt();

        int idx = seqSearch(x, num, ky); //배열 x에서 값이 ky인 요소를 검색

        if (idx == -1)
            System.out.println("그 값의 요소가 없습니다.");
        else
            System.out.println("그 값은 x");
    }
}

// 보초법 ( sentinal method)

class SeqSearchSen {
    // 요솟수가 n인 배열 a에서 key와 값이 같은 요소를 보초법으로 선형 검색

    static int seqSearchSen(int[] a, int n ,  int key) {
        int i = 0;

        a[n] = key;     // 보초를 추가;

        while (true) {
            if (a[i] == key)
                break;
            i++;
        }
        return i == n ? -1 : i;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("요솟수: ");
        int num = sc.nextInt();
        int[] x = new int[num + 1]; //요솟수가 num + 1인 배열

        for ( int i = 0; i < num; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = sc.nextInt();
        }

        System.out.print("검색할 값: ");    // 키값을 입력받음
        int ky = sc.nextInt();

        int idx = seqSearchSen(x, num, ky);     //배열 x에서 값이 ky인 요소를 검색

        if ( idx == -1)
            System.out.println("그 값의 요소가 없습니다.");
        else
            System.out.println("그 값은 " + idx + "에 있습니다");
    }
}
