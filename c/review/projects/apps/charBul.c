/* Problem :	Elimizde bir string olacak.dışardan al veya kendın yaz.
 * 				Sonrada dışardan aranacak karakteri al
 * 				Karakteri bulduysan buldugun noktadan itibaren ekrana yazdır.
 */

#include <stdio.h>
#include <string.h>

void charBul(char *kelime, char aranan){
	int buldu=1,i=0,boyut,j;
	
	boyut = strlen(kelime);
	
	while( kelime[i] && buldu ){
		if( kelime[i] == aranan ){
			buldu = 0;
		}
		i++;
	}	
	
	for(j=i-1; j<=boyut; j++){
		printf("%c", kelime[j]);
	}
}

int main(){
	char kelime[20] = "selimsirrisevgi";
	char aranan;
	
	printf("Aranacak karakter > ");
	scanf("%c", &aranan);
	
	charBul(kelime, aranan);
	
	return 0;
}
