/*
 *  bit,kilobyte,byte,megabyte arasindaki donusumleri
 *  yapabilmek icin hesaplamalarda
 *  kullanacagım üslü sayı hesaplama programı
 * 	11/10/12
 */

#include <stdio.h>

int main(){
	int taban,us,i;
	unsigned long sonuc=1;
	
	printf("Taban > ");
	scanf("%d", &taban);
	
	printf("Us > ");
	scanf("%d", &us);
	
	for( i=1; i<=us; i++ ){
		sonuc *= taban;
	}
	
	printf("Sonuc : %ld", sonuc);
	
	return 0;
}
