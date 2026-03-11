package University.java.lesson2;

public class gradeOutPut {
    public static void main(String[] args) {
        Grade g1, g2;       // 두 명의 성적을 표현하는 객체
        g1 = new Grade();       // 객체 생성
        g2 = new Grade();       // 객체 생성

        g1.input_grade(90,85);
        g2.input_grade(80,80);

        g1.output_grade();  // 총점 출력
        g2.output_grade();
    }
}


class Grade {
    int e;      // 영어 성적
    int m;      // 수학 성적

    void input_grade(int a, int b) {
        e = a;
        m = b;
    }

    void output_grade() {
        System.out.println(e+m);
    }
}