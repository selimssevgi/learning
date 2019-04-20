// yaricapi verilen cemberin alan ve cevresini hesaplayan program.

#include <stdio.h>

# define PI 3.14

int main(){
    int yaricap;
    float cevre;
    float alan;

    printf("Cemberin yaricapi > ");
    scanf("%d", &yaricap);

    cevre = 2 * PI * yaricap;
    alan = PI * yaricap * yaricap;

    printf("\nCemberin cevresi : %f\n", cevre);
    printf("Cemberin Alani : %f", alan);

    return 0;
}
