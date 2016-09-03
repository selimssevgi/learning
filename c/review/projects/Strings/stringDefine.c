#include <stdio.h>

int main(){
	char kelime[] = "Selim"; 	// sonuna \0 karakterini ekler ve dizinin boyutu 6 karakterlık olur
	char word[20] = "Sirri";	// selim ve ardına \0 karakterini ekler diğer kısım oldugu gibi kalır.
	char *wordPtr = "Sevgi"; 	// Aynı sekilde \0 karakterinide ekleyerek ayarlıyor.
	
	printf("%d \n", kelime[5]);
	printf("%d \n", word[5]);
	printf("%d \n", wordPtr[5]);
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/*
	Ancak wordPtr kullanımında üstündeki iki tanesinden 
	farkli olarak ayrıca wordPtr nin baslangıc noktasını tutması
	icin ekstra bir pointer kullanilmiz oluyor.
	*/
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	wordPtr = "Yeni sevgi"; // Bu kısımda ise yeni stringi sıgdırabilebileceği bir yer arıyor.
							// bulunca da yerleştiriyor ve başlangıc adresi pointerımıza atanıyor.
	
	//kelime = word;	// Direkt string atamasına izin vermiyor strcpy() fonksiyonu kullanılmalı bu durumda.
	wordPtr = kelime; // BU sekılde programın ortasında  string ataması yapabiliyoruz.
	*wordPtr = 'B'; // Yildiz operatoru kullanınca tek elemanı ele aldıgımız ıcın ancak karakter ataması yapabılırız.
	printf("%s\n", wordPtr);
	
	// Uzun string ayırma 
	printf("Selim" "Sirri" "Sevgi"); // Bosluklar olmadan hepsini birleşik yazar
	// Altaki şekilde birlşemiyor bosluklu yazdı
	printf("Selim \
			Sirri \
			sevgi");
	
	return 0;
}
