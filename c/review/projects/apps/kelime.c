#include <stdio.h>
#include <string.h>

int main(){
	int i,kelimeSayisi=0;
	char cumle[100];

	printf("cumle gir > ");
	gets(cumle);

	for( i=0; i<strlen(cumle); i++ ){
		if( cumle[i] == ' ' ){
			kelimeSayisi++;
		}
	}

	printf("Cumledeki Kelime Sayisi : %d\n", (kelimeSayisi + 1) );
	
	return 0;
}
