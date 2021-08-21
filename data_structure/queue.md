## 큐
- FIFO 형태의 자료구조(선입선출)
- 줄을 서는 형태
- 프로세스 스케줄러에서 많이 사용
- Enqueue: 큐에 데이터를 넣음
- Dequeue: 큐에서 데이터 추출

## 자바에서의 큐
- Queue 클새스 제공
- add, offer 메서드로 enqueue 기능 구현
- poll, remove 메서드로 dequeue 기능 구현
- LinkedList를 사용하여 생성
	```java
	import java.util.LinkedList;
	import java.util.Queue;

	Queue<Integer> queueInt = new Queue<Integer>();
	Queue<String> queueStr = new Queue<String>();
	```
- [ArrayList로 Queue 구현해보기](./MyQueue.java)

