/*
    Object Orieted Programming, Section 01, Spring 2020
    Isaak Chinault
    Project 2
    Team #6
 */

package project2;

/**
 * The Card class creates an object of type card with a specific number of 
 * properties applicable to each type of card.
 * @author Isaak
 */
public class Card {

    private int precedence;
    private String color, name;

    /**
     * Card Constructor
     * For cards with a color (0-9 and +2)
     * @param color The color of the card Green, Red, ...
     * @param name The value of the card 0-9, skip, ... , etc
     * @param precedence The priority of the Card
     */
    public Card(String color, String name, int precedence) {
        this.color = color;
        this.name = name;
        this.precedence = precedence;
    }
    
    /**
     * Card constructor
     * For wild cards which do not have a color
     * @param name The value of the card 0-9, skip, ... , etc
     * @param precedence The priority of the Card
     */
    public Card(String name, int precedence) {
        this.name = name;
        this.precedence = precedence;
    }
    
    /**
     * Gets the name
     * 
     * @return Returns the name of the card 0-9, skip, ... , etc
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Gets the color
     * 
     * @return Returns the color of the card Green, Red, ...
     */
    public String getColor() {
        return this.color;
    }
    
    /**
     * Gets the Priority
     * 
     * @return Returns the priority of the card
     */
    public int getPrecedence() {
        return this.precedence;
    }
}
