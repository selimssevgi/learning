#include <stdio.h>

int main(){
	// Bir boyutlu dizi ilklendirme
	int tekBoyut[3] = { 11, 22, 33 };
	
	// İki boyutlu dizi ilklendirme
	int ikiBoyut[3][3] = { { 3, 4, 5 },
						   { 6, 7, 8 },
						   { 0, 1, 2 }
						  };
	int i,j;
	int *pTek, *pCift, *pSatir;
	
	pTek = tekBoyut; // tekBoyut = &tekBoyut[0]
	pCift = &ikiBoyut[0][0]; // &ikiBoyut[0][0] = ikiBoyut // Ama sagdaki uyari veriyor!
	
	for( i=0; i<3; i++ ){
			pSatir = ikiBoyut[i]; // i.satirin baslangic adresini belirtir.
			printf("ikiBoyut[%d][0] = %d\n", i, *pSatir); // Aslinda *(pSatir + 0)
			printf("ikiBoyut[%d][1] = %d\n", i, *(pSatir + 1));
			printf("ikiBoyut[%d][2] = %d\n", i, *(pSatir + 2));
	}
	
	printf("pTek = tekBoyut , *pTek = %d\n", *pTek);
	printf("pCift = ikiBoyut, *pCift = %d\n", *pCift);	
	
	for( i=0; i<3; i++ ){
			printf("\n");
			for( j=0; j<3; j++ ){
					printf("%d, ", ikiBoyut[i][j]);
			}
	}
	
	printf("\n\nikiBoyut[1][2] = (8) %d \n", ikiBoyut[1][2]);
	
	return 0;
}
