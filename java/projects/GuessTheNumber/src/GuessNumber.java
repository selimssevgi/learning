
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
	public static void main(String[] args) {
		Random randomNumber = new Random();
		Scanner input = new Scanner(System.in);
		int number = randomNumber.nextInt(100);
		int guess;
		
		System.out.println("System has picked a number randomly.Between 0-100.");
		
		System.out.print("Guess the number > ");
		guess = input.nextInt();
		
		while( guess != number ){
			if( guess > number ){
				System.out.println("Too high!");
			}else{
				System.out.println("Too low!");
			}
			
			System.out.println("Guess the number > ");
			guess = input.nextInt();
		}
		
		if( guess == number ){
			System.out.println("Congrat! You guessed the number correctly.");
		}
		
	}

}
