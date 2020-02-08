/*
    Object Orieted Programming, Section 01, Sprint 2020
    Arthur Lee Jones
    Project 1
 */

package projectone;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.PrintStream;
import java.util.Scanner;
/**
 *
 * @author Arthur
 */
public class ProjectOne {
  private int[][] headerTagPositions = new int[6][2];
  private int[][] paragraphTagPositions = new int[100][2];
  private int[][] tableDataTagPositions = new int[100][2];
  private int[][] tableHeaderTagPositions = new int[100][2];
  private String[] headerTextList = new String[6];
  private String[] paragraphTextList = new String[100];
  private String[] tableDataTextList = new String[100];
  private String[] tableHeaderTextList = new String[100];
  //Header tag Position set/getter
  public void setHTagsPositions(int tagNumber, int index, int position){
    this.headerTagPositions[tagNumber][index] = position;
  };
  public int getHTagsPositions(int tagNumber, int index) {
    return headerTagPositions[tagNumber][index];
  };

  //Header tag strings set/getter
  public void setHTagsStrings(String text, int index) {
    this.headerTextList[index] = text;
  }
  public String getHTagsStrings(int index) {
    return this.headerTextList[index];
  }


  //Paragraph tag Positions set/getter
  public void setPTagPositions(int index, int whichBracket, int position) {
    this.paragraphTagPositions[index][whichBracket] = position;
  };
  public int getPTagsPositions(int tagNumber, int index) {
    return this.paragraphTagPositions[tagNumber][index];
  };

  //Paragraph tag strings set/getter
  public void setPTagsStrings(String text, int index) {
    this.paragraphTextList[index] = text;
  }
  public String getPTagsStrings(int index) {
    return this.paragraphTextList[index];
  }

  //Table Data tag Position set/getter
  public void setTDTagsPositions(int tagNumber, int index, int position){
    this.tableDataTagPositions[tagNumber][index] = position;

  };
  public int getTDTagsPositions(int tagNumber, int index) {
    return tableDataTagPositions[tagNumber][index];
  };

  //Table Data tag strings set/getter
  public void setTDTagsStrings(String text, int index) {
    this.tableDataTextList[index] = text;
    //System.out.println("Contents (Java 7)as : " + this.tableDataTextList[index]);
  }
  public String getTDTagsStrings(int index) {
    return this.tableDataTextList[index];
  }


  //Table Header tag Position set/getter
  public void setTableHeaderTagsPositions(int tagNumber, int index, int position){
    this.tableHeaderTagPositions[tagNumber][index] = position;

  };
  public int getTableHeaderTagsPositions(int tagNumber, int index) {
    return tableHeaderTagPositions[tagNumber][index];
  };

  //Table Header tag strings set/getter
  public void setTableHeaderTagsStrings(String text, int index) {
    this.tableHeaderTextList[index] = text;
    System.out.println("Contents (Java 7)as : " + this.tableHeaderTextList[index]);
  }
  public String getTableHeaderTagsStrings(int index) {
    return this.tableHeaderTextList[index];
  }

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
  };
};
