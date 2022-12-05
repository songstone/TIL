# JPA 정리

## 영속성 컨텍스트
- 엔티티를 영구적으로 저장하는 환경
- EntityManager의 Persist(Entity) : Entity를 영속화 한다.
- 논리적 개념
- 엔티티 매니저를 통해 접근
- 엔티티의 생명 주기
	- 비영속 : 영속성 컨텍스트와 관게가 없는 상태 혹은 새로운 상태 ex) 객체 최초 생성
	- 영속 : 영속성 컨텍스트에 의해 관리되는 상태 ex) em.persist(entity)
	- 준영속 : 영속성 컨텍스트에 저장 후 분리된 상태 ex) em.detach(entity)
	- 삭제 : 영속성 컨텍스트에서 삭제 된 상태
- 이점
	- 1차 캐쉬
	- 동리한 트랜잭션 안에서의 엔티티의 동일성을 보장해 준다.
	- 트랜잭션을 지원하는 쓰기 지연(버퍼) : commit 실행 시점에 한번에 DB에 쓴다(flush)
	- 변경 감지(dirty checking)
		- commit시 flush 호출
		- entity와 그 snapshot을 비교한다(in 1차캐쉬)
		- 변경 감지시에 쓰기 지연 sql 저장소에 쿼리 작성
	- 지연 로딩
- flush
	- 영속성 컨텍스의 변경 내역을 DB에 반영(저장된 쿼리를 쓰기)
	- em.flush()로 호출 시 즉시 DB에 전송
	- 1차 캐쉬를 비우는 개념이 아니라 쓰기지연 sql만 DB 로 전송하여 변경 내용을 DB와 동기화 하는 개념

## 엔티티 매핑
- @Entity
	- 객체 테이블 매핑
	- 기본 생성자 필수
	- final, enum, interface, inner 클래스 에는 선언 불가
- 데이터베이스 스키마 자동생성
	- DDL을 어플리케이션 실행시점에 테이블 생성하도록 실행
	- 테이블 중심 -> 객체 중심으로
	- application property 에서 설정 가능
	- Dialect 참조하여 각 DB에 맞는 쿼리 실행
	- CREATE, CREATE-DROP, UPDATE, VALIDATE, NONE
	- 실제 운영서버에서는 사용 하지 말자!
- 필드와 컬럼 매핑
	- @Column
		- insertable, updatable
		- nullabe
		- unique
		- length
		- precision, scale : Big Decimal 옵션값, precision 소수점 포함 전체자리수, scale 소수점
- 기본키 매핑
	- 직접 할당 : @Id만 사용
	- 자동 할당(@GeneratedValue)
		- IDENTITY : 기본키 생성을 DB에 위임 like mysql의 AUTO_INCREMENT
		- SEQUENCE : 시퀀스 오브젝트를 생성하여 값을 가져오고 set을 해준다.
			- @Sequence Generator로 name, sequnece_name, initValue, 증가값 등을 정의
			- property로 sequence generator의 name으로 매핑
		- TABLE : 키 생성 전용 테이블로 DB시퀀스 흉내
	- 식별자 생성 전략
		- null X, unique, 불변
		- 미래까지 조건을 만족하는 자연키는 찾기 어렵다.
		- 비지지스와 상관 없는 대체키를 사용하자
		- Long형 + 대체키 + 키 생성전략

## 연관 관계 매핑
- 객체의 참조와 테이블의 외래키를 매핑
- 단방향
	- @ManyToOne
	- @JoinColumn(name = '조인 컬럼')
	- 단방향으로 모든 매핑을 끝내고 필요에 따라 양방향 매핑을 추가하자
- 양방향
	- @OneToMany(mapped By = '연관관계 주인의 변수명')
	- List<> : Null 포인터 방지로 ArrayList 로 초기화 해두기
- 연관 관계의 주인
	- 외래키를 관리 하는 Entity가 주인
	- 주인이 아닌 쪽은 읽기만 가능하다
	- 연관관계의 주인에만 값을 세팅하면 알아서 매핑, but 양쪽에 다 명시해주자
		- 미세팅 시 1차 캐쉬 조회 시 참조 불가
		- 테스트 케이스 작성의 용이함을 위해서
		- 값 세팅 메서드를 정의해서 한번에 양방향에 모두 값을 설정하도록 하자!

## 상속 관계 매핑
- DB 에서의 상속 관계 설계
- @Inheritance(strategy = '상속 전략') : 부모 객체에 선언
	- 조인 관계 : 공통 속성 분리, 구체화된 대상에 조인
		- @Discriminator Column : 부모 테이블에 DTYPE으로 컬럼 생성
		- @Discriminator Value : 자식테이블에 들어가는 DTYPE 값의 value 조정 가능
		- 공간 최적화
	- 단일 테이블 전략 : 하나에 다 때려박는 전략 (default)
		- Dtype 값으로 구분값을 줘야만 한다
	- 구현 클래스 : 구체적인 테이블을 각각 구현하여 생성
- @MappedSuperClass
	- 추상 클래스로 선언
	- 공통 매핑 정보 필요시에 Base Entity 로 사용
	- 공통 속성을 묶어서 관리
	- ex) ~ extends BaseEntity , @MappedSuperClass

## 프록시
- em.find() vs em.getReference() 
	- 실제 조회와 DB를 미루는 가짜 객체(프록시)
	- 조회 쿼리 실행 시점의 차이
- 실제 Entity를 상속 받아 만들어진다.
- 외부에서 볼때는 실제와 같다
- 실제 객체의 참조를 보관(target)
- 프록시 객체를 호출하면 영속성 컨텍스트에 초기화 요청 후 DB 조회하여 실제 객체를 생성하여 메서드 호출
- 처음 생성시 한번만 초기화
- 초기화시 프록시가 실제 객체로 바뀌는 건 아님 -> 프록시 객체를 통해서 실제 엔티티에 접근 가능
- 타입 체크시 주의하자 (instanceof 사용)
- 영속성 컨텍스트에 이미 존재하는 엔티티는 em.getReference로 프록시를 호출해도 실제 엔티티가 반환 -> 트랜잭션내 에서 동일성 보장
- 반대로 프록시로 반환된 객체를 em.find로 조회해도 프록시 반환 -> 역시 동일성 보장
- 관련 메서드
	- PersistenceUnitUtil.isLoaded : 프록시 초기화 여부
	- Hibernate.initialize : 강제 초기화

## 즉시로딩, 지연로딩
- 지연 로딩
	- fetch = FetchType.LAZY
	- 실제 객체 참조시에 조회
- 즉시 로딩
	- fetch = FetchType.EAGER
	- 처음 Entity 조회시 한번에 즉시 조회
- 실무에서는 가급적 지연로딩을 설계하자
- @ManyToOne , @OneToOne 은 기본이 즉시로딩이므로 LAZY로 명시적으로 설정하자

## 영속성 전이 
- CASCADE
	- ALL : 자식 엔티티의 라이프 사이클을 부모 엔티티와 일치 시킨다.
	- PERSIST : 영속만 일치, remove는 x
- 연관 관계, 즉시 로딩, 지연 로딩과 상관 x
- 부모 엔티티 저장 시에 자식 엔티티도 같이 저장하고 싶을 때 설정
- 단일 엔티티에 종속되는 자식 엔티티에는 부담없이 사용가능
- 단, 다른 엔티티가 참조할 때는 주의

## 고아객체
- 부모엔티티와 연관 관계가 끊어진 자식 엔티티
- OrphanRemoval
- 연관관계가 끊어지면 삭제
- 사용시 주의 -> 부모엔티티에 단일 종속된 엔티티에만 사용하자

## 기본값 타입
- JPA에서의 데이터 타입
	- 엔티티 타입 vs 값타입
	- 엔티티 : 식별값을 통해 변경시 끝까지 추적 가능
	- 값타입 : int, Integer, String 등 단순 값으로 사용하는 자바 기본타입이나 객체, 식별값이 없어 변경시 추적 불가능
- 값 타입
	- 기본값 타입
		- 자바 기본 타입 : int, double, long ...
		- 래퍼 클래스 : Integer, Double, Long ...
		- String
	- 임베디드 타입 : 복합 값 타입
	- 컬렉션 값 타입 : 자바 컬렉션

## 임베디드 타입
- 새로운 값 타입을 지정
- 기본 값 타입을 모아서 복합 값 타입을 만든다
- **엔티티가 아닌 값 타입이다**(식별자 x)
- @Embeddable, @Embedded + 기본 생성자
- 재사용성 및 응집도 상승
- 객체와 테이블을 세밀하게 매핑하는 것이 가능
- 한 엔티티에서 같은 값타입을 여러개 사용 할 시 @Attribute + Override로 컬럼명 재정의 하여 사용

## 값 타입 vs 불변 객체
- 임베디드 타입(값 타입) 은 공유하면 위험
- 실제 인스턴스를 직접 사용하지말자
- 인스턴스를 복사해서 사용하자
- but 근본적인 공유참조를 컴파일러 단계에서 막을 수는 없다 -> 불변 객체로 설계!
	- 생성자로 값 세팅, setter 메서드 정의 x
- 값 타입 비교
	- 인스턴스가 달라도 그 안에 값이 같으면 같은 값으로 보아야 한다
	- equals 와 hashcode 재정의

## 값 타입 컬렉션
- pk로 값 타입 전체를 묶어서 저장
- @ElementCollection : 값타입 컬렉션
- @CollectionTable(name= "") , @JoinColumns = @JoinColumn(name= "") : 매핑 테이블 이름
- 하나의 값만 있는 컬렉션을 예외적으로 @Column에 지정해도 테이블 생성을 잘해준다.
- 영속성은 엔티티에 의존(영속성 전이, 고아객체 제거 기능이 필수로 탑재된 느낌)
- 기본적으로 지연로딩
- 값타입 변경은 새 객체를 생성하여 갈이 끼워야 한다.
- 컬렉션 값만 변경해도 JPA가 인지하고 반영해준다.
- equals로 값 타입을 조회 삭제 -> equals의 올바른 구현 필요
- 값타입의 제약사항
	- 엔티티와 다르게 식별자 개념 x
	- 값 변경의 추적이 어렵다
	- 변경 생기면 모든 데이터를 다 삭제 후 다시 저장하는 과정을 거친다 -> 비효율적

- **_대안_**
	- 실무에서 값 타입 컬렉션 대신 일대다 관계를 고려하기
	- **일대다 관계를 위한 엔티티를 만들고 여기에서 값 타입을 사용하자!** -> 값 타입을 엔티티로 승격해서 사용
	- 영속성 전이(cascade) + 고아객체 제거 사용 -> 값 타입의 성격과 일치 시키기