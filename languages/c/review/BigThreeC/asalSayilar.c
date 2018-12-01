/*
    Verilen sayiya kadar olan asal sayilari bulur.
    Sayi : 15 - > Cikti : 2,3,5,7,11 gibi.

    18.02.13
    SSSelim
*/


#include <stdio.h>
#include <stdlib.h>


int* allocate(int boyut){
    int *dizi;

    dizi = (int*)malloc(boyut * sizeof(int));
    if( dizi == NULL ){
        printf("HATA : Bellek yetersiz!");
        exit(0);
    }

    return dizi;
}

void diziYazdir(char *msg, int *dizi, int N){
    int i;

    printf("\n\n%s\n", msg);
    for( i=0; i<N; i++ ){
       printf("%3d", dizi[i]);
    }
}

void asallariBul2(int *dizi, int N){ // yahya hocanin yontemi
    int i=1,j,asal=2;

    // N aslinda sayimiz
    while( asal * asal < N ){ // gidecegimiz sinir.
        j = asal * asal;
        while( j < N ){
            dizi[j] = 0;
            j = j + 2*asal;
        }

        do{
            i++;
        }while( dizi[i] == 0 );
        asal = dizi[i];
    }
}

int asallariBul1(int *dizi, int N){ // yontem 1
    int i;
    int j=1;
    int asal=2;
    int asalOlmayanlarinSayisi=0;

    while( asal * asal <= N){
        for( i=j+1; i<N; i++ ){
            if( dizi[i] != 0 && dizi[i] % asal == 0){
                dizi[i] = 0;
                asalOlmayanlarinSayisi++;
            }
        }

        do{
            j++;
        }while( dizi[j] == 0 );
        asal = dizi[j];
    }

    return N - asalOlmayanlarinSayisi - 1;  // Asal sayilarin sayisini geri gonderiyoruz
}

void asallariAyikla(int *dizi, int sayi, int *asalSayilar){
    int i;
    int j=0;

    for( i=1; i<sayi; i++ ){
        if( dizi[i] != 0 ){
            asalSayilar[j] = dizi[i];
            j++;
        }
    }
}

int main(){
    int sayi, asalMiktari;
    int *dizi;
    int *asalSayilar;
    int i;


    printf("sayi > ");
    scanf("%d", &sayi); // sayi ayni zamanda diziBoyutu

    dizi = allocate(sayi);

    for( i=0; i<sayi; i++ ){
        dizi[i] = i+1;
    }

    diziYazdir("Olusturulan ilk dizi : ", dizi, sayi);

    asalMiktari = asallariBul1(dizi, sayi);

    diziYazdir("Sonraki hali : ", dizi, sayi);

    asalSayilar = allocate(asalMiktari);

    asallariAyikla(dizi, sayi, asalSayilar);

    diziYazdir("araliktaki asal sayilar :", asalSayilar, asalMiktari);

    printf("\n\nAsalMiktari : %d\n", asalMiktari);
/*
    diziYazdir("Olusturulan ilk dizi : ", dizi, sayi);

    asallariBul2(dizi, sayi);

    diziYazdir("Sonraki hali : ", dizi, sayi);
*/

    return 0;
}
