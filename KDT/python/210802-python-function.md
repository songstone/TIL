### 함수
- 입력값을 받아 결과값 반환하는 형태
```python
def sample(number):
	print(number)
```
```python
def sample2(a,b):
	return a+b
```

### 내장함수
- 자료 형 변환 함수
	- int : 문자열을 숫자형으로 변환
	- str : 숫자를 문자열로 변환
	- list : 문자열이나 튜플을 리스트로 변환
	- tuple : 문자열이나 리스트를 튜플로 변환

- 다른 내장함수
	- len : 자료형의 길이 반환
	- input : 사용자의 입력을 받아 값을 저장할 때 사용
	```python
	result = input('Input : ')
	print(result)
	```
	- range : 해당 숫자범위의 범위 생성
	- max, min : 문자열,리스트,튜플에서의 최대값과 최소값을 반환
