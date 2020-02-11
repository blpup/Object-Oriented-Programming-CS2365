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
  }
  public String getTableHeaderTagsStrings(int index) {
    return this.tableHeaderTextList[index];
  }

  //Title tag Position set/getter
  public void setTitleTagPosition(int index, int position) {
    this.titleTagPosition[index] = position;
  };
  public int getTitleTagPosition(int index) {
    return this.titleTagPosition[index];
  };

  //Title tag string set/getter
  public void setTitleTagString(String text) {
    this.titleTagText = text;
  }
  public String getTitleTagString() {
    return this.titleTagText;
  }
};
