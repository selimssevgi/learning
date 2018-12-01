/*
 *  Kontrol(escape) Karakterleri
 * 
 * Çıktısı alınacak yazının biçimlendirilmesi.
 * 
 *  Kodu 		Anlamı
 *   \a 		Bell(speaker beeps) bip sesi
 * 	 \b			İmleci bir karakter sola götürür(backspace)
 * 	 \f			Yazıcıda yeni sayfanın başına geçme
 * 	 \n 		İmleci yeni satır başına geçirir
 * 	 \r 		İmleci çalışılan satırın başına alma
 * 	 \t 		İmleci yatay eksende belirli aralıklarla hareket ettirir
 *   \"         Çift Tırnak
 * 	 \v 		Dikey Tab
 * 	 \'			Tek Tırnak
 * 	 \0 		Boş Karakter (NULL karakter)
 * 	 \\ 		Back Slash
 * 
 */
 
#include <stdio.h>

int main()
{		
		printf("\\v Kullanımı : \n");
        printf("Selim \vSırrı \vSevgi\n\n");
		
		printf("\\t Kullanimi :\n");
		printf("Selim \tSırrı \t\tSevgi\n");
		
		return 0;
}
