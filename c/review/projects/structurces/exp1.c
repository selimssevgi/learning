/* In this program, a structure(student) is created which contains name, roll and marks as its data member. Then, an array 
 * of structure of 10 elements is created. Then, data(name, roll and marks) for 10 elements is asked to user and stored in 
 * array of structure. Finally, the data entered by user is displayed.
*/

#include <stdio.h>

typedef struct{
	char name[50];
	int age;
	float weight;
}Student;

int main(){
	Student ogrenciler[3];
	int i;
	
	for( i=0; i<3; i++ ){
		printf("%d. Ogrenci bilgileri : \n", i+1);
		printf("Ogrencinin ismi > ");
		scanf("%s", ogrenciler[i].name);
		printf("Ogrencinin yasi > ");
		scanf("%d", &ogrenciler[i].age);
		printf("Ogrencinin kilosu > ");
		scanf("%f", &ogrenciler[i].weight);
	}
	
	printf("KAyitli ogrencilerin bilgileri : \n");
	
	for( i=0; i<3; i++ ){
		printf("%d.Ogrencinin bilgileri : \n", i+1);
		
		printf("Ogrencinin adi : %s\n", ogrenciler[i].name);
		printf("Ogrencinin yasi : %d\n", ogrenciler[i].age);
		printf("Ogrencinin kilosu : %f\n", ogrenciler[i].weight);
	}
	
	
	return 0;
}
