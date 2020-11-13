package view;

import java.util.Scanner;

/**
 * <code>View</code> interacts with user and represents the data
 *
 * @author Patrycja Sobik
 * @version 1.0
 *
 */
public class View {

    /**
     * Reads params given by user
     *
     * @return the arguments in line given by user
     */
    public String readParams() {

        Scanner scanner = new Scanner(System.in);
        // informs user what to do
        System.out.println("Enter your params: ");
        // return params given by user in line
        return scanner.nextLine();
    }

    /**
     * Displays result to user
     *
     * @param result the result of counted polynomial
     */
    public void showResult(float result) {
        // displays calculations result to user
        System.out.println("Result for your polynomial is: " + result);
    }

    /**
     * Display message to user
     *
     * @param message the message to user
     */
    public void displayMessage(String message) {
        // displays message
        System.out.println(message);
    }
}
