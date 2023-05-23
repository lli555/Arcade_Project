import java.util.Scanner;

public class Player2 extends Board implements Players {
    private int num;
    private int score;

    public Player2() {
        num = 2;
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