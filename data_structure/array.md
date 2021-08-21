## 배열
- 데이터를 나열하고 각 데이터를 인덱스에 대응하도록 구성
- 같은 종류의 데이터를 효율적으로 관리하기 위해 사용
- 데이터의 순차적 저장
- 각 인덱스 번호로 접근 하기 때문에 빠른접근이 가능하다
- 데이터 추가/삭제 시에 번거로움이 있다.

## 자바에서의 배열
- 배열을 효과적으로 관리하기 위한 ArrayList 제공
	```java
	import java.util.ArrayList;

	ArrayList<T> list1 = new ArrayList<T>();
	```
- 선언 시 제네릭 자료형을 정의 하여 사용
- add(T t) : ArrayList에 자료 추가
	```java
	list1.add(t);
	```
- get(int i) : 해당 인덱스의 자료 반환
	```java
	list1.get(0);
	```
- set(int i, T t) : 해당 인덱스의 자료 덮어쓰기
	```java
	list1.set(0, 5);
	```
- remove(int i) : 해당 인덱스의 자료 배열에서 제거 후 반환
	```java
	list1.remove(0);
	```
- size() : 해당 배열의 요소 개수 반환
