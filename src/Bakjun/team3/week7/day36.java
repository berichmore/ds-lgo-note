package Bakjun.team3.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class day36 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            Stack<Character> stack = new Stack<>();

            for(int j = 0; j < line.length(); j++){
                char c = line.charAt(j); //현재 내 손에 쥔 글자
                //핵심 로직
                // 스택이 비어있지 않고(!isEmpty)
                // 맨 위의 글자(peek)가 내 손의 글자(c)와 같다면
                if(!stack.isEmpty() && stack.peek() == c){
                    stack.pop();
                }else {
                    stack.push(c);
                }
            }

            if(stack.isEmpty()){
                count++;
            }
        }
        System.out.println(count);




    }
}

/* [도구 상자 준비] */
// 자바한테 "나 입출력(Input/Output) 할 때 에러 나면 처리할 도구 가져올게"라고 말함
import java.io.IOException;
// "글자를 빠르게 읽어들이는 도구(BufferedReader) 가져올게"
import java.io.BufferedReader;
// "키보드나 파일에서 읽어오는 연결 통로(InputStreamReader) 가져올게"
import java.io.InputStreamReader;
// "차곡차곡 쌓는 바구니(Stack) 도구 가져올게"
import java.util.Stack;

// 백준에서는 클래스 이름을 무조건 'Main'으로 해야 채점이 됨 (규칙)
public class Main {

    // 프로그램이 시작되는 출발점 (메인 메소드)
    // throws IOException: "혹시 입력받다가 에러 나면(예: 키보드 선이 뽑힘)
    // 내가 처리 안 하고 그냥 에러 메시지 띄우고 멈출게"라는 면책 조항
    public static void main(String[] args) throws IOException {

        // 1. 입력 도구 조립 (가장 빠른 읽기 도구)
        // System.in: 키보드와 연결된 전선
        // new InputStreamReader(...): 전선에서 들어오는 0과 1을 '글자'로 바꿔주는 번역기
        // new BufferedReader(...): 글자를 하나씩 읽으면 느리니까, '버퍼(바구니)'에 왕창 담아서 한 번에 읽는 기계
        // br: 이 완성된 기계의 이름표
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 2. 문제의 개수 N 받기
        // br.readLine(): 한 줄을 통째로 읽어옴 (문자열 "3")
        // Integer.parseInt(...): 문자열 "3"을 숫자 3으로 변환 (계산해야 하니까)
        // .trim(): 혹시 모를 공백 제거 (안전장치)
        int N = Integer.parseInt(br.readLine().trim());

        // 좋은 단어 개수를 셀 변수 (초기값 0)
        int count = 0;

        // 3. 단어 N개만큼 반복 (예: 3번 반복)
        // i는 0부터 시작해서 N보다 작을 때까지 하나씩 증가(i++)하며 돕니다.
        for(int i = 0; i < N; i++) {

            // 이번 차례의 단어를 읽어옵니다. (예: "ABBABB")
            // line이라는 변수(상자)에 "ABBABB"라는 글자가 들어갑니다.
            String line = br.readLine();

            // ★ 중요: 스택(대기실) 만들기
            // new Stack<>(): 새로운 바구니를 하나 창조함 (메모리에 공간 확보)
            // <Character>: "이 바구니에는 '글자(Character)'만 담을 거야"라고 라벨 붙임 (제네릭)
            // stack: 이 바구니의 이름
            // ※ 반복문 안에서 만드는 이유: 다음 단어로 넘어가면 바구니를 싹 비우고(새로 만들고) 시작해야 하니까!
            Stack<Character> stack = new Stack<>();

            // 4. 단어의 글자 수만큼 반복 (한 글자씩 뜯어보기)
            // line.length(): 단어의 길이 (예: 6글자면 6)
            // j는 0부터 5까지 감
            for(int j = 0; j < line.length(); j++) {

                // line.charAt(j): 단어에서 j번째 글자를 딱 하나 집어옴
                // c: 내 손에 쥐고 있는 현재 글자 (예: 'A' 또는 'B')
                char c = line.charAt(j);

                // ★ 핵심 로직 (조건문)
                // 조건 1: !stack.isEmpty() -> "바구니가 비어있지 않아야 함" (비어있는데 비교하면 에러 남)
                // 조건 2: stack.peek() == c -> "바구니 맨 위에 있는 놈(peek)이랑 내 손의 글자(c)가 똑같니?"
                if(!stack.isEmpty() && stack.peek() == c) {

                    // 두 조건이 다 맞으면? 짝이다!
                    // stack.pop(): 바구니 맨 위에 있는 놈을 꺼내서 없애버림 (폭파)
                    // 내 손에 있는 c는 바구니에 넣지도 않았으니 자연스럽게 소멸
                    // 결론: 둘 다 사라짐
                    stack.pop();

                } else {

                    // 바구니가 비었거나, 짝이 안 맞으면?
                    // stack.push(c): 내 손에 있는 글자를 바구니 맨 위에 얹음 (저장)
                    stack.push(c);
                }
            } // 안쪽 반복문 끝 (한 단어의 모든 글자 처리 끝)

            // 5. 판정 시간
            // stack.isEmpty(): "바구니가 텅 비었니?" (True/False)
            // 비었다는 건 모든 글자가 짝을 만나 사라졌다는 뜻 -> 좋은 단어!
            if(stack.isEmpty()) {
                count++; // 카운트 1 증가
            }

        } // 바깥쪽 반복문 끝 (모든 단어 처리 끝)

        // 최종 결과 출력
        System.out.println(count);
    }
}