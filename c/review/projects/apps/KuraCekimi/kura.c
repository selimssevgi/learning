#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <time.h>

typedef struct{
	char ad[25]; // ad = ad + soyad
	char ogrNo[9];
} OGR;

void printError(char *error){
	printf("\n%s\n", error);
	exit(0);
}

int oyuncuCek(int ogrSayisi,short int *torba){
	int i;
	
	do{
		i = rand() % ogrSayisi;
	}while( torba[i] != 0 );
	
	// torbadan cikart.	
	torba[i] = 1;
	
	return i;
}

int main(int argc, char *argv[]){
	char dAdi[15];
	FILE *f;
	OGR *ogrenciler;
	short int *torba; // torbadakiler icin 0, torbadan cekilenler 1
	int ogrSayisi=0,ch,i,j;
	short int **eslesmeler;
	int macIndex,eslesmeSayisi;
	
	srand(time(NULL));
	
	ogrenciler = (OGR*)malloc(1 * sizeof(OGR));
	if( ogrenciler == NULL ){ printError("Bellek yetersiz!"); }

	if( argc < 2 ){
		// komut satırından parametre gelmedi.
		printf("Verilerin okunacagi dosya adi >");
		scanf("%s", dAdi);
	}else{
		// Parametreli calistirildi
		strcpy(dAdi, argv[1]);
	}
	
	f = fopen(dAdi, "r");
	if( f == NULL ){ printError("Dosya bulunamadi."); }
	
		
	i=0; j=0;
	ch = fgetc(f);
	while( ch != EOF ){
		
		ogrenciler = (OGR*)realloc(ogrenciler, (i+1) * sizeof(OGR));
		if( ogrenciler == NULL ){ printError("Bellek yetersiz!"); }
		
		while( ch != '\t' ){
 			ogrenciler[i].ad[j] = ch;
 			j++;
 			ch = fgetc(f);
 		}
 		
		ogrenciler[i].ad[j] = '\0';	
		
		while( !isdigit(ch) ){
			ch = fgetc(f);
		}
		
		j = 0;
		while( ch != '\n' ){
			ogrenciler[i].ogrNo[j] = ch;
			j++;
			ch = fgetc(f);
		}
		
		ogrenciler[i].ogrNo[j] = '\0';
		i++;
		j=0;
		ch = fgetc(f);	
	}
	
	fclose(f);
	
	ogrSayisi = i;
	// Basvuranlari Listele
	printf(" #   AD SOYAD                 OKUL NUMARASI\n");
	printf("-------------------------------------------\n");
	for( i=0; i<ogrSayisi; i++ ){
		printf("%2d - %-25s", i+1,ogrenciler[i].ad);
		printf("%s", ogrenciler[i].ogrNo);
		printf("\n\n");
	}
	
	printf("Devam etmek icin enter'a basiniz...\n"); 
	getchar();
	
	torba = (short int*)calloc(ogrSayisi, sizeof(short int));
	if( torba == NULL ){ printError("Bellek Yetersiz!"); }
	
	// yapilacak mac sayisi
	if( ogrSayisi % 2 != 0 ){
		eslesmeSayisi = (ogrSayisi + 1) / 2;
	}else{
		eslesmeSayisi = ogrSayisi / 2;
	}
		
	eslesmeler = (short int**)calloc(2, sizeof(short int*));	
	if( eslesmeler == NULL ){ printError("Bellek Yetersiz!"); }
	for( j=0; j<2; j++ ){
		eslesmeler[j] = (short int*)calloc(eslesmeSayisi, sizeof(short int));
	}
	
	macIndex = 0;
	
	if( ogrSayisi % 2 != 0 ){
		printf("Basvuran sayisi tek oldugu icin bir kisi direk üst tura cikacak.\n");
		printf("Cikan Kisi : ");
		i = rand() % ogrSayisi;
		printf("%s\n", ogrenciler[i].ad);
		torba[i] = 1;
		eslesmeler[0][macIndex] = i;
		eslesmeler[1][macIndex] = -1;
		macIndex++;
	}
	
	printf("Devam etmek icin enter'a basiniz...\n");
	getchar();
	
	printf("\nEslesmeler Basliyor : \n");
	printf("---------------------\n");
	for( ;macIndex<eslesmeSayisi; macIndex++){
		printf("%d.Eslesme : (Oyuncuları cekmek icin enter a basiniz)\n", macIndex+1);
		getchar();
		i = oyuncuCek(ogrSayisi,torba);
		printf("%s\n", ogrenciler[i].ad);
		j = oyuncuCek(ogrSayisi,torba);
		printf("%s", ogrenciler[j].ad);
		printf("\n\n");
		eslesmeler[0][macIndex] = i;
		eslesmeler[1][macIndex] = j; 
	}
	
	printf("Toplamda %d mac yapilacak.\n\n", eslesmeSayisi);
	printf("Eslesmeleri dosyaya yazdirmak icin enter'a basiniz...");
	getchar();
	
	
	printf("\nFiksturun yazilacagi dosyanin adi > ");
	scanf("%s",dAdi);
	f = fopen(dAdi, "w");
	if( f == NULL ){ printError("Dosya olusturulamadi!"); }
	fprintf(f,"=======  Fikstur  =======\n");
	for( i=0; i<eslesmeSayisi; i++ ){
		fprintf(f,"%d.Eslesme : \n", i+1);
		if( eslesmeler[1][i] == -1 ){
			fprintf(f,"%s (Ust tura cikti.)", ogrenciler[eslesmeler[0][i]].ad);
		}else{
			fprintf(f,"%s %s & %s %s", ogrenciler[eslesmeler[0][i]].ogrNo,ogrenciler[eslesmeler[0][i]].ad,ogrenciler[eslesmeler[1][i]].ogrNo, ogrenciler[eslesmeler[1][i]].ad);
		}
		fprintf(f,"\n\n");
	}
	
	printf("Eslesmelerin tumu %s adlı dosyaya basariyla kaydedildi.", dAdi);
	

	return 0;
}
