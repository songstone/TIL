## 스택
- 데이터를 한쪽 끝에서만 자료를 넣거나 뺄 수 있는 구조
- LIFO 형태의 구조(후입선출)
- 차례로 쌓는 형태로 가장 나중에 쌓은 데이터를 먼저 추출하는 구조
- 컴퓨너 내부의 프로세스 구조의 함수 동작 방식과 연관
- push : 데이터 넣기
- pop : 데이터 추출
- 구조가 단순하여 구현이 쉽고 데이터 저장 및 읽기 속도가 빠르다

## 자바에서의 스택
- java.util 패키지에서 Stack 클래스 제공
	```java
	import java.util.Stack;

	Stack<Integer> stack = new Stack<Integer>();
	```
- push(T t): 데이터 삽입
	```java
	stack.push(2);
	```
- pop(): 데이터 추출
	```java
	stack.pop();
	```
- [ArrayList로 스택 구현해보기](./MyStack.java)
