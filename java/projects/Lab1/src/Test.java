
import java.util.Scanner;

public class Test {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String ad,TC;
		int age,kilo;
		float boy;
		
		System.out.print("Hasta TC > ");
		TC = input.nextLine();
		
		System.out.printf("Hasta Adi > ");
		ad = input.nextLine();
		
		Hasta hasta1 = new Hasta(TC,ad);
		
		System.out.printf("Hastanin boyu > ");
		boy = input.nextFloat();
		
		hasta1.setBoy(boy);
		
		System.out.printf("Hastanin yasi > ");
		age = input.nextInt();
		
		hasta1.setAge(age);
		
		System.out.printf("Hastanin kilosu > ");
		kilo = input.nextInt();
		
		hasta1.setKilo(kilo);
		
		System.out.printf("Hastanin KBI'si : "+ hasta1.getKBI());
	}
}
