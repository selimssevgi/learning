#include <stdio.h>

int main(void)
{
	int my_array[] = {13, 4, 9, -5, 45};
	int *ptr = NULL;

	puts("Now execute ptr = my_array (or ptr = &my_array[0]\n");

	// Assing the the addres of my_array(which is of type pointer) to a new pointer (to ptr)
	ptr = &my_array[0]; // shorthand: ptr = my_array;

	printf("Content of my_array:  {13, 4, 9, -5, 45}\n");
	printf("Indices my_array[i]:  {0, 1, 2, 3, 4,  5}\n\n");

	printf("Value of *ptr = %d\n", *ptr);
	printf("Address  of ptr = %p\n\n", ptr);

	printf("Value of *(ptr++) = %d\n", *(ptr++)); // Parantez önceliği olarak düşünme
	printf("Address  of ptr = %p\n\n", ptr); 
	
	printf("Value of *ptr++ = %d\n", *ptr++); // Parantezsiz de aynı seyi yapıyor
	printf("Address  of ptr = %p\n\n", ptr);

	printf("Value of (*ptr)++ = %d\n", (*ptr)++); // Değeri yazdıktan sonra ordaki değeri bir artırıyor
	printf("Address  of ptr = %p\n\n", ptr);

	printf("Value of ++*ptr = %d\n", ++*ptr); // Ordaki değeri bir artırıp oyle yazdırıyor
	printf("Address  of ptr = %p\n\n", ptr);

	printf("Value of *++ptr = %d\n", *++ptr); // pointerın gosterdiği adres bir kaydırılıyor ve ordaki değer yazdırılıyor
	printf("Address  of ptr = %p\n\n", ptr);

	printf("Value of *ptr-- = %d\n", *ptr--); 
	printf("Address  of ptr = %p\n\n", ptr);

	printf("Value of *--ptr = %d\n", *--ptr);
	printf("Address  of ptr = %p\n\n", ptr);

	printf("Value of --*ptr = %d\n", --*ptr);
	printf("Address  of ptr = %p\n\n", ptr);

	return 0;
}
