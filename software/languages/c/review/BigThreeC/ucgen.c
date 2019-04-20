// kenarlari, tabani ve yukseligi verilen ucgenin cever ve alan hesabi

#include <stdio.h>

int main(){
    int kenarA;
    int kenarB;
    int kenarC;
    int yukseklik;
    int cevre;
    float alan;

    printf("Ucgenin 1.kenar uzunlugu > ");
    scanf("%d", &kenarA);

    printf("Ucgenin 2.kenar uzunlugu > ");
    scanf("%d", &kenarB);

    printf("Ucgenin 3.kenar uzunlugu > ");
    scanf("%d", &kenarC);

    printf("Ucgenin 1.kenarina ait yukseklik > ");
    scanf("%d", &yukseklik);

    cevre = kenarA + kenarB + kenarC;
    alan = kenarA * yukseklik * 0.5;

    printf("\nUcgenin cevresi : %d\n", cevre);
    printf("Ucgenin alani : %f", alan);
    return 0;
}
