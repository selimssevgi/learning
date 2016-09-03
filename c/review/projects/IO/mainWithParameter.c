#include <stdio.h>

int main( int argc, char *argv[] ){
	int k;
	
	for( k=0; k<argc; k++ ){
		printf("argv[%d] : %s\n", k, argv[k]);
	}
	
	
	return 0;
}
