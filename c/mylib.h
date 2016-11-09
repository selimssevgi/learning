#ifndef MYLIB_H_INCLUDED
#define MYLIB_H_INCLUDED

int* allocateArray(int n);

void swap(int *a, int *b);

void initializeArray(int *arr, int n);

void printArray(int *arr, int n);

void randomizeArray(int *arr, int n);

void sortArray(int *arr, int n);

void reverseArray(int *arr, int n);

int randWithRange(int start, int end);

int findSecondMax(int *arr,int left,int right);

int partition(int *arr, int left, int right);

void qs(int *arr, int left, int right);

#endif

