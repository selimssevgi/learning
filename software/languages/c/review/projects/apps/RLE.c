/*
 * Programming Languages
 * Assingment 2
 * RLE algorithm
 * 24.10.12
*/

/*
//!!YAPILACAKLAR

# Fonksiyon kullanmaya calis
# compressed array icin dinamik memory
 
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void readInputs(int *row, int *col, int *how){
	// Get dimensions of matrix
	printf("Matrix Dimensions  [row col] > ");
	scanf("%d %d", row, col);
	
	printf("\n1 - For Vertically");
	printf("\n2 - For Horizontally");
	printf("\n\nWhich way do you want the matrix to be encoded? > ");
	scanf("%d", how);
	
	if( *how != 1 || *how != 2){
		printf("You must enter 1 or 2!");
		// Programı bitir!
	}
}

void printMatrix(int **matrix, int row, int col){
	int i,j;
	
	for( i=0; i<row; i++ ){
		printf("\n");
		for( j=0; j<col; j++ ){
			printf(" %d ", matrix[i][j]);
		}
	}
	
}

int** allocateMatrix(int row, int col){
	int **matrix;
	int i;
	
	matrix = (int **) malloc(row * sizeof(int *));
	if( matrix == NULL ){ printf("Faied while allocating!"); return 0;}
	
	for( i=0; i<row; i++ ){
		matrix[i] = (int *) malloc(col * sizeof(int));
		if( matrix[i] == NULL ){ printf("Failed while allocating!"); return 0; }
	}
	
	return matrix;
} 

void randomizeMatrix(int **matrix, int row, int col){
	int i,j;
	
	for( i=0; i<row; i++ ){
		for( j=0; j<col; j++ ){
			matrix[i][j] = rand() % 2;
		}
	}
}



int main(){
	int N,row,col,i,j,k,fr,fc,sr,sc,tane; // fr : first row , sc : second column
	int **matrix,**decodedMatrix;
	int *compArray = (int *) malloc(100 * sizeof(int));
	int how;
	float ratio;
	
	// to create different random numbers each time.
	srand(time(NULL));
	
	// Get input from the user.
	readInputs(&row, &col, &how);
	
	// Allocating  Matrix
	matrix = allocateMatrix(row, col);
	
	// Allocating space for decodedMatrix
	decodedMatrix = allocateMatrix(row, col);
	
	// Randomizing matrix
	randomizeMatrix(matrix, row, col);

	// Encoding Matrix
		
	fr = 0;
	fc = 0;
	tane = 1;
	i = 0;
	
	if( how == 2 ){	
		sr = 0;
		sc = 1;
		
		do{
			if ( matrix[fr][fc] == matrix[sr][sc] ){
				tane++;
			} else{
				compArray[i+1] = matrix[fr][fc];
				compArray[i] = tane;
				tane = 1;
				i = i + 2;
			}		
			
			fr = sr;
			fc = sc;			
			sc = sc + 1;
			
			if( sc == col ){
				sr = sr + 1;
				sc = 0;
			}
			
		}while( sr < row );
		
	} else if( how == 1 ){		
		sr = 1;
		sc = 0;
	
		do{
			if ( matrix[fr][fc] == matrix[sr][sc] ){
				tane++;
			} else{
				compArray[i+1] = matrix[fr][fc];
				compArray[i] = tane;
				tane = 1;
				i = i + 2;
			}		
			
			fr = sr;
			fc = sc;			
			sr = sr + 1;
			
			if( sr == row ){
				sc = sc + 1;
				sr = 0;
			}
		
		}while( sc < col );
		
	}
	
	compArray[i+1] = matrix[fr][fc];
	compArray[i] = tane;
	N = i + 2;
			
	// End of Encoding Matrix
	
	// Decoding Array
	fr = 0;
	fc = 0;
			
	if( how == 2 ){
		for( j=0; j<=i; j=j+2 ){
			for( k=0; k<compArray[j]; k++ ){			
	
				decodedMatrix[fr][fc] = compArray[j+1];
				fc = fc + 1;	
				if( fc == col ){
					fr = fr + 1;
					fc = 0;
					printf("\n");
				}
			}
		}
	} else {
		for( j=0; j<=i; j=j+2 ){
			for( k=0; k<compArray[j]; k++ ){			
	
				decodedMatrix[fr][fc] = compArray[j+1];
				fr = fr + 1;	
				if( fr == row ){
					fc = fc + 1;
					fr = 0;
					printf("\n");
				}
			}
		}
		
	}	
	
	// Outputs!
	
	printf("\nThe Randomized Matrix");
	printMatrix(matrix, row, col);
	
	printf("\n\nThe Compressed Array\n");
	for( j=0; j<i+2; j++ ){
		printf(" %d ", compArray[j]);
	}
	
	printf("The Decoded Matrix\n");
	printMatrix(decodedMatrix, row, col);
	
	// Compression Ratio
	ratio = 1 - (((float) N ) / (col * row) );
	printf("\nThe Compression Ratio : %f,  -- %d", ratio, N);	
		
	free(matrix);
	free(decodedMatrix);
	return 0;
}
