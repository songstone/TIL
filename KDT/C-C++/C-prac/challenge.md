## Chllenge2

1. 길이가 10인 배열 선언하고 총 10개의 정수를 입력받아 홀수,짝수를 나누어 출력하는 프로그램

```C
#include <stdio.h>

void printOdd(int arr[], int len){
	for(int i = 0 ; i<len; i++){
		if(arr[i]%2 == 1){
			printf("%d " , arr[i]);
		}
	}
	printf("\n");
}
void printEven(int arr[], int len){
	for(int i = 0 ; i<len; i++){
		if(arr[i]%2 == 0){
			printf("%d " , arr[i]);
		}
	}
	printf("\n");
}

int main(void){

	int arr[10];

	for(int i = 0; i<10 ; i++){
		printf("입력 : ");
		scanf("%d", &arr[i]);
	}
	printOdd(arr, sizeof(arr)/sizeof(int));
	printEven(arr, sizeof(arr)/sizeof(int));

	return 0;
}
```

2. 10진수 형태로 정수를 입력받아 2진수로 변환해서 출력하는 프로그램

```C
#include <stdio.h>

int main(void){
	int num;
	int squareNum = 0;
	int compare =1;

	printf("10진수 정수 입력 : ");
	scanf("%d" , &num );

	while(compare<=num){
		compare *= 2;
		squareNum++;
	}

	int trans[squareNum];

	for(int i = 0; i<(squareNum); i++){
		compare = compare/2;
		trans[i] = num/compare;
		num = num%compare;
		printf("%d", trans[i]);
	}
	printf("\n");

	return 0;
}
```

3. 길이가 10인 배열 선언하여 정수를 입력받아 홀수는 앞에서부터 짝수는 뒤에서 부터 채워서 출력하는 프로그램
```C
#include <stdio.h>

int main(void){

	int arr[10];
	int* optr = &arr[0];
	int* eptr = &arr[9];
	int num;

	for(int i = 0 ; i < 10 ; i++){
		printf("입력 : ");
		scanf("%d", &num);
		if(num%2 == 0){
			*eptr = num;
			eptr--;
		}
		else{
			*optr = num;
			optr++;
		}
	}

	for(int i = 0 ; i < 10; i++){
		printf("%d ", arr[i]);
	}


	printf("\n");


	return 0;
}
```

4. 문자열을 입력받아 그 문자열이 앞뒤가 같은 회문인지 아닌지 판별하는 프로그램
```C
#include <stdio.h>
#include <string.h>

int main(void){

	char a[50];
	printf("문자열 입력 : ");
	scanf("%s",a);

	for(int i = 0 ; i<(strlen(a)/2) ; i++){
		if(a[i] != a[strlen(a)-1-i]){
			chk = 1;
			break;
		}
	}
	if(chk==0)
		printf("회문 입니다.");
	else
		printf("회문이 아닙니다.");

	return 0;
}
```

5. 숫자7개를 입력받아 버블정렬 알고리즘을 이용해 내림차순으로 정렬하여 출력하는 프로그램
```C
#include <stdio.h>

void DesSort(int ary[], int len){
	for(int i = 0 ; i<len-1 ; i++){
		for(int j = 0; j < len-i-1 ; j++){
			if(ary[j] < ary[j+1]){
				int temp = ary[j+1];
				ary[j+1] = ary[j];
				ary[j] = temp;
			}
		}
	}
}

int main(void){
	int ary[7];

	for(int i = 0; i<7 ; i++){
		printf("입력 : ");
		scanf("%d", &ary[i]);
	}

	DesSort(ary,7);

	for(int i = 0; i<7; i++){
		printf("%d ",ary[i]);
	}
}

return 0;
```
