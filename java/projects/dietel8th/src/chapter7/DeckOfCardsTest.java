package chapter7;

/**
 * Created by ssselim on 8/4/16.
 */
public class DeckOfCardsTest {

    public static void main( String[] args )
    {
        DeckOfCards myDeck = new DeckOfCards();
        myDeck.shuffle();

        for (int count = 1; count <= 52; count++) {
            System.out.printf("%-19s", myDeck.dealCard());

            if ( count % 4 == 0 )
                System.out.println();
        }
    }
}
