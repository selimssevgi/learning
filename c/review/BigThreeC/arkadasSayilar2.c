/*
    İki sayı birbirinin kendisi hariç bölenleri toplamına eşitse bu sayılara arkadaş sayılar denir.
    Örnek: 220 ve 284
    220 : 1 + 2 + 4 + 5 + 10 + 11 + 20 + 22 + 44 + 55 + 110 = 284
    284 : 1 + 2 + 4 + 71 + 142 = 220
*/

#include <stdio.h>

int main(){
    int sayi1,sayi2,i;
    int sinir1,sinir2;
    int bolenlerTop1=1,bolenlerTop2=1;

    printf("ilk sayi > ");
    scanf("%d", &sayi1);

    printf("ikinci sayi > ");
    scanf("%d", &sayi2);

    sinir1 = sqrt(sayi1);
    sinir2 = sqrt(sayi2);

    for( i=2; i<=sinir1; i++ ){
        if( sayi1 % i == 0 ){
            bolenlerTop1 += i + sayi1 / i;
        }
    }

    for( i=2; i<=sinir2; i++ ){
        if( sayi2 % i == 0 ){
            bolenlerTop2 += i + sayi2 / i;
        }
    }

    if( bolenlerTop1 == sayi2 && bolenlerTop2 == sayi1 ){
        printf("bu sayilar arkadas sayilardir.");
    }else{
        printf("Bu sayilar arkadas sayilar değildir.");
    }
    return 0;
}

