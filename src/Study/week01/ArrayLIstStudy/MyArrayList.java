package Study.week01.ArrayLIstStudy;

public class MyArrayList {
    public static void main(String[] args){
        MyArrayList list = new MyArrayList();

//        for(int i = 0; i < 15; i++){
//            list.add(i * 10 );
//            System.out.println("추가된 값 : " + list.get(i) + ",size: " + list.size());
//        }

        //값 추가
        list.add(10);
        list.add(20);
        list.add(30);
//        list.add(40);
//
//
//
//
        //값 출력
        System.out.println("0번 인덱스" + list.get(0)); //10
        System.out.println("1번 인덱스" + list.get(1)); //20
        System.out.println("2번 인덱스" + list.get(2)); //30
        System.out.println("3번 인덱스" + list.get(3)); //40

//        //삭제 테스트
//        list.remove(1);
//
//        //삭제 후 출력
//        System.out.println("1번 인덱스 삭제 후: ");
//        for(int i = 0; i<list.size(); i++){
//            System.out.println(i + "번 인덱스 : " + list.get(i));
//        }
//        //현재 사이즈
//        System.out.println("현재 크기 : " +  list.size());


    }
    private int[] data; //데이터를 저장할 배열
    private int size;  // 현재 저장된 데이터 수

    private static final int DEFAULT_CAPACITY = 10;

    //생성자 - 기본 크기의 배열 생성
    public MyArrayList(){
        this.data = new int[DEFAULT_CAPACITY];
        this.size = 0;
    }
    //여기까지가 생성자 + 기본 필드 설정단계
    //이제 핵심 메서드 구현 - 배열 끝에 요소 추가

    //새로운 값 추가
    public void add(int value){
        ensureCapacity(); //배열 공간이 부족하면 확장.
        data[size] = value;
        size++;
    }

    //내부 배열이 꽉 찼는지 확인하고 필요하면 확장
    private void ensureCapacity(){
        if(size >= data.length){
            int newCapacity = data.length * 2;
            int[] newData = new int[newCapacity];

            //배열 복사
            for(int i =0; i < data.length; i++){
                newData[i] = data[i];
            }
            data = newData;
        }
    }

    //이걸 하면서 터득해야 하는 포인트
//    - 배열 크기가 찰 경우 -> 복사 비용이 크다는 것
//    - "System.arraycopy() 대신 for문으로 직접 구현하면서 감각 익히기"

    //단계 : get 메서드 구현 - 인덱스로 데이터 가져오기
    public int get(int index){
        checkIndex(index);  //잘못된 인덱스 접근 방지
        return data[index]; //배열에서 바로 꺼내기
    }
    private void checkIndex(int index){
        if( index < 0 || index >= size){
            throw new IndexOutOfBoundsException("인덱스 초과: " + index);
        }
    }
//    Java는 배열이 만들어진 크기보다 더 큰 index로 접근하면 프로그램이 터져버리기 때문에
//    ArrayIndexOutOfBoundsException 이 발생함
//    그런데 우리가 만드는 건 MyArrayList, 즉
//    직접 만든 배열 관리 클래스이기 때문에...
//    너무 크거나 작은 건 직접 막아줘야 함
//
//    그래서
//    무조건 익혀야 할 점 :
//    배열은 O(1) 시간으로 접근 가능
//    "index 검사는 직접 해줘야 함"
//
//
//     4단계 : remove 메서드 구현 - 인덱스로 삭제하고 뒤로 당기기
//    배열의 치명적인 단점을 직접 체감하게 해주는 메서드.
//    이번엔 "느리다"는 말이 단순 이론이 아니라 진짜 코드로 느껴지는 경험이 되도록 설명해줌

    public void remove(int index) {
        checkIndex(index);  //인덱스 유효성 검사

        //하나씩 앞으로 당기기
//        삭제 위치 이후의 요소들을 한 칸씩 앞으로 당김
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--; // 전체 데이터 개수 하나 줄임
    }
//    왜 이게 중욯나가?
//    배열의 중간 삭제는 왜 느릴까?
//    ->  배열은 공간을 연속적으로 쓰기 때문에
//        중간에 하나 빼면 그 이후 모두를 한 칸씩 옮겨줘야 함

//    시간복잡도 체감
//    - 최악의 경우 : remove(0)  (맨 앞 삭제) -> 모든 요소 다 이동 -> 0(n)
//    - 평균적 상황 : 절반쯤 삭제 -> n/2번 이동 -> 여전히 0(n)
//    - 최선의 경우 : remove(size-1) (맨 끝 삭제) -> 이동 없음 -> 0(1)

//    -> 하지만 전체적으로 보면 평균적으로 느리다.

//      반드시 체득해야 할 핵심 요점
//     -> 배열의 단점  - 중간에 삽입/삭제 시 모든 요소를 밀거나 당겨야 함
//     -> 시간 복잡도  - remove(index)는 최악의 경우 O(n)
//     -> 직접 느껴보기 - for문 을 써서 요소를 하나씩 복사하는 작업이 얼마나 많은지 확인 가능
//     - > 왜 느린가?  - 배열은 공간이 "쭉 이어져"있어서 비워진 공간을 메워야 함

//     그렇다면 LinkedList는 왜 이런 상황에 강할까?
//     - 연결 리스트는 노드만 연결되어 있어서 중간 삭제 시 이동이 없음.
//     - 그래서 remove(index)는 배열보다 빠를 수 있어 (삽입/삭제에선 유리)

    public int size(){
        return size;
    }

//    내부적으로 무슨 일이 있었나?
//     우린 MyArrayList 클래스에서 데이터를 추가하거나 삭제할 때마다
//    size라는 필드를 이렇게 조작해왔어:
//    - add() -> size++
//    - remove() -> size--
//    즉, size는 항상 ** 현재까지 꽉 찬 서랍의 개수 **를 의미해

}









































