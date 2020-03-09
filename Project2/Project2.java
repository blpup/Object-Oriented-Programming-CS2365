/*
    Object Orieted Programming, Section 01, Spring 2020
    Anna Bartley
    Project 2
    Team #6
 */

package project2;
import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Project2 {
    
    /**
     * The Main function 
     * @param args Main arguments
     */
    public static void main(String[] args) {
        int deckNumber = 0;       //determines the number of decks that the user wants
        boolean shuffler = true;  //true is shuffled independently, false is shuffled all together
        boolean isAction = false; //true is there are action cards, false is no action cards
        
        System.out.println("Welcome to Workout Uno! Are You Ready to Get in Shape?");  //start game
        System.out.println("1. Start Game");
        System.out.println("2. Exit");
        
        int notIntMain = 0, userInputMain = 0, newInputMain = 0; //these variable detect whether the input from the keyboard is the correct type (int)
        while (notIntMain == 0)
        {
            Scanner scanMain = new Scanner(System.in); 
            try {
                newInputMain = scanMain.nextInt();   //gets user input
                userInputMain = newInputMain;        //different types can't be compared
                if (userInputMain != newInputMain)   //if the types are incompatible, loop it again
                {
                    notIntMain = 0;  
                }
                if (userInputMain == newInputMain)  //if the types are compatible, exit loop
                {
                    notIntMain = 1; 
                }
            }
                catch(InputMismatchException e){}
                
        if ((userInputMain < 1) || (userInputMain > 2))  //then, if the input is an int, it detects if it is in the proper range [1,2]
            {
                notIntMain = 0;
                System.out.println("Invalid Input, Please Try Again"); 
            }
        }
        
        switch(userInputMain)
        {
            case 1:
                System.out.println("Gainz incoming");  //user has selected to start the game
                break;
            case 2:
                System.out.println("Thanks for Playing");  //user has selected to exit the program
                return;
            default:
                System.out.println("Error Detected");  //error detection case
                break;
                
        }  
        
	//if the game is started, the user is asked how many decks they would like to play with 
        int notIntDecks = 0, userInputDecks = 0, newInputDecks = 0;
        int holder = 1; //temp variable used in the while loop
        System.out.println("How many decks do you want: 1, 2, or 3?"); //same principle as above
        while (notIntDecks == 0)
        {
            Scanner scan = new Scanner(System.in);
            try {
                newInputDecks = scan.nextInt();
                userInputDecks = newInputDecks;
                if (userInputDecks != newInputDecks)
               	{
                    notIntDecks = 0;
                }
                if (userInputDecks == newInputDecks)
                {
                    notIntDecks = 1;
                }
                }
                catch(InputMismatchException e){}  
            if ((userInputDecks < 1) || (userInputDecks > 3))
                {
                    notIntDecks = 0;
                    System.out.println("Invalid Input, Please Try Again");
                }
        }
        while (holder == 1)
        {
                switch(userInputDecks)
            { 
                case 1:
                    System.out.println("One Deck Selected"); 
                    deckNumber = 1;   //one deck selected
                    shuffler = true;  //if one deck is selected, shuffler is automatically updated to be "independently shuffled"
                    holder = 0;       //exits while loop
                    break;
                case 2:
                    System.out.println("Two Decks Selected");  //if more than one deck is selected, then the user has the option to shuffle the decks together or shuffle them apart
                    System.out.println("Would you like to shuffle the decks independently (1) or together (2)?");
                    deckNumber = 2;
                    int newInput2 = 0, userInput2 = 0, notInt2 = 0; 
                    while (notInt2 == 0)
                    {
                   
                    try {
                        Scanner shuffleScan = new Scanner(System.in);
                        newInput2 = shuffleScan.nextInt();
                        userInput2 = newInput2;
                        if (userInput2 != newInput2)
                        {
                            notInt2 = 0;
                        }
                        if (userInput2 == newInput2)
                        {
                            notInt2 = 1;
                        }
                        }
                        catch(InputMismatchException e){
                                }  
                        if ((userInput2 < 1) || (userInput2 > 3))
                            {
                                notInt2 = 0;
                                System.out.println("Invalid Input, Please Try Again");
                            }
                       
                    }
                    if (userInput2 == 1)
                    {
                        System.out.println("Decks will be shuffled Independently\n");
                        shuffler = true; //independently 
                    }
                    else if (userInput2 == 2)
                    {
                        System.out.println("Decks will be shuffled Together \n");
                        shuffler = false;
                    }
                    
                    holder = 0; //exit loop
                    break;
                case 3:
                    System.out.println("Three Decks Selected - Impressive!");
                    System.out.println("Would you like to shuffle the decks independently (1) or together (2)?");
                    deckNumber = 3;
                    int newInput3 = 0, userInput3 = 0, notInt3 = 0; 
                    while (notInt3 == 0)
                    {
                   
                    try {
                        Scanner shuffleScan = new Scanner(System.in);
                        newInput3 = shuffleScan.nextInt();
                        userInput3 = newInput3;
                        if (userInput3 != newInput3)
                        {
                            notInt3 = 0;
                        }
                        if (userInput3 == newInput3)
                        {
                            notInt3 = 1;
                        }
                        }
                        catch(InputMismatchException e){}
                    
                        if ((userInput3 < 1) || (userInput3 > 3)) 
                            {
                                notInt3 = 0;
                                System.out.println("Invalid Input, Please Try Again");
                            }
                       
                    }
                    if (userInput3 == 1)
                    {
                        System.out.println("Decks will be shuffled Independently");
                        shuffler = true; //independently 
                    }
                    else if (userInput3 == 2)
                    {
                        System.out.println("Decks will be shuffled Together");
                        shuffler = false;
                    }
                    
                    holder = 0;
                    break;
                default:
                    System.out.println("that's not it, chief");
                    holder = 0;
                    break;
                    
            }  
        }
        
        System.out.println("Would you like Action Cards?"); //same principle
        System.out.println("1 - Yes");
        System.out.println("2 - No");
        int notInt = 0, userInput = 0, newInput = 0;
        while (notInt == 0)
        {
            Scanner scan = new Scanner(System.in);
            try {
                newInput = scan.nextInt();
                userInput = newInput;
                if (userInput != newInput)
                {
                    notInt = 0;
                }
                if (userInput == newInput)
                {
                    notInt = 1;
                }
            }
                catch(InputMismatchException e){ }
                
        if ((userInput < 1) || (userInput > 2))
            {
                notInt = 0;
                System.out.println("Invalid Input, Please Try Again");
            }
        }
        
        switch(userInput)
        {
            case 1:
                System.out.println("Action Cards Primed");
                isAction = true;
                break;
            case 2:
                System.out.println("Deck(s) Without Action Cards");
                break;
            default:
                System.out.println("");
                break;    
        }

        /////////////////////////////////////////////////////////////////////////////////
        
        Deck deck = new Deck(isAction, deckNumber, shuffler); //incorporates other classes
        Hand hand = new Hand(deck.getDeck());
        PrintHTML html = new PrintHTML();
        int currentRound = 1; 
        while (hand.getCardsLeft() > 0)
        {
            hand.drawHand();
            ArrayList curHand = hand.getCurHand();
            hand.processHand();
            html.setRow(hand.getCardsLeft(), currentRound, curHand , hand.getExercisesThisRound(), hand.getRoundBurpees());
            currentRound++;
        }
        
        try 
        {
            File outFile = new File("uno.html");
            PrintStream output = new PrintStream(outFile);
            output.print(html.buildHTML(hand.getTotalExercises(), hand.getTotalExercisesSkipped(), hand.getBiggestExercises(), hand.getTotalBurpees(), hand.getLargestBurpeeInHand() ));
            output.close();
            System.out.println("we made it");
        } catch (FileNotFoundException e) {}

        System.out.println("Are there Action Cards? " + isAction + ". How many decks? " + deckNumber + ". How/are they shuffled? " + shuffler);
        System.out.println("Exported the file(uno.html) to " + System.getProperty("user.dir"));
        
        
        /**
         * Uncomment the code below to run user input tests.
         * 
         * Test test = new Test();
         * test.runTests();
        **/
    }
}
