## 클래스와 모듈

### 클래스
- 변수와 함수의 집합
- init과 self를 이용해 생성자와 객체에 대한 접근을 지정해야 한다.
```python
class Sample:
	def __init__(self):
		self.name = 'apple'
	
	def print_name(self):
		print(self.name)

	def print_name_more(self, num):
		for i in range(num):
			print(self.name)
```

### 모듈
- 클래스, 함수, 변수의 집합
- 라이브러리, 패키지라고도 부름
- 다른 파일의 사용을 용이하게 만든다
- from <파일명> import <클래스>를 이용하여 해당 파일의 클래스를 사용할 수 있다
- import <파일명>으로 사용 할수도 있으나 이때는 클래스 선언시 앞에 파일명을 명시하여 클래스를 호출해야한다
```python
from test import Sample
import test2

m_sample = Sample()
m_sample2 = test2.Sample2()
```
