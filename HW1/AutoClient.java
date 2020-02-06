// CS 2365 OOP Spring 2020 Section 001
// Mario Alberto Pitalua Rodriguez
// CS 2365 OOP Spring 2020
// Mario Alberto Pitalu Rodriguez

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auto;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author BlackStar
 */
// STUDENT COMMENTS:
//
//
public class AutoClient {

    public static void main(String[] args) {
        //Using Constructors
        System.out.println("Instantiate sedan");
        Auto sedan = new Auto();

        System.out.println("\nInstantiate suv");
        Auto suv = new Auto("Trailblazer", 7000, 437.5);

        System.out.println("\nInstantiate mini");
        // attempt to set invalid value for gallons of gas
        Auto mini = new Auto("Mini Cooper", 200, -1.0);

        // Using Get Methods
        String sedanModel = sedan.getModel();
        int sedanMiles = sedan.getMilesDriven();
        double sedanGallons = sedan.getGallonsOfGas();
        System.out.println("sedan: model is " + sedanModel
                + "\n miles driven is " + sedanMiles
                + "\n gallons of gas is " + sedanGallons);

        String suvModel = suv.getModel();
        int suvMiles = suv.getMilesDriven();
        double suvGallons = suv.getGallonsOfGas();
        System.out.println("suv: model is " + suvModel
                + "\n miles driven is " + suvMiles
                + "\n gallons of gas is " + suvGallons);

        // Using Get Methods
        // print initial values of instance variables
        System.out.println("suv: model is " + suv.getModel()
                + "\n miles driven is " + suv.getMilesDriven()
                + "\n gallons of gas is " + suv.getGallonsOfGas());

        // call mutator method for each instance variable
        suv.setModel("Sportage");
        suv.setMilesDriven(200);
        suv.setGallonsOfGas(10.5);

        // print new values of instance variables
        System.out.println("\nsuv: model is " + suv.getModel()
                + "\n miles driven is " + suv.getMilesDriven()
                + "\n gallons of gas is " + suv.getGallonsOfGas());

        // attempt to set invalid value for milesDriven
        suv.setMilesDriven(-1);
        // print current values of instance variables
        System.out.println("\nsuv: model is " + suv.getModel()
                + "\n miles driven is " + suv.getMilesDriven()
                + "\n gallons of gas is " + suv.getGallonsOfGas());

        // Printing with Decimal Format
        double mileage = suv.milesPerGallon();
        DecimalFormat mpgFormat = new DecimalFormat("0.0");
        System.out.println("Mileage for suv is "
                + mpgFormat.format(mileage));

        double gasCost = suv.moneySpentOnGas(2.79);
        NumberFormat money = NumberFormat.getCurrencyInstance();
        System.out.println("Gas cost for suv is "
                + money.format(gasCost));

        Auto sporty = new Auto("Spyder", 0, 0.0);
        // Pay attention on the following instruction
        sporty.setGallonsOfGas(3.4).setMilesDriven(67);
        int sportyMiles = sporty.getMilesDriven();
        double sportyGallons = sporty.getGallonsOfGas();
        System.out.println("Miles driven is " + sportyMiles
                + "\nGallons of gas is " + sportyGallons);

        // using toString method
        sporty = new Auto("Spyder", 0, 0.0);
        System.out.println(sporty.toString());

        // Compating two objects using equals
        Auto compact = new Auto("Accent", 0, 0.0);
        System.out.println();
        System.out.println(compact);

        if (compact.equals(sporty)) {
            System.out.println("\nsporty and compact are equal");
        } else {
            System.out.println("\nsporty and compact are not equal");
        }

        // Using a STATIC counter to count of the number of objects instantiated.
        System.out.println("Before instantiating an Auto object:"
                + "\nthe count of Auto objects is "
                + Auto.getCountAutos());

        System.out.println("\nAfter instantiating an Auto object:"
                + "\nthe count of Auto objects is "
                + Auto.getCountAutos());

    }
}
