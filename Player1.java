import java.util.Scanner;
import java.awt.Graphics;


import javax.swing.*;

public class Player1 implements Players{
    private int num;
    private int score;

    //constructor
    public Player1() {
        num = 1;
        score = 0;
    }

    public Player1(int score) {
        num = 1;
        this.score = score;
    }
    
    //returns score
    public int getScore() {
        return score;
    }

    //incrememnts score by s
    public void setScore(int s) {
        score += s;
    }

}