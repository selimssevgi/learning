/*
 *  Date : 191112
 * 
 * 	Problem : 	Bir bankanın müsterilerinin banka hesap verilerini bir structure da tutuyor.
 * 				Bu bilgiler arasında musteri hesap numarası, TL, dolar ve euro biriminde paraları vardır.
 * 				Banka müsterilerinden en fazla parası olan programı yazınız.
*/

#include <stdio.h>
#include <stdlib.h>

// Yapımızın bildirimini yapalım
typedef struct{
	int hesapNo;
	int tl,dolar,euro;
} MUSTERI;

int main(){
	MUSTERI *musteriler; // musteri yapı turunde bir degiskenler dizisi olacak.
	int musteriSayisi,i,kurDolar,kurEuro, maxIndis, maxPara,temp;
	
	// Musteri sayisini dısardan al
	printf("Number of customer > ");
	scanf("%d", &musteriSayisi);
	
	// musterı yapı turunu elemanlarını icerek diziyi point edecek adresi al
	musteriler = (MUSTERI *)malloc( musteriSayisi * sizeof(MUSTERI) );
	if( !musteriler ){ printf("Error : out of memory!"); exit(1); }
	
	// Musterilerin bilgilerini rastgele gir.
	for( i=0; i<musteriSayisi; i++ ){
		musteriler[i].hesapNo = rand() % 10000;
		musteriler[i].tl = rand() % 10000;
		musteriler[i].dolar = rand() % 10000;
		musteriler[i].euro = rand() % 10000;
	}
	
	// Sonuc kontrolu ıcın musteri hesap no ve bilgileri ekrana yazdir.
	printf("   HesapNo |   TL  |   Dolar  |   Euro \n");
	printf("--------------------------------------\n");
	for( i=0; i<musteriSayisi; i++ ){
		printf("   %4d   |  %4d  |    %4d   |  %4d  \n", musteriler[i].hesapNo, musteriler[i].tl, musteriler[i].dolar, musteriler[i].euro);
	}
	
	// Aynı birimde parayı hesaplamak icin dolar ve euro kurlarını al. FLOAT olmaları daha mantıklı :)
	printf("\nDolar kuru > ");
	scanf("%d", &kurDolar);
	printf("Euro kuru > ");
	scanf("%d", &kurEuro);
	
	// En fazla parası olan musteri bulmak icin ilk musteriyi oyleymıs gibi kabul edelim.
	maxIndis = 0;
	maxPara = 0;
	
	for( i=0; i<musteriSayisi; i++ ){
		// her musterinin parasını hesapla
		temp = (musteriler[i].tl) + (musteriler[i].dolar * kurDolar) + (musteriler[i].euro * kurEuro);
		// musterinin parası maxPara dan fazlaysa degiskenleri guncelle
		if( temp > maxPara ){
			maxPara = temp;
			maxIndis = i; // Musteri tespiti icin indis i tutmamız lazım
		}
	}
	
	// Parası en fazla olan musterinin hesap numarısını yazdır
	printf("\nEn fazla parasi olan musterinin hesap nosu : %d", musteriler[maxIndis].hesapNo);
	
	free(musteriler);
	return 0;
}
