#include <stdio.h>

// define ile yapılan tanımlamalardan sonra 
// noktalı vırgul kullanma

#define BUFF_LEN 512 

int main(){
	// mesela kullanmıs olsa burdaki tanımlama soyle olurdu
	// a = 512; ; yani yanlis!
	int a = BUFF_LEN;
	
	printf("%d",a);
	
	return 0;
}
