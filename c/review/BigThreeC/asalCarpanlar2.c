/*
    Verilen bir sayinin asal carpanlarini bulur.
    28 = 2^2x7 seklinde cikti verir.

    18.02.13
    SSSelim
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void diziYazdir(char *msg, int *bolenler, int N){
    int i;

    printf("%s\n", msg);
    for( i=0; i<=N; i=i+2 ){
        printf("%d", bolenler[i]);
       if( bolenler[i+1] != 1 ){
            printf("^%d", bolenler[i+1]);
        }
        if( i != N-1 ){
            printf("x");
        }
    }
}

int main(){
    int asalSayilar[] = { 2,3,5,7,11,13,17,19,23,29 };
    int sayi;
    int bolenler[20] = {0}; // taban,kuvvet,taban,kuvvet seklinde saklanacak
    int kuvvet;
    int i,j,asal;

    printf("Asal carpanlarina ayrilacak sayi > ");
    scanf("%d", &sayi);

    i = 0; // bolenler dizisinin indisi
    j = 0; // asal sayilar dizisinin indisi
    asal = asalSayilar[j];

    while( asal * asal <= sayi ){
        kuvvet = 0;
        while( sayi % asal == 0 ){
            sayi = sayi / asal;
            if( kuvvet == 0 ){
                bolenler[i] = asal;
                i++;
            }
            kuvvet++;
        }
        if( i % 2 != 0){
            bolenler[i] = kuvvet;
            i++;
        }
        j++;
        asal = asalSayilar[j];

    }

    if( sayi != 1 ){
        bolenler[i] = sayi;
        i++;
        bolenler[i] = 1;
    }else{
        i--;
    }

    diziYazdir("Sayinin asal bolenleri : ", bolenler, i);
    return 0;
}

