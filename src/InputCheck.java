/**
 * Created by KhoaPham on 3/29/17.
 */

import java.util.*;
import java.lang.*;
import java.io.*;

public class InputCheck {

    private Scanner in = new Scanner(System.in);


    /**
     * Checks if the user inputs a valid move (the drop position is within the column range of the board)
     * WARNING: May infinitely loop if user continuously inputs invalid choice
     */
    protected int checkValidMove(String position, ConnectBoard board) {
        while (!isInteger(position)) {
            System.out.println("That is not an integer value.");
            System.out.println("Enter in your move (0-" + (board.getCol() - 1) + "): ");
            position = in.next();
        }

        while (Integer.parseInt(position) < 0 || Integer.parseInt(position) > board.getCol() - 1) {
            System.out.println("Your move must be between 0 and " + (board.getCol() - 1) + ".");
            position = "" + checkValidMove(in.next(), board);

        }

        return Integer.parseInt(position);
    }

    protected String checkValidPlayerType(String s) {
        while (!s.equalsIgnoreCase("x") && !s.equalsIgnoreCase("o")) {
            System.out.println("That is not a valid Player type.");
            System.out.println("Are you Player X or O? (x/o)");
            s = in.next();
        }

        return s;
    }

    protected String checkGameSelection(String s) {
        while (!s.equalsIgnoreCase("y") && !s.equalsIgnoreCase("n")) {
            System.out.println("Not a valid input.");
            System.out.println("Please enter y/n if you'd like to play default Connect 4: ");
            s = in.next();
        }
        return s;
    }

    /**
     *  Helper method to determine if the input string can be parsed to an integer
     */
    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);    // This will throw an exception if the string cannot be parsed to an integer
        }
        catch (Exception ex) {
            return false;
        }

        return true;    // This only executes if the string can be parsed to an integer
    }
}
