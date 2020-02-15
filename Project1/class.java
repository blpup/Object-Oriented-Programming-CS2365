/*
    Object Orieted Programming, Section 01, Sprint 2020
    Arthur Lee Jones
    Project 1
 */

package projectone;

/**
 *
 * @author Arthur
 */
public class ProjectOne {
  private int[][] headerTagPositions = new int[6][2];
  private int[][] paragraphTagPositions = new int[100][2];
  private int[][] tableDataTagPositions = new int[100][2];
  private int[][] tableHeaderTagPositions = new int[100][2];
  private int[] titleTagPosition = new int[2];
  private String[] headerTextList = new String[6];
  private String[] paragraphTextList = new String[100];
  private String[] tableDataTextList = new String[100];
  private String[] tableHeaderTextList = new String[100];
  private String titleTagText;
  
  /**
   * H tag position setter
   * @param index The count of the h bracket (will go up for each h tag)
   * @param whichBracket If it is a starting h bracket or and ending h bracket
   * @param position The indexOf of the given h brackets
   */
  //Header tag Position set/getter
  public void setHTagsPositions(int index, int whichBracket, int position){
    this.headerTagPositions[index][whichBracket] = position;
  };
  
  /**
   * H tag position getter
   * @param index The count the of the h bracket (will go up for each h tag)
   * @param whichBracket If it is a H starting bracket or a H ending bracket
   * @return Returns the indexOf of the bracket
   */
  public int getHTagsPositions(int index, int whichBracket) {
    return headerTagPositions[index][whichBracket];
  };

  /**
   * H tag string setter
   * @param text The string of the header tag
   * @param index The h tag index number
   */
  //Header tag strings set/getter
  public void setHTagsStrings(String text, int index) {
    this.headerTextList[index] = text;
  }
  
  /**
   * H tag string getter
   * @param index The h tag index number
   * @return Returns the string of the h  tag
   */
  public String getHTagsStrings(int index) {
    return this.headerTextList[index];
  }
  
  /**
   * Paragraph tag position setter
   * @param index The count the p bracket (will go up for each p tag)
   * @param whichBracket If it is a p starting bracket or p ending bracket
   * @param position The indexOf position of the tag
   */
  public void setPTagPositions(int index, int whichBracket, int position) {
    this.paragraphTagPositions[index][whichBracket] = position;
  };
  
  /**
   * Paragraph tag position getter
   * @param index The location of the bracket
   * @param whichBracket If it is a starting p tag or ending p bracket
   * @return Returns the indexOf of that bracket
   */
  public int getPTagsPositions(int index, int whichBracket) {
    return this.paragraphTagPositions[index][whichBracket];
  };
  
  /**
   * Paragraph string setter
   * @param text The string of the paragraph
   * @param index The paragraph index number
   */
  public void setPTagsStrings(String text, int index) {
    this.paragraphTextList[index] = text;
  }
  
  /**
   * Paragraph string getter
   * @param index The P index number
   * @return Returns the string of the paragraph at that index
   */
  public String getPTagsStrings(int index) {
    return this.paragraphTextList[index];
  }
  
  /**
   * Table Data tag position setter
   * @param index The count of the TD bracket (will go up for each TD tag)
   * @param whichBracket If it is a TD starting bracket or a TD ending bracket
   * @param position The indexOf position of the tag
   */
  public void setTDTagsPositions(int index, int whichBracket, int position){
    this.tableDataTagPositions[index][whichBracket] = position;
  };
  
  /**
   * Table Data tag position getter
   * @param index The count of the TD bracket 
   * @param whichBracket If it is a TD starting bracket or a TD ending bracket
   * @return Returns the TD tag indexOf position
   */
  public int getTDTagsPositions(int index, int whichBracket) {
    return tableDataTagPositions[index][whichBracket];
  };
  
  /**
   * Table Data string setter
   * @param text The text of the inner TD bracket
   * @param index The TD index number
   */
  public void setTDTagsStrings(String text, int index) {
    this.tableDataTextList[index] = text;
  }
  
  /**
   * Table Data string getter
   * @param index The TD index number
   * @return Returns the string of the TD at that index
   */
  public String getTDTagsStrings(int index) {
    return this.tableDataTextList[index];
  }
  
  /**
   * Table Header tag position setter
   * @param index The count of the TH bracket (will go up for each TH tag)
   * @param whichBracket If it is a TH starting bracket or a TH ending bracket
   * @param position The indexOf position of the tag
   */
  public void setTableHeaderTagsPositions(int index, int whichBracket, int position){
    this.tableHeaderTagPositions[index][whichBracket] = position;
  };
  
  /**
   * Table Header tag position getter
   * @param index The count of the TH bracket
   * @param whichBracket If it is a TH starting bracket or a TH ending bracket
   * @return Returns the TH tag indexOf position
   */
  public int getTableHeaderTagsPositions(int index, int whichBracket) {
    return tableHeaderTagPositions[index][whichBracket];
  };

  /**
   * Table Header string setter
   * @param text The text of the inner TH bracket
   * @param index The TH index number
   */
  public void setTableHeaderTagsStrings(String text, int index) {
    this.tableHeaderTextList[index] = text;
  }
  
  /**
   * Table Header string getter
   * @param index The TH index number
   * @return Returns the string of the TD at that index
   */
  public String getTableHeaderTagsStrings(int index) {
    return this.tableHeaderTextList[index];
  }
  
  /**
   * Title tag position setter
   * @param whichBracket If it is a title starting bracket or a title ending bracket 
   * @param position The indexOf position of the tag
   */
  public void setTitleTagPosition(int whichBracket, int position) {
    this.titleTagPosition[whichBracket] = position;
  };
  
  /**
   * Title tag position getter
   * @param index The title index number
   * @return Returns the position of the title
   */
  public int getTitleTagPosition(int index) {
    return this.titleTagPosition[index];
  };

  /**
   * Title tag text setter
   * @param text The text of the inner title bracket
   */
  public void setTitleTagString(String text) {
    this.titleTagText = text;
  }
  
  /**
   * Title tag text getter
   * @return Returns the string of the title 
   */
  public String getTitleTagString() {
    return this.titleTagText;
  }
};
