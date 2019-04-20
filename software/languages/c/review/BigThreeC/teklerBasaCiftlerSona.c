/*
    Bir dizideki elemanlarin, baska bir dizi kullanilmadan
    teklerin basa ciftlerin ise sona tasindigi program.
    SSSelim
    15.02.13
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void diziYazdir(int *dizi, int N){
    int i;
    printf("\n");
    for( i=0; i<N; i++ ){
        printf("%3d", dizi[i]);
    }
    printf("\n");
}

int main(){
    int *dizi=NULL;
    int i,j;
    int diziBoyutu;
    int tmp;

    srand(time(NULL)); // her acilista farkli rasgele degerler icin

    printf("Dizimizin boyutu > ");
    scanf("%d", &diziBoyutu);

    dizi = (int*)malloc(diziBoyutu * sizeof(int));
    if( dizi == NULL ){ printf("Bellek yetersiz!"); return 0; }

    for( i=0; i<diziBoyutu; i++ ){
        dizi[i] = rand() % 100; // 100 den kucuk degerler icin
    }

    printf("Dizimizin ilk hali : ");
    diziYazdir(dizi, diziBoyutu);

    i = 0;
    j = diziBoyutu-1;

    while( i != j ){
        if( dizi[i] % 2 == 0 ){
                while( dizi[j] % 2 == 0 && j != i){ // dizinin tumu cift sayi olabilir
                    j--;
                }
                if( i != j ){
                   tmp = dizi[i];
                   dizi[i] = dizi[j];
                   dizi[j] = tmp;
                   j--;
                   i++;
                }
        }else{
            i++;
        }
    }

    printf("Tekler basta, ciftler sonda olan hali : ");
    diziYazdir(dizi, diziBoyutu);

    free(dizi);
    return 0;
}
