#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main (){
	int *arr;
	int *range,*repetition;
	int i,j,minValue,maxValue,Nrange,maxRepetition,N;
	
	srand(time(NULL));
	
	printf("Enter N value > ");
	scanf("%d", &N);
	
	// kac tane sayı isteniyorsa onları sakyalabileceğimiz dizi için yer ayıralım
	arr = (int *) malloc( N * sizeof(int) );	
	if( arr == NULL ){ printf("Error : not able to allocate memory!"); return 0;} // Bellek ayırma islemi basarılı mı?
	
	printf("MixValue and maxValue > ");
	scanf("%d %d", &minValue, &maxValue);
	
	Nrange = maxValue - minValue; // Verilen aralıkta kac sayı var.(ilk elemanı saymıyoruz.)
	
	// Aralıgı tutacak olan dizi ve tekrar sayısını tutacak dizi icin yer ayıralım
	range = (int *) malloc( Nrange * sizeof(int));
	if( range == NULL ){ printf("Error : not able to allocate memory!"); return 0;}
	
	repetition = (int *) malloc( Nrange * sizeof(int));
	if( repetition == NULL ){ printf("Error : not able to allocate memory!"); return 0;}
	
	// Arasından rastgele seçilecek diziyi belirle
	for( j=minValue+1, i=0; i<Nrange; i++ ){
		range[i] = j;
		j++;
	}
	
	printf("\n");
	// kumeden rastgele sectigin sayıları diziye ekle 
	for( i=0; i<N; i++ ){		
		j = rand() % Nrange;
		arr[i] = range[j];
	}
	
	// Tekrar edilme sayısını bul
	for( i=0; i<N; i++ ){	
		repetition[arr[i]-minValue-1]++;
	}
		
	// Tekrar sayılarından en buyugu
	maxRepetition = 0;
	for( i=0; i<Nrange; i++ ){
		if( maxRepetition<repetition[i] ){ maxRepetition = repetition[i]; }
	}	
	
	// Tekrar edilme sayılarına göre x leri diz.
	i=0;
	while( i != N ){	
		for( j=0; j<Nrange; j++ ){
			if( maxRepetition <= repetition[j] ){
				printf("X ");
				i++;
			}else{
				printf("  ");
			}
		}
		
			maxRepetition--;			
			printf("\n");
	}
	
	// En alttaki min-max deger aralıgı
	for( i=0; i<Nrange; i++ ){		
		printf("%d ", range[i]);
	}
	
	free(arr);
	free(range);
	free(repetition);
	return 0;
}

















