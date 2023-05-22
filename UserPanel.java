import java.util.ArrayList;
import javax.swing.JPanel;

public class UserPanel extends JPanel implements JavaArcade {
    private boolean run;
    private int highestScore;
    private Board board;
    private Player1 playerOne;
    private Player2 playerTwo;
    private int width;
    private int height;

    public UserPanel(int width, int height){
        board = new Board();
        playerOne = new Player1();
        playerTwo = new Player2();
        this.width = width;
        this.height = height;
        run =false;
    }

    public boolean running() {
        return run;
    }

    /* This method should start your game, it should also set a global boolean value so that your running method
     * can return the appropriate value */

    public void startGame() {
        run = true;
    }

    /*This method should return the name of your game */
    public String getGameName() {
        return "Four In A Row";
    }

    /* This method should stop your timers but save your score, it should set a boolean value to indicate
     *the game is not running, this value will be returned by running method */
    public void pauseGame() {
        run = false;
    }

    /* This method should return your instructions */
    public String getInstructions() {
        return "The first player to connect 4 pieces in a row wins. Ways include horizontal, vertical, and diagonal.";
    }

   /* This method should return the author(s) of the game */

    public String getCredits() {
        return "By Lina Li and Sharayu Josh";
    }

    /* This method should return the highest score played for this game */
    public static String getHighScore() {
        return "The highest score achieved is " + highestScore + "points!" +
                    "\nCan you beat it? Play to find out!";
    }

    /* This method should stop the timers, reset the score, and set a running boolean value to false */
    public void stopGame() {
        run = false;
    }

    /* This method shoud return the current players number of points */

    public ArrayList<Integer> getPoints() {
        int temp1 = playerOne.getScore();
        int temp2 = playerTwo.getScore();
        ArrayList<Integer> scores = new ArrayList<Integer>(2);
        scores.add(temp1);
        scores.add(temp2);
        return scores;
    } //add to spec

    /* This method provides access to GameStats display for UserPanel to pass information to update score
    GameStats is created in Arcade, a reference should be passed to UserPanel (main panel) to update poionts */
    public void setDisplay(GameStats d) {

    }
}