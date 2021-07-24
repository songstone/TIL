#### 더블 포인터 
- 포인터형 변수의 포인터
- #좀더 공부해보기

#### example
```C
#include <stdio.h>

void MaxAndMin(int arr[], int** xPtr, int** nPtr){

	*xPtr = &arr[0];
	*nPtr = &arr[0];

	for(int i = 0 ; i<5; i++){
		if(**xPtr < arr[i]){
			*xPtr = &arr[i];
		}
		if(**nPtr > arr[i]){
			*nPtr = &arr[i];
		}
	}
}

int main(void){
	int* maxPtr;
	int* minPtr;
	int arr[5];

	for(int i = 0 ; i<5 ; i++){
		printf("입력 : ");
		scanf("%d", &arr[i]);
	}

	MaxAndMin(arr, &maxPtr, &minPtr);

	printf("%d",*maxPtr);
	printf("%d",*minPtr);

	return 0;
}

```
