/*
    Tam kare sayilarin son rakamlari : 0,1,4,5,6,9
*/

#include <stdio.h>

int main(){
    int sayi;
    int sonRakam;

    printf("Sayiyi giriniz > ");
    scanf("%d", &sayi);

    sonRakam = sayi % 10;


    return 0;
}
