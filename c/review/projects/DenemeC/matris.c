#include <stdio.h>

int main(){
	int matris[10][15];
	int *pMatris;
	
	matris[0][0] = 0;
	pMatris = matris;
	
	printf("Matrisin ilk elemani > %d",*pMatris);
	
	return 0;
}
