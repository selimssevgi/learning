#include <stdio.h>

int main(){
	int i,N,notlar[100];
	float ort,top=0;
	
	// Ogrenci sayisini kullanıcıdan alıyoruz.
	printf("Ogrenci Sayisi : ");
	scanf("%d", &N);
	
	// Ogrenci notlarını dizi olarak alıyoruz.
	for( i=0; i<N; i++ ){
		printf("%d. ogrencinin notu > ", i+1);
		scanf("%d", &notlar[i]);
	}
	
	// Notların toplamını bul
	for( i=0; i<N; i++ ){
		top += notlar[i];
	}
	
	// Ortalamayı hesapla
	ort = top / N;
	
	// Ortalamayı ekrana yazdır
	printf("%d ogrencinin not ortalaması : %f", N,ort);
	
	return 0;
}
