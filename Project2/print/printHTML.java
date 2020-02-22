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
                            "<body style=\"text-align:center; margin:0px;\">";
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
         currentHand += printCard(4,"blue");
         currentHand += printCard(5,"red");
         currentHand += printCard(7,"green");
         currentHand += printCard("Wild","red");
         currentHand += "</div>";
         return currentHand;
    }
    
    private String printCalculations() {
        String currentCalculations = "";
        currentCalculations += "<div style=\" display:inline-block; margin-left:15px; border-left:thin solid black; padding-left:15px; margin-top:15px;\">";
        currentCalculations += "<div style=\" background-color:rgb(0,112,192);color:black; font-weight: bold; border-radius: 3px;\"><div style=\" padding: 10px 25px; \">Push Ups</div><div style=\" background-color: white; color: black; border: thin solid black; border-top: none; text-align: center; padding: 10px 0px; \">12</div></div>";
        currentCalculations += "<div style=\" background-color:rgb(255,255,0); color:black; font-weight: bold; border-radius: 3px; margin-top: 10px;\"><div style=\" padding: 10px 25px; \">Push Ups</div><div style=\" background-color: white; color: black; border: thin solid black; border-top: none; text-align: center; padding: 10px 0px; \">12</div></div>";
        currentCalculations += "<div style=\" background-color:rgb(254,0,0); color:black; font-weight: bold; border-radius: 3px; margin-top: 10px;\"><div style=\" padding: 10px 25px; \">Push Ups</div><div style=\" background-color: white; color: black; border: thin solid black; border-top: none; text-align: center; padding: 10px 0px; \">12</div></div>";
        currentCalculations += "<div style=\" background-color:rgb(0,176,80); color:black; font-weight: bold; border-radius: 3px; margin-top: 10px;\"><div style=\" padding: 10px 25px; \">Push Ups</div><div style=\" background-color: white; color: black; border: thin solid black; border-top: none; text-align: center; padding: 10px 0px; \">12</div></div>";
        currentCalculations += "</div>";
        return currentCalculations;
    }
    
    public void setRow() {
        this.innerHTML += "<section style=\"border-bottom:thin solid black; padding-bottom:15px; margin-bottom:15px;\">";
        this.innerHTML  += this.printHand() + this.printCalculations();
        this.innerHTML += "</section>";
    }
     
    public String buildHTML() {
        return this.HTMLStart() + this.innerHTML + this.HTMLEnd();
    }
}
