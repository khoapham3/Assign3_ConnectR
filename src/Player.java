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
        System.out.println();
        return 1;
    }

    public char getPlayerType() {
        return this.playerType;
    }

}