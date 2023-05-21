import java.util.Scanner;

public class Player1 extends Players {
    private int num;
    private int score;
    public Player1() {
        num = 1;
        score = 0;
    }

    public int getScore() {
        return score;
    }

    public int getMove() {
        Scanner scan = new Scanner(System.in);
        int col = 1;
        do {
            System.out.println("What column would you like to choose? (Columns 1 - 7)");
            col = scan.nextInt();
        }
        while (col > 7 || col <= 0);

        return col--;
    }

    public void setScore(int s) {
        score += s;
    }
}