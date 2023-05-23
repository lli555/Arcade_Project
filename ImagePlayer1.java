/**
 * Player1 that is using an image
 * @version 1.00 2016/2/7
 */
import java.awt.*;
import java.util.ArrayList;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;



public class Player1Image extends Player1{

  	private BufferedImage img;

   
    public Player1Image() {     
    	img = null;
        try
        {
            img = ImageIO.read(new File("player1_img.png"));
        }
        catch (IOException e)
        {
        	System.out.println("Could not get picture");
        }
    }
   
    public void draw(Graphics g){
      g.drawImage(img, getX(), getY(), null);       
    }  
}
 