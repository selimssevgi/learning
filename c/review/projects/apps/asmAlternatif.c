#include <stdio.h>

int main(){
	int dizi[] = {1,2,3,5,6,5,7,5,5,4};
	int adet=0,i,aranan=5;
	
	for( i=0; i<=10; i++){
		if( dizi[i] == aranan ){
			adet++;
		}
	}
	
	printf("%d tane bulundu.", adet);
	return 0;
}
