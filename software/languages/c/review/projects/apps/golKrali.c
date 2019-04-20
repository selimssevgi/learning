/* 
 * N tane takimimiz var.
 * Bu N takimin M oyuncusu var. - Hepsi için aynı sabit!
 * Kullanicidan her oyuncunun attigi gol sayisi aliniyor. [random olarak da yap.]
 * Her takimin en fazla gol atan oyuncusunu bul.
 * 
 * 15.10.12 
 */
 
 #include <stdio.h>
 #include <stdlib.h> // random,rand,malloc,.. icin gerekli
 #include <time.h> // time fonksiyonu icin
 
 int golKraliBul(int *pSatir, int oSayisi);
 
 int main(){
	int takimSayisi,oyuncuSayisi;
	int i,j;
	int goller[20][20]; // goller[takimSayisi][oyuncuSayisi]
	int golKrallari[20];
	
	// Random dan gelen sayilari degistir
	srand(time(NULL));
	
	printf("Takim Sayisini Giriniz > ");
	scanf("%d", &takimSayisi);
	
	printf("Oyuncu Sayisini Giriniz > ");
	scanf("%d", &oyuncuSayisi);
	
	// Golleri matrisi gir.
	for( i=0; i<takimSayisi; i++ ){
		for( j=0; j<oyuncuSayisi; j++ ){
				goller[i][j] = rand() % 90 + 10; // gol sayisi 0-99 arasi sayilar gelecek
		}
	}
	
	// Kontrol icin matrisi yazdir.
	for( i=0; i<takimSayisi; i++ ){
		printf("\n");
		for( j=0; j<oyuncuSayisi; j++ ){
			printf("%d  ", goller[i][j]);
		}
	}
	
	// Satirlari Fonksiyona gonderip o satirdaki gol kralini dizimize atalim
	for( i=0; i<takimSayisi; i++ ){
		golKrallari[i] = golKraliBul(goller[i], oyuncuSayisi);
	}
	
	printf("\n");
	
	//gol krallarini ekrana yazdir.
	for( i=0; i<takimSayisi; i++ ){
		printf("%d.takimin gol krali %d. kişi ve attigi gol sayisi %d tanedir.\n", i+1, golKrallari[i], goller[i][golKrallari[i]]);
	}
	
	return 0;
}

int golKraliBul(int *pSatir, int oSayisi){
		int i, maxIndex=0, max= *(pSatir + 0);
		
		for( i=0; i<oSayisi; i++ ){
				if( *(pSatir + i) > max ){
					max = *(pSatir + i);
					maxIndex = i;
				}
		}
		
		return maxIndex;
}
