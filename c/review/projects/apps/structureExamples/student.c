#include <stdio.h>

// Definin a structure
struct Student{
	char name[50];
	int age;
	float marks;
};

int main(){
	// mesela 
	char gunler[7][10] = {	
							};
	
	
	
	
	
	
	
	
	
	struct Student s;
	
	printf("Enter the information of the student.\n\n");
	
	printf("name > ");
	scanf("%s", s.name);
	
	printf("Age > ");
	scanf("%d", &s.age);
	
	printf("marks > ");
	scanf("%f", &s.marks);
	return 0;
}
