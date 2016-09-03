#include <stdio.h>
#include <stdlib.h> // rand icin
#include <time.h>

int rollDice(){
	int die1,die2,sum;
	
	srand(time(NULL));	
	die1 = 1 + rand() % 6;
	srand(time(NULL));
	die2 = 1 + rand() % 6; 
	sum = die1 + die2;
	
	printf("Player rolled %d + %d = %d\n", die1, die2, sum);
	
	return sum;
}

int main(){
	int sumOfDice,myPoint;
	char *status = "Selim";
	
	sumOfDice = rollDice();
	
	switch( sumOfDice ){
		case 7:
		case 11:
			status = "WON";
		break;
		case 2:
		case 3:
		case 12:
			status = "LOST";
		break;
		default:
			status = "CONTINUE";
			myPoint = sumOfDice;
			printf("Point is %d\n", myPoint);
		break;
	} 
	
	while( *status == 'C' ){
		sumOfDice = rollDice();
		
		if( sumOfDice == myPoint ){
			status = "WON";
		}else if( sumOfDice == 7 ){
			status = "LOST";
		}
	}
	
	if( *status == 'W' ){
		printf("Player wins!\n");
	}else {
		printf("Player loses!\n");
	}
	return 0;
}
