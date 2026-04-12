package Doit.chapter04;

public class IntStackEx {
    private int[] stack;
    private int capacity;
    private int pointer;

    // 실행 시 예외 : 스택이 비어있을 때
    public class EmptyStackException extends RuntimeException {
        public EmptyStackException() { }
    }

    // 실행 시 예외 : 스택이 가득 참
    public class StackOverFlowIntException extends RuntimeException {
        public StackOverFlowIntException() { }
    }

    // 생성자
    public IntStackEx(int maxleng) {
        pointer = 0;
        capacity = maxleng;
        try {
            stack = new int[capacity];  // 스택 본체용 배열을 생성
        } catch (OutOfMemoryError e) {
            capacity = 0;
        }
    }

    // 메서드

    // psuh
    public int push(int x) throws StackOverFlowIntException {
        if (pointer == capacity) {
            throw new StackOverFlowIntException();
        }
        return stack[pointer++] = x;
    }

    // pop
    public int pop() throws EmptyStackException {
        if (pointer <= 0) {
            throw new EmptyStackException();
        }
        return stack[--pointer];
    }

    // peek
    public int peek() throws EmptyStackException {
        if (pointer <= 0) {
            throw new EmptyStackException();
        }
        return stack[pointer - 1];
    }

    // 스택 초기화
    public void stackClear() {
        pointer = 0;
    }

    // Stack에서 x를 찾아 인덱스(없으면 -1)를 반환
    public int indexOf(int x) {
        for (int i = pointer -1; i >= 0; i--) {
            if (stack[i] == x)
                return i;  // 검색 성공
        }
        return -1;
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
            for (int i = 0; i < pointer; i++) {
                System.out.println(stack[i] + " ");
            }
            System.out.println();
        }
    }
}
