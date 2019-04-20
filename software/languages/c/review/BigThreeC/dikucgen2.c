#include <stdio.h>
#include <time.h>

#define altSinir 1
#define ustSinir 1000

int main(){
    int kenarA,kenarB,kenarC,i=1;
    time_t baslangic,bitis;
    double sure;

    baslangic = time(NULL);
    for( kenarA=altSinir; kenarA<=ustSinir; kenarA++  ){
        for( kenarB=altSinir; kenarB<=ustSinir; kenarB++ ){
            for( kenarC=kenarB; kenarC<=ustSinir; kenarC++ ){
                if( (kenarA - kenarC) * (kenarA + kenarC) == (kenarB * kenarB)){
                    printf("%d.DikUcgen : %d, %d, %d\n", i,kenarA, kenarB, kenarC);
                    i++;
                }
            }
        }
    }
    bitis = time(NULL);

    sure = difftime(bitis, baslangic);

    printf("Programin hesaplama suresi : %f\n", sure);
    return 0;
}
