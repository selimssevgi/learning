#include <stdio.h>

int main(){
	FILE *f1;

	f1 = fopen("deneme", "w");
	
	fclose(f1);	
	return 0;
}
