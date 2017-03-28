/**
 * Created by KhoaPham on 3/20/17.
 */
import java.util.*;
import java.lang.*;
import java.io.*;

public class ConnectGame {

    private ConnectBoard board;
    private Player playerX = new Player('X');
    private Player playerO = new Player('O');
    private String winConnectionX;  /** The winning connection necessary for Player X */
    private String winConnectionO;  /** The winning connection necessary for Player O */
    private int TOTAL_MOVES;        /** Total number of possible moves on the board */
    private int currentMoves;       /** Current total number of moves made by either player*/

    private Scanner in = new Scanner(System.in);

    /** CONSTRUCTORS */
    /** Default game of Connect4 */
    public ConnectGame() {
        board = new ConnectBoard();
        TOTAL_MOVES = board.getRow() * board.getCol();
        currentMoves = 0;
        winConnectionX = buildWinningConnection('X');
        winConnectionO = buildWinningConnection('O');
    }

    /** Custom game of ConnectR */
    public ConnectGame(int n, int m, int r) {
        board = new ConnectBoard(n, m, r);
        TOTAL_MOVES = board.getRow() * board.getCol();
        currentMoves = 0;
        winConnectionX = buildWinningConnection('X');
        winConnectionO = buildWinningConnection('O');
    }

    /** Starts of game of ConnectR */
    public void start() {

        this.board.printBoard();

        System.out.println("Are you Player X or O? (x/o)");
//        String playerType = checkValidPlayerType(in.next());

        System.out.println("Player X moves first.");

        /** while() runs until either
         * there no more possible moves on the board or
         * a player has won the game
         */
        while (currentMoves <= TOTAL_MOVES) {

            System.out.println("Enter in a move: ");

            int colMove = checkValidMove(in.next(), board);
            int rowMove;

            if (isEven(currentMoves)) {
                rowMove = playerX.drop(colMove, board);
                currentMoves++;
            }
            else {
                rowMove = playerO.drop(colMove,board);
                currentMoves++;
            }

            this.board.printBoard();

            /** Check if a player has won the game after enough moves have been made */
            if (currentMoves >= this.board.getR()) {
                if (isEven(currentMoves)) {     // If currentMoves is even, then PlayerO made the last move
                    if (hasWon(rowMove, colMove, winConnectionO, board)) {
                        System.out.println("Player O has WON!");
                        return;
                    }
                }
                else {
                    if (hasWon(rowMove, colMove, winConnectionX, board)) {
                        System.out.println("Player X has WON!");
                        return;
                    }
                }
            }
        }

        System.out.println("This game is a DRAW.");     // This only executes if a player has not won
    }

    /** Checks if the player who made the last move has won the game */
    private boolean hasWon(int n, int m, String winningConnection, ConnectBoard board) {

        return contains(this.horizontal(n, board), winningConnection) ||
                contains(this.vertical(m, board), winningConnection) ||
                contains(this.slashDiagonal(n, m, board), winningConnection) ||
                contains(this.backslashDiagonal(n, m, board), winningConnection);
    }

    /** Contents of the row containing the last played chip. */
    private String horizontal(int n, ConnectBoard board) {
        StringBuilder sb = new StringBuilder(board.getRow());
        for (int j = 0; j < board.getCol(); j++) {
            sb.append(board.getPosition(n,j));
        }
        return sb.toString();
    }

    /** Contents of the column containing the last played chip. */
    private String vertical(int m, ConnectBoard board) {
        StringBuilder sb = new StringBuilder(board.getRow());
        for (int i = 0; i < board.getRow(); i++) {
            sb.append(board.getPosition(i, m));
        }
        return sb.toString();
    }

    /**
     * The contents of the "/" diagonal containing the last played chip.
     */
    private String slashDiagonal(int n, int m, ConnectBoard board) {
        StringBuilder sb = new StringBuilder(board.getRow());
        for (int i = 0; i < board.getRow(); i++) {
            int j = m + n - i;
            if (0 <= j && j < board.getCol()) {
                sb.append(board.getPosition(i, j));
            }
        }
        return sb.toString();
    }

    /** The contents of the "\" diagonal containing the last played chip. */
    private String backslashDiagonal(int n, int m, ConnectBoard board) {
        StringBuilder sb = new StringBuilder(board.getRow());
        for (int i = 0; i < board.getRow(); i++) {
            int j = m - n + i;
            if (0 <= j && j < board.getCol()) {
                sb.append(board.getPosition(i, j));
            }
        }
        return sb.toString();
    }

    /** Helper function to determine if a string to be searched contains the given sequence */
    private boolean contains(String search, String sequence) {
        return search.contains(sequence);
    }

    /** Verifies if the player's move is valid
     * The player must input an integer with value between 0 and the number of columns of the board
     */
    /** _____THIS CODE IS DUPLICATED IN PLAYER CLASS_______
     * _____FIGURE OUT HOW TO FIX THIS DUPLICATION_______ */
    private int checkValidMove(String position, ConnectBoard board) {

        /** This runs if the passed string cannot be parsed to an integer */
        while (!isInteger(position)) {
            System.out.println("That is not an integer value.");
            System.out.println("Enter in a valid move (0-" + (board.getCol() - 1) + "): ");
            position = in.next();
        }

        /** This runs if the integer string is not between 0 and the number of columns of the board */
        while (Integer.parseInt(position) < 0 || Integer.parseInt(position) > board.getCol() - 1) {
            System.out.println("Your move must be between 0 and " + (board.getCol() - 1) + ".");
            position = "" + checkValidMove(in.next(), board);       // Checks if the newly passed string is valid recursively

        }

        return Integer.parseInt(position);
    }

    private String checkValidPlayerType(String s) {
        while (!s.equalsIgnoreCase("x") && !s.equalsIgnoreCase("o")) {
            System.out.println("That is not a valid Player type.");
            System.out.println("Are you Player X or O? (x/o)");
            s = in.next();
        }

        return s;
    }

    private String buildWinningConnection(char c) {
        StringBuilder sb = new StringBuilder(board.getR());
        for (int i = 0; i < board.getR(); i++) {
            sb.append(c);
        }

        return sb.toString();
    }

    /** Checks if a string is an integer */
    /** _____THIS CODE IS DUPLICATED IN PLAYER CLASS_______
     * _____FIGURE OUT HOW TO FIX THIS DUPLICATION_______ */
    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        }
        catch (Exception ex) {
            return false;       // The string cannot be parsed to an integer
        }

        return true;        // Only executes if passed string can be parsed to an integer
    }


    private boolean isEven(int num) {
        return num % 2 == 0;
    }

}