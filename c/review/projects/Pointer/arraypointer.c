#include <stdio.h>

int main(){
	int dizi[] = {5, 43, 65, 78};
	int *pDizi; // Pointerımız bu sekliyle herhangi bir yere işaret(point) etmiyor.
	
	// Diziler bellekte bir block halinde ard arda sıralanır.Sıralı verilerdir.
	// Dizinin ile elemanına işaret ediyoruz.ARitmetik hesaplarla sonrakilere ulaşabiliriz.
	pDizi = &dizi[0];
	pDizi = dizi; // Dizimizin adi dizinin ilk elemanın adresini saklar. diziIsmi = &diziIsmı[0] 
	
	printf("Dizinin ile elemanı (*pDizi) / %%d : %d\n", *pDizi); // 5
	printf("Dizinin bir sonraki elemanı (*(pDizi+1)) / %%d : %d\n", *(pDizi+1));
	printf("Dizinin birinci elemanın degerini bir artır > (*(pDizi)+1) / %%d : %d\n", *(pDizi)+1); // 6
	printf("(dizi+3) %d\n", *(dizi+3));	
	
	// dizi[3] = *(pDizi+3) = *(dizi+3)
	
	printf("dizi[2] : %d\n", dizi[2]); // 65
	printf("2[dizi] : %d\n", 2[dizi]); // 65
	
	printf("*pDizi : %d\n", *pDizi);
	printf("*(pDizi++) : %d\n", *(pDizi++)); // Yazdıktan sonra pDizi arttırdı.ARtık ikinci elemanı point ediyor.
	printf("*pDizi : %d\n", *pDizi);
	printf("(*pDizi)++ : %d\n", (*pDizi)++); // Ekrana (43) yazdırdıktan sonra elemanın degeri(44) bir artacak
	printf("++*(pDizi) : %d\n", ++*(pDizi)); // Elemanın (44) degerini bir artıracak(45) ekrana yazdıracak
	printf("++*pDizi : %d\n", ++*pDizi); // öncelik * oldugu icin ustekının aynısı bir artırıp ekrana yazacak
	
	
	
	return 0;
}
