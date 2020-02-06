/*
    Object Orieted Programming, Section 01, Sprint 2020
    Arthur Lee Jones
    Project 1
 */

package projectone;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.io.PrintStream;
import java.util.Scanner;
/**
 *
 * @author Arthur
 */
public class ProjectOne {
  private int[][] hTagsPositions = new int[6][2];
  private int[][] pTagsPositions = new int[100][2];
  private String[] innerHText = new String[6];
  private String[] innerPText = new String[100];
  private int[][] tdTagsPositions = new int[100][2];

  public void setHTagsPositions(int tagNumber, int index, int position){
    this.hTagsPositions[tagNumber][index] = position;
  };
  public int getHTagsPositions(int tagNumber, int index) {
    return hTagsPositions[tagNumber][index];
  };

  public void setHTagsStrings(String text, int index) {
    this.innerHText[index] = text;
  }
  public String getHTagsStrings(int index) {
    return this.innerHText[index];
  }

  public void setPTagsStrings(String text, int index) {
    this.innerPText[index] = text;
  }
  public String getPTagsStrings(int index) {
    return this.innerPText[index];
  }

  public void setPTagPositions(int index, int whichBracket, int position) {
    this.pTagsPositions[index][whichBracket] = position;
  };
  public int getPTagsPositions(int tagNumber, int index) {
    return this.pTagsPositions[tagNumber][index];
  };

  public void setHTagsPositions(int tagNumber, int index, int position){
    this.hTagsPositions[tagNumber][index] = position;
  };
  public int getHTagsPositions(int tagNumber, int index) {
    return hTagsPositions[tagNumber][index];
  };
  

  public static void main(String[] args) throws Exception {
    String htmlAsString = new String(Files.readAllBytes(Paths.get("C:\\Users\\Arthr\\Documents\\NetBeansProjects\\ProjectOne\\customers.html")));
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
    };

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


    //Print output to a File
    File outFile = new File("output.txt");
    PrintStream output = new PrintStream(outFile);
    for(int i = 0; i < 6; i++) {
      if(objData.getHTagsStrings(i) != null) {output.println(objData.getHTagsStrings(i));}
    }
    output.println(" ");
    for(int i = 0; i < pIndex; i++) {
        output.println(objData.getPTagsStrings(i));
    }
  };
};
