package Doit.chapter04.Queue;

    /*
    private int[] queue
    private int capacity
    private int pointer

    enQueue()
    deQueue()
    front()  ??
    rear()   ??
    clear()

     */

public class IntQueue {
    private int[] queue;    //큐용 배열
    private int capacity;   // 큐의 용량
    private int front;      // 맨 앞의 요소 커서
    private int rear;       // 맨 뒤의 요소 커서
    private int num;        // 현재 데이터 개수

    // 실행 시 예외 : 큐가 비어 있음
    public class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() { }
    }

    // 실행 시 예외: 큐가 가득 참
    public class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() { }
    }

    // 생성자
    public IntQueue(int maxlen) {
        num = front = rear = 0;
        capacity = maxlen;
        try {
            queue = new int[capacity];  // 큐 본체용 배열을 생성
        } catch (OutOfMemoryError e) {  // 생성할 수 없음
            capacity = 0;
        }
    }

    // 큐에 데이터를 인큐
    public int enqueue(int x) throws OverflowIntQueueException {
        if (num >= capacity) {
            throw new OverflowIntQueueException();
        }
        queue[rear++] = x;
        num++;

        if (rear == capacity) {
            rear = 0;
        }
        return x;
    }

    // 큐에서 데이터를 디큐
    public int dequeue() throws EmptyIntQueueException {
        if (num <= 0) {
            throw new EmptyIntQueueException();
        }
        int x = queue[front++];
        num--;

        if (front == capacity) {
            front = 0;
        }
        return x;
    }
}
