// CS 2365 Object Oriented-Programming  Spring 2020
// Section 001 ,002 ,003, C01
// Mario Alberto Pitalua Rodriguez, PhD.
//
package auto;

/**
 *
 * @author mapitalu
 */
import java.text.DecimalFormat;

public class Auto {

    String model;
    int milesDriven;
    double gallonsOfGas;
    static int countAutos;
    // Instance variables
    //  model of auto           (String)
    //  number of miles driven  (integer)
    //  number of gallons of gas (double)

    // static class variable use to count the number of objects instantiated.
    // Constructors:
    //  initializes model to "unknown";
    //  milesDriven is auto-initialized to 0
    //        and gallonsOfGas to 0.0;
    // increments countAutos
    public Auto() {
        this.model = "unknown";
        this.milesDriven = 0;
        this.gallonsOfGas = 0.0;
        this.countAutos++;
    }

    // allows client to set beginning values for
    // model, milesDriven, and gallonsOfGas;
    // increments countAutos
    public Auto(String startModel, int startMilesDriven, double startGallonsOfGas) {
        this.model = startModel;
        this.milesDriven = startMilesDriven;
        this.gallonsOfGas = startGallonsOfGas;
        countAutos++;
    }

    // Accessor Method:
    // returns current value of Model
    public String getModel() {
        return this.model;
    }

    // Accessor Method:
    // returns current value of milesDriven
    public int getMilesDriven() {
        return this.milesDriven;
    }

    // Accessor Method:
    // returns current value of gallonsOfGas
    public double getGallonsOfGas() {
        return this.gallonsOfGas;
    }

    // Accessor Method:
    // returns countAutos
    public static int getCountAutos() {
        return countAutos;
    }

    // Mutator Method:
    // allows client to set model
    public void setModel(String model) {
        this.model = model;
    }

    // Mutator Method:
    // allows client to set value of milesDriven
    // if new value is not less than 0
    public Auto setMilesDriven(int milesDriven) {
        if (milesDriven <= 0) {
            return this;
        }
        this.milesDriven = milesDriven;
        return this;
    }

    // Mutator Method:
    // allows client to set value of gallonsOfGas
    // if new value is not less than 0.0
    public Auto setGallonsOfGas(double gallonsOfGas) {
        if (gallonsOfGas <= 0) {
            return this;
        }
        this.gallonsOfGas = gallonsOfGas;
        return this;
    }

    // Calculates miles per gallon.
    // if no gallons of gas have been used, returns 0.0;
    // otherwise, returns miles per gallon
    //   as milesDriven / gallonsOfGas
    public double milesPerGallon() {
        if (this.gallonsOfGas == 0.0) {
            return 0.0;
        }
        return milesDriven / gallonsOfGas;
    }

    // Calculates money spent on gas.
    // returns price per gallon times gallons of gas
    public double moneySpentOnGas(double pricePerGallon) {
        return pricePerGallon * gallonsOfGas;
    }

    // toString: returns a String with values of instance variable
    // Format a compleling String to display the object's information
    @Override
    public String toString() {
        DecimalFormat gallonsFormat = new DecimalFormat("#0.00");
        return "The model of the car is: " + this.model + ". The miles driven on the car is: " + this.milesDriven + ". The gallons of gas the car has is: " + gallonsFormat.format(gallonsOfGas);
    }

    // PAY ATTENTION ON HOW THIS METHOD IS OVERRIDED for the Class Auto
    // equals: returns true if fields of parameter object
    //         are equal to fields in this object
    @Override
    public boolean equals(Object o) // Object Class, defined the signature of the method.
    {
        if (!(o instanceof Auto)) // Check if the Object O, the parameter, is of Class Auto
        {
            return false;				      //  If NOT the object cannot be equal since they are from different classes.
        } else {
            Auto objAuto = (Auto) o;	  // Cast from Object to Auto, to obtain access to data members by the reference variable objAuto
            if (model.equals(objAuto.model) // Compare Atrribute by Attraibute between the Object of the Parameter and the one Invoking the Method.
                    && milesDriven == objAuto.milesDriven
                    && Math.abs(gallonsOfGas - objAuto.gallonsOfGas)
                    < 0.0001) {
                return true;			       // IF All attributes have the same values return true
            } else {
                return false;				   // Otherwise return false.
            }
        }
    }
}
