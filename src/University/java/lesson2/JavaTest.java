package University.java.lesson2;

public class JavaTest {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 0;

        try{
            int result = num1 / num2;
            System.out.println("결과: " + result);
        } catch (ArithmeticException e) {
            System.out.println("프로그램 종료");
        }
    }
}
