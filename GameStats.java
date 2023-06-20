// Represents current Game Stats

import java.util.ArrayList;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.io.File;  // Import the File class
import java.io.FileWriter;

import java.io.IOException;

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
      try {
        hScore = new JLabel(" Current High Score:   " + t.getHighScore());
      } catch (IOException e) {
        hScore = new JLabel(" Current High Score:   " + 0);
      }
      

      add(hScore); //new JLabel(" Current High Score:   " + t.getHighScore()));

      add(new JLabel(" "));
      yourScoreText = new JLabel(" Your Final Score: " + 0);

      add(yourScoreText);
      Font displayFont = new Font("Monospaced", Font.BOLD, 16);
      game = t;

     }

     //updates scores
    public void update(ArrayList<Integer> points)
    {
      yourScoreText.setText(" Your Scores: " + points);
    }

    public void gameOver(ArrayList<Integer> points) throws IOException{
      if(points.get(0) > Integer.parseInt(game.getHighScore()) && points.get(0) > points.get(1)){
          yourScoreText.setForeground(Color.BLUE);
          String s = (String)JOptionPane.showInputDialog(this, "You are the new high scorer with " + points.get(0) + " points! Congratulations!\n Enter your name: ", "High Score", JOptionPane.PLAIN_MESSAGE, null, null,"name");
          hScore.setText(" Current High Score:   " + points.get(0));
          
          try {
            File myObj = new File("HighScore.txt");
            // if file not created, write to file
            if (myObj.createNewFile()) {
                writeFile(points.get(0));
            } else {
                // if file created, add to file
                addToFile(points.get(0));
            }
          } catch (IOException e) {
              System.out.println("An error occurred.");
              e.printStackTrace();
          }
        }
        else if(points.get(1) > Integer.parseInt(game.getHighScore()) && points.get(1) > points.get(0)){
          yourScoreText.setForeground(Color.BLUE);
          String s = (String)JOptionPane.showInputDialog(this, "You are the new high scorer with " + points.get(1) + " points! Congratulations!\n Enter your name: ", "High Score", JOptionPane.PLAIN_MESSAGE, null, null,"name");
          hScore.setText(" Current High Score:   " + points.get(1));
          
          try {
            File myObj = new File("HighScore.txt");
            // if file not created, write to file
            if (myObj.createNewFile()) {
                writeFile(points.get(1));
            } else {
                // if file created, add to file
                addToFile(points.get(1));
            }
          } catch (IOException e) {
              System.out.println("An error occurred.");
              e.printStackTrace();
          }
        }
        else {
          yourScoreText.setForeground(Color.BLUE);
          String s = (String)JOptionPane.showInputDialog(this, "You have scores of " + points.get(0) + " and " + points.get(1) + " points! Congratulations!\n Enter your team name: ", "Player Scores", JOptionPane.PLAIN_MESSAGE, null, null,"name");
          hScore.setText(" Current High Score:   " + Integer.parseInt(game.getHighScore()));
        }
      }

    private void writeFile(int p) {
      
      try {
          FileWriter myWriter = new FileWriter("HighScore.txt");
          myWriter.write("" + p);
          myWriter.close();
          
      } catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
      }
  }

  //adds to txt file if it already exists
  private void addToFile(int p) {
      try {
          FileWriter myWriter = new FileWriter("HighScore.txt");
          myWriter.write("" + p);
          myWriter.close();
      } catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
      }
  }
}
