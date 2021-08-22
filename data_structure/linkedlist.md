## 링크드 리스트
- 연결리스트라고도 하며 떨어진 곳에 존재하는 데이터를 화설표로 연결해서 관리하는 데이터 구조
- 노드: 데이터 저장단위(데어터, 포인터)로 이루어져있다.
- 포인터: 각 노드 안에서 다음 혹은 이전 노드의 정보를 가진다.
- 미리 데이터 공간을 할당 하지 않아도 된다.
- 다음 노드에 대한 정보를 담을 별도의 데이터 공간이 필요하므로 저장공간 효율이 높지 않다
- 인덱스로 바로 접근 하는 것이 아니라 맨 앞 노드 부터 순차적으로 찾기 때문에 접근 속도가 느리다.

## 자바에서의 노드
- 노드 구현
    ```java
    public class Node<T>{
        T data;
        Node<T> next = null;

        public Node(T data){
            this.data = data;
        }
    }
    ```
- 노드와 노드 연결
    ```java
    Node<Integer> node1 = new Node<Integer>(1);
    Node<Integer> node1 = new Node<Integer>(2);

    node1.next = node2;
    Node head = node1;
    ```
- [싱글 링크드리스트 구현](./MySingleLinkedList.java)
- [양방향 링크드리스크 구현](./MyDoubleLinkedList.java)