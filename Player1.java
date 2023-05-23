import java.util.Scanner;

public class Player1 extends Board implements Players{
    private int num;
    private int score;
    private int x;

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
        x = (col - 1) * 10 + (col * 5);
        y = 
        return col--;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return super.availableY(x);
    }

    public void setScore(int s) {
        score += s;
    }

    public void draw(Graphics g){
        
    }
}