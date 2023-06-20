// class to store each token and its coordinates
import java.awt.*;
import java.util.ArrayList;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.security.auth.x500.X500PrivateCredential;

import java.io.IOException;


public class Cake {
    private Image img;
    private int x;
    private int y;
    private int player;

    // GETTERS
    public int getPlayer(){
        return player;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public Image getImage(){
        return img;
    }

    // CONSTRUCTOR
    public Cake(int player, int row, int col) {
        //initialize
        img = null;
        this.player = player;

        // store starting x and y coordinates
        x = 397 + col * 50 + col*6;
        y = 140 + row * 50 + row*6;

        // store img path
        if (player == 1) {
            try
            {
                img = ImageIO.read(new File("player1_img.png"));
                //img = img.getScaledInstance(45, 45,Image.SCALE_DEFAULT);
                // img = ImageIO.read(new File("player1_img.png"));
                // img = (BufferedImage) img.getScaledInstance(45, 45, Image.SCALE_DEFAULT);

            }
            catch (IOException e)
            {
                e.printStackTrace();
                System.out.println("Could not get picture");
            }
        }
        else if (player == 2) {
            try
            {
                img = ImageIO.read(new File("player2_img.png"));
                //img = img.getScaledInstance(45, 45,Image.SCALE_DEFAULT);
            }
            catch (IOException e)
            {
                e.printStackTrace();
                System.out.println("Could not get picture");
            }
        }
    }
}