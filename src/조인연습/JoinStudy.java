package 조인연습;

public class JoinStudy {
    /*
    MySQL Sakila를 활용한 Join 연습

     INNER JOIN
    문제1)
    모든 고객의 이름(first_name, last_name)과 그 고객이 살고 있는 주소(address)를 함께 보고 싶습니다.
    어떻게 쿼리를 짜야 할까요?


    SELECT c.first_name, c.last_name, a.address
    FROM customer c
    INNER JOIN address a ON c.address_id = a.address_id;




    문제2)
    모든 영화의 제목(title)과 그 영화가 속한 카테고리 이름(name)을 함께 보고 싶습니다.


    SELECT f.title, c.name
    FROM film f
    INNER JOIN film_category fc ON f.film_id = fc.film_id
    INNER JOIN category c ON c.category_id = fc.category_id




    문제3)
    모든 고객의 이름(first_name, last_name)과
    그 고객이 영화를 빌린 날짜(rental_date)를 함께 보고 싶습니다.


    SELECT c.first_name, c.last_name, r.rental_date
    FROM customer c
    INNER JOIN rental r ON c.customer_id = r.customer_id;




    문제4)
    모든 직원(staff)의 이름(first_name, last_name)과
    그 직원이 근무하는 사무실의 주소(address)를 보고 싶습니다.


    SELECT s.first_name, s.last_name, a.address
    FROM staff s
    INNER JOIN address a ON s.address_id = a.address_id;




    문제5)
    모든 직원의 이름(first_name, last_name)과
    그 직원이 근무하는 도시 이름(city)을 보고 싶습니다.


    SELECT s.first_name, s.last_name, c.city
    FROM staff s
    INNER JOIN address a ON a.address_id = s.address_id
    INNER JOIN city c ON c.city_id = a.city_id;


    문제6)

    특정 고객의 이름(first_name, last_name)과
    그 고객이 빌린 영화 제목(title)들을 전부 보고 싶습니다.


    SELECT c.first_name, c.last_name, f.title
    FROM customer c
    INNER JOIN store s ON c.store_id = s.store_id
    INNER JOIN inventory i ON i.store_id = s.store_id
    INNER JOIN film f ON f.film_id = i.film_id;

    틀림

    현재 작성하신 쿼리의 연결 방식은 이렇습니다:
    고객(c) ↔ 매장(s) ↔ 인벤토리(i) ↔ 영화(f)

    결과: 이 쿼리를 실행하면 "특정 고객이 다니는 매장에 진열된 모든 영화"가 나옵니다.

    이유: 고객이 1번 매장 소속이라면, 1번 매장에 있는 모든 DVD(인벤토리)와 연결되기 때문이죠.
    우리가 알고 싶은 건 "그 고객이 돈을 내고 빌려간(rental) 영화"가 무엇인지입니다.


    아 이해가 된다

    ------- 다시 -------

    SELECT c.first_name, c.last_name, f.title
    FROM customer c
    INNER JOIN rental r ON c.customer_id = r.customer_id
    INNER JOIN inventory i ON i.inventory_id = r.inventory_id
    INNER JOIN film f ON f.film_id = i.film_id;



     */
}
