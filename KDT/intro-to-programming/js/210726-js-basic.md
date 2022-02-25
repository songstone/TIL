## js기초 정리

#### js 기초
 - 변수는 let으로 선언, 같은 이름으로 여러번 선언x
 - 상수는 const로 선언, 값을 재할당하거나 재선언할 수 없다.
 - 문자열 선언은 ‘ 로 선언
 - null과 undefined는 비슷하지만 null은 값이 없는 거고, undefined는 값이 아직 정해지지 않았다는 의미이다.

#### 비교 연산자
 - js에서 같은지 비교 하고 싶을때는 ‘===’ 를 이용한다. (‘==’는 타입형을 검사하지 않는다)
 - ‘!==’ 와 ‘!=’도 위 사항과 마찬 가지로 ‘!==”을 사용하자

#### 함수
 - function으로 선언. function 함수명(매개변수){...}
 - 반환값을 return으로 지정 해 줄수 있는데 return이 실행되면 함수는 종료된다.
 - 화살표형 함수 문법 : (a,b) => return a+b;

#### 객체
 - 하나의 이름에 여러 종류의 이름을 담을 수 있다.
 - key값과 value값으로 정의. 각 요소는 쉼표 구분(key1 : value1, key2 : value2 }
 - 중괄호로 묶어서 선언. 객체명 = { name : dog, age : 20}
 ```javascript
const dog = {
    name : dog,
    age : 2
}
 ```
 - 비구조 할당(객체 구조 분해) : 객체에서 특정 값 추출
    1. 
    ```javascript
    function print (hero){
        const {alias, name, actor} = hero;
        const text = `${alias}(${name})역할을 맡은 배우는 ${actor} 입니다.`
    }
    ```
    2. 
    ```javascript
    function print ({alias, name, actor}){
       const text = `${alias}(${name})역할을 맡은 배우는 ${actor} 입니다.`
    }
    ```

   

#### 배열 내장함수 
 - 대부분 배열명.함수명 으로 호출
 - foreach : for문 대치. 배열 전체에 대해 수행(배열명.forEach)
 - map : 각 요소 변환.(array.map(n=>n*n))
 ```javascript
 const array = [1,2,3,4];
 const squared = array.map(n => n*n);
 ```
 - indexOf : 찾는 값의 index값 반환 (array.indexOf(‘찾을값')
 - findindex : 조건에 맞는 객체의 index값 반환 (array.findindex(todo => todo.id ===3)
 - find : 조건에 맞는 객체 반환 (array.find(todo => todo.id ===3)
 - filter : 조건에 맞는 배열 생성 ( array.filter(todo => todo.id ===3)
 - splice : 특정 항목 제거 (array.splice(0,1))는 인덱스0번부터 1개 제거, 단 splice는 원래의 배열 자체를 변화시킨다.
 - slice : 배열을 자를 때 사용 (array.slice(0,2)는 인덱스0번부터 2번 전까지를 잘라서 새로운 배열을 생성
 - shift : 배열의 첫번째 요소 추출하여 반환
 - pop : 배열의 마지막 요소 추출하여 반환
 - unshift : 배열의 첫번째에 요소 추가
 - concat : 배열 병합 (arr1.concat(arr2))는 arr1에 arr2를 붙여서 새로운 배열 생성
 ```javascript
 arr1 = [1,2,3];
 arr2 = [4,5,6];
 const concated = arr1.concat(arr2);
 ```
 - joint : 배열 안 요소들의 값을 문자열 형태로 합친다.
    - array.join() : 1,2,3,4,5
    - array.join(‘ ‘) : 1 2 3 4 5
    - array.join(‘, ‘) : 1, 2, 3, 4, 5
