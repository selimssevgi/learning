#include <stdio.h>
#include <time.h>

int main(){
		time_t start,end; 	// The function time() returns the type time_t
		//volatile
		long unsigned i;
		
		// printf("Number of hours since January 1, 1970 is %ld \n", sec/3600); // unreadable for human
		
		start = time(NULL);
		
		for(i=0; i<500000000; i++){
				; //sum+=i;
		}
		
		end = time(NULL);
		
		printf("For Dongu Suresi : %f \n", difftime(end, start));
		
		
		return 0;
}
