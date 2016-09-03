
public class MethodOverload {
	
	public static void main(String[] args) {
		
		System.out.println("square of int 7 : " + square(7));
		System.out.println("square of double 7.5 : " + square(7.5));
	}
	
	
	// Metot isimlerimiz aynı ama return degerleri ve parametre turlerı farklı.METHOD OVERLOADED.
	public static int square( int intValue ){
		return intValue * intValue;
	}
	
	public static double square( double doubleValue ){
		return doubleValue * doubleValue;
	}

}
