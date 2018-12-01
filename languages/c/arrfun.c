#include <stdio.h>
#include <stdlib.h>
#include <time.h>


int* allocateArray(int n){
    int *arr = 0;

    arr = (int*) malloc( n * sizeof(*arr) );

    if ( arr == 0 ){
        printf("an error occured!!");
    }

    return arr;
}

int** allocateMatrix(int rows, int cols){
    int **mat = 0;

    mat = (int **)malloc(rows * sizeof(int*));

    if ( mat != 0 ){
        for(int i = 0; i < rows; i++){
            mat[i] = (int *)malloc(cols * sizeof(int));
        }
    } else {
        printf("an error occured!!");
    }

    return mat;
}

void initializeMatrix(int row, int col, int mat[row][col]){
    int i,j;

    for( i=0; i < row; i++ ){
        for( j=0; j < col; j++ ){
             mat[i][j] = 0;
        }
    }
}

int findMinMatrix(int** mat, int row, int col){
    int min = mat[0][0];

    for( int i=0; i < row; i++ ){
        for( int j=0; j < col; j++ ){
            if( min > mat[i][j] ){
                min = mat[i][j];
            }
        }
    }

    return min;
}

int findMaxMatrix(int** mat, int row, int col){
    int max = mat[0][0];

    for( int i=0; i < row; i++ ){
        for( int j=0; j < col; j++ ){
            if( max < mat[i][j] ){
                max = mat[i][j];
            }
        }
    }

    return max;
}

void printMatrix(int** mat, int row, int col, , char *msg){

    printf("\n%s\n", msg);

    for( int i=0; i < row; i++ ){
        for( int j=0; j < col; j++ ){
            printf("%d ", mat[i][j]);
        }

        printf("\n");
    }
}


void initializeArray(int *arr, int n){
    int i=0;

    for( i=0; i<n; i++ ){
        arr[i] = i;
        //printf("\n%d\n", arr[i]);
    }
}
void swap(int *a, int *b){
    int temp;

    temp = *a;
    *a = *b;
    *b = temp;
}

void printArray(int *arr, int n, char *msg){
    int i=0;

    printf("\n%s\n", msg);
    for( i=0; i<n; i++ ){
        printf(" %d ", arr[i]);
    }
}

void printMatrix(int row, int col, int mat[row][col], char *msg){
    int i,j;

    printf("\n%s\n", msg);
    for( i=0; i < row; i++ ){
        for( j=0; j < col; j++ ){
             printf("%d ", mat[i][j]);
        }
        printf("\n");
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
    // Selection Sort
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

int main(){
    int *arr;
    int **mat;
    int rows=5;
    int cols=5;
    int n;

/*
    printf("Size?>");
    scanf("%d", &n);

    arr = allocateArray(n);
    initializeArray(arr,n);
    //printArray(arr,n);
    //randomizeArray(arr,n);
   // printArray(arr,n);
*/

    mat = allocateMatrix(rows,cols);
    initializeMatrix(rows,cols,mat);
    printMatrix(rows,cols,mat,"Matris :");

    //free(mat);
    return 0;
}
