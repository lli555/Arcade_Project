// class to store each token and its coordinates
import java.awt.*;
import java.util.ArrayList;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;


public class Cake {
    private BufferedImage img;
    private int x;
    private int y;

    public Cake(int player, int row, int col) {
        img = null;
        // store img path
        if (player == 1) {
            try
            {
                img = ImageIO.read(new File("player1_img.png"));
            }
            catch (IOException e)
            {
                System.out.println("Could not get picture");
            }
        }
        else if (player == 2) {
            try
            {
                img = ImageIO.read(new File("player2_img.png"));
            }
            catch (IOException e)
            {
                System.out.println("Could not get picture");
            }
        }


        // store starting x and y coordinates
        x = col * 15 + 5;
        y = row * 15 + 5;
    }

    public void draw(Graphics g){
        g.drawImage(img, x, y, null);
    }
}