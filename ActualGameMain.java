import java.awt.*;
import javax.swing.*;

public class ActualGameMain {

    public static void main(String[] args){
        
        System.out.print("Hello World! before frame");
        JFrame arcade = new JFrame("Dessert Detion");
        arcade.setTitle("Dessert Desperation");
        arcade.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.print("before panel!");

        JPanel panel = new UserPanel(600, 450);
        
        Container pane = arcade.getContentPane();
        pane.setLayout(new GridLayout(1, 1));
        pane.add(panel);

        arcade.pack();
        arcade.setVisible(true);
        panel.requestFocus();
    }
}