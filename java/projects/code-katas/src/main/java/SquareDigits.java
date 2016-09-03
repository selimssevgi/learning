import java.util.ArrayList;

/**
 *
 In this kata, you are asked to square every digit of a number.

 For example, if we run 9119 through the function, 811181 will come out.

 Note: The function accepts an integer and returns an integer
 */
public class SquareDigits {

    public static int squareDigits(int n)
    {
        char[] digitChars = String.valueOf(n).toCharArray();
        StringBuilder sb = new StringBuilder();

        for ( char digit: digitChars ) {
           int d = Integer.parseInt(digit + "");
            int sqr = d * d;
            sb.append(sqr);
        }

        return Integer.parseInt(sb.toString());

    }

    public static int squareDigits2(int n)
    {
        ArrayList<Integer> digits = new ArrayList<>();

        while ( n > 1 )
        {
            digits.add(n % 10);
            n = n / 10;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = digits.size()-1; i >= 0 ; i--) {
           int digit = digits.get(i);
            sb.append(digit * digit);
        }

        return Integer.parseInt(sb.toString());

    }

    public static int[] getDigits(int n) {
        char[] asChars = String.valueOf(n).toCharArray();
        int[] digits = new int[ asChars.length ];

        for (int i = 0; i < digits.length; i++) {
            digits[ i ] = Integer.parseInt( String.valueOf( asChars[ i ] ) );
        }

        return digits;
    }
}
