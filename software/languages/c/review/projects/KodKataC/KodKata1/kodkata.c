// Day two

#include <stdio.h>
#include <stdlib.h> // required for malloc,alloc,realloc,free functions.

int main(){
	int *stdGrade;
	int i,stdNum;
	float sum=0,avr;
	
	// get number of the students
	printf("Number of the students > ");
	scanf("%d", &stdNum);
	
	// Allocate a block of memory for the grades of the students
	stdGrade = (int *) malloc(stdNum * sizeof(int));
	
	// Check if the necessary memory is allocated
	if( stdGrade == NULL ){
		printf("ERROR : not able to allocate the memory!");
		return 0;
	}
	
	// get the grade of the students
	for( i=0; i<stdNum; i++ ){
			printf("# %d student's grade > ", i+1);
			scanf("%d", stdGrade + i); // same as stdGrade[i] - dont use & operator. it is like array now.
	}
	
	// find the sum of the grades
	for( i=0; i<stdNum; i++ ){
			sum += *(stdGrade + i);
	}
	
	// find the average
	avr = sum / stdNum;
	
	// printf the avr
	printf("the Average : %f \n", avr); 
	
	// Do not forget to free the allocated memory
	free(stdGrade);
	stdGrade = NULL;
	return 0;
}
