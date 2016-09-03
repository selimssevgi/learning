#include <stdio.h>
#include <stdlib.h> // required for random() and randomize()

int main(){
		int i;
		
		srand(); // for generating diff random number each time		
		
		i = rand() % 100;
		printf("random number : %d", i);
		
		return 0;
}
