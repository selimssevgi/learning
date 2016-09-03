/*
    Verilen bir sayinin asal carpanlarini bulur.
    28 = 2.2.7 şeklinde cıktı verir.

    18.02.13
    SSSelim
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void diziYazdir(char *msg, int *bolenler, int N){
    int i;

    printf("%s\n", msg);
    for( i=0; i<=N; i++ ){
        printf("%d.", bolenler[i]);
        // bir if sorgusuyla en sondaki nokta kaldirilabilir.
    }
}

int main(){
    int asalSayilar[] = { 2,3,5,7,11,13,17,19,23,29 };
    int sayi;
    int bolenler[10];
    int i,j,asal;
    int yedekSayi; // inputu degistirmeden saklamakta fayda var.

    printf("Asal carpanlarina ayrilacak sayi > ");
    scanf("%d", &sayi);

    yedekSayi = sayi;
    i = 0;
    j = 0;
    asal = asalSayilar[j];

    // (asal * asal < sayi) : 4 sayisi icin bu sart saglanmaz
    // ve 4 sayinin asal bolenleri bulunamazdi.
    while( asal * asal <= sayi ){
        while( sayi % asal == 0 ){
            sayi = sayi / asal;
            bolenler[i] = asal;
            i++;
        }
        j++;
        asal = asalSayilar[j];
    }

    if( sayi != 1 ){
        bolenler[i] = sayi;
    }else{
        // sayi == 1 oldugunda bolenler dizimizin
        // eleman sayisi yanlis olurdu.
        i--;
    }

    diziYazdir("Sayinin asal bolenleri : ", bolenler, i);

    return 0;
}
