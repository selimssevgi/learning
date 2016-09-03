/*
    17.02.13 SSSelim
    Sirala bir dizi icin;
    verilen bir x elemani, dizideki iki elemanin
    toplamina esit olup olmadiginin bulunmasi.
*/

#include <stdio.h>
#include <stdlib.h> // rand,srand,malloc,free
#include <time.h> // time

void diziRandomla(int *dizi, int N){
    int i;

    for( i=0; i<N; i++ ){
        dizi[i] = rand() % 100; // 100 den kucuk elemanlar
    }
}

void diziYazdir(char *msg, int *dizi, int N){
    int i;

    printf("%s\n", msg);
    for( i=0; i<N; i++ ){
        printf("%4d", dizi[i]);
    }

    printf("\n");
}

void diziSirala(int *dizi, int N){ // Selection Sort
    int i,j,tmp;
    int minIndis; // kucukten buyuge sirala

    for( i=0; i<N-1; i++ ){ // N-1 bir degiskene aktarilabilirdi.
        minIndis = i;
        for( j=i+1; j<N; j++ ){
            if( dizi[j] < dizi[minIndis] ){
                minIndis = j;
            }
        }
        tmp = dizi[i];
        dizi[i] = dizi[minIndis];
        dizi[minIndis] = tmp;
    }
}

int main(){
    int diziBoyutu;
    int *dizi;
    int sayi;
    int i,j;

    srand(time(NULL));

    printf("Dizinin boyutu > ");
    scanf("%d", &diziBoyutu);

    dizi = (int*)malloc(diziBoyutu * sizeof(int));
    if( dizi == NULL ){ printf("Bellek yetersiz!");  return 0; }

    diziRandomla(dizi, diziBoyutu);
    diziYazdir("Dizinin ilk hali :", dizi, diziBoyutu);
    diziSirala(dizi, diziBoyutu);
    diziYazdir("Dizinin siralanmis hali : ", dizi, diziBoyutu);

    printf("    |Gireceginiz sayinin, dizideki iki elemanin\n");
    printf("    |toplami olup olmadigina bakilacak.\n");
    printf("Sayi > ");
    scanf("%d", &sayi);

    i=0;
    j=diziBoyutu-1;
    // sayi toplami olan bir kac cift olabilir
    // bu sekilde ilk bulma durumunda cikiyor.
    while( (i != j) && (dizi[i] + dizi[j] != sayi) ){
        if( dizi[j] > sayi ){
            j--;
        }else if( dizi[i] + dizi[j] < sayi ){
            i++;
        }else{
            j--;
        }
    }

    if( i != j ){
        printf("%d + %d = %d seklinde.", dizi[i],dizi[j],sayi);
    }else{
        printf("Bulunamadi!");
    }

    free(dizi);
    return 0;
}
