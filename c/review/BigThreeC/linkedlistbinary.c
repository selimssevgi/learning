#include <stdio.h>
#include <stdlib.h>
#include <time.h>


int main(){
    int **LL;
    //int LL[13][2];
    int N,col,i,j,onceki;
    int indis,current;

    srand(time(NULL));

    printf("the count of numbers > ");
    scanf("%d", &N);

    col = 2;
    // NX2 matris allocation
    LL = (int**)malloc( N * sizeof(int*) );
    if( LL == NULL ){ printf("Hata!"); return 0; }
    for( i=0; i<N; i++ ){
        LL[i] = (int*)malloc( col * sizeof(int) );
    }

    for( i=0;i<N; i++ ){
        LL[i][0] = rand() % 100;
        LL[i][1] = 0;
    }

    LL[0][1] = 1;
    LL[1][1] = -1;

    // YAZDIR
    for( i=0; i<N; i++ ){
        printf("%2d   %2d   %2d\n", i, LL[i][0], LL[i][1]);
    }

    for( indis=2; indis<N; indis++ ){
        current = LL[0][1];
        onceki = 0; // while girmediginde gelen sayiyi en basa alacak

        while( (LL[indis][0] >= LL[current][0]) && current != -1 ){
            onceki = current;
            current = LL[current][1];
        }

        // LL[current][0], current -1 olmamalı, rasgele degerle karsilastirir.
        if( (LL[indis][0] < LL[current][0]) && current != -1 ){
            LL[onceki][1] = indis;
            LL[indis][1] = current;
        }
        else{
            LL[onceki][1] = indis;
            LL[indis][1] = -1;
        }
    }

    printf("\n\n");

    for( i=0; i<N; i++ ){
        printf("%2d   %2d   %2d\n", i, LL[i][0], LL[i][1]);
    }

    printf("\n------Sirali Hali-----\n");
    current = LL[0][1];
    while( current != -1 ){
        printf("%3d", LL[current][0]);
        current = LL[current][1];
    }

    return 0;
}

























