#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define N 9
#define START 0

int searchValue(int *row, int value){
	int i;
	
	
	printf("\n");
	for( i=START; i<N; i++ ){
		if( row[i] == value ){
				return 0;
		} 
	}
	
	return 1;
}

void printMatrix(int **matrix){
	int i,j;
	
	for( i=START; i<N; i++ ){
		printf("\n");
		for( j=START; j<N; j++ ){
			printf("%d ", matrix[i][j]);
		}
	}
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

int main(){
	int **sudoku;
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
	int lastIndex;
	
	srand(time(NULL));
	
	sudoku = (int**)malloc(N * sizeof(int*));
	for( i=0; i<N; i++ ){
		sudoku[i] = (int*)malloc(N * sizeof(int));
	}
	
	// make elements of sudoku zero
	for( i=0; i<N; i++ ){
		for( j=0; j<N; j++ ){
			sudoku[i][j] = 0;
		}
	}
	
	printMatrix(sudoku);
	printf("\n\n\n");
	//searchValueInSquare(sudoku, 5, 0,2,0,2);
	
	// assing the value of the domain
	for( i=0; i<9; i++ ){
		domain[i][0] = i+1;
		domain[i][1] = 0;
	}
	j=0;
	i=0;
	while( j != N ){ // counter of columns // sutun gonderemediğim ıcın !
		
		if( i == 100 ){
			// break ile cikmis
			j--;
			for( z=0; z<N; z++ ){
				sudoku[z][j] = 0;
			}
			printf("\nSutun Sifirlandi\n");
			printMatrix(sudoku);
			printf("\nSutun Sifirlandi\n");
			//getchar();
		}
		
		// domain 2.satirini sıfırla
		for( k=0; k<N; k++){
			domain[k][1] = 0;
		}
		printf("Domain sifirlandi!\n");
		times=0;		
		i = 0;
		while( i != N ){			
			if( times > 100 ){
				i = 100;
				break;
			}
			
			index = rand() % 9; // for domain index [0-8]
			//printf("Sayisi Secildi : %d\n", domain[index][0]);
			
			
			if( domain[index][1] == 1 ){
				//printf("Sayi bu sutunda kullanilmis!\n");
				continue;
			}
			
			times++;
			
			if( !(searchValue(sudoku[i], domain[index][0])) ){
				//printf("Sayi ayni satirda var\n");
				continue;	
			}
			
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
			
			if( !(searchValueInSquare(sudoku, domain[index][0],squares[squareIndex])) ){
				continue;
			}
			
			printf("Sayi sudokuya eklendi\n");
			sudoku[i][j] = domain[index][0];
			times = 0;
			domain[index][1] = 1;
			lastIndex = index;
			i++;
			printf("\nSudoku son durum : \n");
			printMatrix(sudoku);
			//getchar();
		} // i while nın sonu		
		j++;
	}
	
	// Print the sudoku
	printf("\nSudoku son durum : \n");
	for( i=0; i<N; i++ ){
		printf("\n");
		for( j=0; j<N; j++ ){
			printf(" %2d", sudoku[i][j]);
		}
	}
	
	return 0;
}
