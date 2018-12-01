#include <stdio.h>

int main(){
    int sayi1,sayi2,islem;
    float sonuc;

    printf("1- Toplama\n");
    printf("2- Cikarma\n");
    printf("3- Carpma\n");
    printf("4- Bolme\n");

    do{
        printf("hangi islemi yapmak istiyorsunuz > ");
        scanf("%d", &islem);
    }while( islem > 4 );

    printf("\nIlk sayi > ");
    scanf("%d", &sayi1);
    printf("Ikinci sayi > ");
    scanf("%d", &sayi2);

    if( islem == 1 ){
        sonuc = sayi1 + sayi2;
    }else if( islem == 2 ){
        sonuc = sayi1 - sayi2;
    }else if( islem == 3 ){
        sonuc = sayi1 * sayi2;
    }else if( islem == 4 ){
        sonuc = sayi1 * 1.0 / sayi2;
    }

    printf("\nIslem sonucu : %f", sonuc);

    return 0;
}
