/**
 * Created by KhoaPham on 3/20/17.
 */
import java.util.*;
import java.lang.*;
import java.io.*;

public class ConnectBoard {

    private int rows, cols;
    private int r;
    private char[][] board;

    /** CONSTRUCTORS */
    /** Standard 7 x 6 Connect board */
    public ConnectBoard() {
        this.rows = 6;
        this.cols = 7;
        this.r = 4;
        board = new char[rows][cols];
        initBoard();
    }

    /** Custom n x m Connect board */
    public ConnectBoard(int n, int m, int r) {
        this.rows = n;
        this.cols = m;
        this.r = r;
        board = new char[rows][cols];
        initBoard();
    }

    public int getRow() {
        return this.rows;
    }

    public int getCol() {
        return this.cols;
    }

    public int getR() {
        return this.r;
    }
    public char getPosition(int n, int m) {
        return this.board[n][m];
    }

    public void setPosition(int n, int m, char c) {
        this.board[n][m] = c;
    }

    public void printBoard() {

        for (int i = 0; i < this.rows; i++) {
            System.out.print("|");

            for (int j = 0; j < this.cols; j++) {
                System.out.print(this.board[i][j] + "|");
            }

            System.out.println();
        }

        for (int i = 0; i < 2 * this.cols + 1; i++) {
            System.out.print("-");
        }
        System.out.println();


        /** Prints indices for each column (which are the possible moves for the board) */
        System.out.print("|");
        for (int i = 0; i < this.cols; i++) {
            System.out.print(i + "|");
        }

        System.out.println();
    }

    /** Initializes every position to '.' (which signifies an empty spot on the board) */
    private void initBoard() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                this.board[i][j] = '.';
            }
        }
    }
}