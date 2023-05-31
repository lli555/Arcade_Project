// Represents current Game Stats

import java.util.ArrayList;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class GameStats extends JPanel
{
  private JTextField gameNameText, currentHighScorer, currentHighScore;
  private int yourScore;
  private JLabel yourScoreText, hScore;
  private JavaArcade game;

  // Constructor
  public GameStats(JavaArcade t)
  {
      super(new GridLayout(2, 4, 10, 0));
      setBorder(new EmptyBorder(0, 0, 5, 0));
      Font gameNameFont = new Font("Monospaced", Font.BOLD, 24);

      JLabel gName = new JLabel(" " + t.getGameName());

      gName.setForeground(Color.red);
      gName.setFont(gameNameFont);
      add(gName);
        hScore = new JLabel(" Current High Score:   " + t.getHighScore());

      add(hScore); //new JLabel(" Current High Score:   " + t.getHighScore()));

      add(new JLabel(" "));
      yourScoreText = new JLabel(" Your Final Score: " + 0);

      add(yourScoreText);
      Font displayFont = new Font("Monospaced", Font.BOLD, 16);
      game = t;

     }


  public void update(ArrayList<Integer> points)
  {
  	yourScoreText.setText(" Your Scores: " + points);
  }

  public void gameOver(ArrayList<Integer> points) {
    for(Integer i : points) {
        if(i.intValue() > Integer.parseInt(game.getHighScore())){
          yourScoreText.setForeground(Color.BLUE);
          String s = (String)JOptionPane.showInputDialog(this, "You are the new high scorer with " + i.intValue() + " points! Congratulations!\n Enter your name: ", "High Score", JOptionPane.PLAIN_MESSAGE, null, null,"name");
          hScore.setText(" Current High Score:   " + i.intValue());
  	  }
    }
  }
}
