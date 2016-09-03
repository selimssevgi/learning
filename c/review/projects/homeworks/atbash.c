#include <stdio.h>

int main(){
	char frstLtrs[13]={'A','B','C','D','E','F','G','H','I','J','K','L','M'}; // bu harfleri kodla yazdirabilirsin.
	char scndLtrs[13]={'Z','Y','X','W','V','U','T','S','R','Q','P','O','N'}; 
	char input[100], encInput[100]; // Dinamik memory allocation ı kullanabilirsin.
	int i,j;
	
	// Kullanıcıdan stringi al
	printf("Sifrelenecek string > ");
	gets(input);
	
	// string i yazdir.
	printf("String : %s\n", input);
	
	// UYARI : asagidaki for da string uzunlugu sabit alinmiş onu daha dinamik yapmalıyım.
	
	// String harfleri tek tek ele al	
	for( i=0; i<5; i++ ){
		for( j=0; j<13; j++ ){ // Harf dizilerimiz sabit 13 elemanlı
			if( input[i] == frstLtrs[j] ){ // İlk diziye bakıyoruz var mı?
					printf("Eslesme : %c\n", frstLtrs[j]);
					encInput[i] = scndLtrs[j]; // Diğer dizideki aynı indeksli elemanı sifrelenmis diziye yazıyoruz
			} else if ( input[i] == scndLtrs[j] ){ // Yoksa diğer diziye bakıyoruz
					printf("Eslesme : %c\n", scndLtrs[j]);
					encInput[i] = frstLtrs[j];
			}
		}
	}
	
	encInput[i] = '\0'; // Dizimiz string olması icin sonuna ekliyoruz.
	
	// Giriş ve sifreli hali yazdırıyoruz.
	printf("input : %s \n", input);
	printf("encInput : %s \n", encInput);
	
	return 0;
}
