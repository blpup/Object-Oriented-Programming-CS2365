//NAME: SUMMER WARRICAN
//TITLE: PROJECT 2
//COURSE:CS 2365
//SECTION:2
//SEMESTER:SPRING SEMESTER

package project2;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The Deck Class
 * 
 * @author Summer
 */
public class Deck {
    
    private ArrayList<Card> deck;
    private final String Colors[] = {"Red", "Blue", "Yellow", "Green"};
    private final String NumberCards[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private final String ActionCards[] = {"Draw 2", "Reverse", "Skip"};
    private final String WildCards[] = {"Wild", "Draw 4"};

/**
 * This constructs a deck with a specified number of decks, with or without action cards and with overall shuffling or separate shuffling for each deck 
 * @param addAction determines whether or not action cards should be added to the deck
 * @param numOfDecks the number of decks
 * @param isSeparate determines if the decks should be shuffled together or separately
 */
    public Deck(boolean addAction, int numOfDecks, boolean isSeparate) {
        this.deck = new ArrayList<>();
        for (int i = 0; i < numOfDecks; i++) {
            for (String C : Colors) {
                for (String N : NumberCards) {
                    if (N.equals("0")) {
                        Card card = new Card(C, N, 0);
                        deck.add(card);
                    } else {
                        Card card = new Card(C, N, 0);
                        deck.add(card);
                        deck.add(card);
                    }

                }
            }
            for (int x = 0; x < 4; x++) {
                Card card = new Card("Wild", 2);
                deck.add(card);
                card = new Card("Draw 4", 1);
                deck.add(card);
            }

            if (addAction) {
                for (String C : Colors) {
                    for (String A : ActionCards) {
                        if (A.equals("Reverse")) {
                            Card card = new Card(C, A, 3);
                            deck.add(card);
                            deck.add(card);
                        }
                        if (A.equals("Draw 2")) {
                            Card card = new Card(C, A, 4);
                            deck.add(card);
                            deck.add(card);
                        }
                        if (A.equals("Skip")) {
                            Card card = new Card(C, A, 5);
                            deck.add(card);
                            deck.add(card);
                        }
                    }
                }
            }

            if (isSeparate) {
                Collections.shuffle(this.deck);
            }

        }

        if (!isSeparate) {
            Collections.shuffle(this.deck);
        }
    }
    
/**
 * This returns the entire deck of cards
 * @return the deck of cards
 */
    public ArrayList<Card> getDeck() {
        return deck;
    }

}
