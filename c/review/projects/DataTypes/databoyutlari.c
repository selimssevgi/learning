#include <stdio.h>

int main(){
		
		// size of data types in C programming
		
		printf("             Void : %d byte\n", sizeof(void));
		printf("             Char : %d byte\n", sizeof(char));
		printf("   Short Interger : %d bytes\n", sizeof(short int));
		printf("         Interger : %d bytes\n", sizeof(int));
		printf("    Long Interger : %d bytes\n", sizeof(long int));
		
		// Unsigned ve signed boyutunda bir değişiklik yapmıyor.Sadece alabileceği max değeri etkiliyor.
		printf("Unsigned Interger : %d bytes\n", sizeof(unsigned int));
		printf("  Signed Interger : %d bytes\n", sizeof(signed int));
		
		printf("            Float : %d bytes\n", sizeof(float));
		printf("      Long Double : %d bytes\n", sizeof(long double));
		printf("           Double : %d bytes\n", sizeof(double));
		
		
		int charVar;
				
		/*
		 *  char değişkeni tek bir karakteri saklar.
		 *  8 bit, 1 byte boyutundadır.256 farklı karakteri bir char değişkeninde saklayabiliriz.
		 *  Bu karakterler sembol gibi görünmelerine ragmen sayılardan ibarettirler.
		 *  Zaten char da en kucuk boyuttaki ozel bir integerdir.
		 * 	O 256 farklı sayinin ASCII tablosunda karşılıkları vardır.
		 */
		 
		charVar = 'a'; // charVar = 97 ile aynı şeydir.
		printf("charVar = 'a' -> %c, %d", charVar,charVar); 
		
		// charVar = "a";   --> Burda char tipini string ataması yapılmaya çalışılıyor. OLMAZ!
		// charVar = 'abc'; --> Burda char notasyonu kullanılmış; ancak char tipi sadece tek karakteri saklayabilir. OLMAZ!
		// charVar = "abc"; --> Burda da aynı şekilde string atama notasyonu kullanılmış. OLMAZ!
		
		
		return 0;
}

