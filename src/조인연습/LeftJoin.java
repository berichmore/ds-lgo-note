package 조인연습;

public class LeftJoin {
    /*
    "주인공 결정": FROM 절에 나오는 첫 번째 테이블(A)을 '무조건 다 보여줘야 할 주인공'으로 설정합니다.
    "있으면 붙이고, 없으면 말고": 오른쪽 테이블(B)에서 조건(ON)에 맞는 데이터를 찾습니다.
    매칭 성공: INNER JOIN처럼 데이터를 옆에 딱 붙입니다.
    매칭 실패: 주인공(A)은 포기할 수 없으므로 그대로 두되,
    옆구리(B의 컬럼들)에는 아무것도 없다는 의미로 NULL을 채워넣습니다.
    데이터의 보존: INNER JOIN이 '조건에 안 맞으면 과감히 버리는' 필터라면,
    LEFT JOIN은 '일단 왼쪽은 다 살려두는' 보존 방식입니다.

    📐 수학적 설명 (집합론)수식: $A \cup (A \cap B)$ 처럼 보일 수 있지만,
     정확히는 집합 A의 모든 원소를 유지하면서 B와의 교집합 정보를 추가하는 것입니다.
     결과 행(Row)의 개수는 최소한 집합 $A$의 개수만큼 보장됩니다.
     (B에 매칭되는 게 여러 개면 더 늘어날 수도 있습니다.)


    2. LEFT JOIN vs RIGHT JOIN (거울 관계)

    결론부터 말씀드리면, "둘은 완전히 같은 기능을 하지만 방향만 반대"입니다.

    TableA LEFT JOIN TableB: A가 주인공입니다.

    TableB RIGHT JOIN TableA: 여전히 A가 주인공입니다. (B의 오른쪽에 A를 뒀으므로)

    💡 왜 LEFT JOIN을 더 많이 쓰나요?
    우리는 글을 왼쪽에서 오른쪽으로 읽습니다.
    그래서 "이 테이블(A)을 기준으로 저 테이블(B)을 붙여줘"라고 말하는 것이 훨씬 직관적입니다.
    실무에서도 90% 이상은 LEFT JOIN을 사용하며,
    RIGHT JOIN은 테이블 위치를 바꾸기 귀찮을 때 가끔 쓰는 정도입니다.
    따라서 LEFT JOIN 하나만 제대로 파도 충분합니다.

    문제1)
    연습 문제: "우리 가게에 없는 영화는 무엇인가?"

    문제: 모든 영화의 제목(title)과 그 영화가 현재 우리 가게의 인벤토리(inventory)에
    몇 개나 있는지 확인하고 싶습니다. 단, 재고가 하나도 없는 영화도 목록에 나와야 합니다.



    -- A film  / B: inventory
    SELECT  f.title,
		    i.inventory_id
    FROM film f
    LEFT JOIN inventory i ON i.film_id = f.film_id


    정답입니다! 쿼리를 아주 정확하게 작성하셨습니다.
    이제 이 쿼리가 데이터베이스 내부에서 어떤 논리적 단계를 거쳐 결과를 만들어내는지,
    '학자 스타일'로 깊이 있게 파고들어 보겠습니다.

    🟢 LEFT JOIN: 사고의 확장🧠 생각의 과정 (Thought Process)
    기준점(Anchor) 설정: FROM film f라고 쓰는 순간,
     시스템은 "일단 우리 영화 1,000권(Sakila 기준)은
     무조건 한 줄씩 자리를 만들어놔!"라고 결정합니다.
     이것이 왼쪽 테이블(A)의 위엄입니다.데이터

     탐색 및 매칭: 오른쪽 테이블인 inventory i를 훑으며 각 영화(film_id)에 해당하는 DVD 실물이 있는지 찾습니다.
     케이스
     1 (다수 매칭): 영화 'Academy Dinosaur'가 가게에 8장 있다면,
      결과창에는 제목이 8줄 반복되면서 각각의 서로 다른 inventory_id가 붙습니다.케이스
     2 (매칭 실패): 만약 어떤 영화가 인벤토리에 한 장도 없다면?
     여기서 LEFT JOIN의 진가가 드러납니다. INNER JOIN이었다면 그 영화를 결과에서 삭제했겠지만,
     LEFT JOIN은 영화 제목을 그대로 살려둔 채 옆에 NULL이라는 표식을 남깁니다.


     📐 수학적 설명 (집합론적 관점)image_6ca61a.png 파일의 왼쪽 상단(첫 번째 그림)을 보며 이해해 봅시다.
     집합 $A$ ($film$): 전체 영화 목록 (원 전체가 빨간색)집합 $B$
     ($inventory$): 실제 보유한 DVD 목록논리 기호: $A \sqsubset B$ (왼쪽 우선 결합)

     수학적 의미: $\{x \mid x \in A\}$ 를 기본으로 하되, $x \in B$ 인 경우에는
     $B$의 속성값($inventory\_id$)을 결합하고, $x \notin B$ 인 경우에는 $B$의 속성값을 비워둡니다.
     결과적으로 이 결과물은 "완벽한 전체 목록 + 알파 정보"가 됩니다.

     💡 NULL의 의미: "데이터의 부재"LEFT JOIN을 했을 때 inventory_id 자리에 나오는
     NULL은 단순히 0이나 공백이 아닙니다. 논리적으로 "이 영화는 우리 시스템에 등록은 되어 있지만,
     실제 물건(Inventory)은 존재하지 않는다"라는 아주 중요한 비즈니스 정보를 담고 있습니다.



        -- A film  / B: inventory
    SELECT  f.title,
		    i.inventory_id
    FROM film f
    LEFT JOIN inventory i ON i.film_id = f.film_id
    WHERE i.film_id is null;


     */
}
