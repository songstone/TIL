# JPQL
- JPA == 엔티티 객체 중심 개발
- SQL을 추상화한 객체 대상 쿼리
- SELECT, FROM, WHERE, GROUP BY, HAVING, JOIN 지원
- DB 종속 x
```java
String jpql = "select m from Member m where m.age > 18";

List<Member> result = em.createQuery(jpql, Member.class)
	.getResultList();
```
- Entity와 속성은 대소문자 구분
- JPQL 키워드는 대수문자 구분 x
- 테이블의 이름이 아닌 Entity 이름 기준
- 각 엔티티의 별칭은 필수
- 집합, 정렬 함수 제공 : COUNT, SUM, AVG, MAX, MIN
- 기본 함수 제공 : CONCAT, SUBSTRING, TRIM, LOWER, UPPER, LEGNTH, LOCATE, ABS, SQRT, MOD

### 쿼리 반환 타입 및 결과 조회
- TypeQuery : 반환 타입이 명확할때 사용
```java
TypeQuery<Member> query = em.createQuery("select m from Member m", Member.class);
```
- Query : 반환 타입이 명확하지 않을 때 사용
```java
Query query = em.createQuery("select m.username, m.age from Member m");
```
- query.getResultList() : 결과가 하나 이상일 때 리스트 형식으로 반환, 결과가 없으면 빈 리스트 반환
- query.getSingleResult() : 결과가 오로지 단 하나 일 때 사용, 단일 객체 반환, 결과가 없거나 둘 이상이면 Exception 발생

###  페이징 API
- 페이징을 API 2개로 추상화
- setFirstResult(int startPosition) : 조회 시작 위치, 0부터 시작
- setMaxResults(int maxResult) : 조회할 데이터 수
```java
List<Member> resultList = em.createQuery("select m from Member m order by m.name desc", Member.class)
	.setFirstResult(10) // 10번째 데이터 부터
	.setMaxResults(20) // 20개의 데이터 만
	.getResultList();
```

### 경로 표현식
- 점을 찍어 객체 그래프 탐색
- `select o.member from Order o`  -> 묵시적 조인 발생, 추후 쿼리 튜닝 난이도 증가
- `select m from Order o join o.member m` -> 명시적 조인, 조인 상황 파악 용이

### 페치 조인
- join fetch
- SQL 조인 x
- JPQL에서 성능 최적화를 위해 제공
- 연관된 엔티티나 컬렉션을 한번에 영속화
- 지정한 범위의 객체 그래프를 한번에 조회하는 개념
- `select m from Member m join fetch m.team`
```java
String jpql = "select m from Member m join fetch m.team";
List<Member> members = em.creatQuery(jpql, Member.class)
	.getResultList(); // team 조회시 지연로딩 발생 x
```
- **_일반적인 엔티티의 로딩 전략을 LAZY로 세팅하고 join fetch로 최적화하여 가져오자_**
- **_여러 테이블을 조회 후 엔티티가 가진 모양이 아닌 전혀 다른 결과를 내야하면 일반 조인 후 필요 데이터들만 따로 조회하여 DTO로 반환하는 것이 효과적_**

- JPQL 에서의 DISTINCT
	- SQL 자체 중복 제거 distinct
	- application 단에서 엔티티 식별자를 통한 중복 제거
- 한계
	- 페치 조인 대상에 별칭 x
	- 둘 이상의 컬렉션은 페치 조인 할 수 없다.
	- 컬렉션을 페치 조인 시 페이징 API 사용 불가

### 벌크 연산
- 다건의 update, delete 쿼리 날릴 때 사용
- 변경 감지로 인한 update, delete 시 너무 많은 쿼리 실행
- excuteUpdate() -> 변경된 row 갯수 반환
```java
String qlString = "update Product p " + 
					"set p.price = p.price * 1.1 " +
					"where p.stockAmount < :stockAmount";
					
int resultCount = em.createQuery(qlString)
	.setParameter("stockAmount", 10)
	.excuteUpdate();
```
- 벌크 연산은 영속성 컨텍스트를 무시하고 DB에 직접 쿼리 실행
- **_벌크 연산 먼저 수행 후 영속성 컨텍스트 초기화 필요!_**