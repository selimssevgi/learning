
import java.util.Scanner;

public class Average {
	//Main method
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int counter=1,total=0,grade,numberOfStd;
		float averageGrade;
		
		System.out.print("Number of Students > ");
		numberOfStd = input.nextInt();
		
		// numberOfStd cannot be zero / invalid division by zero
		if( numberOfStd == 0 ){
			System.out.println("Error : cannot be zero!");
		}else{
		
			while( counter<=numberOfStd ){
				System.out.print(counter +".Grade > ");
				grade = input.nextInt();
				
				total = total + grade;
				counter = counter + 1;
			}
			
			averageGrade = (float) (1.0 * total / numberOfStd);
			
			System.out.println("Average of Number is : "+ averageGrade);
		}
	}
}
