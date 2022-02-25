#### 배열 내장 함수
- reduce : 배열 전체를 돌면서 누적값 구하는 데 유용
    - [배열명].reduce((누적값, 현재값, 인덱스, 배열) => {return 결과} , 초깃값)
    - 초기값은 누적값의 초기값이고 생략할시 배열의 첫번째 요소값이 초기값으로 설정된다. 인덱스는 현재 처리하는 요소의 배열에서의 인덱스 값을 나타내고 배열은 reduce가 수행중인 배열 그 자체를 나타낸다.
	- reduce를 이용하여 평균을 구하는 예시
	```javascript
	numbers.reduce((acc,cur,index,array) => {
			if(index === array.length-1){
				return(acc + cur) / array.length
			}
			else
				return acc + cur
			});
	```

#### 객체생성자
- 함수 이름의 첫 글자를 대문자로 하여 매개변수와 함께 정의하고 생성시에는 ‘new’를 이용하여 생성
- 프로토타입으로 공통의 값이나 함수를 호출할 수 있다.
- es6부터 클래스가 추가됨에 따라 객체생성자를 이용한 코드보다 쉽고 명확하게 클래스로 나타낼 수 있다.

#### 클래스
- 객체생성자의 코드를 좀 더 명확하고 깔끔하게 구현 할수 있고, 상속도 쉽게 할 수 있다.
- ‘class [클래스명(첫글자 대문자] { [코드] }’ 로 선언
- 내부에서 constructor를 이용해 생성자를 정의 할 수 있다.
- extends와 super를 이용해 상속을 좀 더 쉽게 할수 있다.
```javascript
class Animal {
  constructor(type, name, sound) {
    this.type = type;
    this.name = name;
    this.sound = sound;
  }
  say() {
    console.log(this.sound);
  }
}

class Dog extends Animal {
  constructor(name, sound) {
    super('개', name, sound);
  }
}

class Cat extends Animal {
  constructor(name, sound) {
    super('고양이', name, sound);
  }
}

const dog = new Dog('멍멍이', '멍멍');
const cat = new Cat('야옹이', '야옹');

dog.say();
cat.say();
```
