#### Call-by-value vs Call-by-reference

- value : 값을 호출하여 복사 및 저장하여 함수의 인자로 활용(지역변수 느낌)
- reference : 주소값을 호출하여 참초해서 인자로 활용(전역변수 느낌)

#### example
```C
#include <stdio.h>

int SquareByValue(int num){
	return num*num;

}

void SquareByRef(int* num){
	*num = (*num)*(*num);
}

int main(void){

	int i = 3;
	int k = SquareByValue(3);
	printf("%d ", k);
	SquareByRef(&i);
	printf("%d", i);

	return 0;
}
```
