/**
 * Created by ssselim on 7/29/16.
 */
public class Test
{
    public static void main( String[] args )
    {
        System.out.print(accum("ZpglnRxqenU"));


        String[] s1 = new String[]{"hoqq", "bbllkw", "oox", "ejjuyyy", "plmiis", "xxxzgpsssa", "xxwwkktt", "znnnnfqknaz", "qqquuhii", "dvvvwz"};
        String[] s2 = new String[]{"cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww"};

        System.out.printf( " max diff len : %d\n ", mxdiflg(s1, s2));
    }

    public static String accum(String s) {
        // your code
        char[] letters = s.toCharArray();
        String finalStr = "";

        for (int i = 0; i < letters.length; i++) {
            char[] temp = new char[i + 1];
            for (int j = 0; j < i + 1; j++) {
                temp[j] = letters[i];
            }

            temp[0] = Character.toUpperCase(temp[0]);
            String tempStr = new String(temp);
            finalStr += "-" + tempStr;

        }

        return finalStr;
    }

    public static int mxdiflg( String[] a1, String[] a2 )
    {
        if ( a1.length == 0 || a2.length == 0)
        {
            return -1;
        }

        int a1Min = 999999;
        int a1Max = 0;
        int a2Min = 999999;
        int a2Max = 0;

        for ( String s:a1 ) {
            if ( a1Min > s.length() ) { a1Min = s.length(); }
            if ( a1Max < s.length() ) { a1Max = s.length(); }
        }

        for ( String s:a2 ) {
            if ( a2Min > s.length() ) { a2Min = s.length(); }
            if ( a2Max < s.length() ) { a2Max = s.length(); }
        }

        int diff1 = a1Max - a2Min;
        int diff2 = a2Max - a1Min;

        return Math.max( diff1, diff2 );
    }
}
