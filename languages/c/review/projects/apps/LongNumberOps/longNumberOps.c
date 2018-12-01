/*
 * Büyük sayilari dizide saklayarak dort ıslem yapılacak.
 * 
 * Dizilerin boyutu dizinin 0 indisli elemanı olacak.
*/

#include <stdio.h>
#include <stdlib.h>

int* getNum(int *num){
	int i;
	printf("Sayi kac basamakli > ");
	scanf("%d", &num[0]);
	
	num = (int*)realloc(num, num[0]);
	
	for( i=1; i<=num[0]; i++ ){
		printf("%d.Basamaktaki Rakam > ", i);
		scanf("%d", &num[i]);
	}
	return num;
}

void printNum(int *num){
	int i;
	printf("\nSayi : ");
	for( i=1; i<=num[0]; i++ ){
		printf("%d", num[i]);
	}
}

int* add(int *num1, int *num2, int *result){
	if( num1[0] > num2[0] ){
		result[0] = num1[0] + 1;
	} else {
		result[0] = num2[0] + 1;
	}
	
	result = (int*)realloc(result, result[0]);
	
	int i=num1[0],j=num2[0],k=result[0];
	int elde = 0,top;
	while( i>0 && j>0 ){
		top = num1[i] + num2[j] + elde;
		if( top >= 10 ){
			elde = 1;
			top = top % 10;
		} else {
			elde = 0;
		}
		result[k] = top;
		k--;
		i--;
		j--;
	}
	
	if( i>0 ){
		for( i=j; i>0; i-- ){
			top = num2[i] + elde;
			if( top >= 10 ){
				elde = 1;
				top = top % 10;
			} else {
				elde = 0;
			}
			result[k] = top;
			k--;
		}
	}else {
		for( j=i; j>0; j-- ){
			top = num1[j] + elde;
			if( top >= 10 ){
				elde = 1;
				top = top % 10;
			} else {
				elde = 0;
			}
			result[k] = top;
			k--;
		}
	}
	
	return result;
}

int main(){
	int *num1;
	int *num2;
	int *result;
	int N,i;	
	
	
	num1 = (int*)malloc(1 * sizeof(int));
	num2 = (int*)malloc(1 * sizeof(int));
	result = (int*)malloc(1 * sizeof(int));
	
	
	num1 = getNum(num1);
	num2 = getNum(num2);
	
	result = add(num1, num2, result);
	
	printNum(num1);
	printNum(num2);
	printf("\n");
	printNum(result);
	
	return 0;
}
