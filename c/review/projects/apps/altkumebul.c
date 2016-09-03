/*
 * Eleman sayisi ve elemanları verilen bir kumenin
 * alt kümelerini tek tek ekrana yazdiran program.
 * SSSelim 16.10.12
 */ 
 
#include <stdio.h>
#include <stdlib.h> // malloc,calloc,realloc,free icin gerekli.

// Us hesaplama
int ikiUssu(int us){
	int i, sonuc=1;
		
	for( i=1; i<=us; i++){
		sonuc *= 2;
	}
		
	return sonuc;
}

void durumAyarla(int *durum, int onlukSayi, int elemanSayisi){
	int i=0;

	while( onlukSayi>=2 ){
		*(durum + i) = onlukSayi % 2;
		onlukSayi = onlukSayi / 2;
		i++;
	}
	
	*(durum + i) = onlukSayi;
}

int main(){
	int elemanSayisi;
	int *elemanlar; // Elemanlarin hepsinin integer sayi oldugu varsayiliyor.
	int *durumlar; 
	int i,j,altKumeSayisi;
	
	//Eleman sayisini al
	printf("Kumenin eleman sayisi > ");
	scanf("%d", &elemanSayisi);
	
	// Bellekte eleman sayisina gore yer ayır.
	elemanlar = (int *) calloc(elemanSayisi, sizeof(int)); // calloc ta carpmiyorsun. ayrı ayrı parametre olarak veriyorsun!
	durumlar = (int * ) calloc(elemanSayisi, sizeof(int));
	
	// Yer ayrilabildi mi?
	if( elemanlar == NULL || durumlar == NULL){
		printf("ERROR : Bellekte yer ayrilamadi!");
		return 0;
	}
	
	// Kullanicadan elemanlari al.
	for( i=0; i<elemanSayisi; i++ ){
		printf("%d.Eleman > ", i+1);
		scanf("%d", (elemanlar + i));
	}	
	
	altKumeSayisi = ikiUssu(elemanSayisi);	
	for( i=0; i<altKumeSayisi; i++ ){
		durumAyarla( durumlar, i, elemanSayisi);
		printf("\n%2d.AltKume : { ", i+1);
		for( j=0; j<elemanSayisi; j++ ){
			if( *(durumlar + j) == 1 ){
				printf("%d,", *(elemanlar + j));
			}
		}
		printf("\b }"); // \b En sondaki bosuna konulan virgulu siliyoruz.
	}
	
	// Ayrılan yeri serbest bırak!
	free(elemanlar);
	free(durumlar);
	
	return 0;
}
