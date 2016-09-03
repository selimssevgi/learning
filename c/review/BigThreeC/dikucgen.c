/*
    Kenar uzunluklari 1-1000 arasinda degisen ucgenlerden
    dik olanlari ekrana yazdiriniz.
    11.02.13
*/

#include <stdio.h>
#include <time.h>

#define altSinir 1
#define ustSinir 1000

int main(){
    int kenarA,kenarB,kenarC,i=1;
    time_t baslangic,bitis;
    double sure;

    // kenarC nin altSinir'i kenarB dir. Obur turlu aynı ucgenleri yazmis olacak
    // 5,4,3 ve 5,3,4 gibi.

    baslangic = time(NULL);
    for( kenarA=altSinir; kenarA<=ustSinir; kenarA++  ){
        for( kenarB=altSinir; kenarB<=ustSinir; kenarB++ ){
            for( kenarC=kenarB; kenarC<=ustSinir; kenarC++ ){
                if( (kenarA * kenarA) == (kenarB * kenarB + kenarC * kenarC) ){
                    printf("%d.DikUcgen : %d, %d, %d\n", i,kenarA, kenarB, kenarC);
                    i++;
                }
            }
        }
    }
    bitis = time(NULL);

    sure = difftime(bitis,baslangic);

    printf("Hesaplamanin aldigi sure : %f\n", sure);

    return 0;
}
