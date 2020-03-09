/*
    Object Orieted Programming, Section 01, Spring 2020
    Arthur Lee Jones
    Project 2
    Team #6
 */
package project2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The Test Class
 * 
 * @author Arthur Jones
 */
public class Test {
    
    /**
     * Will run all the tests
     */
    public void runTests() {
        System.out.println("\nRunning Tests...");

        this.overflowTest(5);
        this.stringInputTest("abc+-12d;km30");
        this.underflowTest(-3);
    }
    
    /**
     * Will perform the overflow test
     * @param num A number 
     */
    private void overflowTest(int num) {
        System.out.println("Overflow Input test...");
        int notIntMain = 0, userInputMain = num, newInputMain = 0; //these variable detect whether the input from the keyboard is the correct type (int)
        while (notIntMain == 0) {
            try {
                userInputMain = newInputMain;        //different types can't be compared
                if (userInputMain != newInputMain) //if the types are incompatible, loop it again
                {
                    notIntMain = 0;
                }
                if (userInputMain == newInputMain) //if the types are compatible, exit loop
                {
                    notIntMain = 1;
                }
            } catch (InputMismatchException e) {
            }

            if ((userInputMain < 1) || (userInputMain > 2)) //then, if the input is an int, it detects if it is in the proper range [1,2]
            {
                notIntMain = 0;
                System.out.println("Invalid Input, Please Try Again");
            }
            break;
        }
    }
    
    /**
     * Will perform the wrong input format test
     * @param letter A string
     */
    private void stringInputTest(String letter) {
        System.out.println("String Input test...");
        int notIntMain = 0, userInputMain = 0, newInputMain = 0, userInput = 0, newInput = 0; //these variable detect whether the input from the keyboard is the correct type (int)
        while (notIntMain == 0) {
            Scanner scan = new Scanner(letter);
            try {
                newInput = scan.nextInt();
                userInput = newInput;
                userInputMain = newInputMain;        //different types can't be compared
                if (userInputMain != newInputMain) //if the types are incompatible, loop it again
                {
                    notIntMain = 0;
                }
                if (userInputMain == newInputMain) //if the types are compatible, exit loop
                {
                    notIntMain = 1;
                }
            } catch (InputMismatchException e) {
            }

            if ((userInputMain < 1) || (userInputMain > 2)) //then, if the input is an int, it detects if it is in the proper range [1,2]
            {
                notIntMain = 0;
                System.out.println("Invalid Input, Please Try Again");
            }
            break;
        }
    }
    
    /**
     * Will perform the underflow test
     * @param num A number
     */
    private void underflowTest(int num) {
        System.out.println("Underflow Input test...");
        int notIntMain = 0, userInputMain = num, newInputMain = 0; //these variable detect whether the input from the keyboard is the correct type (int)
        while (notIntMain == 0) {
            try {
                userInputMain = newInputMain;        //different types can't be compared
                if (userInputMain != newInputMain) //if the types are incompatible, loop it again
                {
                    notIntMain = 0;
                }
                if (userInputMain == newInputMain) //if the types are compatible, exit loop
                {
                    notIntMain = 1;
                }
            } catch (InputMismatchException e) {
            }

            if ((userInputMain < 1) || (userInputMain > 2)) //then, if the input is an int, it detects if it is in the proper range [1,2]
            {
                notIntMain = 0;
                System.out.println("Invalid Input, Please Try Again");
            }
            break;
        }
    }
}
