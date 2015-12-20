package Sources.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;

/**
 * Created by djura on 16-Dec-15.
 */
public class Frame extends JFrame {

    private BufferedImage icon = null;

    public Frame(){

        try{
            icon = ImageIO.read(getClass().getResource("/hexagon-icon.png"));
        } catch(Exception e){
            e.printStackTrace();
        }

        setTitle("Hex");
        setIconImage(icon);
        setSize(800, 600);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

}
