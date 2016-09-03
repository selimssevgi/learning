// 13.10.12
// İki sayinin kullanıcıdan alınıp toplanması

import java.util.Scanner; // for class Scanner

public class Addition{
	public static void main( String[] args ){
		//Create a Scanner to obtain input
		// type : Scanner , variable name : input
		Scanner input = new Scanner( System.in );
		
		int num1;
		int num2;
		int sum;

		System.out.print("Enter First integer > ");
		num1 = input.nextInt();
		
		System.out.print("Enter scond integer > ");
		num2 = input.nextInt();

		sum = num1 + num2;

		System.out.printf("Sum is %d\n", sum);
	}
}
