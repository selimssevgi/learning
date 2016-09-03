/**
 Find the smallest integer in the array.

 Given an array of integers your solution should find the smallest integer. For example:
 Given [34, 15, 88, 2] your solution will return 2
 Given [34, -345, -1, 100] your solution will return -345

 You can assume, for the purpose of this kata, that the supplied array will not be empty.
 */
public class SmallestIntegerFinder {
    public static int findSmallestInt(int[] intArr) {

        if ( intArr.length == 0 ) return -1;

        int min = intArr[ 0 ];

        for (int i = 1; i < intArr.length; i++) {
           if ( min > intArr[ i ] )
           {
               min = intArr[ i ];
           }
        }
        return min;
    }
}
