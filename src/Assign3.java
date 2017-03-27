/**
 * Created by KhoaPham on 3/20/17.
 */
import java.util.*;
import java.lang.*;
import java.io.*;

public class Assign3 {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Play default Connect 4? (y/n) ");
        String input = checkInput(in.next());

        ConnectGame game;

        if (input.equalsIgnoreCase("y")) {
            game = new ConnectGame();
        }
        else {
            int row, col, r;
            System.out.println("Board Height? ");
            row = in.nextInt();

            System.out.println("Board Width? ");
            col = in.nextInt();

            System.out.println("Connect? ");
            r = in.nextInt();

            game = new ConnectGame(row, col, r);
        }

        game.start();
    }

    private static String checkInput(String s) {
        while (!s.equalsIgnoreCase("y") && !s.equalsIgnoreCase("n")) {
            System.out.println("Not a valid input.");
            System.out.println("Please enter y/n if you'd like to play default Connect 4: ");
            s = in.next();
        }
        return s;
    }
}
