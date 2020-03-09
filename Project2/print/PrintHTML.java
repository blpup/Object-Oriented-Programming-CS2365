/*
    Object Orieted Programming, Section 01, Spring 2020
    Arthur Lee Jones
    Project 2
    Team #6
 */
package project2;

import java.util.ArrayList;

/**
 * The view class in the MVC. Will build and print HTML
 *
 * @author Arthur Jones
 */
public class PrintHTML {

    private String innerHTML = "";

    /**
     * Prints the starting HTML information
     *
     * @return Returns the HTML string
     */
    private String HTMLStart() {
        return "<!DOCTYPE html>"
                + "<html lang=\"en\" dir=\"ltr\">"
                + "<head>"
                + "<meta charset=\"utf-8\">"
                + "<title></title>"
                + "</head>"
                + "<body style=\"text-align:center; margin:0px; padding:0 10px;\">";
    }

    /**
     * Prints the ending HTML information
     *
     * @return Returns the HTML string
     */
    private String HTMLEnd() {

        return "</body>"
                + "</html>";
    }

    /**
     * Prints the card
     *
     * @param name The Number or name of the card
     * @param color The color of the card
     * @return Returns the HTML string
     */
    private String printCard(String name, String color) {
        if (color == null) color = "black";
        return "<div style=\"width:175px; height:250px; background-color:white; border-radius:10px; margin-left:10px; border:thin solid black; padding:10px; box-sizing:border-box; display:inline-block\">\n"
                + "      <div style=\"background-color:" + color + ";height:100%;width:100%;border-radius:10px;position: relative;border: thin solid black;\">\n"
                + "        <span style=\"color:white;font-weight:bold;font-size:25px; position: absolute;left: 10px;top: 3px;\">" + name + "</span>\n"
                + "        <div style=\"border-radius:50%;background:white;height: 70%;width:100%;position: absolute;top: 50%;margin-top: -80px; text-align:center\"><span style=\"font-size: 30px;font-weight:bold;text-align:center;vertical-align:middle;line-height: 160px; color:" + color + "; text-shadow: 1px 1px 1px #000000;\">" + name + "</span></div>\n"
                + "        <span style=\"color:white;font-weight:bold;font-size:25px; position: absolute;right: 10px;bottom: 3px;\">" + name + "</span>\n"
                + "      </div>\n"
                + "</div>";
    }

    /**
     * Prints the number of cards left
     *
     * @param cardsLeft The number of cards left in the deck
     * @return Returns the HTML string
     */
    private String printCardsLeft(int cardsLeft) {
        String currentInformation = "";
        currentInformation += "<div style=\"width:100%; border-top:thin solid black; margin-top:25px; padding-top:25px;\">";
        currentInformation += "Cards left in deck: " + cardsLeft + "";
        currentInformation += "</div>";
        return currentInformation;
    }
    
    /**
     * Will print the final information
     * 
     * @param totalReps The final total of all reps combined
     * @param totalSkipped The final total of all skipped cards
     * @param totalSingleHand The final total of all maximum reps per
     * @param totalBurpees The final number of burpees combined
     * @param biggestHandBurpees The largest burpees number in a single hand
     * @return Returns and HTML file
     */
    private String printFinalInformation(int[] totalReps, int[] totalSkipped, int[] totalSingleHand, int totalBurpees, int biggestHandBurpees ) {
        String finalInformation = "";
        finalInformation += "<div style=\" padding: 20px 0;\">";
        finalInformation += "<div style=\" display:inline-block; margin:0 10px;\"><span style=\" display:block; padding-bottom:10px;\">The total number of repetitions per exercise: </span>" + this.printCalculations(totalReps, totalBurpees) + "</div>";
        finalInformation += "<div style=\" display:inline-block; margin:0 10px;\"><span style=\" display:block; padding-bottom:10px;\">The total number of repetitions per exercise that were skipped: </span>" + this.printCalculations(totalSkipped, 0) + "  </div>";
        finalInformation += "<div style=\"  display:inline-block; margin:0 10px;\"><span style=\" display:block; padding-bottom:10px;\">The biggest number of repetitions in a single hand for each exercise: </span>" + this.printCalculations(totalSingleHand, biggestHandBurpees) + " </div>";
        finalInformation += "</div>";
        return finalInformation;
    }

    /**
     * Prints the round number
     *
     * @param round The current round
     * @return Returns the HTML string
     */
    private String printRoundNumber(int round) {
        String currentRound = "";
        currentRound += "<div style=\"width:100%; font-size:25px; font-weight:bold; text-align:left; margin-bottom:25px;\">";
        currentRound += "Round " + round + "";
        currentRound += "</div>";
        return currentRound;
    }
    
    /**
     * Will print the values of that specific hand
     * 
     * @param values The values of reps per round
     * @param roundBurpees The value of burpees per round
     * @return Returns an HTML string
     */
    private String printCalculations(int[] values, int roundBurpees) {
        String currentCalculations = "";
        currentCalculations += "<div style=\" display:block; margin-left:15px; border-left:thin solid black; padding-left:15px; vertical-align:top\">";
        currentCalculations += "<div style=\" background-color:rgb(0,112,192);color:black; font-weight: bold; border-radius: 3px;\"><div style=\" padding: 10px 25px; \">Push Ups</div><div style=\" background-color: white; color: black; border: thin solid black; border-top: none; text-align: center; padding: 10px 0px; \">" + values[1] + "</div></div>";
        currentCalculations += "<div style=\" background-color:rgb(255,255,0); color:black; font-weight: bold; border-radius: 3px; margin-top: 10px;\"><div style=\" padding: 10px 25px; \">Squats</div><div style=\" background-color: white; color: black; border: thin solid black; border-top: none; text-align: center; padding: 10px 0px; \">" + values[3] + "</div></div>";
        currentCalculations += "<div style=\" background-color:rgb(254,0,0); color:black; font-weight: bold; border-radius: 3px; margin-top: 10px;\"><div style=\" padding: 10px 25px; \">Sit Ups</div><div style=\" background-color: white; color: black; border: thin solid black; border-top: none; text-align: center; padding: 10px 0px; \">" + values[0] + "</div></div>";
        currentCalculations += "<div style=\" background-color:rgb(0,176,80); color:black; font-weight: bold; border-radius: 3px; margin-top: 10px;\"><div style=\" padding: 10px 25px; \">Lunges</div><div style=\" background-color: white; color: black; border: thin solid black; border-top: none; text-align: center; padding: 10px 0px; \">" + values[2] + "</div></div>";
        currentCalculations += "<div style=\" background-color:rgb(128,0,128); color:black; font-weight: bold; border-radius: 3px; margin-top: 10px;\"><div style=\" padding: 10px 25px; \">Burpees</div><div style=\" background-color: white; color: black; border: thin solid black; border-top: none; text-align: center; padding: 10px 0px; \">" + roundBurpees + "</div></div>";
        currentCalculations += "</div>";
        return currentCalculations;
    }
    
    /**
     * Will print a single Row of cards 
     * 
     * @param cardsLeft The amount of cards left in the deck
     * @param currentRound The current round the hand is on
     * @param hand An array of cards provided by the hand
     * @return Returns an HTML string
     */
    private String printHand(int cardsLeft, int currentRound, ArrayList hand) {

        String currentHand = "";

        currentHand += "<div style=\" display:inline-block;\">";
        currentHand += this.printRoundNumber(currentRound);
        for (int i = 0; i < hand.size(); i++) {
            Card currCard = (Card) hand.get(i);
            currentHand += printCard(currCard.getName(), currCard.getColor());
        }
        
        currentHand += this.printCardsLeft(cardsLeft);
        currentHand += "</div>";
        return currentHand;
    }
    
    /**
     * Will print the 1 minute break
     * 
     * @return Returns the HTML string of the break 
     */
    private String printBreak() {
        String currentHand = "";
        currentHand += "<div style=\" width:100%; padding:20px 0; background-color:gray; color:white; font-weight:bold;\">";
        currentHand += "1 Minute break";
        currentHand += "</div>";
        return currentHand;
    }
    
    /**
     * Will build the row of each round 
     * 
     * @param cardsLeft The amount of cards left in the deck
     * @param currentRound The current round the hand is on
     * @param hand An array of cards provided by the hand
     * @param values The current round workout values
     * @param roundBurpees The current round burpee value
     */
    public void setRow(int cardsLeft, int currentRound, ArrayList hand, int[] values, int roundBurpees) {
        this.innerHTML += "<section style=\"border-bottom:thin solid black; padding:15px 0; display:flex; align-items:center; justify-content:center;\">";
        this.innerHTML += this.printHand(cardsLeft, currentRound, hand) + this.printCalculations(values, roundBurpees);
        this.innerHTML += "</section>";
        
        boolean alreadyThere = false;
        for (int i = 0; i < hand.size(); i++) {
            Card currCard = (Card) hand.get(i);
            if ("0".equals(currCard.getName()) && !alreadyThere) {
                alreadyThere = true;
                this.innerHTML += this.printBreak();
            }
        }
    }

    /**
     * Will build a HTML file
     * 
     * @param totalReps The final total number of reps
     * @param totalSkipped The final total number of skipped cards
     * @param totalSingleHand The final total of maximum numbers in a single hand
     * @param totalBurpees The final total number of burpees 
     * @param biggestHandBurpees The largest number of burpees in a single hand
     * @return Returns a complete HTMl file
     */
    public String buildHTML(int[] totalReps, int[] totalSkipped, int[] totalSingleHand, int totalBurpees, int biggestHandBurpees) {
        return this.HTMLStart() + this.innerHTML + this.printFinalInformation(totalReps, totalSkipped, totalSingleHand, totalBurpees, biggestHandBurpees) + this.HTMLEnd();
    }
}
