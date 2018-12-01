package com.selimssevgi.dietel8th.chapter7;

import java.util.Random;

/**
 * Created by ssselim on 8/4/16.
 */
public class DeckOfCards {
    private Card[] deck;
    private int currentCard; // index of the next card to dealt
    private static final int NUMBER_OF_CARDS = 52;
    private static final Random rand = new Random();

    public DeckOfCards()
    {
        String[] faces = { "Ace", "Deuce", "Three", "Four", "Five", "Six",
                "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };

        deck = new Card[ NUMBER_OF_CARDS ];
        currentCard = 0;

        for (int count = 0; count < NUMBER_OF_CARDS; count++) {
            deck[ count ] = new Card( faces[ count % 13 ], suits[ count / 13 ]);
        }
    }

    public void shuffle()
    {
        currentCard = 0; // after shuffling, dealing should start from deck[0]

        Card tempCard;
        for (int first = 0; first < NUMBER_OF_CARDS; first++) {
           int second = rand.nextInt( NUMBER_OF_CARDS );

            tempCard = deck[ first ];
            deck[ first ]  = deck[ second ];
            deck[ second ] = tempCard;
        }
    }

    public Card dealCard()
    {
        if ( currentCard < NUMBER_OF_CARDS )
        {
            return deck[ currentCard ++ ];
        } else {
            return null;
        }
    }
}
