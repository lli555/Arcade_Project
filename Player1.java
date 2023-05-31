import java.util.Scanner;
import java.awt.Graphics;


import javax.swing.*;

public class Player1 extends Board implements Players{
    private int num;
    private int score;
    private Cake c;

    public Player1() {
        num = 1;
        score = 0;
    }

    public int getScore() {
        return score;
    }

    public int getMove() {
        int col = 1;
        do {
            // System.out.println("What column would you like to choose? (Columns 1 - 7)");
            // col = scan.nextInt();
            Object[] colIntegers = {1, 2, 3, 4, 5, 6, 7};
      
            col = ((Integer) JOptionPane.showInputDialog(null, "Which column would you like?", "Player 1 Move", JOptionPane.QUESTION_MESSAGE, null, colIntegers, null)).intValue();
        }
        while (col > 7 || col <= 0);

        return col;
    }

    public void setScore(int s) {
        score += s;
    }

}