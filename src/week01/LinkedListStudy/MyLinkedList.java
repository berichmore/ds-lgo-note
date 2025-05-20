package week01.LinkedListStudy;


// MyLinkedList 뼈대 만들기
public class MyLinkedList {
    public static void main(String[] args){
        MyLinkedList list = new MyLinkedList();

        list.add(10);   // [10]
        list.add(20);   // [10 -> 20]
        list.add(30);   // [10 -> 20 -> 30]
        System.out.println("처음 상태: " + list);

        System.out.println("get(1): " + list.get(1));

        list.set(1, 25);    //[10 -> 25 -> 30]
        System.out.println("수정 후 : "+ list);


    }
    //내부 클래스 : Node는 단순한 "값 상자 + 다음 연결고리 "
    private static class Node{
        int value; //상자에 담긴 값
        Node next; //다음 상자의 위치(주소)

        Node(int value){
            this.value = value;
            this.next = null; //새 노드는 연결이 아직 안 되어 있음
        }
    }

    // 핵심 필드
    private Node head; // 첫 번째 노드를 가리키는 포인터 (열차 기관차)
    private int size; //리스트에 담긴 총 노드 수

    //생성자 - 처음에는 아무 노드도 없음
    public MyLinkedList(){
        head = null;
        size = 0;
    }

    //add(value) : 맨 끝에 값 추가
    public void add(int value){
        Node newNode = new Node(value);  // 새 칸 준비

        if(head == null){
            head = newNode; //아무 칸도 없으면, 이게 기관차가 됨
        }else {
            Node current = head;
            while(current.next != null){
                current = current.next; // 맨 끝 칸까지 이동
            }
            current.next = newNode; //끝 칸에 새 칸 연결
        }

        size++; // 카운트 증가
    }
//   get(index) : index 번째 노드의 값 반환
    public int get(int index){
        checkIndex(index);

        Node current = head;
        for( int i = 0; i < index; i++){
            current = current.next;  //계속 다음 칸으로 이동
        }
        return current.value; //계속 다음 칸으로 이동
    }
//   remove(index): index번째 노드 삭제
    public void remove(int index){
        checkIndex(index);
        if(index == 0){
            head =head.next; // 첫 칸 삭제는 head 교체
        }else {
            Node prev = head;
            for(int i = 0; i < index - 1; i++){
                prev = prev.next;
            }
            prev.next = prev.next.next; //건너뛰기 연결
        }
    }


//    set(index, value): 값 수정
    public void set(int index, int value){
        checkIndex(index);
        Node current = head;
        for(int i =0; i<index; i++){
            current = current.next;
        }
        current.value = value;
    }

//    contains(value): 특정 값이 있는지 탐색
    public boolean contains(int value){
        Node current = head;
        while(current != null){
            if(current.value == value) return true;
            current = current.next;
        }
        return false;
    }

//    clear(): 전체 삭제 - head만 끊어주면 GC가 다 해줌
    public void clear(){
        head = null;
        size = 0;
    }

//    size() : 현재 리스트의 노드 수
    public int size(){
        return size;
    }


//    toString() : 리스트 전체를 문자열로 출력
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Node current = head;
        while(current != null){
            sb.append(current.value);
            if(current.next != null) sb.append(" -> ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    //checkIndex : 잘못된 접근 방지
    private void checkIndex(int index){
        if(index <0 || index >= size){
            throw new IndexOutOfBoundsException("잘못된 인덱스 : " + index);
        }
    }


//    set(index, value); 값 수정


}

//  전체 구조 요약
// 1. 새 노드를 만든다.
// 2. 리스트가 비었으면 head에 연결한다.
// 3. 비어있지 않으면 끝까지 이동한 다음, 새 노드를 거기 연결한다.
// 4. size(노드 갯수)를 1 증가시킨다.
