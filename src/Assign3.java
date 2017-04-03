/**
 * Created by KhoaPham on 3/20/17.
 */
import java.util.*;
import java.lang.*;

public class Assign3 {

    private static InputCheck inputCheck = new InputCheck();
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Play default Connect 4? (y/n) ");
        String input = inputCheck.checkGameSelection(in.next());

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

}
