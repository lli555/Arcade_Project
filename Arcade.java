import java.awt.*;
import javax.swing.*;

public class Arcade extends JFrame{

    public Arcade(){

        super("Dessert Desperation");

        UserPanel canvas = new UserPanel(600, 400);
        GameStats gs = new GameStats(canvas);
        ControlPanel controls = new ControlPanel(canvas, gs);
        Container c = getContentPane();
        c.add(canvas, BorderLayout.CENTER);
        c.add(controls, BorderLayout.SOUTH);
    }

    public static void main(String[] args)
    {
        Arcade window = new Arcade();
        window.setBounds(100, 100, 400, 400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}