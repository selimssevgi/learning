/*
 * Kullanicidan 10 tabanında aldigi sayiyi iki tabanina 
 * ekrana 2 tabanında yazdıran program.
 * 
 * 16.10.12
 */
 
#include <stdio.h>

int main(){
	int onlukSayi,yedekOnluk;
	int ikilikSayi[30],bitSayisi=0,i;
	
	// 10 tabaninda sayi al
	printf("10 tabaninda bir sayi giriniz > ");
	scanf("%d", &onlukSayi);
	yedekOnluk = onlukSayi;
	
	// Sayimiz 2 ve 2 den buyuk oldugu surece bolme islemine devam edecek
	while( yedekOnluk>=2 ){
			ikilikSayi[bitSayisi] = yedekOnluk % 2;
			yedekOnluk = yedekOnluk / 2;
			bitSayisi++;
	}
	// En sonda 2 den kucuk olarak elde ettiğimiz bölme son kalanimiz
	ikilikSayi[bitSayisi] = yedekOnluk;
	
	// Bitleri ters sekilde yazdiriyoruz.
	printf("Girilen sayinin ikilik tabanda karsiligi : ");
	for( i=bitSayisi; i>=0; i-- ){
			printf("%d", ikilikSayi[i]);
	}
	
	
	return 0;
}
