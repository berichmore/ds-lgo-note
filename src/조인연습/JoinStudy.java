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



     */
}
