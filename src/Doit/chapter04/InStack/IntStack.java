package Doit.chapter04.InStack;

public class IntStack {
    private int[] stack; // 스택용 배열
    private int capacity; // 스택 용량
    private int pointer;    // 스택 포인터

    // 실행 시 예외 : 스택이 비어있음
    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() { }
    }

    // 실행 시 예외: 스택이 가득 참
    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() { }
    }

    // 생성자
    public IntStack(int maxleng) {
        pointer = 0;
        capacity = maxleng;
        try {
            stack = new int[capacity];  // 스택 본체용 배열을 생성
        } catch (OutOfMemoryError e) {  // 생성될 수 없음
            capacity = 0;
        }
    }

    public int push(int x) throws OverflowIntStackException {
        if (pointer >= capacity)
            throw new OverflowIntStackException();
        return stack[pointer++] = x;
    }

    public int pop() throws EmptyIntStackException {
        if (pointer <= 0)   // Stack이 비어있을 때
            throw new EmptyIntStackException();
        return stack[--pointer];
    }
    public int peek() throws EmptyIntStackException {
        if (pointer <= 0)
            throw new EmptyIntStackException();
        return stack[pointer - 1];
    }

    // 스택 초기화
    public void stackClear() {
        pointer = 0;
    }

    // Stack에서 x를 찾아 인덱스(없으면 -1)를 반환
    public int indexOf(int x) {
        for (int i = pointer - 1; i >= 0; i--) { // 꼭대기 쪽부터 선형 검색
            if (stack[i] == x)
                return i;   // 검색 성공
        }
        return -1;  //검색 실패
    }

    // 스택 용량을 반환
    public int getCapacity() {
        return capacity;
    }


    // p.139 실습 4-1 [F]

    // 스택에 쌓여 있는 데이터 개수를 반환
    public int size() {
        return pointer;
    }

    // 스택이 비어 있는가?
    public boolean isEmpty() {
        return pointer <= 0;
    }

    // 스택이 가득 찼는가?
    public boolean isFull() {
        return pointer >= capacity;
    }

    // 스택 안의 모든 데이터를 바닥 -> 꼭대기 순서로 출력
    public void dump() {
        if (pointer <= 0) {
            System.out.println("스택이 비어있습니다.");
        } else {
            for (int i = 0; i < pointer; i++ ) {
                System.out.println(stack[i] + " ");
            }
            System.out.println();
        }
    }





}
