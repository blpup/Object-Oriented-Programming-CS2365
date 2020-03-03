/*
    Object Orieted Programming, Section 01, Spring 2020
    Arthur Lee Jones
    Project 2
    Team #6
 */
package projecttwo;

/**
 * The view class in the MVP. Will build and print HTML
 * @author Arthur Jones
 */
public class printHTML {
    private String innerHTML = "";
    
    /**
     * Prints the starting HTML information
     * @return Returns the HTML string
     */
    private String HTMLStart() {
        return "<!DOCTYPE html>" +
                        "<html lang=\"en\" dir=\"ltr\">" +
                            "<head>" +
                                "<meta charset=\"utf-8\">" +
                                "<title></title>" +
                            "</head>" +
                            "<body style=\"text-align:center; margin:0px; padding:0 10px;\">";
    }
    
    /**
     * Prints the ending HTML information
     * @return Returns the HTML string
     */
    private String HTMLEnd() {
        
        return "</body>" +
                    "</html>";
    }
    /**
     * Prints the card
     * @param name The Number or name of the card
     * @param color The color of the card
     * @return Returns the HTML string
     */
    private String printCard(String name, String color) {
        
        return "<div style=\"width:175px; height:250px; background-color:white; border-radius:10px; margin-left:10px; border:thin solid black; padding:10px; box-sizing:border-box; display:inline-block\">\n" +
                           "      <div style=\"background-color:"+ color +";height:100%;width:100%;border-radius:10px;position: relative;border: thin solid black;\">\n" +
                            "        <span style=\"color:white;font-weight:bold;font-size:25px; position: absolute;left: 10px;top: 3px;\">"+ name +"</span>\n" +
                            "        <div style=\"border-radius:50%;background:white;height: 70%;width:100%;position: absolute;top: 50%;margin-top: -80px; text-align:center\"><span style=\"font-size: 30px;font-weight:bold;text-align:center;vertical-align:middle;line-height: 160px; color:"+ color +"; text-shadow: 1px 1px 1px #000000;\">"+ name +"</span></div>\n" +
                            "        <span style=\"color:white;font-weight:bold;font-size:25px; position: absolute;right: 10px;bottom: 3px;\">"+ name +"</span>\n" +
                            "      </div>\n" +
                  "</div>";
    }
    

    
    /**
     * Prints the number of cards left
     * @param cardsLeft The number of cards left in the deck
     * @return Returns the HTML string
     */
    private String printCardsleft(int cardsLeft) {
        String currentInformation = "";
        currentInformation += "<div style=\"width:100%; border-top:thin solid black; margin-top:25px; padding-top:25px;\">";
        currentInformation += "Cards left in deck: "+cardsLeft+"";
        currentInformation += "</div>";
        return currentInformation;
    }
    
    /**
     * Will print the final information
     * @param totalReps The final total of all reps combined
     * @param totalSkipped The final total of all skipped cards
     * @param totalSingleHand The final total of all maximum reps per 
     * @return Returns the HTML string
     */
    private String printFinalInformation(int[] totalReps, int[] totalSkipped, int[]totalSingleHand) {
        String finalInformation = "";
        finalInformation += "<div style=\" padding: 20px 0;\">";
        finalInformation += "<div style=\" display:inline-block; margin:0 10px;\"><span style=\" display:block; padding-bottom:10px;\">The total number of repetitions per exercise: </span>"+ this.printCalculations(totalReps)+"</div>";
        finalInformation += "<div style=\" display:inline-block; margin:0 10px;\"><span style=\" display:block; padding-bottom:10px;\">The total number of repetitions per exercise that were skipped: </span>"+ this.printCalculations(totalSkipped)+"  </div>";
        finalInformation += "<div style=\"  display:inline-block; margin:0 10px;\"><span style=\" display:block; padding-bottom:10px;\">The biggest number of repetitions in a single hand for each exercise: </span>"+ this.printCalculations(totalSingleHand)+" </div>";
        finalInformation += "</div>";
        return finalInformation;
    }
    
    /**
     * Prints the round number
     * @param round The current round
     * @return Returns the HTML string
     */
    private String printRoundNumber(int round) {
        String currentRound ="";
        currentRound += "<div style=\"width:100%; font-size:25px; font-weight:bold; text-align:left; margin-bottom:25px;\">";
        currentRound += "Round "+round+"";
        currentRound += "</div>";
        return currentRound;
    }
    
    /**
     * Will print the calculations
     * @param values The values of the reps
     * @return Returns the HTML string
     */
    private String printCalculations(int[] values) {
        String currentCalculations = "";
        currentCalculations += "<div style=\" display:block; margin-left:15px; border-left:thin solid black; padding-left:15px; vertical-align:top\">";
        currentCalculations += "<div style=\" background-color:rgb(0,112,192);color:black; font-weight: bold; border-radius: 3px;\"><div style=\" padding: 10px 25px; \">Push Ups</div><div style=\" background-color: white; color: black; border: thin solid black; border-top: none; text-align: center; padding: 10px 0px; \">"+values[0]+"</div></div>";
        currentCalculations += "<div style=\" background-color:rgb(255,255,0); color:black; font-weight: bold; border-radius: 3px; margin-top: 10px;\"><div style=\" padding: 10px 25px; \">Squats</div><div style=\" background-color: white; color: black; border: thin solid black; border-top: none; text-align: center; padding: 10px 0px; \">"+values[1]+"</div></div>";
        currentCalculations += "<div style=\" background-color:rgb(254,0,0); color:black; font-weight: bold; border-radius: 3px; margin-top: 10px;\"><div style=\" padding: 10px 25px; \">Sit Ups</div><div style=\" background-color: white; color: black; border: thin solid black; border-top: none; text-align: center; padding: 10px 0px; \">"+values[2]+"</div></div>";
        currentCalculations += "<div style=\" background-color:rgb(0,176,80); color:black; font-weight: bold; border-radius: 3px; margin-top: 10px;\"><div style=\" padding: 10px 25px; \">Lounges</div><div style=\" background-color: white; color: black; border: thin solid black; border-top: none; text-align: center; padding: 10px 0px; \">"+values[3]+"</div></div>";
        currentCalculations += "<div style=\" background-color:rgb(128,0,128); color:black; font-weight: bold; border-radius: 3px; margin-top: 10px;\"><div style=\" padding: 10px 25px; \">Burpees</div><div style=\" background-color: white; color: black; border: thin solid black; border-top: none; text-align: center; padding: 10px 0px; \">"+values[4]+"</div></div>";
        currentCalculations += "</div>";
        return currentCalculations;
    }
  
    private String printHand() {
        String currentHand = "";
         currentHand += "<div style=\" display:inline-block;\">";
         currentHand += this.printRoundNumber(2);
         currentHand += printCard("Wild 4","black");
         currentHand += printCard("5","red");
         currentHand += printCard("6","green");
         currentHand += printCard("3","yellow");
         currentHand += printCard("2","red");
         currentHand += printCard("skip","green");
         currentHand += printCard("Wild","red");
         currentHand += this.printCardsleft(50);
         currentHand += "</div>";
         return currentHand;
    }
    
    public void setRow(int[] values) {
        this.innerHTML += "<section style=\"border-bottom:thin solid black; padding:15px 0; display:flex; align-items:center; justify-content:center;\">";
        this.innerHTML  += this.printHand() + this.printCalculations(values);
        this.innerHTML += "</section>";
    }
     
    /**
     * Will build the HTML
     * @param totalReps The final total of all reps combined
     * @param totalSkipped The final total of all skipped cards
     * @param totalSinglehand The final total of all maximum reps per 
     * @return Returns the HTML string
     */
    public String buildHTML(int[] totalReps, int[] totalSkipped, int[] totalSinglehand) {
        return this.HTMLStart() + this.innerHTML  + this.printFinalInformation(totalReps, totalSkipped, totalSinglehand) + this.HTMLEnd();
    }
}
