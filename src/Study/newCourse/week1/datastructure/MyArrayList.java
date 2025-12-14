//package Study.newCourse.week1.datastructure;
//
//
//import static com.sun.tools.javac.util.ArrayUtils.ensureCapacity;
//import static java.util.Objects.checkIndex;
//
//public class MyArrayList {
//    private int[] data; // 데이터를 저장할 배열
//    private int size; //현재 저장된 데이터 수
//
//    private static final int DEFAULT_CAPACITY = 10;
//
//    //생성자 - 기본 크기의 배열생성
//    public MyArrayList(){
//        this.data = new int[DEFAULT_CAPACITY];
//        this.size = 0;
//    }
//    // 새로운 값 추가
//    public void add(int value){
//        ensureCapacity();    //배열 공간이 부족하면 확장 / 공간확인 -> 부족하면 학장
//        data[size] = value;  // 현재 size 위치에 값 저장
//        size++;              // 요소 개수 증가
//    }
//
//    //내부 배열이 꽉 찼는지 확인하고 필요하면 확장
//    private void ensureCapacity(){
//        if(size >= data.length){
//            int newCapacity = data.length * 2;
//            int[] newData = new int[newCapacity];
//
//            //배열 복사
//            for(int i = 0; i< data.length; i++){
//                newData[i] = data[i];
//            }
//            data = newData;
//        }
//    }
//    //이걸 하면서 체득해야 하는 포인트 :
////    - "배열 크기가 찰 경우 복사 비용이 크다는 것"
////    - "System.arraycopy() 대신 for문으로 직접 구현하면서 감각 익히기
//
////    3단계 : get 메서드 구현 - 인덱스로 데이터 가져오기
//    public int get(int value){
//        checkIndex(index);
//        return data[index];
//    }
//
//    private void checkIndex(int index){
//        if (index < 0 || index >= size){
//            throw new IndexOutOfBoundsException("인덱스 초과: " + index);
//        }
//    }
//
////    무조건 익혀야 할 점
////    배열은 O(1) 시간으로 접근 가능
////    index 검사는 직접 해줘야 함
//}
//
