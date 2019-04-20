/*
	Bicim tanımlayıcılar konusunda örnekler : 
	26/09/12

	Biçim Tanımlayıcı 				Anlamı
	* %d						Onlu(decimal) tam sayi
	* %c						Tek karakter
	* %s						Karakter Katarı
	* %f						Ondalık Sayi
	* %e						Ondalik sayi(üslü gösterimi ile)
	* %g 						%e veya %f hangisi kısa ise
	* %u						işaretsiz(unsgined) onlu tamsayi
	* %o						işaretsiz(octamal) sekizli tamsayi
	* %x						işaretsiz(hexidecimal) onaltılı tamsayi
*/

#include <stdio.h>

int main(){
		int sayi=200;
		float fsayi=23.452;
		char ch=97;
		char ch2='A';
		
		// Farkli sayi tabanlarında sayi kullanabiliriz.
		int dsayi=11;
		int osayi=013;
		int xsayi=0xB;
		
		printf("Decimal, sayi=200, %%d : %d\n", sayi);
		printf("Octomal, sayi=200, %%o : %o\n", sayi);
		printf("Hexidecimal, sayi=200, %%x : %x\n\n", sayi);
		
		printf("Float, %%f : %f\n", fsayi);
		printf("Float, %%e : %e\n", fsayi);
		printf("Float, %%g : %g\n\n", fsayi);
		
		printf("char, ch=97, %%d : %d\n", ch);
		printf("char, ch=97, %%c : %c\n", ch);
		printf("char, ch='A', %%d : %d\n", ch2);
		printf("char, ch='A', %%c : %c\n\n", ch2);
		
		// Sayi farkli tabanlarda tanımlanmışsa da biz istediğimiz tabanda yazdırabiliriz.s
		printf("dsayi=11  : %%d %%o %%x : %d %o %x\n", dsayi, dsayi, dsayi);
		printf("osayi=013 : %%d %%o %%x : %d %o %x\n", osayi, osayi, osayi);
		printf("xsayi=OXB : %%d %%o %%x : %d %o %x\n", xsayi, xsayi, xsayi);
		
		return 0;
}
