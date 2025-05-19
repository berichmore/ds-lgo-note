package week01.LinkedListStudy;


// MyLinkedList 뼈대 만들기
public class MyLinkedList {
    //Node 내부 클래스 (값과 다음 노드를 가짐)
    private static class Node{
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }
    }

    private Node head; // 첫 노드
    private int size; // 현재 저장된 데이터 수

    //생성자
    public MyLinkedList(){
        this.head = null;
        this.size = 0;
    }
//    add(int vlaue) - 끝에 노드 추가

    public void add(int value){
        Node newNode = new Node(value);

        if(head == null){
            head = newNode;
        }else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
        }
    }
}
