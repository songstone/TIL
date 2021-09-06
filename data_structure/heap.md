## 힙
- 데이터에서 최대값과 최소값을 빠르게 찾기 위해 고안된 완전 이진 트리
- 노드를 삽입할 때 최하단 왼쪽 노드부터 차례때로 삽입된다.
- 부모노드가 최대값을 유지하는 힙은 MaxHeap, 최소값을 유지하는 힙은 MinHeap
- 왼쪽자식노드의 인덱스 = 부모노드의 인덱스/2
- 오른쪽자식노드의 인덱스 = 무모노드의 인덱스/2 + 1 
- 자료의 변경이 있을 때마다 전체 구조를 재정렬
- [자바로 맥스힙 구현해보기](./MyMaxHeap.java)