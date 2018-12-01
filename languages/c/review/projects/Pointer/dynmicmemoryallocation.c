#include <stdio.h>
#include <stdlib.h> // required for malloc,calloc,realloc,free functions.

int main(){
	int *pDizi; // Dizimizin baslangic adresini gosterecek pointer.
	int N,i;
	
	// Kullanicadan aldigimiz deger kadar yer ayiracaz.
	printf("Dizimiz kac elemanlı olsun > \n");
	scanf("%d", &N);
	
	// malloc void pointer i gonderir bunun gerekli durumlarda cast edilmesi gerekir.
	pDizi = (int *) malloc(N * sizeof(int)); 
	
	// Eğer malloc yer bulamadıysa NULL pointer gonderir.
	if( pDizi == NULL){
			printf("Bellekte yer ayrilamadi!");
			return 0;
	} else {
		// Bellekte yer ayrıldıysa islemlerimize devam ediyoruz.
			for( i=0; i<N; i++ ){
					printf("%d.Eleman : \n", i+1);
					scanf("%d", pDizi+i);
			}
			
			printf("Dizinin 2.elemani : %d\n", *(pDizi+1));
			
			// Ayirdigimiz bölgeyi bosaltiyoruz.
			free(pDizi);
			
			pDizi = NULL; // Programın sonraki kısımlarında kullanılmaması icin.
	}	
	return 0;
}
