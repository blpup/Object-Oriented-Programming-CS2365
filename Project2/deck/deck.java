
import java.util.ArrayList;
import java.util.Collections;
import projecttwo.Card;

public class Deck {

    public ArrayList<Card> deck = new ArrayList<>();

    String Colors[] = {"Red", "Blue", "Yellow", "Green"};
    String NumberCards[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    String ActionCards[] = {"Draw 2", "Reverse", "Skip"};
    String WildCards[] = {"Wild", "Draw 4"};

//add mechanism for separate shuffling
    public Deck(boolean addAction, int numOfDecks, boolean isSeparate) {
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
        //add length method
    }
}
