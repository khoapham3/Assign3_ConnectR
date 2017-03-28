/**
 * Created by KhoaPham on 3/20/17.
 */

import java.net.ConnectException;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Player {

    private char playerType;
    private Scanner in = new Scanner(System.in);

    public Player(char type) {
        this.playerType = type;
    }

    public int drop(int position, ConnectBoard board) {
        for (int i = board.getRow() - 1; i >= 0; i--) {
            if (board.getPosition(i, position) == '.') {
                board.setPosition(i, position, this.playerType);
                return i;
            }
        }
        System.out.println("Column " + position + " is full.");

        return newMove(board);
    }


    private int newMove(ConnectBoard board) {
        System.out.println("Enter in a new move (0-" + (board.getCol() - 1) + "): ");

        int position = checkValidMove(in.next(), board);

        return drop(position, board);
    }

    public char getPlayerType() {
        return this.playerType;
    }

    /** _____THIS CODE IS DUPLICATED IN CONNECTGAME CLASS_______
     * _____FIGURE OUT HOW TO FIX THIS DUPLICATION_______ */
    private int checkValidMove(String position, ConnectBoard board) {
        while (!isInteger(position)) {
            System.out.println("That is not an integer value.");
            System.out.println("Enter in your move (0-" + (board.getCol() - 1) + "): ");
            position = in.next();
        }

        while (Integer.parseInt(position) < 0 && Integer.parseInt(position) > board.getCol() - 1) {
            System.out.println("Your move must be between 0 and " + (board.getCol() - 1));
            position = "" + checkValidMove(in.next(), board);

        }

        return Integer.parseInt(position);
    }

    /** _____THIS CODE IS DUPLICATED IN CONNECTGAME CLASS_______
     * _____FIGURE OUT HOW TO FIX THIS DUPLICATION_______ */
    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        }
        catch (Exception ex) {
            return false;
        }

        return true;
    }

}