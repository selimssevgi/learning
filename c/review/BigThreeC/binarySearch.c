#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(){
    int *dizi;
    int arananSayi;
    int N;
    int i,j;
    int first,middle,last;

    srand(time(NULL));

    printf("Dizi boyutu > ");
    scanf("%d", &N);

    dizi = malloc( N * sizeof(int) );

    for( i=0; i<N; i++ ){
        dizi[i] = rand() % 100;
        printf("%3d", dizi[i]);
    }

    printf("\nAranacak sayi > ");
    scanf("%d", &arananSayi);

    first = 1;
    last = N;
    middle = (first + last) / 2;
    while( dizi[middle] != arananSayi && first<last ){

        if( dizi[middle] < arananSayi){
            last = middle;
        }else{
            first = middle;
        }

        middle = (first + last) / 2;
    }

    if( dizi[middle] != arananSayi ){
        printf("Sayi yok.");
    }else{
        printf("Sayi var.");
    }

    return 0;
}
