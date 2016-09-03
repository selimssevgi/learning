//#############################
//	Sudoku Oyunu
//	021212
//	selimssevgi@gmail.com
//#############################

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define N 9

int searchValue(int *row, int value){
	int i;
	
	for( i=0; i<N; i++ ){
		if( row[i] == value ){
				return 0;
		} 
	}
		
	return 1;
}

void printMatrix(int **matrix){
	int i,j;
	
		printf("\n     1   2   3   4   5   6   7   8   9");
	for( i=0; i<N; i++){
		printf("\n  --------------------------------------\n%d |  ",i+1);
		for( j=0; j<N; j++ ){
			printf("%d   ", matrix[i][j]);
		}
	}
	printf("\n  --------------------------------------\n");
}

int searchValueInSquare(int **sudoku, int value, int* square){
	int i,j;
	
		for( i=square[0]; i<=square[1]; i++ ){
			for( j=square[2]; j<=square[3]; j++ ){
				if( value == sudoku[i][j] ){
					return 0;
				}
			}
		}

	return 1;
}

int** allocateMatrix(){
	int i;
	int **matrix;
	
	// userSudoku ve sudoku icin calloc ile yer ayirip sifirliyoruz
	matrix = (int**)calloc(N, sizeof(int*));
	if( matrix == NULL ){ printf("HATA: Bellek alikasyonu basarisiz!"); exit(0); }
	for( i=0; i<N; i++ ){
		matrix[i] = (int*)calloc(N, sizeof(int));
		if( matrix[i] == NULL ){ printf("HATA: Bellek alikasyonu basarisiz!"); exit(0); }
	}
	
	return matrix;
}

void printMenu(int *op){
	do{
		printf("\n        OYUN MENUSU");
		printf("\n        ------------");
		printf("\n	1 - Sayi Yaz");
		printf("\n	2 - Sayi Sil");
		printf("\n	3 - Yeni Oyun");
		printf("\n	4 - Nasil Oynanir?");
		printf("\n	5 - Oynamak Istemiyorum - Cikis\n");
		
		printf("\nYapmak istediginiz islem > ");
		scanf("%d", op);
	}while( *op<1 || *op>5 );
}

void howToPlay(){
	printf("\n\n SUDOKU NASIL OYNANIR\n");
	printf(" ---------------------");
	printf("\n # 9 satir ve sutundan olusan karede, 1-9 arasindaki sayilar");
	printf("\nayni satirda ve aynı sutunda tekrar etmemeli.\n");
	printf("\n # Ayrica buyuk kare icerisinde olusan 3x3luk 9 karecik");
	printf("\nicerisinde de 1-9 arasindaki sayilar birer kere kullanilmali.\n");
	printf("\nDevam etmek icin bir tusa basiniz > ");
	getchar();
	getchar();
}

void koordinatlariAl(int *row, int *col){
	do{
		printf("\nKoordinatlar 1-9 arasinda olmali(dahil)\n");
		printf("Satir > ");
		scanf("%d", row);
		printf("Sutun > ");
		scanf("%d", col);
	}while( (*row>9 || *row<1) || (*col<1 || *col>9) );
	
	// Matrislerimiz 0 dan basladigi icin birer azaltalim
	(*row)--;
	(*col)--;
}

int cmp( int** sudoku, int **userSudoku ){
	int i,j;
	
	for( i=0; i<N; i++ ){
		for( j=0; j<N; j++ ){
			if( sudoku[i][j] != userSudoku[i][j] ){
				return 0; // yanlis cozmus
			}
		}
	}
	return 1; // dogru cozmus
}

int main(){
	int **sudoku;
	int **userSudoku;
	int domain[9][2];
	int squares[9][4] = {	{0,2,0,2},	
							{3,5,0,2},
							{6,8,0,2},
							{0,2,3,5},
							{3,5,3,5},
							{6,8,3,5},
							{0,2,6,8},
							{3,5,6,8},
							{6,8,6,8},
						};
	int i,j,k,z;
	int index;	
	int squareIndex;
	int times=0;
	int operation;
	int row,col;
	int numberOfInput=20; // 81 karenin 20 sini onceden girip kullanicaya sunuyoruz.
	
	// Rastgele degerlerin program her calistiginda farkli olmasi icin
	srand(time(NULL));
	
	// 9x9 luk kareler icin yer ayir.
	sudoku = allocateMatrix();
	userSudoku = allocateMatrix();	
	
	// Sudoku da 1-9 arasi sayilar olacak.Onlari dizinin 1.satirina yerleştirelim.
	// 2.satirda ise sayinin o anki sudoku sutununda kullanılıp kullanılmadıgı degerini tutacak
	// kullanildi = 1, kullanilmamis=0
	for( i=0; i<9; i++ ){
		domain[i][0] = i+1;
		domain[i][1] = 0;
	}
	
	// Sudokunun olusturulmasi.
	j=0;
	i=0;
	while( j != N ){ // counter of columns 
		
		if( i == 100 ){
			// break ile cikmis
			j--; // break ile ciktigimiz icin en alta j arti.Silecegimiz sutun bir onceki olmali.
			
			for( z=0; z<N; z++ ){
				sudoku[z][j] = 0;
			}
		}
		
		// domain 2.satirini sıfırla
		for( k=0; k<N; k++){
			domain[k][1] = 0;
		}
		
		times=0;		
		i = 0;
		
		while( i != N ){	
			// Eğer 100 kerede sayi bulunmamissa ters giden bir seyler var.O sutuna sayilari bastan yerlestirecez.		
			if( times > 100 ){
				i = 100;
				break;
			}
			
			index = rand() % 9; // for domain index [0-8]
			
			// Gelen sayi daha onceden o sutunda kullanilmis mi?
			if( domain[index][1] == 1 ){
				continue;
			}
			// Sayinin yerlestirilemediği basarisiz olunan durum sayisi
			times++;
			
			// Gelen sayi o anki satirda kullanilmis mi?
			if( !(searchValue(sudoku[i], domain[index][0])) ){
				continue;	
			}
			
			// satir(i) ve sutun(j) durumuna gore o an 9 kucukkareden olusan karelerden hangisindeyiz? 
			if( i<3 ){
				if( j<3 ){
					squareIndex = 0;
				}else if( j<6 ){
					squareIndex = 3;
				}else{
					squareIndex = 6;
				}
			}else if( i<6 ){
				if( j<3 ){
					squareIndex = 1;
				}else if( j<6 ){
					squareIndex = 4;
				}else{
					squareIndex = 7;
				}
			}else{
				if( j<3 ){
					squareIndex = 2;
				}else if( j<6 ){
					squareIndex = 5;
				}else{
					squareIndex = 8;
				}
			}
			// Secilen sayi o anki 9 lu hucrenin icinde var mı?
			if( !(searchValueInSquare(sudoku, domain[index][0],squares[squareIndex])) ){
				continue;
			}
			
			sudoku[i][j] = domain[index][0];
			times = 0;
			domain[index][1] = 1;
			i++;
		} // i while nın sonu		
		j++;
	} // j while nın sonu
	
	
	// Kullaniciya gosterecegimiz sudoku da bazı elemanlari onceden yerlestirmemiz lazım
	// 15 tane yerlestirelim.
	i=0;
	while( i != 20 ){
		row = rand() % 9;
		col = rand() % 9;
		
		if( userSudoku[row][col] == 0 ){
			userSudoku[row][col] = sudoku[row][col];
			i++;
		}
	
	}
	
	printf("\n Sudoku olusturuldu!\n");
	do{
		
		printMatrix(userSudoku);
		printf("\n");
		printMenu(&operation);
		
		switch( operation ){
			case 1: // Sayi gir
				koordinatlariAl(&row, &col);
				if( userSudoku[row][col] != 0 ){
					printf("\nHATA : Istedigimiz bolgede zaten deger var!\n");
				}else{
					int deger;
					do{
						printf("\n[%d, %d] bolgesine yazacaginiz deger [1-9]> ", row+1,col+1);
						scanf("%d", &deger);
					}while( deger>9 || deger<0 );
					userSudoku[row][col] = deger;
					numberOfInput++;
					printf("\nIstediginiz bolgeye istediginiz deger yazildi.\n");
				}
			break;
			case 2: // Sayi sil
				koordinatlariAl(&row, &col);
				if( userSudoku[row][col] == 0 ){
					printf("\nHATA : Istedigimiz bolgede zaten deger yok!\n");
				}else{
					userSudoku[row][col] = 0;
					numberOfInput--;
					printf("\nIstediginiz bolgedeki deger silindi!\n");
				}
			break;
			case 3: // Yeni oyun
				printf("\nYeni oyun icin programi kapatip tekrar acin :) \n");
				return 0;
			break;
			case 4: // Nasil oynanir
				howToPlay();
			break;
			case 5: // cikis
				printf("Exiting....");
			break;
			// default a gerek yok.Gerekli kontrol printmenu fonk. yapildi.
		}
	}while( operation != 5 || numberOfInput != 81);
	
	if( numberOfInput == 81 ){
		// Kullanici sudokuyu tamamlamis bakalim dogru mu?
		if( cmp(sudoku, userSudoku) ){
			printf("\nTEBRIKLER! Sudokuyu basariyla cozdünüz!\n");
		} else {
			printf("\nMalesef! Cozumunuzde yanlisliklar var!\n");
		}
	}
	
	free(sudoku);
	free(userSudoku);
	return 0;
}

