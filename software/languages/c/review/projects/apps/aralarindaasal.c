#include <stdio.h>

#define N 5

int main(){
	int ks,i,j,k,ebob;
	int A[N];
	
	// Sayilari al
	for( i=0; i<N-1; i++ ){
			printf("%d.Sayiyi gir : ", i+1);
			scanf("%d", &A[i]);
	}
	
	for( i=0; i<N-1; i++ ){
		for( j=i+1; j<N; j++ ){
			// Kucuk sayi bul
			if( A[i] > A[j] ){
					ks = A[j];
			}else {
					ks = A[i];
			}
			
			for( k=1; k<=ks; k++ ){
				// Ebob bul
				if( (A[i] % k == 0) && (A[j] % k == 0) ){
						ebob = k;
				}
			}
			
			// Aralarında Asallar mı?
			if( ebob == 1 ){
				printf("%d ve %d aralarinda asaldir.\n", A[i], A[j]);
			}
		}
	}
	
	return 0;
}
