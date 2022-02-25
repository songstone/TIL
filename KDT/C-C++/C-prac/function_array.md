#### 함수의 인자로 배열 전달

- 배열 자체를 매개변수로 전달하는 것은 불가능
- 포인터로 주소값을 전달 받아 그 요소에 접근하는 것은 가능

#### example
```C
#include <stdio.h>


void ShowArrayElem(int* param, int len){
	for(int i = 0 ; i < len ; i++){
		printf("%d" , param[i]);
	}
	printf("\n");
}

void AddArrayElem(int* param, int len, int add){
	for(int i = 0 ; i < len ; i++){
		param[i] += add;
	}
}

int main(void) {

	int arr[3] = {1,2,3};
	AddArrayElem(arr, sizeof(arr)/sizeof(int), 3);
	ShowArrayElem(arr, sizeof(arr)/sizeof(int));

	AddArrayElem(arr, sizeof(arr)/sizeof(int), 2);
	ShowArrayElem(arr,sizeof(arr)/sizeof(int));

	AddArrayElem(arr,sizeof(arr)/sizeof(int),1);
	ShowArrayElem(arr,sizeof(arr)/sizeof(int));


	return 0;
```
