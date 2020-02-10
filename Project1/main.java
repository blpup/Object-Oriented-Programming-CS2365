/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectone;

import java.io.File;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author Arthr
 */
public class ProjectOneMain {

  public static void main(String[] args) throws Exception {

    String htmlAsString = new String(Files.readAllBytes(Paths.get("C:\\Users\\Arthr\\Documents\\NetBeansProjects\\ProjectOne\\SecondExampleTable.html")));
    String modifiedString = htmlAsString.toLowerCase();
    ProjectOne objData;
    objData = new ProjectOne();

    //Get the H1-6 tag positions (if any)
    for(int i = 1; i <= 6; i++) {
      if(modifiedString.indexOf("<h"+i+">") > 0) {
        objData.setHTagsPositions(i-1, 0, modifiedString.indexOf("<h"+i+">"));
        objData.setHTagsPositions(i-1, 1, modifiedString.indexOf("</h"+i+">"));
        objData.setHTagsStrings(htmlAsString.substring(objData.getHTagsPositions(i-1,0)+4,objData.getHTagsPositions(i-1,1)),i-1);
      }
    }

    //Get the P tag postions (if there is multiple get those too)
    int foundPOpeningTags = modifiedString.indexOf("<p>");
    int foundPClosingTags = modifiedString.indexOf("</p>");
    int pIndex = 0;
    while(foundPOpeningTags >= 0) {
      objData.setPTagPositions(pIndex,0,foundPOpeningTags);
      objData.setPTagPositions(pIndex,1,foundPClosingTags);
      //System.out.println("Contents (Java 7)as : " + foundPOpeningTags + " " +  foundPClosingTags);
      objData.setPTagsStrings(htmlAsString.substring(objData.getPTagsPositions(pIndex,0)+3,objData.getPTagsPositions(pIndex,1)),pIndex);
      foundPOpeningTags = modifiedString.indexOf("<p>", foundPOpeningTags + 1);
      foundPClosingTags = modifiedString.indexOf("</p>", foundPClosingTags + 1);
      pIndex++;
    }


    //Get the table data
    int foundTDOpeningTags = modifiedString.indexOf("<td>");
    int foundTDClosingTags = modifiedString.indexOf("</td>");
    int tdIndex = 0;
    while(foundTDOpeningTags >= 0) {
      objData.setTDTagsPositions(tdIndex,0,foundTDOpeningTags);
      objData.setTDTagsPositions(tdIndex,1,foundTDClosingTags);
      objData.setTDTagsStrings(htmlAsString.substring(objData.getTDTagsPositions(tdIndex,0)+4,objData.getTDTagsPositions(tdIndex,1)),tdIndex);
      foundTDOpeningTags = modifiedString.indexOf("<td>", foundTDOpeningTags + 1);
      foundTDClosingTags = modifiedString.indexOf("</td>", foundTDClosingTags + 1);
      tdIndex++;
    }

    //Remove any A tags from the TD tags.
    for(int i = 0; i < tdIndex; i++) {
        String formatedString = objData.getTDTagsStrings(i);
        int foundAOpeningTag = formatedString.indexOf(">");
        int foundAClosingTag = formatedString.indexOf("</a>");
        if(foundAOpeningTag > 0 || foundAClosingTag > 0) {
          formatedString = formatedString.substring(0,foundAOpeningTag-1);
          formatedString = formatedString.substring(foundAClosingTag,formatedString.length());
          objData.setTDTagsStrings(formatedString,i);
        }
        System.out.println("Contents (Java 7)as : " + formatedString);

    }


    //Get the table header
    int foundTableHeaderOpeningTags = modifiedString.indexOf("<th>");
    int foundTableHeaderClosingTags = modifiedString.indexOf("</th>");
    int tHeaderIndex = 0;
    while(foundTableHeaderOpeningTags >= 0) {
      objData.setTableHeaderTagsPositions(tHeaderIndex,0,foundTableHeaderOpeningTags);
      objData.setTableHeaderTagsPositions(tHeaderIndex,1,foundTableHeaderClosingTags);
      objData.setTableHeaderTagsStrings(htmlAsString.substring(objData.getTableHeaderTagsPositions(tHeaderIndex,0)+4,objData.getTableHeaderTagsPositions(tHeaderIndex,1)),tHeaderIndex);
      foundTableHeaderOpeningTags = modifiedString.indexOf("<th>", foundTableHeaderOpeningTags + 1);
      foundTableHeaderClosingTags = modifiedString.indexOf("</th>", foundTableHeaderClosingTags + 1);
      tHeaderIndex++;
    }

    //Print output to a File
    File outFile = new File("output.txt");
    PrintStream output = new PrintStream(outFile);

    //Print H tags
    for(int i = 0; i < 6; i++) {
      if(objData.getHTagsStrings(i) != null) {output.println(objData.getHTagsStrings(i));}
    }

    //Print P tags
    output.println(" ");
    for(int i = 0; i < pIndex; i++) {
        output.println(objData.getPTagsStrings(i));
    }

    //Print table header tags
    for(int i = 0; i < tHeaderIndex; i++) {
      output.print(objData.getTableHeaderTagsStrings(i));
      if(i < tHeaderIndex) output.print(", ");
    }

    //print table data tags
    for(int i = 0; i < tdIndex; i++) {
      if((i % tHeaderIndex) == 0) output.println("");
      output.print(objData.getTDTagsStrings(i));
      if(i < tdIndex) output.print(", ");
    }

  };
}
