import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileWriter;

public class UserPanel extends JPanel implements MouseListener, JavaArcade, ActionListener {
    private boolean run;
    private int highestScore;
    private Board board;
    private Player1 playerOne;
    private Player2 playerTwo;
    private int width;
    private int height;
    private GameStats gameStats;
    private ArrayList<Cake> c;
    private int turn;
    Timer t;
    ActionListener action;
    private boolean isFirstRun;

    // constructor
    public UserPanel(int width, int height){
        board = new Board();
        playerOne = new Player1();
        playerTwo = new Player2();
        this.width = width;
        this.height = height;
        run = false;
        isFirstRun = true;
        gameStats = new GameStats(this);
        addMouseListener(this);

        // Scanner reader;

        // try {
        //     reader = new Scanner(new File("HighScore.txt"));
        //     highestScore = Integer.parseInt(reader.nextLine());
        // }
        // catch (IOException e) {
        //     System.out.println("An error occurred.");
        //     e.printStackTrace();
        // }

        game();
    }

    //starts timer
    public void game(){
        c = new ArrayList<Cake>();

        turn = 1;

        t = new Timer(100, action);  
    }

    // when screen is clicked
    public void actionPerformed(ActionEvent e){
        run = true;
    }

    public boolean running() {
        return run;
    }

    /* This method should start your game, it should also set a global boolean value so that your running method
     * can return the appropriate value */

    public void startGame() {
        run = true;
        t.start();
        if(!isFirstRun){
            turn = 1;
            board = new Board();
            c = new ArrayList<Cake>();
            repaint();
        }
    }

    /*This method should return the name of your game */
    public String getGameName() {
        return "Desset Desperation";
    }

    /* This method should stop your timers but save your score, it should set a boolean value to indicate
     *the game is not running, this value will be returned by running method */
    public void pauseGame() {
        run = false;
    }

    /* This method should return your instructions */
    public String getInstructions() {
        return "The first player to connect 4 in a row wins. Ways include horizontal, vertical, and diagonal.";
    }

   /* This method should return the author(s) of the game */
    public String getCredits() {
        return "By Lina Li and Sharayu Josh";
    }

    /* This method should return the highest score played for this game */
    public String getHighScore() throws IOException{
        Scanner reader = new Scanner(new File("HighScore.txt"));
        return "" + reader.nextInt();
    }

    /* This method should stop the timers, reset the score, and set a running boolean value to false */
    public void stopGame() {
        run = false;
        isFirstRun = false;
        t.stop();
    }

    /* This method shoud return the current players number of points */
    public ArrayList<Integer> getPoints() {
        int temp1 = playerOne.getScore();
        int temp2 = playerTwo.getScore();
        ArrayList<Integer> scores = new ArrayList<Integer>(2);
        scores.add(temp1);
        scores.add(temp2);
        return scores;
    }

    /* This method provides access to GameStats display for UserPanel to pass information to update score
    GameStats is created in Arcade, a reference should be passed to UserPanel (main panel) to update poionts */
    public void setDisplay(GameStats d) {
        gameStats = d;
        d.update(getPoints());
    }

    //when a column is clicked, determines which column and row, adds Cake object to the ArrayList, checks for a winner, calls repaint
    public void mouseClicked(MouseEvent e){
        //System.out.println(true);
        Cake k;
        int col = 0;
        
        if(e.getX() >= 450 && e.getX() <= 500){
            col = 1;
        } else if(e.getX() > 500 && e.getX() <= 555){
            col = 2;
        } else if(e.getX() > 558 && e.getX() <= 610){
            col = 3;
        } else if(e.getX() > 615 && e.getX() <= 670){
            col = 4;
        } else if(e.getX() > 670 && e.getX() <= 720){
            col = 5;
        } else if(e.getX() > 720 && e.getX() <= 778){
            col = 6;
        } else if(e.getX() > 778 && e.getX() <= 850){
            col = 7;
        }

        int row = board.makeMove(col, turn);
        if(row != -1){
            k = new Cake(turn, row, col);
            c.add(k);

            if (turn == 1)
                turn = 2;
            else
                turn = 1;
        }

        repaint();

        if(!checkWinner().equals("None")){
            try {
                isFirstRun = false;
                gameStats.gameOver(getPoints());
            } catch (IOException i) {
            }
        }
    }

    // checks for a winner
    public String checkWinner(){
        String winner = board.checkWinner();

        // game ends
        if (winner.equals("Player 1")) {
            playerOne.setScore(2);
        }
        else if (winner.equals("Player 2")) {
            playerTwo.setScore(2);
        }
        else if (winner.equals("Tie")) {
            playerOne.setScore(1);
            playerTwo.setScore(1);
        }

        return winner;
    }

    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}

    //paints graphics on the JPanel
    public void paintComponent(Graphics g){

        super.paintComponent(g); //a call to JPanel's paintComponent

            //Draw board
          board.draw(g);
          
        if(run)
            for(Cake k: c)
                g.drawImage(k.getImage(), k.getX(), k.getY(), null);
    }
}