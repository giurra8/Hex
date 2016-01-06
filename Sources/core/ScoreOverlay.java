package Sources.core;

import javax.swing.*;
import java.awt.*;

/**
 * Created by djura on 06-Jan-16.
 */
public class ScoreOverlay extends JPanel {

    private JTextField tf1 = new JTextField(5);
    private JTextField tf2 = new JTextField(5);


    public ScoreOverlay(){

        setLayout(new GridLayout(1, 2));

        setPreferredSize(new Dimension(100, 100));
        tf1.setVisible(true);
        tf1.setEditable(false);
        tf1.setPreferredSize(new Dimension(50, 50));

        tf2.setVisible(true);
        tf2.setEditable(false);
        tf2.setPreferredSize(new Dimension(50, 50));

        add(tf1);
        add(tf2);


        setVisible(true);
    }

}
