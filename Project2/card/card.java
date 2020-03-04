public class Card {

    private int precedence;
    private String color, name;

    /**
     *
     * @param color this is the color of the card
     * @param name
     * @param precedence
     */
    public Card(String color, String name, int precedence) {
        this.color = color;
        this.name = name;
        this.precedence = precedence;
    }

    public Card(String name, int precedence) {
        this.name = name;
        this.precedence = precedence;
    }

    public String getName() {
        return this.name;
    }

    public String getColor() {
        return this.color;
    }

    public int getPrecedence() {
        return this.precedence;
    }
}
