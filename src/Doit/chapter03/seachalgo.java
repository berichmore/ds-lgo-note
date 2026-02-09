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


// 2진 검색 알고리즘
// 2진 검색(binary search)은 요소가 오름차순 또는 내림차순으로 정렬된 배열에서
// 검색하는 알고리즘입니다.

// 다음 그림과 같이 이진 검색은 검색 대상(배열)이 오름차순으로 정렬(sort)되어 있음을
// 가정합니다. 따라서 다음 프로그램의 36~41행은 사용자가 각 요솟값을 입력할 때 바로
// 앞에 입력한 요소보다 작은 값을 입력할 경우 다시 입력하게 합니다.


// 이진 검색  p.109 실습 3-4
class BinSearch {
    // 요솟수가 n개인 배열 a에서 key와 같은 요소를 이진 검색
    static int binSearch(int[] a, int n , int key) {
        int pl = 0;     //검색 범위의 첫 인덱스
        int pr = n -1;  // 검색 범위의 끝 인덱스

        do{
            int pc = (pl + pr) / 2;     // 중앙 요소의 인덱스
            if (a[pc] == key)
                return pc;
            else if (a[pc] < key)
                pl = pc + 1;    // 검색범위를 뒤쪽으로 좁힘
            else
                pr = pc -1;     // 검색 범위를 앞쪽 절반으로 좁힘
        }while (pl <= pr);

        return -1;      // 검색 실패
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("요소수: ");
        int num = sc.nextInt();
        int[] x = new int[num];     // 요소수가 num인 배열

        System.out.println("오름차순으로 입력하세요");

        System.out.println("x[]: ");    //첫 요소 입력받음
        x[0] = sc.nextInt();

        for (int i = 1; i < num; i++) {
            do {
                System.out.print("x[" + i + "]: ");
                x[i] = sc.nextInt();
            }while (x[i] < x[i - 1]);       // 바로 앞의 요소보다 작으면 다시 입력받음
        }

        System.out.print("검색할 값: "); // 키값을 입력받음
        int ky = sc.nextInt();

        int idx = binSearch(x, num,ky);    // 배열 x에서 값이 ky인 요소를 검색

        if (idx == -1)
            System.out.println("그 값의 요소가 없습니다. ");
        else
            System.out.println("그 값은 ㅌ[" + idx + "]에 있습니다.");
    }
}




