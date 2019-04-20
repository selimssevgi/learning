#include <stdio.h>

int main(){
	FILE *f1;
	int len;
	int ch;
	
	f1 = fopen("file1.txt", "r+");
	if( f1 == NULL ){ printf("error"); return 1;}
	
	printf("\n File pointer / position indicator ------\n");
	ch = fgetc(f1);
	while( ch != EOF ){
		printf("File pointer : %ld \n", ftell(f1));
		ch = fgetc(f1);
	}
	
	
	//int fseek(FILE *stream, long int offset, whence); return 0 for successfull, else nonzero value.
	// whence : SEEK_SET, SEEK_CUR, SEEK_END
	
	fseek(f1, 27, SEEK_SET);
	//fprintf(f1, "Nerelerdeyiz ? ");
	
	fseek(f1, 100, SEEK_END);
	//fprintf(f1, "WTF?");
	ch = fgetc(f1);
	printf("char : %d\n", ch);
	len = ftell(f1);
	fclose(f1);
	
	printf("the size of the fie  : %d bytes", len);
	return 0;
}
