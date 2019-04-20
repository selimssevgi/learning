#include <stdio.h>
#include <stdlib.h> // malloc, calloc, realloc, free icin gerekli



int main(){
	float **matris; // pointer-to-pointer
	int i;
	int satir=10, sutun=5;

	// Baslangic Adresi
	matris = (float **) calloc(satir, sizeof(float *));

	for( i=0; i<10; i++ ){
			matris[i] = (float *) calloc(sutun, sizeof(float));
	}



	return 0;
}
