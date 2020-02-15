/*
    Object Orieted Programming, Section 01, Sprint 2020
    Arthur Lee Jones
    Project 1
 */

package projectone;

import java.io.File;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author Arthur
 */

public class ProjectOneMain {
/**
 * 
 * @param args
 * @throws Exception 
 */
  public static void main(String[] args) throws Exception {
    Scanner input = new Scanner(System.in);
    boolean fileExists;
    String fileName;
    File file;
    
    do {
      System.out.print("Enter a file name: ");
      fileName = input.next();
      file = new File(fileName);
      fileExists = file.exists();
      if(!fileExists) System.out.println("File not found. Please try again.");
    } while(!fileExists);

    System.out.println("File found.");
    String htmlAsString = new String(Files.readAllBytes(Paths.get(fileName))); //File location
    String modifiedString = htmlAsString.toLowerCase(); //Convert the string to lowercase.
    ProjectOne objData = new ProjectOne(); //Start a new Class object

    //Remove img tag
    int foundStartingImgTag = htmlAsString.indexOf("<img");
    String wholeImg = "";
    for(int i = 0;;i++) {
      if(foundStartingImgTag < 0) break;
      wholeImg = wholeImg + htmlAsString.charAt(foundStartingImgTag + i);
      if(htmlAsString.charAt(foundStartingImgTag + i) == '>') break;
    }
    modifiedString = modifiedString.replace("<p>"+wholeImg.toLowerCase()+"</p>","");
    htmlAsString = htmlAsString.replace("<p>"+wholeImg+"</p>","");


    //Get title tag
    objData.setTitleTagPosition(0,modifiedString.indexOf("<title>")); //Store the starting title position inside our object
    objData.setTitleTagPosition(1,modifiedString.indexOf("</title>")); //Store the closing title position inside our object
    objData.setTitleTagString(htmlAsString.substring(objData.getTitleTagPosition(0)+7,objData.getTitleTagPosition(1))); //Cut the string so it only contains the text inside the <title> tag and store it inside our object

    //Loop through and get the H1-6 tag positions (if any)
    for(int i = 1; i <= 6; i++) {
      if(modifiedString.indexOf("<h"+i+">") > 0) {
        objData.setHTagsPositions(i-1, 0, modifiedString.indexOf("<h"+i+">")); //Store the <h1-6> opening position inside our object
        objData.setHTagsPositions(i-1, 1, modifiedString.indexOf("</h"+i+">")); //Store the </h1-6> closing position inside our object
        objData.setHTagsStrings(htmlAsString.substring(objData.getHTagsPositions(i-1,0)+4,objData.getHTagsPositions(i-1,1)),i-1); //Set the inner string values of each <h> tag.
      }
    }

    //Get the P tag postions (if there is multiple get those too)
    int foundPOpeningTags = modifiedString.indexOf("<p>"); //Get the index of the opening <p> tag
    int foundPClosingTags = modifiedString.indexOf("</p>"); //Get the index of the closing <p> tag
    int pIndex = 0; //Counter for how many p tags recived.
    //Loop through the found opening tags
    while(foundPOpeningTags >= 0) {
      objData.setPTagPositions(pIndex,0,foundPOpeningTags); //Store the opening tag position inside our object
      objData.setPTagPositions(pIndex,1,foundPClosingTags); //Store the closing tag position insdie our object
      objData.setPTagsStrings(htmlAsString.substring(objData.getPTagsPositions(pIndex,0)+3,objData.getPTagsPositions(pIndex,1)),pIndex); //Store the text inside the p tags inside our object
      foundPOpeningTags = modifiedString.indexOf("<p>", foundPOpeningTags + 1); //Find the next opening tag
      foundPClosingTags = modifiedString.indexOf("</p>", foundPClosingTags + 1); //Find the next closing tag
      pIndex++; //++ to the counter
    }

    //Replace and <br> tags with enters
    for(int i = 0; i < pIndex; i++) {
      String formatedString = objData.getPTagsStrings(i);
      formatedString = formatedString.replace("<br> ", "\n");
      objData.setPTagsStrings(formatedString,i);
    }

    //Get the table data
    int foundTDOpeningTags = modifiedString.indexOf("<td>"); //Get the index of the opening <td> tag
    int foundTDClosingTags = modifiedString.indexOf("</td>"); //Get the index of the closing <td> tag
    int tdIndex = 0; //Counter for how many td tags recived.
    //Loop through the found opening tags
    while(foundTDOpeningTags >= 0) {
      objData.setTDTagsPositions(tdIndex,0,foundTDOpeningTags); //Store the opening tag position inside our object
      objData.setTDTagsPositions(tdIndex,1,foundTDClosingTags); //Store the closing tag position insdie our object
      objData.setTDTagsStrings(htmlAsString.substring(objData.getTDTagsPositions(tdIndex,0)+4,objData.getTDTagsPositions(tdIndex,1)),tdIndex); //Store the text inside the td tags inside our object
      foundTDOpeningTags = modifiedString.indexOf("<td>", foundTDOpeningTags + 1); //Find the next opening tag
      foundTDClosingTags = modifiedString.indexOf("</td>", foundTDClosingTags + 1); //Find the next closing tag
      tdIndex++; //++ to the counter
    }

    //Remove any A tags from the TD tags.
    for(int i = 0; i < tdIndex; i++) {
        String formatedString = objData.getTDTagsStrings(i); //Get the text from the object
        int foundAOpeningTag = formatedString.indexOf(">"); //Find the closing > for the <a element
        int foundAClosingTag = formatedString.indexOf("</a>"); //Find the closing </a>
        //If they both exist remove it and set the new string
        if(foundAOpeningTag > 0 && foundAClosingTag > 0) {
          formatedString = formatedString.substring(foundAOpeningTag+1,foundAClosingTag);
          objData.setTDTagsStrings(formatedString,i);
        }
    }


    //Get the table header
    int foundTableHeaderOpeningTags = modifiedString.indexOf("<th>"); //Get the index of the opening <th> tag
    int foundTableHeaderClosingTags = modifiedString.indexOf("</th>"); //Get the index of the closing <th> tag
    int tHeaderIndex = 0; //Counter for how many th tags recived.
    //Loop through the found opening tags
    while(foundTableHeaderOpeningTags >= 0) {
      objData.setTableHeaderTagsPositions(tHeaderIndex,0,foundTableHeaderOpeningTags); //Store the opening tag position inside our object
      objData.setTableHeaderTagsPositions(tHeaderIndex,1,foundTableHeaderClosingTags); //Store the closing tag position insdie our object
      objData.setTableHeaderTagsStrings(htmlAsString.substring(objData.getTableHeaderTagsPositions(tHeaderIndex,0)+4,objData.getTableHeaderTagsPositions(tHeaderIndex,1)),tHeaderIndex); //Store the text inside the th tags inside our object
      foundTableHeaderOpeningTags = modifiedString.indexOf("<th>", foundTableHeaderOpeningTags + 1); //Find the next opening tag
      foundTableHeaderClosingTags = modifiedString.indexOf("</th>", foundTableHeaderClosingTags + 1); //Find the next closing tag
      tHeaderIndex++; //++ to the counter
    }

    //Print output to a File
    File outFile = new File(objData.getTitleTagString() + ".txt");
    PrintStream output = new PrintStream(outFile);

    //Print H tags
    for(int i = 0; i < 6; i++) {
      if(objData.getHTagsStrings(i) != null) {output.println(objData.getHTagsStrings(i));}
    }

    //Print P tags
    output.println(" ");
    for(int i = 0; i < pIndex; i++) {
        output.println(objData.getPTagsStrings(i));
        output.println("");
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
    System.out.println("Exported the file ("+ objData.getTitleTagString()+".txt) to " + System.getProperty("user.dir"));
  };
}
