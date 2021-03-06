## 파이썬 기초 정리

### 변수형의 종류
- 숫자, 문자열, 리스트, 튜플, 딕셔너리형이 있다.

### 문자열
- ' 혹은 " 을 이용해 선언하며 각각의 기호를 3번 연달아 사용하여 여러줄의 문자열을 쉽게 선언 가능하다
- 이스케이프 코드를 사용하기도 한다(\n, \t, \\\\, \', \")
- 문자열 연산
	- + : 문자열을 연걸하여 붙일 때 사용
	- * : 문자열을 일정 횟수만큼 반복할 때 사용
- 인덱싱 : 인덱스 값으로 문자열의 문자에 접근 가능
	```python
	string = 'apple'
	string[2]
	```
- 슬라이싱 : 문자열의 인덱스값을 이용하여 자를때 사용 ':' 앞에 있는 인덱스부터 뒤에 인덱스의 바로 전까지를 자른다.
	```python
	string = 'apple'
	string[1:3]
	```
- 문자열 내장함수
	- count : 문자열 내에서 해당 문자의 수 반환
	```python
	s = 'apple'
	s.count(p)
	```
	- find : 문자열 내에서 해당 문자열의 인덱스값 반환. 문자열이 존재하지 않을때는 -1반환
	```python
	s = 'apple'
	s.find('l')
	```
	- index : find와 동일하나 문자열이 존재하지 않을 때 에러 발생
	- join : 해단문자열을 대상 문자열 사이사이에 끼워넣는다
	```python
	s = "'"
	s.join('ABC')
	```
	- upper : 해당 문자열을 대문자로
	- lower : 해당 문자열을 소문자로
	- replace : 문자열에서 앞에 인자를 뒤에 인자의 문자열로 바꾼다.
	```python
	s = 'apple'
	s.replace('pp','cc')
	```
	- 문자열을 해당 문자 기준으로 나눈다
	```python
	s = 'apple is good'
	s.split(' ')
	```
	- strip : 문자열의 양쪽 공백 제거

### 리스트
- 데이터 모음을 담을 때 주로 사용하는 자료형
- 데이터의 추가, 삭제, 수정이 자유롭다.
- 중복된 데이터 가능
- [ ] 를 이용해 선언
- 문자열과 동일하게 (+,*)연산이 가능하다
- 데이터 삭제 : del과 인덱스를 이용하여 삭제
```python
list = [1,2,3,4,5]
del(list[0])
```
-리스트 내장함수
	- append : 배열 뒤에 데이터 추가
	```python
	list = [1,2,3,4,5]
	list.append(6)
	```
	- sort : 배열내의 자료를 정렬
	- reverse : 배열내의 자료의 순서를 거꾸로 한다
	- index : 해당 자료의 리스트에서의 인덱스 반환
	- insert : 자료를 해당 인덱스에 삽입
	```python
	list = [1,2,3,4,5]
	list.insert(1,7)
	```
	- remove : 리스트에서 해당 데이터 삭제
	```python
	list = [1,2,3,4,5]
	list.remove(5)
	```
	- pop : 마지막 자료 추출
	- count : 리스트에서 해당 자료의 개수 반환

### 튜플
- 리스트와 매우 흡사하나 수정,삭제,추가 불가능 오직 읽기만 가능하다
- ( )로 선언
- 인덱싱, 슬라이싱 모두 가능하며 내장함수 또한 리스트와 동일하다
- 단, 수정,삭제,삽입 관련 내장함수는 불가능

### 딕셔너리
- key값과 value값이 쌍으로 저장된다.
- { key : value } 의 형태로 선언
- 자료의 순서가 없으므로 슬라이싱은 불가하다
- 인덱싱은 해당 자료의 키값을 통해 value값을 불러올 수 있다
```python
tu = {'name' : 'apple' , 'color' : red }
tu['name']
```
- 삭제도 key값을 이용해 가능하다
```python
tu = {'name' : 'apple', 'color' : 'red' }
del(tu['color'])
```
- 추가도 key값을 이용하여 그 value값을 지정하는 것으로 가능하다
```python
tu = {'name' : 'apple', 'color' : 'red' }
tu['count'] = 3 
```
- 튜플 내장함수
	- keys : 해당 튜플의 키 값들을 반환
	- values : 해당 튜플의 밸류 값들을 반환
	- items : 해당 튜플의 키와 밸류 값의 쌍으로 반환
	- get : 해당 키에 대한 값을 반환하고 없으면 기본값을 반환
	```python
	tu = {'name' : 'apple', 'color' : 'red'}
	tu.get('name','default)
	```
