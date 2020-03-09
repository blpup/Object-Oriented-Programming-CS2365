/*
    Object Orieted Programming, Section 01, Spring 2020
    Elijah Hand
    Project 2
    Team #6
 */
package project2;

import java.util.ArrayList;

/* Presidence List:

5 - Skip
4 - Draw2
3 - Reverse
2 - Wild
1 Wild Draw 4
-1 Number Card
 */
/**
 * The Hand Class
 *
 * @author Elijah Hand
 * @version 1.0
 */
public class Hand {

    private ArrayList curHand = new ArrayList(7);
    private ArrayList deck;
    private int start, end;
    private int cardsLeft;
    private int[] exercisesThisRound = {0, 0, 0, 0};
    private int[] totalExercises = {0, 0, 0, 0};
    private int[] totalExercisesSkipped = {0, 0, 0, 0};
    private int[] biggestExercises = {0, 0, 0, 0};
    private int totalRoundBurpees = 0;
    private int totalBurpees = 0;
    private int largestBurpeeInHand = 0;

    /**
     *
     * @return Returns the largest burpee in the hand
     */
    public int getLargestBurpeeInHand() {
        return this.largestBurpeeInHand;
    }

    /**
     * @return Returns the integer value associated with the running total of
     * burpees
     */
    public int getTotalBurpees() {
        return this.totalBurpees;
    }

    /**
     * @return Returns the integer value associated with the round total of
     * burpees
     */
    public int getRoundBurpees() {
        return this.totalRoundBurpees;
    }

    /**
     * @return Returns the current Hand represented by an array list. Returns a
     * shallow copy of the array.
     */
    public ArrayList getCurHand() {

        ArrayList tempList = this.sortHandColor(this.curHand);
        tempList = this.sortHand(tempList);

        return tempList;
    }

    /**
     * @return Returns the integer value associated with cards left in the deck
     */
    public int getCardsLeft() {
        return this.cardsLeft;
    }

    /**
     * @return Returns the number of exercises this round. Each index represents
     * a different color 0 = red, 1 = blue, 2 = green, 3 = yellow.
     */
    public int[] getExercisesThisRound() {
        return this.exercisesThisRound;
    }

    /**
     * @return Returns the running total of exercises this round. Each index
     * represents a different color 0 = red, 1 = blue, 2 = green, 3 = yellow.
     */
    public int[] getTotalExercises() {
        return this.totalExercises;
    }

    /**
     * @return Returns the running total of exercises skipped. Each index
     * represents a different color 0 = red, 1 = blue, 2 = green, 3 = yellow.
     */
    public int[] getTotalExercisesSkipped() {
        return this.totalExercisesSkipped;
    }

    /**
     * @return Returns the greatest number of each color throughout the workout.
     * Each index represents a different color 0 = red, 1 = blue, 2 = green, 3 =
     * yellow.
     */
    public int[] getBiggestExercises() {
        return this.biggestExercises;
    }

    /**
     * Constructor for the Hand Class. Takes in an <b>ArrayList</b> and sets
     * everything to their starting values
     *
     * @param deck The whole deck
     */
    public Hand(ArrayList deck) {
        this.deck = deck;
        this.start = 0;
        this.end = 7;
        this.cardsLeft = deck.size();
    }

    /**
     * Draws a hand from the Deck. Non-destructive to the deck ArrayList.
     * Automatically takes care to not overdraw from the deck of cards
     */
    public void drawHand() {
        for (; this.start < this.end; this.start++) {
            int i = this.start % 7;
            this.curHand.add(this.deck.get(this.start));
        }
        this.setCardsLeft();
        this.increaseIndex();
    }

    /**
     * Helper method for drawHand, simply decreases the number of cards by a
     * hands worth (7) whenever called
     */
    private void setCardsLeft() {
        this.cardsLeft -= 7;
    }

    /**
     * Helper method for drawHand. Increases the start and end index values so
     * the program knows where to select cards next from the deck. Will prevent
     * itself from going out of bounds.
     */
    private void increaseIndex() /* Increase the start and end indexes. To be used after the drawHand method is done */ {
        int trackingNum;
        if (this.cardsLeft > 7) {
            this.end += 7;
        } else {
            this.start = this.end - 1;
            this.end = this.deck.size() - 1;
        }
    }

    /**
     * @return Returns an ArrayList populated with the number of Card objects
     * matching the color of the Reverse in the <b>CurHand</b>
     * Automatically calls the <b>removeColor</b> method. Destructive on
     * curHand.
     */
    private ArrayList removeReverse() {
        ArrayList tempList = new ArrayList();
        String[] colorsRemoved = new String[4];
        // 0 == red
        // 1 == blue
        // 2 == green
        // 3 == yellow
        for (int i = 0; i < this.curHand.size(); i++) {
            Card curCard = (Card) this.curHand.get(i);
            if (curCard.getPrecedence() == 3) // Precedence number for Reverse cards
            {
                switch (curCard.getColor()) {
                    case "Red":
                        colorsRemoved[0] = "Red";
                        break;
                    case "Blue":
                        colorsRemoved[1] = "Blue";
                        break;
                    case "Green":
                        colorsRemoved[2] = "Green";
                        break;
                    case "Yellow":
                        colorsRemoved[3] = "Yellow";
                        break;
                }
                curHand.remove(i);
            }
        }
        tempList.addAll(removeColor(colorsRemoved));
        return tempList;
    }

    /**
     * @param Requires a <b>colorArray</b>
     * @return Returns an ArrayList of the cards removed from the
     * <b>curHand</b>.
     */
    private ArrayList removeColor(String colorArray[]) {
        // Rework. Have 2 for loops one cycling through the color Array and one cycling through the length of the deck. Have the switch statement work off of hand card loop, then add it it array to be returned. 
        Card curCard;
        ArrayList removedCardList = new ArrayList(7);
        for (int h = 0; h < 7; h++) {
            for (int i = 0; i < colorArray.length; i++) {
                if (colorArray[i] != null) {
                    for (int j = 0; j < this.curHand.size(); j++) {
                        curCard = (Card) curHand.get(j);
                        if (colorArray[i] == curCard.getColor()) {
                            removedCardList.add(curHand.get(j));
                            curHand.remove(j);
                        }
                    }
                }
            }
        }
        removedCardList.trimToSize();
        curHand.trimToSize();
        return removedCardList;
    }

    /**
     * Calculates the value of a given hand after taking into account what is
     * present. Sets the <b>exercisesThisRound</b>, <b>totalExercises</b>,
     * <b>totalExercisesSkipped</b>, <b>biggestExercises</b>,
     * <b>totalRoundBurpees</b>, and <b>totalBurpees</b> values. Destroys the
     * curHand after being called.
     */
    public void processHand() {
        int[] totalExercisesThisRound, Draw2, skippedExercises = new int[4];
        int Wild, Draw4;
        ArrayList reversedArrayList, skippedArrayList;
        skippedArrayList = removeSkip();
        Draw2 = removeDraw2();
        reversedArrayList = removeReverse();
        Wild = removeWild();
        Draw4 = removeWild4();
        totalExercisesThisRound = arrayListConversion(this.curHand);
        skippedExercises = arrayListConversion(skippedArrayList);
        this.totalRoundBurpees = 0;
        for (int i = 0; i < Draw4; i++) {
            this.totalRoundBurpees += 10;
        }
        for (int j = 0; j < Wild; j++) {
            this.totalRoundBurpees += 10;
        }

        if (this.totalRoundBurpees > this.largestBurpeeInHand) {
            this.largestBurpeeInHand = this.totalRoundBurpees;
        }
        this.totalBurpees += totalRoundBurpees;
        Draw4 = Draw4 * 4;
        for (int i = 0; i < 4; i++) {
            if (Draw4 != 0) {
                totalExercisesThisRound[i] *= Draw4;
            }
            if (Draw2[i] != 0) {
                totalExercisesThisRound[i] *= (2 * Draw2[i]);
            }
        }
        for (int i = 0; i < 4; i++) {
            this.exercisesThisRound[i] = totalExercisesThisRound[i];
            this.totalExercises[i] += totalExercisesThisRound[i];
            this.totalExercisesSkipped[i] += skippedExercises[i];
            if (biggestExercises[i] < totalExercisesThisRound[i]) {
                biggestExercises[i] = totalExercisesThisRound[i];
            }
        }
        this.deck.addAll(reversedArrayList);
        this.cardsLeft += reversedArrayList.size();
        if (this.cardsLeft < 0) {
            this.cardsLeft = 0;
        }
        this.curHand.clear();
    }

    /**
     * Removes all wild cards in a given hand.
     *
     * @return Returns an integer representing the number of Wilds removed
     */
    private int removeWild() {
        int numRemoved = 0;
        for (int i = 0; i < this.curHand.size(); i++) {
            Card curCard = (Card) this.curHand.get(i);
            if (curCard.getPrecedence() == 2) {
                numRemoved++;
                this.curHand.remove(i);
                i--;
            }
        }
        return numRemoved;
    }

    /**
     * Removes all Draw2 cards in a given hand.
     *
     * @return Returns an integer array representing the number of Wilds removed
     * for each color. 0 = red, 1 = blue, 2 = green, 3 = yellow
     */
    private int[] removeDraw2() {
        int[] numRemoved = {0, 0, 0, 0};
        for (int i = 0; i < this.curHand.size(); i++) {
            Card curCard = (Card) this.curHand.get(i);
            if (curCard.getName() == "Draw 2") {
                switch (curCard.getColor()) {
                    case "Red":
                        numRemoved[0] += 1;
                        break;
                    case "Blue":
                        numRemoved[1] += 1;
                        break;
                    case "Green":
                        numRemoved[2] += 1;
                        break;
                    case "Yellow":
                        numRemoved[3] += 1;
                        break;
                }
                this.curHand.remove(i);
            }
        }
        return numRemoved;
    }

    /**
     * Removes all Wild Draw 4 cards in a given hand.
     *
     * @return Returns an integer representing the number of Draw4s removed
     */
    private int removeWild4() {
        int numRemoved = 0;
        for (int i = 0; i < this.curHand.size(); i++) {
            Card curCard = (Card) this.curHand.get(i);
            if (curCard.getPrecedence() == 1) {
                numRemoved += 1;
                curHand.remove(i);
                i--;
            }
        }
        return numRemoved;
    }

    /**
     * Converts a given ArrayList populated with <b>Card</b> objects to an
     * integer array with the ranks of each card added up.
     *
     * @return Returns an integer array. Each index represents a color 0 = red 1
     * = blue, 2 = green, 3 = yellow. The magnitude of each index represents the
     * ranks of that color in the given Hand.
     */
    private static int[] arrayListConversion(ArrayList a) {
        int[] returnIntArray = new int[4];
        for (int i = 0; i < a.size(); i++) {
            Card curCard = (Card) a.get(i);
            String curCardName = curCard.getName();
            try {
                int curCardNumber = Integer.parseInt(curCardName);
                switch (curCard.getColor()) {
                    case "Red":
                        returnIntArray[0] += curCardNumber;
                        break;
                    case "Blue":
                        returnIntArray[1] += curCardNumber;
                        break;
                    case "Green":
                        returnIntArray[2] += curCardNumber;
                        break;
                    case "Yellow":
                        returnIntArray[3] += curCardNumber;
                        break;
                }
            } catch (Exception e) {
                switch (curCard.getColor()) {
                    case "Red":
                        returnIntArray[0] += 1;
                        break;
                    case "Blue":
                        returnIntArray[1] += 1;
                        break;
                    case "Green":
                        returnIntArray[2] += 1;
                        break;
                    case "Yellow":
                        returnIntArray[3] += 1;
                        break;
                }
            }
        }
        return returnIntArray;
    }

    /*
    * Method to remove skips from the curHand.
    * @return Returns an <b>ArrayList</b> populated with <b>Card</b> objects that were skipped.
     */
    private ArrayList removeSkip() {
        ArrayList tempList = new ArrayList();
        String[] colorsRemoved = new String[4];
        // 0 == red
        // 1 == blue
        // 2 == green
        // 3 == yellow
        for (int i = 0; i < this.curHand.size(); i++) {
            Card curCard = (Card) this.curHand.get(i);
            if (curCard.getPrecedence() == 5) // Precedence number for Reverse cards
            {
                switch (curCard.getColor()) {
                    case "Red":
                        colorsRemoved[0] = "Red";
                        break;
                    case "Blue":
                        colorsRemoved[1] = "Blue";
                        break;
                    case "Green":
                        colorsRemoved[2] = "Green";
                        break;
                    case "Yellow":
                        colorsRemoved[3] = "Yellow";
                        break;
                }
            }
        }
        tempList.addAll(removeColor(colorsRemoved));
        //this.deck.addAll(tempList);
        return tempList;
    }

    /**
     * Sorts the hand by value
     *
     * @param tempList A list of the current hand
     * @return Will return a new array of the sorted hand.
     */
    private ArrayList sortHand(ArrayList tempList) {
        ArrayList newTempList = (ArrayList) tempList.clone();
        for (int j = 0; j < newTempList.size(); j++) {
            for (int i = 0; i < newTempList.size(); i++) {
                Card curCard = (Card) newTempList.get(j);
                Card nextCard = (Card) newTempList.get(i);
                String curCardRank = curCard.getName();
                String nextCardRank = nextCard.getName();
                if (curCardRank.compareTo(nextCardRank) < 0) {

                    if (curCard.getColor() == nextCard.getColor()) {
                        Card tempCard = nextCard;
                        newTempList.set(i, curCard);
                        newTempList.set(j, tempCard);
                    }
                }
            }
        }
        return newTempList;
    }

    /**
     * Will sort the hand by color
     *
     * @param currentHand A list of the current hand
     * @return ill return a new array of the sorted hand.
     */
    private ArrayList sortHandColor(ArrayList currentHand) {
        ArrayList tempList = (ArrayList) currentHand.clone();
        for (int j = 0; j < tempList.size(); j++) {
            for (int i = 0; i < tempList.size(); i++) {
                Card curCard = (Card) tempList.get(j);
                Card nextCard = (Card) tempList.get(i);
                int curCardColor = getCardColor(curCard);
                int nextCardColor = getCardColor(nextCard);
                if (curCardColor < nextCardColor) {
                    Card tempCard = nextCard;
                    tempList.set(i, curCard);
                    tempList.set(j, tempCard);
                }
            }
        }
        return tempList;
    }

    /**
     * Gets the card color and will return a priority
     *
     * @param a The card color
     * @return Will return a sorting priority number
     */
    private int getCardColor(Card a) {
        if ("Red".equals(a.getColor())) {
            return 0;
        }
        if ("Blue".equals(a.getColor())) {
            return 1;
        }
        if ("Green".equals(a.getColor())) {
            return 2;
        }
        if ("Yellow".equals(a.getColor())) {
            return 3;
        }
        return 4;
    }
}
