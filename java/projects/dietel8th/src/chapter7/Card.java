package chapter7;

/**
 * Created by ssselim on 8/4/16.
 */
public class Card {
    private String face; // face of card { Ace, Deuce ...
    private String suit; // suit of card { Hearts, Diamond ...

    public Card( String f, String s )
    {
        face = f;
        suit = s;
    }

    public String toString()
    {
        return face + " of " + suit;
    }
}
