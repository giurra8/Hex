package Sources.gui;

import javax.swing.*;

/**
 * Created by djura on 16-Dec-15.
 */
public class Frame extends JFrame {

    private ImageIcon icon = null;

    public Frame(){

        try{
            icon = new ImageIcon(getClass().getResource("resources/hexagon-icon.png"));
        } catch(Exception e){
            e.printStackTrace();
        }

        setTitle("Hex");
        //setIconImage(icon);
        setSize(800, 600);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
