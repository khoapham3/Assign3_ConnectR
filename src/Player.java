/**
 * Created by KhoaPham on 3/20/17.
 */

import java.util.*;
import java.lang.*;

public class Player {

    private char playerType;    // Player's for ConnectR can by X or O

    private InputCheck inputCheck;
    private Scanner in = new Scanner(System.in);

    /** CONSTRUCTOR */
    public Player(char type) {
        this.playerType = type;
        inputCheck = new InputCheck();
    }

    /**
     *  Player's drop a ConnectR piece in a column position they specify
     *  WARNING: This may infinitely recurse
     */
    public int drop(int colPosition, ConnectBoard board) {

        /** Start at the bottom of the specified column and loop upwards */
        for (int i = board.getRow() - 1; i >= 0; i--) {

            /** Drop the game piece if there is an empty spot (represented by '.') in the specified column */
            if (board.getPosition(i, colPosition) == '.') {
                board.setPosition(i, colPosition, this.playerType);
                return i;
            }
        }

        System.out.println("Column " + colPosition + " is full.");

        return newMove(board);      // Only executes if the column to drop a game piece is full
    }


    /**
     *  Player's must make a new move if the column they want to drop a ConnectR piece is full
     *  WARNING: This may infinitely recurse
     */
    private int newMove(ConnectBoard board) {
        System.out.println("Enter in a new move (0-" + (board.getCol() - 1) + "): ");

        int position = inputCheck.checkValidMove(in.next(), board);

        return drop(position, board);
    }

    public char getPlayerType() {
        return this.playerType;
    }


}