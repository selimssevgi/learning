#include <stdio.h>

// #define macroNAme(parameters) (macrobody)

// macroname ile parametrelerin parantezleri arasında bosluk olması farklı sonuclar dogurur

#define MUL_BY_TWO(a) ( (a) + (a) )

#define min(a,b) ( (a)<(b) ? (a) : (b) )

#define TO_LOWER(c) ( (c) + ('a') - ('A') )


int main(){
	int b = MUL_BY_TWO(2);
	
	printf("%d", MUL_BY_TWO(2));
	
	printf("\nmin : %d\n", min(15,25));
	
	printf("\nKucukHarfi : %c\n", TO_LOWER('Z'));
	
	return 0;
}
