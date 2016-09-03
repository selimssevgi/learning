package chapter18;

/**
 * Created by ssselim on 8/6/16.
 */
public class TowersOfHanoi {

    public static void solveTowers( int disks, int sourcePeg,
                                    int destinationPeg, int tempPeg )
    {

        // base case -- only one disk to move
        if ( disks == 1 ) {
            System.out.printf("\n%d --> %d ", sourcePeg, destinationPeg );
            return;
        }

        // recursion step -- move (disk - 1) disks from sourcePeg
        // to tempPeg using destinationPeg
        solveTowers( disks - 1, sourcePeg, tempPeg, destinationPeg );

        // move last disk from sourcePeg to destinationPeg
        System.out.printf( "\n%d --> %d", sourcePeg, destinationPeg );

        // move ( disks - 1 ) disks from tempPeg to destinationPeg
        solveTowers( disks - 1, tempPeg, destinationPeg, sourcePeg );
    }

    public static void main(String[] args) {
        int startPeg = 1;
        int endPeg = 3;
        int tempPeg = 2;
        int totalDisks = 3;

        // initial nonrecursive call: move all disks
        solveTowers( totalDisks, startPeg, endPeg, tempPeg );
    }
}
