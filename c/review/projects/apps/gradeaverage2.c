#include <stdio.h>
#include <stdlib.h> // required for malloc,alloc,realloc,free functions.

int main(){
	int i,N;
	int *notlar;
	float ort,top=0;
	
	// Ogrenci sayisi
	printf("Ogrenci Sayisi > ");
	scanf("%d", &N);
	
	// ! Su ana kadar bir ogrenci notlarını tutacagımiz bir dizi yok
	// ! ama ogrenci sayisi icin yetecek kadar yer arıyabiliriz.
	// ! ve ayırdıgımız kısmı pointerımıza aktararak dizi gibi kullanabiliriz.
	notlar = (int *) malloc(N * sizeof(int));
	
	// Yer ayırabildi mi ?
	if( notlar == NULL ){
		printf("Bellekte yer ayrılamadı!");
		return 0;
	}
	
	// Ogrenci Notlarını al
	for( i=0; i<N; i++ ){
		printf("%d.Ogrencinin notu > ", i+1);
		scanf("%d", (notlar + i));
	}
	
	// Ogrenci notlarını topla 
	for( i=0; i<N; i++ ){
		top += *(notlar + i); // or notlar[i]
	}
	
	// Ortalama Hepapla 
	ort = top / N;
	
	// Ortalamayı ekrana yazdır
	printf("%d ogrencinin not ortalamasi : %f", N,ort);
	
	// İsin bittikten sonra aldığın bellegi serbest bırak!
	free(notlar);
	notlar = NULL; // pointer herhangi bir yere gostermiyor olacak.
	
	return 0;
}
