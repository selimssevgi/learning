/*
    Selection Sort algoritmasi
    14 02 13
    Buyukten -> kucuge
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void printArray(int* dizi, int diziBoyutu){
    int i;

    for( i=0; i<diziBoyutu; i++ ){
        printf("%5d", dizi[i]);
    }
    printf("\n  ");
}

int main(){
    int diziBoyutu;
    int *dizi;
    int i,j;
    int max;
    int indis;

    srand(time(NULL)); // fark degerler icin

    printf("Dizinin boyutu > ");
    scanf("%d", &diziBoyutu);

    // verilen boyutta bir dizi olustur
    dizi = (int*)malloc(diziBoyutu * sizeof(int));
    if( dizi == NULL ){ printf("Yetersiz bellek!"); return 0; }

    // diziye rasgele elemanlar ata
    for( i=0; i<diziBoyutu; i++ ){
        dizi[i] = rand() % 100; // 100 den kucuk elemanlar.
    }

    printf("Dizinin ilk hali :\n");
    printArray(dizi, diziBoyutu);

    // Selection Sort
    for( i=0; i<diziBoyutu-1; i++ ){
        max = dizi[i];
        indis = i;
        for( j=i+1; j<diziBoyutu; j++ ){
            if( dizi[j] > max ){
                max = dizi[j];
                indis = j;
            }
        }
        // buraya geldigimizde taranan elemanlarin en buyugunu
        // bulmus oluyoruz basa alalim
        dizi[indis] = dizi[i];
        dizi[i] = max;
    }

    printf("Dizinin siralanmis hali:\n");
    printArray(dizi, diziBoyutu);

    free(dizi);
    return 0;
}
