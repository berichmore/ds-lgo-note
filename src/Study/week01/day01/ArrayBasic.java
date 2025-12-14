package Study.week01.day01;

public class ArrayBasic {
    public static void main(String[] args) {
        /*
         * 📌 문제명: 배열 요소 출력
         * ✨ 개념 키워드: 배열, 반복문, 인덱스
         *
         * 📘 개념 설명:
         *     - 배열은 같은 타입의 값을 여러 개 연속된 메모리에 저장하는 자료구조
         *     - 인덱스를 통해 각 요소에 빠르게 접근할 수 있음 (O(1))
         *     - 크기가 고정되어 있으며, 반복문과 함께 자주 사용됨
         *     - 배열의 길이는 .length로 확인
         *
         * 🎯 문제 설명:
         *     - int[] nums = {3, 7, 1, 9, 5}
         *     - 각 요소를 "nums[i] = 값" 형태로 출력
         *
         * 🧠 배운 문법:
         *     - 배열 선언: int[] nums = {...};
         *     - 반복문: for (int i = 0; i < nums.length; i++) ...
         *     - 출력문: System.out.println(...)
         *
         * 🔍 풀이 아이디어:
         *     - 배열의 크기만큼 반복
         *     - 각 인덱스의 값을 그대로 출력
         *
         * 🧑‍💻 작성자: Jay (코드 직접 구현)
         * 🗓️ 날짜: 2025-04-09
         */






        //void 와 return의 차이가 뭐야?

        //실전문제
//        지금처럼 void와 return 차이를 확실히 익히는 최고의 방법은
//        두 가지 방식으로 같은 기능을 구현해보는 거야.
//
        //✍️ 실전 문제: 두 수를 더하는 프로그램
        //🎯 문제 설명
//        두 개의 정수 a, b가 주어졌을 때,
//        다음 두 가지 방식으로 결과를 출력하는 프로그램을 작성하시오.
//
        //✅ 1. void를 사용하는 방식
//        printSum(int a, int b) 라는 메서드를 만들어라.
//
//                a + b 값을 System.out.println()으로 출력만 하자.
//
        //✅ 2. return을 사용하는 방식
//        getSum(int a, int b) 라는 메서드를 만들어라.
//
//                a + b 값을 return해서,
//
//        main() 메서드 안에서 결과를 받아 출력하자.

//        🎯 목표
//        Jay가 직접 두 방식으로 코드를 작성
//
//        주석 템플릿도 붙여서 정리
//
//        두 방식의 차이를 느껴보고, 어떤 상황에서 return이 필요한지 감을 잡자

//        1




//    }
//    public static void getSum(int a, int b){
//        System.out.println(a + b);


        //여태 이렇게 했었으니 자바가 실행이 안됐었다 잘 기억해두자.
        //main 메서드 안에두면 안됨!
//            -이유
//                    1. '자바는 함수 안에 함수를 만들 수 없다!' 는 규칙이 있다 (중첩 함수 정의 금지)


//        public class MyClass {
//            public static void main(String[] args) {
//
//                // 이렇게 메서드를 'main 메서드 안에서 정의'하면 자바 문법 오류!
//                public static void sayHello() {  // ❌ 불가능
//                    System.out.println("Hello");
//                }
//            }
//        }

//        ✅  1. "함수"란 뭐야?
//        함수(Function)는 **어떤 입력(값)**을 받아서,
//                어떤 작업을 한 다음,
//                그 결과를 반환하거나(또는 그냥 수행만 하거나)
//        그걸 이름을 붙여서 계속 재사용할 수 있는 코드 묶음이야.
//        진짜 생활 예시
//                java
//        복사
//                편집
//        public static void sayHello() {
//            System.out.println("Hello!");
//        }
//        이건 "sayHello"라는 **함수(또는 메서드)**를 만들어서,
//                누군가 sayHello();라고 부르면 실행되는 동작이야.
//
//        ✅ 2. 자바에서는 "함수"와 "메서드"는 사실상 같다!
//                하지만 정확히 말하면:
//
//        용어	의미
//        함수(Function)	일반적인 "코드 묶음" (언어 전반에서 쓰임)
//        메서드(Method)	클래스 안에 있는 함수, 자바에선 모두 메서드라고 부름
//          ➡ 자바는 클래스 기반 언어라서
//        "함수"란 말보다는 메서드라는 표현을 써!
//
//        ✅ 3. 메서드 소괄호 ( ) 는 왜 붙어?
//                이게 진짜 중요한 질문인데…
//
//        소괄호는 "이 메서드가 동작할 때 필요로 하는 값들(매개변수)"을 넣는 곳이야.
//
//                java
//
//
//        public static int sum(int a, int b)
//        (int a, int b)는 이 메서드를 실행할 때 필요한 값이 2개라는 의미
//
//        그리고 그걸 호출할 때 sum(3, 5) 이렇게 소괄호에 넣어서 보내는 거야
//
//            🧠 아주 단순화하면:
//        만드는 쪽에서는 (매개변수 목록)을 적고,
//
//        **부르는 쪽(호출)**에서는 (인자 목록)을 전달해
//
//
//
//
//// 정의
//        public static void greet(String name) {
//            System.out.println("안녕 " + name);
//        }
//
//// 호출
//        greet("Jay");  // 👉 "Jay"가 name으로 전달됨
//✅ 4. "호출"은 자동으로 되는 게 아냐!
//                Jay가 했던 말:
//
//        "메서드를 만들면 당연히 호출도 생기는 거 아냐?" → ❌
//
//        Nope! 직접 호출해줘야 해!
//
//                java
//        복사
//                편집
//        public static void hello() {
//            System.out.println("Hi!");
//        }
//
//        public static void main(String[] args) {
//            hello();  // 여기서 직접 호출해줘야 실행돼!
//        }
//        만들기만 해선 절대 실행되지 않음.
//                꼭 호출해야 동작해.
//
//🔁 핵심 정리
//        개념	설명
//        함수	어떤 작업을 수행하는 코드 묶음
//        메서드	자바에서 "클래스 내부에 정의된 함수"
//        소괄호 ()	매개변수를 전달하는 곳 (필요 없어도 생략 불가!)
//        호출	메서드를 직접 실행하는 것 (만들기만 하면 실행 안 됨!)
//        Jay, 이걸 한 번 딱 이해하고 나면
//        앞으로 어떤 메서드를 보더라도 "아 이건 어떤 기능이고, 실행하려면 내가 불러야겠구나" 하고
//        구조가 보이기 시작할 거야.


                                    //        그렇다면 함수를 만들 때 넣은 매개변수가
                                    //        그 함수 메서드 안에서 매개역할을 하는 것들을 인자라고 하는거야?
                                    //        곧 매개변수로 임명을 하고 그 안에서는 그것을 인자라고 다시 칭하는거야?
                                    //
                                    //        그리고 호출을 말했던 것은 자동호출이 되냐는 의미가 아니라
                                    //        함수를 만들면 매개변수를 넣을 소괄호 ()를 만들잖아 그럼 이건 언제든 호출받을 준비가 된 상태라는거고
                                    //        메서드나 함수는 다른 곳에서 써야하니까 당연히 호출받을 준비를 해놔야하고 그걸
                                    //        소괄호로 표시를 해둔건가??
                                    //
                                    //        내가 잘 이해하고 있어?  -> 거의 맞다 함
                                    //

        //



//        int [] numbers = {10, 20, 30};
//        System.out.println(numbers[0]);
//        System.out.println(numbers.length);



//        문제 1
//        int[] nums = {3, 7, 1, 9, 5};
//
//        System.out.println("nums[0] = "+nums[0]);
//        System.out.println("nums[1] = "+nums[1]);
//        System.out.println("nums[2] = "+nums[2]);
//        System.out.println("nums[3] = "+nums[3]);
//        System.out.println("nums[4] = "+nums[4]);
//
//        for(int i = 0; i< nums.length; i++){
//            System.out.println("nums [" + i + "] = " + nums[i]  );
//        }
//            2. 심화문제 1
//        int [] nums = {4, 7, 2, 9, 6, 1};
//
//        for (int i = 0;  i < nums.length; i++){
//            if(nums[i] % 2 == 0) {
//                System.out.println("nums[" + i + "] = " + nums[i]);
//            }
//        }












    }

}
