// BasamakGrupla.java
/* PROBLEM : 
	kullanicidan alinacak 4 basamakli bir sayiyi, ilk iki basamagi
	bir sayi diğer iki basamagi baska bir sayi olacak sekilde
	ayır ve bu sayıların buyuklugunu kucuklugu hakkında bılgı ver.
*/
// 02.11.12

import java.util.Scanner; // for Scanner class

public class BasamakGrupla{
	public static void main( String[] args ){
		Scanner Input = new Scanner(System.in);
		int sayi,birinciKisim,ikinciKisim;

		System.out.print("4 basamakli bir sayi > ");
		sayi = Input.nextInt();
		
		// abcd > ikinciKisim = cd
		ikinciKisim = sayi % 100;
		// abcd > birinciKisim = ab
		birinciKisim = sayi / 100;
		
		// SAyilari Ekrana yazdir
		System.out.println("Birinci Sayi : "+birinciKisim);
		System.out.println("Ikinci Sayi : "+ikinciKisim);

		if( birinciKisim > ikinciKisim ){
			System.out.println("Birinci sayi("+birinciKisim+") buyuktur ikinci sayidan("+ikinciKisim+")");
		} else {
			System.out.println("Ikinci sayi("+ikinciKisim+") buyuktur birinci sayidan("+birinciKisim+")");
		}
	}
}
