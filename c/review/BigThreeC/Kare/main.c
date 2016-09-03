// Kenari girilen bir karenin alan ve cevresini hesaplayan program.

#include <stdio.h>
#include <stdlib.h>

int main()
{
    int kenar;
    int alan;
    int cevre;

    // INPUT
    printf("Karenin kenar uzunlugu > ");
    scanf("%d", &kenar);

    // PROCESSING
    alan = kenar * kenar;
    cevre = kenar * 4;

    // OUTPUT
    printf("\n");
    printf("Karenin Cevresi : %d\n", cevre);
    printf("Karenin Alani : %d\n", alan);

    return 0;
}
