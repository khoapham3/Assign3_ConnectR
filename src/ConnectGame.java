/**
 * Created by KhoaPham on 3/20/17.
 */
import java.util.*;
import java.lang.*;
import java.io.*;

public class ConnectGame {

    private ConnectBoard board;
    private Player x = new Player('X');
    private Player o = new Player('O');
    private final int TOTAL_MOVES = this.board.getRow() * this.board.getCol();
    private int currentMoves = 0;

    private Scanner in = new Scanner(System.in);

    public ConnectGame() {
        board = new ConnectBoard();

    }

    public ConnectGame(int n, int m, int r) {
        board = new ConnectBoard(n, m, r);

    }

    public void start() {

        this.board.printBoard();

        System.out.println("Are you Player X or O? (x/o)");
        String playerType = checkValidPlayerType(in.next());

        System.out.println("Player X moves first.");

        while (currentMoves <= TOTAL_MOVES) {

        }

    }

    private boolean hasWon(int n, int m, ConnectBoard board) {
        char c = this.board.getPosition(n, m);

        StringBuilder sb = new StringBuilder(board.getR());
        for (int i = 0; i < board.getR(); i++) {
            sb.append(c);
        }
        String streak = sb.toString();

        return contains(this.horizontal(n, board), streak) ||
                contains(this.vertical(m, board), streak) ||
                contains(this.slashDiagonal(n, m, board), streak) ||
                contains(this.backslashDiagonal(n, m, board), streak);
    }

    /** The contents of the row containing the last played chip. */
    private String horizontal(int n, ConnectBoard board) {
        StringBuilder sb = new StringBuilder(board.getRow());
        for (int j = 0; j < board.getCol(); j++) {
            sb.append(board.getPosition(n,j));
        }
        return sb.toString();
    }

    /** The contents of the column containing the last played chip. */
    private String vertical(int m, ConnectBoard board) {
        StringBuilder sb = new StringBuilder(board.getRow());
        for (int i = 0; i < board.getRow(); i++) {
            sb.append(board.getPosition(i, m));
        }
        return sb.toString();
    }

    /**
     * The contents of the "/" diagonal containing the last played chip
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

    /**
     * The contents of the "\" diagonal containing the last played chip
     */
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

    private boolean contains(String search, String sequence) {
        return search.contains(sequence);
    }

    private int checkValidMove(String position, ConnectBoard board) {
        while (!isInteger(position)) {
            System.out.println("That is not an integer value.");
            System.out.println("Enter in your move (0-" + (board.getCol() - 1) + ": ");
            position = in.next();
        }

        while ( ) {

            System.out.println("Your move must be between 0 and " + (board.getCol() - 1));
            position = in.next();
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