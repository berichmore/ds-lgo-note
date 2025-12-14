package Study.week01.LinkedListStudy.whyStack;

public class ArrayStack implements Stack{
    private int[] data;
    private int top;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayStack(){
        this.data = new int[DEFAULT_CAPACITY];
        this.top = -1;
    }


    @Override
    public void push(int value) {
        if(top == data.length -1){
            throw new RuntimeException("스택이 가득 찼습니다.");
        }
        data[++top] = value;

    }

    @Override
    public int pop() {
        if(isEmpty()){
            throw new RuntimeException("스택이 비어 있습니다.");
        }
        return data[top--];
    }

    @Override
    public int peek() {
        if(isEmpty()){
            throw enw RuntimeException("스택이 비어 있습니다.");
        }
        return data[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public int size() {
        return top + 1;
    }
}
