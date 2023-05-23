public interface Players {
    public int getScore(); // returns the result of the game; 0 for loss, 1 for tie, 2 for win
    public int getMove(); // returns the column of choice
    public void setScore(int s); // increments the score
}