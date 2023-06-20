import java.util.Scanner;
import java.awt.Graphics;


import javax.swing.*;

public class Player2 implements Players{
    private int num;
    private int score;

    //constructor
    public Player2() {
        num = 2;
        score = 0;
    }

    public Player2(int score) {
        num = 1;
        this.score = score;
    }

    //returns score
    public int getScore() {
        return score;
    }

    //increments score
    public void setScore(int s) {
        score += s;
    }
}