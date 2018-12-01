#include <stdio.h>
#include <string.h> // strlen() fonk. için
#include <stdlib.h> // malloc ve free için.
#include <time.h> // time() için.

#define KELIMESAYISI 9

void adamCiz(int durum){
		switch(durum){
			case 9 : 
		printf(" __________     \n");
		printf("|      ( )      \n");
		printf("|       |       \n");
		printf("|      /|\\     \n");
		printf("|       |       \n");
		printf("|      / \\     \n");
		printf("|__             \n");
			break;
			case 8 :	
		printf(" __________     \n");
		printf("|      ( )      \n");
		printf("|       |       \n");
		printf("|      /|\\     \n");
		printf("|       |       \n");
		printf("|      /|       \n");
		printf("|__             \n");
		printf("\nBir tane yanlis yapma hakkın kaldi!\n");
			break;
			case 7 : 
		printf(" __________     \n");
		printf("|      ( )      \n");
		printf("|       |       \n");
		printf("|      /|\\     \n");
		printf("|       |       \n");
		printf("|       |       \n");
		printf("|__             \n");
			break;
			case 6 :
		printf(" __________     \n");
		printf("|      ( )      \n");
		printf("|       |       \n");
		printf("|      /|       \n");
		printf("|       |       \n");
		printf("|       |       \n");
		printf("|__             \n");
			break;
			case 5 :
		printf(" __________     \n");
		printf("|      ( )      \n");
		printf("|       |       \n");
		printf("|       |       \n");
		printf("|       |       \n");
		printf("|       |       \n");
		printf("|__             \n");
			break;
			case 4 : 
		printf(" __________     \n");
		printf("|      ( )      \n");
		printf("|               \n");
		printf("|               \n");
		printf("|               \n");
		printf("|               \n");
		printf("|__             \n");
			break;
			case 3 : 
		printf(" __________     \n");
		printf("|               \n");
		printf("|               \n");
		printf("|               \n");
		printf("|               \n");
		printf("|               \n");
		printf("|__             \n");
			break;
			case 2 : 
		printf("                \n");
		printf("|               \n");
		printf("|               \n");
		printf("|               \n");
		printf("|               \n");
		printf("|               \n");
		printf("|__             \n");
			break;
			case 1 : 
		printf("                \n");
		printf("                \n");
		printf("                \n");
		printf("                \n");
		printf("                \n");
		printf("                \n");
		printf(" __             \n");
			break;
			default : 
			printf("\nAdamın Henüz Asilmaya Baslanmadi!\n\n");
			break;
	}
}

void altTirele(char *dizi, int boyut){
	int i;
	
	for( i=0; i<boyut; i++ ){
		dizi[i] = '_';
	}
	
	// En sonuna terminator karakterini koy
	dizi[i] = '\0';
}

int harfiAra(char *girilenHarfler, int *NgirilenHarfler, char letter){
	int buldu = 0; // 0 ise onceden girilmemis, 1 ise onceden girilmis 
	int i=0;
	
	while( buldu == 0 && i < *NgirilenHarfler ){
		if( letter == girilenHarfler[i] ){
			buldu = 1;
		} else {
			i++;
		}
	}
	// Eğer harf dizide yoksa onu ekleyelim
	if( buldu == 0 ){
		girilenHarfler[*NgirilenHarfler] = letter;		
		(*NgirilenHarfler)++;
	}
	return buldu;
}

int main(){
	char letter;
	char *letters;
	int i,buldu=0,adam=0,bulunanKarakter=0,uzunluk,kelime;
	char girilenHarfler[20]; // Kullanicinin girmiş oldugu harfleri saklayacak
	int NgirilenHarfler=0;
	char words[KELIMESAYISI][10] = {
							{'s','e','l','i','m','\0'},
							{'e','n','e','s','\0'},
							{'s','e','v','i','m','\0'},
							{'s','e','r','h','a','t','\0'},
							{'e','m','r','e','\0'},
							{'y','u','n','u','s','\0'},
							{'a','h','m','e','t','\0'},
							{'y','u','s','u','f','\0'},
							{'m','e','h','m','e','t','\0'},
							};
							
	// for generating different number
	srand(time(NULL));
	
	// Kelimeler matrisinden bir kelime seç
	kelime = rand() % KELIMESAYISI;
	
	// Rastgele secilen kelimenin uzunlugu
	uzunluk = strlen(words[kelime]);
	
	// Bulunan harflerin saklanaacagi dizi icin bellek ayır
	letters = (char *)malloc(uzunluk + 1 * sizeof(char));
	if( letters == NULL ){ printf("Bellek ayırma islemi basarisiz!"); return 0; }
	
	// Bulunan harflerin saklanacagi diziyi alt-tirele
	altTirele(letters, uzunluk);
	
	// Turkce karakterlerde sorun cıkıyor, atlama yapıyor.
	printf("Lutfen Turkce Karakterleri Kullanmayin! {ı,ç,ö,ğ,ü}\n");
	
	while( adam != 9 && bulunanKarakter != uzunluk){
		
		// Kullanicidan harf al
			do{
				printf("Girilen Harfler : ");
				for( i=0; i<NgirilenHarfler; i++ ){
					printf(" %c", girilenHarfler[i]);
				}
				
				printf("\nHarf : ");
				scanf("%c", &letter);
				i = harfiAra(girilenHarfler, &NgirilenHarfler, letter);
				
				if( i == 1 ){
					printf("\nGirdiginiz harfi daha önceden zaten girmiştiniz!\n");
					getchar();
				}
			}while( i == 1 );
			
		for( i=0; i<uzunluk; i++ ){
			// Aldigin harf kelimenin icinde var mi?
			if( letter == words[kelime][i] ){
				letters[i] = letter;
				bulunanKarakter++;
				buldu = 1;
			}
		}
		
		if( buldu != 1 ){
			// harf bulamadiysa adami as
			adam++;
		} else {
			// Bulmussa sayaci sifirla
			buldu = 0;
		}
		
		printf("Adamin Son Durumu    : \n");
		adamCiz(adam);
		
		printf("\nKelimenin Son Durumu : ");
		puts(letters);
		
		printf("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		getchar(); // Buffer dan enter karakterini okuyor.
	}
	
		printf("\n\n");
		if( adam != 9 ){
			// Basarili olunan durum
			printf("Tebrikler! Kelimeyi Dogru Tahmin Ettiniz.");
		} else {
			// Basarisiz olunun durum
			printf("Olmadi Artik Baska Sefere.\n");
			printf("Kelime : %s", words[kelime]);
		}		
		
		//Ayırdıgın bellek alanını serbest bırak
		free(letters);
		return 0;
}
