/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.View;

/**
 * <code>AppController</code> parses arguments from console or user and make
 * them usable for counting
 *
 * @author Patrycja Sobik
 * @version 1.0
 *
 */
public class AppController {

    View view = new View();

    /**
     * Parses args from console
     *
     * @param args the arguments given in console - numbers separated by space
     * @return the array of parsed Objects ready to calculations, object can be
     * <code>null</code> if wrong argument was given
     */
    public Float[] parseStartupArgs(String[] args) {
        // array prepared for putting numbers
        Float[] numbers = new Float[args.length];
        // parse string argument into float value
        for (int i = 0; i < args.length; i++) {
            // var to check if arg is number
            String checkNum = args[i];
            // if argument is not a number make it null in array
            if (!isNumerical(checkNum)) {
                //display to user which argument was not numerical
                view.displayMessage("Given argument is not a number: " + args[i]);
                numbers[i] = null;
            } //if argument is ok put it into array
            else {
                numbers[i] = Float.parseFloat(args[i]);
            }
        }
        //return table of Objects prepared for counting
        return numbers;
    }

    /**
     * Parses params given by user
     *
     * @param userParams the params given by user in String
     * @return the array of Objects ready to calculations, object can be
     * <code>null</code> if wrong argument was given, the array can be
     * <code>null</code> if no arguments were given
     */
    public Float[] parseUserParams(String userParams) {
        // if no params were given by user
        if (userParams.isEmpty()) {
            // return array which is null
            return null;
        } // if user give params
        else {
            // put user params seprated by space into String array
            String[] arrayOfStrings = userParams.split(" ");
            // array prepared for numbers
            Float numbers[] = new Float[arrayOfStrings.length];
            // parse string params into float value
            for (int i = 0; i < numbers.length; i++) {
                // var to check if param is number
                String checkNum = arrayOfStrings[i];
                // if param is not a number make it null in array
                if (!isNumerical(checkNum)) {
                    // display to user which param was not numerical
                    view.displayMessage("Given argument is not a number: " + arrayOfStrings[i]);
                    numbers[i] = null;
                } // if argument is ok put it into array
                else {
                    numbers[i] = Float.parseFloat(arrayOfStrings[i]);
                }
            }
            // return table of Objects prepared for counting
            return numbers;
        }
    }

    /**
     * Checks if argument or param is numerical
     *
     * @param num the arument to check if is a number
     * @return <code>true</code> if it was a number, <code>false</code> if was
     * not
     */
    private boolean isNumerical(String num) {
        // array of chars from String to check
        char[] chars = num.toCharArray();
        // loop for each char in array
        for (int i = 0; i < chars.length; i++) {
            // if char is not a number return false
            if (!Character.isDigit(chars[i])) {
                return false;
            }
        }
        // if char is number return true
        return true;
    }
}
