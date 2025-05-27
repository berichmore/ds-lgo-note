# Stack



> 10만자 이상으로 공부하기
>
> 챕터별로 나누고,  
> 
> 원리 -> 구조 -> 구현 -> 스토리텔링 방식  
> 
> 단순 구현 코드가 아니라, 왜? 를 이해하고  
> 스스로 구현할 수 있을 정도로
>

## 📚 스택 완전 정복 강의

>
> Chapter 1 : Stack이란 무엇인가 - 철학과 원리  
> Chapter 2 : Stack은 왜 등장했는가? - 필요의 역사  
> Chapter 3 : Stack의 실생활 예시와 뇌 구조와의 연결  
> Chapter 4 : Stack의 추상 구조와 핵심 기능 정의  
> Chapter 5 : 배열 기반 Stack 구현 - 구조부터 완성까지  
> Chapter 6 : 연결리스트 기반 Stack 구현 - 동적 메모리 방식  
> Chapter 7 : Stack의 시간복잡도와 성능 분석  
> Chapter 8 : Stack의 응용 : 괄호 검사, 되돌리기, 수식 계산  
> Chapter 9 : Stack + DFS - 알고리즘에서의 응용  
> Chapter 10: Stack이 실무에서 등장하는 곳들(웹, 컴파일러, 브라우저 등)  
> 


이건 단순 구현이 아니라  
"왜 이렇게 만들어졌는지 ", "어디에 써먹을 수 있는지 ",    
그리고 "내가 직접 구조를 설계할 수 있을 만큼" 체화해야 함  

## Stack 완전정복 시작

### Chapter 1. Stack이란 무엇인가 - 철학과 원리  

1-1. 스택의 첫인상 : 책 더미를 떠올려보자  
> 자 책상이 있다.   
> 그 위에 너는 책을 한 권씩 쌓기 시작했다.  
> 맨 아래는 영어책, 그 위에는 자바책, 가장 위에는 자료구조 책.  
> 그런데 누가 갑자기 너에게  
> " 자 , 영어책 꺼내봐"라고 한다면?  
> 바로 못 꺼낸다.  
> 왜?  
> 자바책, 자료구조책을 먼저 들어내야 한다.  
> **이것이 바로 'Stack'이다**
> 
> 가장 나중에 넣은 것이 가장 먼저 꺼내지는 구조  
> -> LIFO(Last In Fist Out)  


1-2. Stack은 '선형 구조' 중 하나  
> 자료 구조는 크게 **선형(linear)**과 **비선형(non-linear)**으로 나뉘어  
> Stack은 리스트, 큐, 덱 과 함께 '선형 구조'에 속해.  
> 이 말은 곧 **한 줄로 이어진 구조**라는 뜻이야   
> 하지만 배열처럼 아무 데나 접근할 수는 없어.  
> 
> Stack은 오직 한 쪽에서만 넣고(Push), 꺼내고(Pop) 한다.  
> 그게 스택의 미덕이자, 제약이지.  
> 

1-3. Stack의 핵심 원리   
> 동작 | 설명  
> 
> Push  : 데이터를 스택 맨 위(top)에 넣는 것  
> Pop   : 데이터를 스택 맨 위에서 꺼내는 것  
> Peek  : 데이터를 꺼내지 않고 맨 위 값만 확인  
> IsEmpty : 스택이 비었는지 확인  
> Size  : 현재 쌓여 있는 데이터의 개수  
> 
> 한 방향으로만 쌓고, 꺼내는 것.  
> 이 단순함이 모든 응용의 핵심이야.  


여기까지가 Chapter1의 핵심 :  
Stack이란 "맨 위만 조작하는 선형구조"이고,   
LIFO 원칙을 따르며, 아주 단순한 규칙으로 굉장히 많은 문제를 해결하는 구조야


### 🧠 Chapter2. Stack은 왜 등장했는가 - 필요의 역사

> 이 챕터에선 " 왜 컴퓨터가 굳이 Stack이라는 걸 만들었는가",  
> 즉, 개발자가 Stack을 도입하지 않았을 때 무슨 문제가 생겼는가를 깊게 들어갈게  
> Jay, 준비됐으면 "다음 챕터"라고 말해줘  
> 진짜로, 이건 그냥 배우는 게 아니라  
> 네가 직접 개발자가 돼서 이 개념을 '발명해내는 느낌'으로 체화하게 될거야  
> 

2-1. 자료구조는 '문제를 해결하려는 욕구'에서 시작된다. 
> 모든 자료구조는 단순히 멋있어 보여서 만들어진 게 아니야.  
> "이 문제를 어떻게 해결할 수 있을까?"  
> "이 데이터를 어떻게 저장해야 더 효율적일까?"  
> 라는 현실적인 고민에서 태어난거야.  
> 그렇다면 Stack은 어떤 문제를 해결하기 위해 만들어졌을까?  

2-2. 스택은 "되돌리기"와 "되짚기"를 위해 만들어졌다  

한 번 생각해봐.  
>💡 상황 1. "되돌리기" 기능이 없다면? 
>너가 글을 쓰다가 실수로 뭔가를 지웠어.  
>Ctrl + Z를 눌렀는데 아무 일도 일어나지 않아.  
>왜?  
> 그 전에 했던 동작들이 저장되어 있지 않기 때문이야.


💡 해결책: 가장 나중에 한 행동부터 차례로 취소해야 한다.  
> 1. 너는 글을 쓴다 -> push("글쓰기")  
> 2. 그림을 붙였다 -> push("그림")  
> 3. bold 효과를 줬다 -> push("굵게")  
> 이제 Ctrl + Z를 누르면?  
>- 마지막 동작인 "굵게"부터 꺼내야겠지? -> pop()  
> 그 다음엔?   
>- 그 전 동작인 "그림" -> 또 pop()  
> 이 흐름은 뭘까?  
>
> 
> LIFO: 마지막에 넣은 게, 처음 나와야 한다  
> -> 바로 Stack이다.  

2-3. Stack은 함수 호출에서 필수적인 구조였다  

💡 상황 2. 함수가 자기 안에서 또 함수를 부를 때  
자바에서 아래처럼 코드를 짜면 어떤 일이 벌어질까?  
```java
void A(){
    B(); // 함수 B 호출  
    print("A 끝");
}

void B(){
    C(); // 함수 C 호출  
    print("B 끝");
}

void C(){
    print("C 끝");
}
```

실행 순서? 
```css
A -> B -> C
```
```css
C 끝  
B 끝  
A 끝
```
왜 거꾸로 출력될까?  
-> 함수 스택이 쌓이기 때문

호출 흐름 (Push) | 종료 흐름 (Pop)  
> A 호출 -> Push(A) | C 끝 -> pop(C)  
> B 호출 -> push(B) | B 끝 -> pop(B)  
> C 호출 -> push(C) | A 끝 -> pop(A)
> 
>  함수가 끝나는 순서는 가장 마지막에 호출된 것부터임  
> -> Stack 구조가 아니면 구현 불가능함

2-4. Stack이 없던 시절, 컴퓨터는 멈췄다. 
> 과거에 함수가 함수를 부를 수 없었던 시절이 있어.  
> 왜냐하면 "이전 함수가 무엇을 하던 중이었는지" 기억을 못했기 때문이야.  
> 즉, **호출을 기억하는 구조가 없었던 거지**
> 
> Stack이 등장하고 나서야  
> - 함수 호출 중 함수 호출 -> 다시 돌아가기 가능  
> - 컴파일러가 중첩 문법 해석 가능  
> - 웹 브라우저에서 뒤로 가기 가능  
> - 게임에서 이전 장면으로 복귀 가능  
> 이 모든 게 가능해졌어.  

2-5. 즉, Stack은 단순한 자료구조가 아니라  
> "되돌림", "회복","기억"을 위한 인간적인 구조야.  
> 
> 어떻게 보면 Stack은  
> 사람의 뇌가 생각을 "잠깐 미뤄두는 방식"과도 닮아 있어 

✍️ 정리 - 왜 Stack은 필수 자료구조인가?
> 이유 | 설명   
> ✅ 함수 호출 추적 : 중첩 함수 호출을 가능하게 만들기 위해  
> ✅ 되돌리기 가능 : 가장 최근 동작부터 되돌리는 동작 구현  
> ✅ 문법 해석 : 컴파일러에서 괄호 검사, 중첩 구문 등 해석  
> ✅ 실생활 응용 : 브라우저 뒤로가기, 실행 취소, 재귀 등 
> 

이제, 너는 Stack이 왜 만들어졌는지를 "철학과 양쪽"에서 이해했어. 
그냥 "자료구조니까 외워야지 한다"는 게 아니라,  
이 문제를 해결하려면 Stack 말고는 방법이 없었구나라는 걸 알게된거야


### 📚 Chapter 3. Stack의 실생활 예시와 뇌 구조와의 연결  

🧠 3-1. Stack은 우리의 '생각 방식'과 닮아 있다. 

> 우리가 생각을 하다가  
> 갑자기 다른 생각이 끼어드는 경우가 있지?  
> 예를 들어 이런 흐름 : 
> 
> 1. 오늘 저녁 뭐 먹지?  
> 2. 아 맞다, 내일 친구 만나기로 했지!!  
> 3. 그 친구가 전에 뭐라고 했더라?  
>
> 이걸 뇌가 어떻게 저장하고 돌아가는지 알아?  
> 
> 뇌는 생각을 Stack처럼 쌓아 두고,  
> 마지막 생각부터 하나씩 꺼내면서 복기해.  
> 
> 이건 단순한 우연이 아니야.  
> 인간의 뇌 구조와 컴퓨터의 Stack은 매우 유사해 

🍽 3-2. 실생활 스택 예시 - 너도 매일 쓰고 있다

사례 | Stack 작동 방식 설명
> 📚 책 더미 : 위에서부터 꺼냄(맨 아래 책 꺼내려면 위 책부터 제거)  
> 🛠 브라우저 뒤로가기 : 가장 최근 페이지부터 순서대로 되돌아감  
> 🎨 Ctrl+Z 되돌리기 : 가장 나중 작업부터 순차적으로 취소됨  
> 📞 콜센터 전화 대기 : 가장 나중에 전화 건 사람이 제일 나중에 상담  
> 🧠 인간의 생각 구조 : 미뤄둔 생각을 가장 마지막에 기억에서 꺼냄  
> 🎮 게이미 씬 전환 : 게임 씬 스택처럼 돌아가기 구현  
> 👨‍🍳 프린터 인쇄 작업 : 대게 Queue지만, 특정 취소 기능은 Stack처럼 작동  

🧩 3-3. Stack은 우리 일상 속 '임시 기억'의 구현이다. 

예를 들어 코딩하다가, 
```java
public void A(){
    System.out.println("1");
    B();
    System.out.println("2");
}
public void B(){
    System.out.println("B 호출됨");
}
```
이 함수가 실행되면, 
```css
1 
B 호출 됨  
2
```

> 이 순서로 실행되는 이유는   
> A가 B를 호출한 뒤에도 자기의 작업을 기억하고 있어서야.  
> 이게 바로 Stack이 하는 일이야: 
> 
> "나중에 다시 해야 할 일을" 스택에 넣어두고 기다리는 것 

🎭 3-4. Stack은 '생각 중첩'과 '상태 기억'을 위해 존재한다.  
> 예술가가 그림을 그리다가 갑자기 떠오른 메모를 적고,  
> 그 메모를 쓰다가 이메일 답장을 하고,  
> 그 답장을 쓰다 말고 다시 그림을 그리는 흐름.  
> 이 모든 게 Stack 구조로 돌아가는 거야.  
>  - 메모가 끝나면 -> 메모 pop  
>  - 이메일이 끝나면 -> 이메일 pop  
>  - 다시 그림 작업으로 돌아옴 -> 이전 작업 peek/pop 
> 
> Stack은 이렇게 상태를 저장하고 되돌아가는 구조를 통해  
> '중단된 작업의 복귀'를 가능하게 해줘.
>

🧬 3-5. Stack은 우리의 뇌, 언어, 프로그램 흐름에 모두 존재한다.   
영역 | Stack 활용 예시 
> 🧠 인간의 뇌 : 미뤄둔 기억 되살리기, 단기 기억 작동방식  
> 🧾 언어 문법 : 괄호 짝 맞추기, 중첩 문장 해석 (if 중첩 등)
> 💻 프로그램 : 함수 호출, 재귀함수, try-catch 흐름  
> 📱 앱 설계 : 화면 전환 뒤로가기(Activity Stack)  
> 🧪 알고리즘 : DFS(깊이 우선 탐색)

🧘 정리 - Stack은 세상의 본질이다.  

Stack은 단순한 자료구조가 아니라  
기억하고, 복귀하고, 중첩하고, 되돌리는 모든 행위의 핵심 구조임  
우리가 일상에서 
- 무언가 미뤘다가  
- 나중에 그 일을 먼저 처리하는 순간  
 그건 바로 Stack을 살아가는 거야. 


### 🧱 Chapter 4. Stack의 추상 구조와 핵심 기능 정의  

4-1. 자료구조는 설계가 먼저다  

> 프로그래밍을 할 때 제일 먼저 하는 건  
> 코드를 작성하는게 아니라 "구조를 설계하는 것"이야.   
> Stack도 마찬가지야.  
> 무작정 push, pop 코드를 쓰기 전에 먼저 자문해야 해:  
>

❓ Stack을 객체지향적으로 표현하면 어떻게 될까?  
> Stack이라는 것은 현실 세계에서 "위에 쌓고, 위에서 꺼내는 상자"야.   
> 그러면 이걸 프로그래밍 세계에선 어떻게 모델링하지?  


4-2. Stack을 클래스로 만들기 위한 질문 3가지 

✅ 1. Stack 안에는 무엇이 들어가야 할까? -> 필드(Filed)  
- 데이터를 저장할 공간이 필요해 -> data[]
- 가장 위가 어디인지 알려주는 포인터 필요해 -> top
```java
int[] data;
int top;
```

✅ 2.Stack은 어떤 "동작"을 해야 할까? -> 메서드(Method)  
메서드 이름 | 기능 설명  
> push() : 위에 값을 넣는다.  
> pop()  : 위에서 값을 꺼낸다.  
> peek() : 위 값을 꺼내지 않고 확인만 한다.  
> isEmpty()  : 아무것도 안쌓여 있는지 확인한다.  
> size() : 몇 개나 쌓였는지 확인한다. 

✅ 3. Stack은 어떤 초기 상태에서 시작될까? -> 생성자(Constructor)  

처음엔 :  
- 아무것도 안 쌓여 있음 -> top = -1  
- 기본 배열 생성 필요 -> data = new int[10]  

4-3. Stack 클래스 구조 요약  

```java
public class MyStack{
    //1. 필드 정의   
    private int[] data; 
    private int top;
    
    //2. 기본 크기 설정  
    private static final int DEFAULT_CAPACITY = 10;  
    
    //3. 생성자 : 처음엔 빈 상태  
    public MyStack() {
        data = new int[DEFAULT_CAPACITY];
        top = -1;
    }
    
    // 4. 주요 메서드 정의 예정  
    public void push(int value){ ... }  
    public int pop(){ ... }  
    public int peek() { ... }
    public boolean isEmpty() { ... }
    public int size() { ... }
}
```

4-4. Stack의 동작 순서 시뮬레이션

직접 머릿속으로 상상해봐: 

```java
MyStack stack = new MyStack();  
stack.push(10);  // top : 0
stack.push(20);  // top : 1
stack.push(30);  // top : 0
```

호출 순서 | 내부 상태(data) | top  
> 초기 :  [ ][ ][ ][ ]... -1  
> push(10) :  [10][ ][ ][ ]... 0  
> push(20) : [10][20][ ][ ]... 1  
> pop()  :  [10][20][ ][ ]... 0
> 
> Stack은 항상 top을 중심으로 위 아래만 움직이는 자료구조야.
> 

4-5. Stack은 "구조적 제한"이 만든 정직한 자료구조
> Stack은 의도적으로 아래쪽은 못 건드리게 막은 구조야.  
> 왜냐하면 그게 이 자료구조의 철학이기 때문이야.  
> - 배열은 아무데나 접근할 수 있어  
> - 하지만 Stack은 가장 위(top)만 접근 가능해  
> 
> 이 제한은 불편함이 문제가 아니라,   
> 문제 해결의 정확함과 예측 가능성을 위한 디자인이야 
>

✍️ 정리 - 추상화된 Stack은 이런 모습이다. 
구성요소 | 설명
> 필드 : 데이터를 저장할 배열, top 포인터  
> 생성자 : 배열 초기화 + top = -1  
> 메서드 : push, pop, peek, isEmpty, size 등


### 💻 Chapter 5. 배열 기반 Stack 구현 - 구조부터 완성까지  

5-1. 이번 챕터 목표  

> 🎯목표 : 직접 MyStack 클래스를 만들고  
> push, pop, peek, isEmpty, size 전부 구현해서   
> 완전히 작동하는 배열 기반 Stack을 만들자. 
> 
 
5-2. 기본 설계 복습  
```java
public class MyStack{
    private int[] data; // 데이터를 담을 배열  
    private int top; // 현재 스택의 최상단 인덱스  
    private static final int DEFAULT_CAPACITY = 10;
    
    public MyStack(){
        this.data = new int[DEFAULT_CAPACITY];
        this.top = -1; // 아무것도 안 쌓여 있으면 top은 -1
    }
}

```

📌 여기까지는 준비된 "그릇" 상태야.
이제 여기에 기능을 하나씩 채워 넣는다. 

5-3. push(int value) - 값을 넣는다.  
개념 설명 : 
- Stack에 새 데이터를 넣는 건  
    -> top을 1 증가시키고, 거기에 값을 쓰는 것  
코드 구현: 
```java
public void push(int value){
    if(top == data.length - 1){
        throw new RuntimeException("스택이 가득 찼습니다.");
    }
    data[++top] = value; // top을 먼저 증가시키고, 그 자리에 저장
}
```

작동 흐름: 
```plaintext
초기 상태: top = -1

push(10) -> top = 0 -> data[0] = 10
push(20) -> top = 1 -> data[1] = 20
```
> 핵심 : ++top 먼저 하고 data[top]에 저장한다. 

5-4. pop() - 값을 꺼낸다. 

개념 설명 : 
- Stack에서 값을 꺼낸다는 건  
-> 현재 top 위치의 값을 꺼내고, top을 1 줄이는 것  

코드 구현: 
```java
public int pop(){
    if(isEmpty()){
        throw new RuntimeException("스택이 비어 있습니다.");
    }
    return data[top--]; //먼저 값을 반환하고, 그 후에 top 감소
}
```
> 핵심 : data[top]을 먼저 가져오고, top--으로 한 칸 내려온다.

5-5. peek() - 맨위의 값을 확인한다 (꺼내지 않고)
```java
public int peek(){
    inf(isEmpty()){
        throw new RuntimeException("스택이 비어 있습니다.");
    }
    return data[top]; //pop과 달리 top을 줄이지 않음. 
}
```

5-6. isEmpty() - 비었는지 확인 
```java
public boolean isEmpty(){
   return top == -1; 
        }
```

5-7. size() - 스택에 쌓인 데이터 개수 
```java
public int size(){
    return top + 1;
}
```

5-8. 전체 클래스 코드 완성 
```java
public class MyStack{
    private int[] data;
    private int top;
    private static final int DEFAULT_CAPACITY = 10;
    
    public MyStack(){
        this.data = new int[DEFAULT_CAPACITY];
        this.top = -1;
    }
    public void push(int value) {
        if(top == data.length -1){
            throw new RuntimeException("스택이 가득 찼습니다.");
        }
        data[++top] = vlaue;
    }
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("스택이 비어있습니다.");
        }
        return data[top--];
    }
    public int peek(){
        if(isEmpty()) {
            throw new RuntimeException("스택이 비어 있습니다.");
        }
        return data[top];
    }
    public boolean isEmpty(){
        return top == -1;
    }
    public int size(){
        return top +1; 
    }
            
}
```

5-9. 테스트 예제 코드 
```java
public class Main{
    public static void main(String[] args){
        MyStack stack = new MyStack();
        
        stack.push(10); 
        stack.push(20);
        stack.push(30);
        
        System.out.println(stack.pop()); //30
        System.out.println(stack.pop()); //20
        System.out.println(stack.size()); //2
        System.out.println(stack.isEmpty()); //false
    }
}
```

5-10 스택 작동 흐름 시뮬레이션 
```plaintext
push(10): [10]
push(20): [10,20]
push(30): [10,20,30]
pop() : 30 -> [10, 20]
peek(): 20 
```
✍️ 정리
메서드 | 핵심로직
> push : ++top -> data[top] = value;  
> pop : return data[top--]    
> peek : return data[top]  
> isEmpty : top == -1  
> size : top + 1


지금 너는 배열 기반 Stack을 직접 설계하고, 구현하고, 동작까지 추적해봤어.  
이제 Stack이라는 자료구조가 네 머릿속에  
그림, 코드, 로직으로 완전히 연결됐을 거야

# 🔗 Chapter 6. 연결리스트 기반 Stack 구현 - 동적 메모리 방식

## ✅ 6-1. 왜 연결리스트 기반 Stack이 필요한가?  
배열 기반 Stack은 깔끔하고 빠르지만 한계가 있어.  
### 📌 배열기반 Stack의 한계: 
문제점 | 설명  
> ✅ 고정 크기 : 배열은 처음 크기를 정해야 해. 초과되면 오류 발생.  
> ✅ 공간 낭비 : 데이터가 적으면 메모리 낭비  
> ✅ 재할당 비효율 : 크기 확장 시 새로운 배열 생성 + 복사  
>

🔄 해결책 : 연결리스트로 구현  
- Stack은 어차피 맨 위(top)에서만 넣고 빼니까  
- LinkedList의 head 쪽만 쓰면 아주 자연스럽게 구현됨  


💡 6-2. 구조적으로 완벽한 조합: Stack + LinkedList  
구조 그림: 
```java
Top -> [30] -> [20] -> [10] -> null
```
- 가장 위에 있는 노드 = Stack의 top  
- 데이터를 넣으면 -> 맨 앞에 추가 (Push)  
- 데이터를 빼면 -> 맨 앞에서 제거 (Pop)  
> 연결리스트의 삽입/삭제는 head에서 할 때 O(1) 이니까  
> Stack에 딱 맞는 구조지. 
>

🧱 6-3. 클래스 구조 설계  

🧩 Node 클래스 (내부 클래스로 작성 )  
```java
private static class Node{
    int value; 
    Node next;  
    
    Node(int value){
        this.value = value;
        this.next = null;
    }
} 
```
🧩 MyStack 필드 구성  
```java
public class MyStack {
    private Node top; //가장 위 노드를 가리킴  
    private int size; // 요소 수 
}
```

🧪6-4. 메서드별 구현  
✅ push(int value)  
```java
public void push(int value){
    Node newNode = new Node(value);
    newNode.next = top; // 기존 top 위에 덮어 씌우기
    top = newNode; // top 갱신  
    size++; 
}
```
✅ pop()

```java
public int pop(){
    if(isEmpty()){
        throw new RuntimeException("스택이 비어 있습니다.");
    }
    int result = top.value;
    top = top.next; //다음 노드가 top이 됨 
    size--;
    return result;
}
```
✅ peek()  
```java
public int peek(){
    if(isEmpty()){
        throw new RuntimeException("스택이 비어 있습니다.");
    }
    return top.value;
}
```

✅ isEmpty() & size()
```java
public void isEmpty(){
    return top == null; 
}
public int size() {
    return size; 
}
```
✅ 6-5. 전체 클래스 코드  
```java
public class MyStack {
    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
    private Node top; 
    private int size; 
    
    public MyStack{
        this.top = null; 
        this.size = 0; 
    }
    
    public void push(int value) {
        Node newNode = new Node(value);
        top = newNode;
        size++;
    }
    
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("스택이 비어 있습니다.");
        }
        int result = top.value;
        top = top.next; 
        size--;
        return result;
    }
    
    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("스택이 비어 있습니다.");
        }
        int result = top.value;
        top = top.next; 
        size--;
        return result;
    }
    public boolean isEmpty(){
        return top == null;
    }
    public int size(){
        return size;
    }
}

```

🧪 6-6. 테스트 예시  
```java
public class Main{
    public static void main(String[] args){
        MyStack stack = new MyStack();
        
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        System.out.println(stack.pop()); //30
        System.out.println(stack.peek()); // 20
        System.out.println(stack.size()); // 2 
    }
}
```
🧠 6-7. 메모리 구조 흐름 시각화  
```plaintext
push(10) : top -> [10]  
push(20) : top -> [20] -> [10]  
push(30) : top -> [30] -> [20] -> [10]

pop(): top -> [20] -> [10]
```
✍️ 정리 

구현 방식  | 특징
> 배열 기반 : 구현 쉽고 빠름, 고정 크기  
> 연결리스트 기반 : 메모리 효율적, 크기 제한 없음, 동적 구조  
> 
> Stack은 둘 다 장단점이 있고,  
> 네가 필요한 상황에 따라 배열 vs 연결리스트 중 선택하면 돼.  

지금 너는 Stack을 배열 기반/ 연결리스트 기반 두 가지 방식으로 전부 구현했어.  

# 📈Chapter 7. Stack의 시간복잡도와 성능 분석

이제 성능까지 파악하면서   
"왜 Stack은 빠르고, 어디서 병목이 생길 수 있는지 분석해 볼거야"

✅ 7-1. 자료구조는 성능이 생명이다.  

우리는 지금까지 Stack의 동작을 코드와 그림으로 다뤘지만,  
이제는 냉정하게 물어봐야 해:  
>"이 자료구조는 얼마나 빠른가?"  
> "사용할 때 성능 문제가 생기진 않을까?"  
> 
> 이걸 판단하기 위해 우리는 시간 복잡도라는 도구를 사용해 


🧠 7-2. Stack의 시간복잡도 정리  

>| 연산          | 시간복잡도 | 설명                       |  
>|-------------|-------|--------------------------|
> | `push()`    | O(1)  | top에 하나만 추가하므로 한 번만 연산.  |
> | `pop()`     | O(1)  | top에서 하나만 제거하므로 한 번만 연산  |
> | `peek()`    | O(1)  | top의 값만 확인하므로 단순 조회 | 
> | `isEmpty()` | O(1)  | top 포인터만 비교|
> | `size()`    | O(1)  | size 변수 값만 반환 |
>


🔥 **결론**
Stack의 모든 연산은 평균적으로 **단 한 번의 연산(O(1))** 으로 끝난다.  
-> 그래서 **빠르다. 정말 빠르다.**

🔍 7-3. Stack은 왜 이렇게 빠른가?  
이유 1. top만 조작하니까  
- Stack은 항상 한쪽 끝(top)에서만 작업해.  
- 중간에 접근하거나, 전체 탐색 같은 거 안 해.
이유 2. 탐색, 정렬, 이동이 없다.  
- 배열이나 리스트는 위치 이동, 삽입/삭제에 따라 요소들을 옮겨야 해  
- Stack은 그런 게 없어  
 -> **단일 포인터만 조작**

⚠️ 7-4. 그럼 Stack은 언제 느려지나?   
이론상 O(1)이지만 실제 상황에서 느려질 수 있는 경우도 있어  
> | 상황              | 느려지는 원인          | 해결 방안 | 
> |-----------------|------------------|--|
> | 배열 기반 스택이 꽉 찼을 때 | 배열 재할당 필요 (O(n)) | 미리 충분한 크기로 확보하거나 연결리스트 방식으로 대체|
> | 잘못된 사용 (중간 접근) | Stack을 배열처럼 쓰려 함| Stack은 Stack답게 써야 함 |  
> | 무한 재귀 호출 (재귀 = Stack) | 스택 오버플로우 발생 | 재귀 깊이 제한, 꼬리재귀 최적화 등 사용|
>

🧬 7-5. 메모리 관점 성능 비교 (배열 vs 연결리스트)

>|기준| 배열 기반 Stack| 연결리스트 기반 Stack| 
> |--|--|--|
> |메모리 사용| 배열 크기 고정 -> 낭비 가능 | 필요할 때마다 노드 생성|
> |접근 속도| 빠름 (배열 연속 메모리) | 느림 (포인터 따라가야 함)|
> |크기 유연성 | 고정 (넘치면 재할당) | 유연(동적 생성) | 
> | push/pop 속도 | O(1) | O(1)|  


⚖️ 7-6. 실제 상황에선 어떤 걸 써야 할까?? 
>| 상황 | 추천 Stack 방식|  
> |--|--|  
> |크기를 예상할 수 있음| 배열 기반 (빠르고 단순)|  
> |크기를 모름, 유동적임| 연결리스트 기반(유연함)|  
> |메모리 중요함 | 연결리스트(낭비 없음) |  
> |성능 중요함 | 배열 기반 (빠름) |

💡7-7. Stack은 작고 빠르고 강하다.  
Stack은 기능이 단순해서 우습게 보일 수 있지만,  
실제로는 가장 효율적인 연산만으로 구성된 고성능 자료구조임.  
- push/pop : 단 1번의 연산 (O(1))
- 공간도 적게 차지하고 
- 예측 가능하고 안전하게 동작함


✍️ 정리 - Stack 성능 분석 요약표 
> |연산 | 시간복잡도| 비고         | 
> |--|--|------------|
> |push| O(1)| 가장 위에만 추가  |
> |pop| O(1)| 가장 위에서만 제거 |
> |peek| O(1)| 가장 위 값 확인  | 
> |isEmpty| O(1)| top 확인     |
> |size| O(1)| size 변수 있음 |
> 


