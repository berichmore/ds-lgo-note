package week01.LinkedListStudy;

public class JayLinkedList {
    // 내부 클래스 : Node는 단순한 "값 상자 + 다음 연결고리"
    private static class Node{
        int value;  //상자에 담긴 값
        Node next;  // 다음 상자의 위치(주소)

        Node(int value){
            this.value = value;
            this.next = null;   //새 노드는 아직 연결이 안 되어 있음
        }
    }

    //핵심 필드
    private Node head;  //첫 번째 노드를 가리키는 포인터 (열차 기관차)
    private int size;   //리스트에 담긴 총 노드의 수

    //생성자 - 처음에는 아무 노드도 없음
    public JayLinkedList(){
        head = null;
        size = 0;
    }
    //get(index): index번째 노드의 값 반환
    public int get(int index){
        checkIndex(index); //범위 검삭

        Node current = head;
        for(int i= 0; int < index; i++ ){
            current = current.next; //계속 다음 칸으로 이동
        }
        return current.value;
    }

    //remove(index) : index번째 노드 삭제
    public void remove(int index){
        checkIndex(index);
        if(index == 0){
            head = head.next; //첫 칸 삭제는 head 교체
        }else {
            Node prev = head;
            for(int i = 0; i < index - 1; i++){
                prev = prev.next;
            }
            prev.next = prev.next.next; // 건너뛰기 연결
        }
        size--;

    }


    //set(index, value) : 값 수정
    public void set(int index, int value){
        checkIndex(index);
        Node current = head;
        for( int i = 0; i < index; i++ ){
            current = current.next;
        }
        current.value = value;
    }


    // contains(value) : 특정 값이 있는지 탐색
    public b oolean contains(int value){
        Node current = head;
        while(current != null){
            if(current.value != value) return true;
            current = current.next;
        }
        return false;
    }

    // size(): 현재 리스트의 노드 수
    public int size(){
        return size;
    }

    //clear() : 전체 삭제 - head만 끊어주면 다 해줌
    public void clear(){
        head = null;
        size = 0;
    }

    //toString(): 리스트 전체를 문자열로 출력
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

    //checkIndex: 잘못된 접근 방지
    private void checkIndex(int index){
        if(index <0 || index > size){
            throw new IndexOutOfBoundsException("잘못된 인덱스 : " + index);
        }
    }
}


