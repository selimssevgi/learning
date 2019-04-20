// Kenar uzunluklari verilen bir dikdortgenin alan ve cevresini hesaplayan program.

#include <stdio.h>

int main(){
    int kenarA;
    int kenarB;
    int cevre;
    int alan;

    printf("Dikdortgenin kisa kenari > ");
    scanf("%d", &kenarA);

    printf("Dikdortgenin uzun kenari > ");
    scanf("%d", &kenarB);

    cevre = 2 * (kenarA + kenarB);
    alan = kenarA * kenarB;

    printf("\n");
    printf("Dikdortgenin cevresi : %d\n", cevre);
    printf("Dikdortgenin alani : %d", alan);

    return 0;
}
