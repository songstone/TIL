## 해쉬 테이블
- 키에 데이터를 매핑하여 저장하는 데이터 구조
- 해쉬 함수를 통해 키에 대한 데이터를 저장할 수 있는 주소를 계산
- Key를 통해 바로 데이터가 저장된 주소로 접근하므로 저장 및 탐색 속도가 빠르다.
- 미리 주소에 대한 공간을 할당
- 일반적으로 저장공간이 좀 더 많이 필요하다
- 해쉬함수에 의한 주소가 충돌할 경우 이를 처리해주어야 한다.

## 충돌 해결 알고리즘
- chaining 기법
    - open hashing 기법
    - 해쉬 테이블 저장공간 외의 공간을 활용
    - 링크드 리스트 자료구조 이용
    - [chaining 해쉬 구현](./MyHash_chaining.java)
- linear probing 기법
    - close hashing 기법
    - 저장공간 안에서 충돌 문제 해결
    - 충돌 발생시 해당 address로 부터 맨 처음 나오는 빈 공간에 저장
    - [linear probing 해쉬 구현](./MyHash_linearProbing.java)