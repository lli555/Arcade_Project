public abstract class Players {
    public abstract int getScore(); // returns the result of the game; 0 for loss, 1 for tie, 2 for win
    public abstract int getMove(); // returns the column of choice
    public abstract void setScore(int s); // increments the score
}