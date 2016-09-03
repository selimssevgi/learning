
import java.util.Random;

public class RandomGen {
	public static void main(String[] args) {
		Random rastgeleSayi = new Random();
		int sayi,sayi2,zar;
		
		int counter;
		
		int fre1 = 0;
		int fre2 = 0;
		int fre3 = 0;
		int fre4 = 0;
		int fre5 = 0;
		int fre6 = 0;
		
		sayi = rastgeleSayi.nextInt(); // bu durumda -2milyar ve 2milyar arasinda bir sayi seciliyor.
		sayi2 = rastgeleSayi.nextInt(2); // burda ise bir sınıf koyuyoruz sınır dahil degil. [0-sinir) seklinde.0 veya1
		zar = rastgeleSayi.nextInt(6) + 1; // burda ise 0-5 dahil sececek +1 ile zar durumunu saglayabiliriz.
		
		System.out.println("Sayi : " + sayi);
		System.out.println("Sayi2 : " + sayi2);
		System.out.println("Zar : " + zar);
		
		for( counter=0; counter<6000; counter++ ){
			zar = rastgeleSayi.nextInt(6) + 1;
			
			switch( zar ){
			case 1 : 
				++fre1;
			break;
			case 2 : 
				++fre2;
			break;
			case 3 : 
				++fre3;
			break;
			case 4 : 
				++fre4;
			break;
			case 5 : 
				++fre5;
			break;
			case 6 : 
				++fre6;
			break;			
			}
		}
		
		System.out.println("Fre1 : " + fre1);
		System.out.println("Fre2 : " + fre2);
		System.out.println("Fre3 : " + fre3);
		System.out.println("Fre4 : " + fre4);
		System.out.println("Fre5 : " + fre5);
		System.out.println("Fre6 : " + fre6);
			
	}

}
