#include <stdio.h>
#include <stdlib.h>
#include <stddef.h>

typedef struct{
	char ad[10];
	char soyad[10];
	int no;
} OGR;

int main(){
	OGR ogr1;
	FILE *f1;
	
	printf("Ad> ");
	scanf("%s", ogr1.ad);
	printf("NO > ");
	scanf("%d", &ogr1.no);
	
	f1 = fopen("liste", "wb");
	if( f1 == NULL ){
		printf("İslem Basarisiz\n");
		exit(1);
	}
	
	fwrite(&ogr1, sizeof(OGR), 1, f1);
	
	fclose(f1);
	return 0;
}
