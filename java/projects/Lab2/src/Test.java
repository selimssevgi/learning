
import java.util.Scanner;

public class Test {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int en,boy;
		
		System.out.println("Dikdortgenin eni > ");
		en = input.nextInt();
		
		System.out.println("Dikdortgenin boyu > ");
		boy = input.nextInt();
		
		Dikdortgen dik1 = new Dikdortgen(en,boy);
		
		System.out.println("Dikdortgenin Alani : " + dik1.alanHesapla());
		System.out.println("Dindortgenin Cevresi : " + dik1.cevreHesapla());
	}	
}
