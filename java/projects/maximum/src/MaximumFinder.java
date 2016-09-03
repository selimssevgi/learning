
import java.util.Scanner;

public class MaximumFinder {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double num1,num2,num3;
		
		System.out.print("Number 1 > ");
		num1 = input.nextDouble();
		
		System.out.print("Number 2 > ");
		num2 = input.nextDouble();
		
		System.out.print("Number 3 > ");
		num3 = input.nextDouble();
		
		System.out.println("Maximum of these numbers is " + maximum(num1,num2,num3));
	}
	
	// Aynı class icerisinde metotların birbirini direkt cagırması ıcın metotlar STATIC olmalı.
	
	// Bu metoda nesne olusturmadan, sınıf adıyla ile cagırmadan ulasabilmem icin STATIC yapmam gerekiyor
	public static double maximum(double n1, double n2, double n3){
		double max = n1;
		
		if( max<n2 ){
			max = n2;
		}
		
		if( max<n3 ){
			max = n3;
		}
		
		return max; // return Math.max(x, Math.max(y,z));
	}

}
