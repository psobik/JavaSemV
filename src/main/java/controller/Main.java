/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.PolynomialException;
import view.View;
import model.Polynomial;

/**
 * <code>Main</code> controls the data flow between <code>AppController</code> ,
 * <code>View</code> , <code>Polynomial</code>
 *
 * @author Patrycja Sobik
 * @version 1.0
 *
 */
public class Main {

    /**
     * Controls the data and updates the view, main method of prgram which count
     * polynomial from numbers given by user
     *
     * @param args the arguments given in console, should be numbers separeted
     * by space, last number is always x
     */
    public static void main(String args[]) {
        // variable for result to show at the end
        float result;
        // array of Objects float type for args/params
        Float[] numbers;

        View view = new View();
        AppController appController = new AppController();
        Polynomial polynomial = new Polynomial();
        // checks if less than 1 params give in console
        if (args.length < 1) {
            // if less than 1 params then user write params separeted by space
            String userParams = view.readParams();
            // converts and returns user params into numbers array
            numbers = appController.parseUserParams(userParams);
        } // if there was more than 1 param given in console
        else {
            // converts and returns arguments into numbers array
            numbers = appController.parseStartupArgs(args);
        }
        // checks for exceptions
        try {
            // validates and count polynomial into result variable
            result = polynomial.validateAndCountPolynomial(numbers);
            // shows result to user
            view.showResult(result);
        } // catches exception if there was any
        catch (PolynomialException e) {
            // displays message about error to user
            view.displayMessage("Error occured: " + e.getMessage());
        }
    }
}
