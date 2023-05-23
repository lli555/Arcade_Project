import java.awt.*;
import javax.swing.*;

public class ActualGameMain extends JFrame{

    public ActualGameMain(){

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
        ActualGameMain window = new ActualGameMain();
        window.setBounds(100, 100, 400, 400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}