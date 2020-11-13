package model;

import java.util.Arrays;

/**
 * <code>Polynomial</code> makes validations and calculations
 *
 * @author Patrycja Sobik
 * @version 1.0
 *
 */
public class Polynomial {

    /**
     * Checks arguments and throw exception if needed or count poynomial
     *
     * @param args the arguments to count converted in AppControler
     * @return the result of counted polynomial
     * @throws model.PolynomialException if something is wrong with argumetns
     */
    public float validateAndCountPolynomial(Float[] args) throws PolynomialException {
        // exception if array Float has no agruments
        if (args == null) {
            throw new PolynomialException("Missing arguments");
        } // exception if there is only one argument - x
        else if (args.length == 1) {
            throw new PolynomialException("Only one argument -'x' was given. There is nothing to count");
        } // if none of other exception occured
        else {
            // loop to check each argument
            for (Float arg : args) {
                // if any argument is null
                if (arg == null) {
                    // exception if at leas one argument was not correct
                    throw new PolynomialException("At least one argument is wrong");
                }
            }
            // if everything ok return counted polynomial
            return countPolynomial(args);
        }
    }

    /**
     * Removes last element from array
     *
     * @param tabToRemoveElement the array which we remove element from
     * @return the array without las element - x
     *
     */
    private Float[] removeLastElement(Float[] tabToRemoveElement) {
        // returns array without last element which was 'x'
        return Arrays.copyOf(tabToRemoveElement, tabToRemoveElement.length - 1);
    }

    /**
     * Counts validated polynomial as (number * x ^ n)+(number * x ^
     * n-1)+...+(number * x) + number
     *
     * @param args the array of numbers to count polynomial
     * @return the result of counted polnomial
     * @throws model.PolynomialException if something is wrong with argumetns
     */
    private float countPolynomial(Float[] args) throws PolynomialException {
        // variable for returning result
        float result = 0;
        // the last element from array - x
        float x = args[args.length - 1];
        // removes x from array
        args = removeLastElement(args);
        // power of x to make calculations
        int power = 0;
        // loop to calculate polynomial from numbers in array
        for (int i = (args.length - 1); i >= 0; i--) {
            // count polynomial as sum of arguments * x^power
            result = (float) (result + (args[i] * (Math.pow(x, power))));
            // greater power of x
            power++;
        }
        // return counted polynomial result
        return result;
    }
}
