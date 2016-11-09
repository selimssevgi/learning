#include "mylib.h"

int* allocateArray(int n){
    int *arr = 0;

    arr = (int*) malloc( n * sizeof(*arr) );

    if ( arr == 0 ){
        printf("an error occured!!");
    }

    return arr;
}

void swap(int *a, int *b){
    int temp;

    temp = *a;
    *a = *b;
    *b = temp;
}

void initializeArray(int *arr, int n){
    int i=0;

    for( i=0; i<n; i++ ){
        arr[i] = i;
    }
}

void printArray(int *arr, int n){
    int i=0;

    printf("\nThe array consists : \n");
    for( i=0; i<n; i++ ){
        printf("%d:", arr[i]);
    }
}

void randomizeArray(int *arr, int n){
    int i=0;

    srand(time(0)); // seeding the generator

    printf("The array consists : \n");
    for( i=0; i<n; i++ ){
        arr[i] = rand();
    }
}

void sortArray(int *arr, int n){
    int i;
    int j;
    int max=0;

    for( i=0; i<n-1; i++){
        max = i;
        for( j=i+1; j<n; j++ ){
            if( arr[max] < arr[j] ){
                max = j;
            }
        }

        swap(&arr[i],&arr[max]);
    }
}

void reverseArray(int *arr, int n){
    int i=0;
    int j=n-1;
    int temp=0;

    printf("\nReversed Array : \n");

    while(j>i){
        swap(&arr[i],&arr[j]);
        j--;
        i++;
    }
}

int randWithRange(int start, int end){
    int i = 0;

    i = rand() % (end-start) + start;

    return i;
}

int findSecondMax(int *arr,int left,int right){
    int middle = (left+right) / 2;
    int firstMax = left;
    int secondMax = middle;
    int thirdMax = right;

    if( arr[firstMax] < arr[secondMax] ){
        swap(&firstMax,&secondMax);
    }

    if( arr[firstMax] < arr[thirdMax] ){
        swap(&firstMax,&thirdMax);
    }

    if( arr[secondMax] > arr[thirdMax] ){
        return thirdMax;
    }

    return secondMax;

}


