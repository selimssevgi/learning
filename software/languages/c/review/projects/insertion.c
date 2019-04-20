#include <stdio.h>
#include <stdlib.h> // rand() ve srand() fonksiyonlari icin gerekli.
#include <time.h> // time() ve difftime() fonksiyonlari icin gerekli. 

#define N 100000

int main(){
		time_t start,end; // time() fonksiyonu time_t tipinde deger donderiyor.
		int A[N] = {0};
		volatile int i,j,temp;
		
		srand(time(NULL)); // Her seferinde farkli sayilar üretmesi icin
		
		// Random sayilari diziye atiyoruz.
		for(i=0; i<N; i++){
				A[i] = rand() % 10000; // 10000 den kucuk sayilar uretiyoruz
		}
		
		start = time(NULL); // Siralama baslama zamani
		printf("Siralamanin Basladigi An : %s \n", ctime(&start));
		
		/*
		// Sorting the array with Insertion 
		for(i=1; i<N; i++){
				temp = A[i]; // Karşılastıracagımız sayı
				j = i-1;	// Seçtiğimiz sayinin bir önunden baslıyoruz            
				
				while(temp<A[j] && j>=0){
						A[j+1] = A[j];
						j = j-1;
				}
				A[j+1] = temp;
		}
		* */
		
		//Bubble Sort
		for(i=0; i<N-1; i++){
			for(j=0; j<N-i; j++){								
				if( A[j]>A[j+1] ){
					
					temp = A[j];
					A[j] = A[j+1];
					A[j+1] = temp;
										
				} // if sonu				
			} // for j sonu
		} //for i sonu
		
		end = time(NULL); // Siralamayi bitirdiği an
		printf("Siralamanin Bittiği An    : %s \n", ctime(&end));
		
		printf("Bubble Siralamasi, %d sayiyi siralamasi %f sn surdu. \n", N,difftime(end,start));
		
		return 0;
}
