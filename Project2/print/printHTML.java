/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecttwo;

/**
 *
 * @author Arthr
 */
public class printHTML {
    private String innerHTML = "";
    
    private String HTMLStart() {
        return "<!DOCTYPE html>" +
                        "<html lang=\"en\" dir=\"ltr\">" +
                            "<head>" +
                                "<meta charset=\"utf-8\">" +
                                "<title></title>" +
                            "</head>" +
                            "<body style=\"text-align:center; margin:0px; padding:0 10px;\">";
    }
    
    private String HTMLEnd() {
        
        return "</body>" +
                    "</html>";
    }
    
    private String printCard(int number, String color) {
        
        return "<div style=\"width:175px; height:250px; background-color:white; border-radius:10px; margin-left:10px; border:thin solid black; padding:10px; box-sizing:border-box; display:inline-block\">\n" +
                           "      <div style=\"background-color:"+ color +";height:100%;width:100%;border-radius:10px;position: relative;border: thin solid black;\">\n" +
                            "        <span style=\"color:white;font-weight:bold;font-size:25px; position: absolute;left: 10px;top: 3px;\">"+ number +"</span>\n" +
                            "        <div style=\"border-radius:50%;background:white;height: 70%;width:100%;position: absolute;top: 50%;margin-top: -80px; text-align:center\"><span style=\"font-size: 30px;font-weight:bold;text-align:center;vertical-align:middle;line-height: 160px; color:"+ color +"; text-shadow: 1px 1px 1px #000000;\">"+ number +"</span></div>\n" +
                            "        <span style=\"color:white;font-weight:bold;font-size:25px; position: absolute;right: 10px;bottom: 3px;\">"+ number +"</span>\n" +
                            "      </div>\n" +
                  "</div>";
    }
    
    private String printCard(String name, String color) {
        
        return "<div style=\"width:175px; height:250px; background-color:white; border-radius:10px; margin-left:10px; border:thin solid black; padding:10px; box-sizing:border-box; display:inline-block\">\n" +
                           "      <div style=\"background-color:"+ color +";height:100%;width:100%;border-radius:10px;position: relative;border: thin solid black;\">\n" +
                            "        <span style=\"color:white;font-weight:bold;font-size:25px; position: absolute;left: 10px;top: 3px;\">"+ name +"</span>\n" +
                            "        <div style=\"border-radius:50%;background:white;height: 70%;width:100%;position: absolute;top: 50%;margin-top: -80px; text-align:center\"><span style=\"font-size: 30px;font-weight:bold;text-align:center;vertical-align:middle;line-height: 160px; color:"+ color +"; text-shadow: 1px 1px 1px #000000;\">"+ name +"</span></div>\n" +
                            "        <span style=\"color:white;font-weight:bold;font-size:25px; position: absolute;right: 10px;bottom: 3px;\">"+ name +"</span>\n" +
                            "      </div>\n" +
                  "</div>";
    }
    
    private String printHand() {
        String currentHand = "";
         currentHand += "<div style=\" display:inline-block;\">";
         currentHand += this.printRoundNumber();
         currentHand += printCard(4,"blue");
         currentHand += printCard(5,"red");
         currentHand += printCard(7,"green");
         currentHand += printCard(3,"yellow");
         currentHand += printCard(2,"red");
         currentHand += printCard("skip","green");
         currentHand += printCard("Wild","red");
         currentHand += this.printCardsleft();
         currentHand += "</div>";
         return currentHand;
    }
    
    private String printCardsleft() {
        String currentInformation = "";
        currentInformation += "<div style=\"width:100%; border-top:thin solid black; margin-top:25px; padding-top:25px;\">";
        currentInformation += "Cards left in deck: 100";
        currentInformation += "</div>";
        return currentInformation;
    }
    
    private String printFinalInformation() {
        String finalInformation = "";
        finalInformation += "<div style=\" padding: 20px 0;\">";
        finalInformation += "<div style=\" display:inline-block; margin:0 10px;\">The total number of repetitions per exercise: "+ this.printCalculations()+"</div>";
        finalInformation += "<div style=\" display:inline-block; margin:0 10px;\"> The total number of repetitions per exercise that were skipped: "+ this.printCalculations()+"  </div>";
        finalInformation += "<div style=\"  display:inline-block; margin:0 10px;\"> The biggest number of repetitions in a single hand for each exercise: "+ this.printCalculations()+" </div>";
        finalInformation += "</div>";
        return finalInformation;
    }
    
    private String printRoundNumber() {
        String currentRound ="";
        currentRound += "<div style=\"width:100%; font-size:25px; font-weight:bold; text-align:left; margin-bottom:25px;\">";
        currentRound += "Round 1";
        currentRound += "</div>";
        return currentRound;
    }
    private String printCalculations() {
        String currentCalculations = "";
        currentCalculations += "<div style=\" display:block; margin-left:15px; border-left:thin solid black; padding-left:15px; vertical-align:top\">";
        currentCalculations += "<div style=\" background-color:rgb(0,112,192);color:black; font-weight: bold; border-radius: 3px;\"><div style=\" padding: 10px 25px; \">Push Ups</div><div style=\" background-color: white; color: black; border: thin solid black; border-top: none; text-align: center; padding: 10px 0px; \">12</div></div>";
        currentCalculations += "<div style=\" background-color:rgb(255,255,0); color:black; font-weight: bold; border-radius: 3px; margin-top: 10px;\"><div style=\" padding: 10px 25px; \">Squats</div><div style=\" background-color: white; color: black; border: thin solid black; border-top: none; text-align: center; padding: 10px 0px; \">12</div></div>";
        currentCalculations += "<div style=\" background-color:rgb(254,0,0); color:black; font-weight: bold; border-radius: 3px; margin-top: 10px;\"><div style=\" padding: 10px 25px; \">Sit Ups</div><div style=\" background-color: white; color: black; border: thin solid black; border-top: none; text-align: center; padding: 10px 0px; \">12</div></div>";
        currentCalculations += "<div style=\" background-color:rgb(0,176,80); color:black; font-weight: bold; border-radius: 3px; margin-top: 10px;\"><div style=\" padding: 10px 25px; \">Lounges</div><div style=\" background-color: white; color: black; border: thin solid black; border-top: none; text-align: center; padding: 10px 0px; \">12</div></div>";
        currentCalculations += "<div style=\" background-color:rgb(128,0,128); color:black; font-weight: bold; border-radius: 3px; margin-top: 10px;\"><div style=\" padding: 10px 25px; \">Burpees</div><div style=\" background-color: white; color: black; border: thin solid black; border-top: none; text-align: center; padding: 10px 0px; \">12</div></div>";
        currentCalculations += "</div>";
        return currentCalculations;
    }
    
    public void setRow() {
        this.innerHTML += "<section style=\"border-bottom:thin solid black; padding:15px 0; display:flex; align-items:center; justify-content:center;\">";
        this.innerHTML  += this.printHand() + this.printCalculations();
        this.innerHTML += "</section>";
    }
     
    public String buildHTML() {
        return this.HTMLStart() + this.innerHTML  + this.printFinalInformation() + this.HTMLEnd();
    }
}
