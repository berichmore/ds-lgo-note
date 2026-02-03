package Doit.chapter1;



/**
 * day 1 doit java page 13
 *  260203
 *  알고리즘이란 무엇인가?
 *  어떤 문제를 해결하기위한 절차로, 명확하게 정의되고 순서가 있는 유한 개의 규칙으로 이루어진 집합
 *  이건 너무 투박하다 한 마디로,
 *  어떤 문제를 해결하기 위한 정의가 있고 순서가 있는 유한 개의 규칙?  결국 이렇게 따라가네
 */
public class day1 {

}
class Max3Method{
    static int max3(int a, int b, int c){
        int max = a;
        if (b > max)
            max = b;
        if (c > max)
            max = c;
        return max;

    }

    public static void main(String[] args) {
        System.out.println("max3(3,2,1) = " + max3(3,2,1));
        System.out.println("max3(3,2,1) = " + max3(3,2,2));
        System.out.println("max3(3,2,1) = " + max3(3,1,2));
        System.out.println("max3(3,2,1) = " + max3(3,2,3));
    }
}

// 연습문제 1
class practice{

    static int max4(int a, int b, int c, int d){
        int max = a;

        if (b > max)
            max = b;
        if (c > max)
            max = c;
        if (d > max)
            max = d;
        return max;
    }

    // 연습문제 1-2
    static int max3(int a, int b, int c){
        int min = a;

        if (b < min)
            min = b;
        if (c < min)
            min = c;
        return min;
    }
    // 연습문제 1-3
    static int min4(int a, int b, int c, int d){
        int min = a;

        if (b < min)
            min = b;
        if (c < min)
            min = c;
        if (d < min)
            min = d;
        return min;
    }

    public static void main(String[] args) {
        System.out.println();
    }

}
