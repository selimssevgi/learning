// exOne.java
// Example of getting ınput from user
// 2.11.12

// Scanner class
import java.util.Scanner;

public class exOne{
	public static void main( String[] args ){
		Scanner Input = new Scanner( System.in );
		int num1;

		System.out.print("A number : ");
		num1 = Input.nextInt();

		System.out.println("Sayi : " + num1);	
	}
}
