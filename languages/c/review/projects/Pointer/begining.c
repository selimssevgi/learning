#include <stdio.h>

int main(){
	// sayi bir değişken.
	// bir "adi" var. -> sayi
	// bir "değeri" var -> DAha bir şey atanmamış.
	// bellekte bir "adresi" var -> Bu adres &sayi ile elde edilir.
	int sayi;
	int *pSayi;
	
	// psayi = 500; Bu durumda hata verir. -> pointer = int 
	// sayi = &sayi; Bu durum hata verir.  -> int = pointer
	// Çünkü &sayi bize pointer turunde deger donderir.
	// Ama bizim sayi değişkenimiz int türünde olmalı.
	// Bir dönüşüm yapmadan bunu yapmak hataya sebep olacaktır.
	
	sayi = 500;
	pSayi = &sayi;
	*pSayi = 501;
	
	printf("sayi değişkeninin adresi (&sayi)/%%p : %p \n", &sayi);
	printf("sayi değişkeninin degeri (sayi)/%%d : %d \n", sayi);
	printf("pSayi değişkeninin değeri (pSayi) / %%p : %p\n", pSayi); // bir pointer olarak adres degeri saklıyor
	printf("pSayi değişkenin adresi (&pSayi) / %%p : %p\n", &pSayi); // pointerın kendi adresi
	printf("pSayi pointerının gosterdiği adresteki değer (*pSayi) / %%d : %d", *pSayi);
	
	return 0;
}
