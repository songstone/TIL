## 파이썬의 조건문과 반복문

### 조건문(if)
- if, elif, else 이용( 다른 언어들과 조건의 형태는 같다)
- 자료형 별로 값이 비어있으면 기본적으로 논리값은 false가 된다. 자료형 그자체를 이용하여 조건문에 이용가능
```python
int_var = 1
if int_var:
	print(int_var)
```

### 반복문(for)
- 정해진 횟수만큼 반복할때 사용
- 반복하는 데이터가 코드안에 존재할 때 주로 사용
- range함수를 이용하여 조합하여 많이 사용. 0부터 인자로 사용된 숫자 전까지의 리스트 생성
```python
for i in [1,2,3,4,5]:
	print(i)

for i in range(100):
	print(i)
```
- 딕셔너리를 사용할때는 key와 value를 묶음으로 지정
```python
for (key, value) in {'one' : 1 , 'two' : 2}:
	print(key)
	print(value)
```

### 반복문(while)
- 특정조건을 만족할 때까지의 반복
```python
list = [1,2,3,4,5]
while list:
	list.pop()
```
