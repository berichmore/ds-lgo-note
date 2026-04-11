package Doit.chapter04;

public class IntStackEx {
    private int[] stack;
    private int pointer;
    private int capacity;

    // 예외처리
    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() { }
    }

    // 실행 시 예외 : 스택이 가득 참
    public class OverFlowIntStackException extends RuntimeException {
        public OverFlowIntStackException() { }
    }

    // 생성자
    public IntStackEx(int maxlength) {
        pointer = 0;
        capacity = maxlength;
        try {
            stack = new int[capacity];
        } catch (OutOfMemoryError e) {
            capacity = 0;
        }
    }
    // Method


    // push()
    public int push(int x) throws OverFlowIntStackException {
        if (pointer >= capacity) {
            throw new OverFlowIntStackException();
        }
        return stack[pointer++];
    }

    // pop()
    public int pop() throws EmptyIntStackException {
        if (pointer <= 0) {
            throw new EmptyIntStackException();
        }
        return stack[--pointer];
    }
    // peek()
    public int peek() throws EmptyIntStackException {
        if (pointer <= 0) {
            throw new EmptyIntStackException();
        }
        return stack[pointer - 1];
    }

    // 스택 초기화

    public void clear() {
        pointer = 0;
    }

    public int indexOf(int x) {
        for (int i = pointer - 1; i >= 0; i--) {
            if (stack[i] == x)
                return i;
        }
        return -1;
    }

    // 스택 용량을 반환
    public int getcapacity() {
        return capacity;
    }

}
