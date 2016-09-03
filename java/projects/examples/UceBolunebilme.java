// UceBolunebilme.java
/* PROBLEM : 
	Kullanicidan alacagin 3 basamakli bir sayinin
	basamaklardaki sayi degerlerinin uce bolunup bolunmedıgı
	ekrana yazdiran program.
*/

// 02.11.12

import java.util.Scanner;

public class UceBolunebilme{
	public static void main( String[] args ){
		Scanner Input = new Scanner(System.in);
		int sayi,top=0,deger;
		
		System.out.print("Basamak degerlerinin toplaminin \nuce bolunup bolunmedigini ogrenmek istediginiz sayi : ");
		sayi = Input.nextInt();

		while( sayi != 0 ){
			deger = sayi % 10;
			sayi = sayi / 10;
			top = top + deger;
		}

		if( top % 3 == 0 ){
			System.out.println("Sayinin basamak degerlerinin toplami uce tam BOLUNUYOR!");	
		} else {
			System.out.println("Sayinin basamak degerlerinin toplami uce tam BOLUNMUYOR!");
		}

	}
}
