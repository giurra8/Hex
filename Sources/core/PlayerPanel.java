package Sources.core;

import javax.swing.*;

/**
 * Created by djura on 03-Jan-16.
 */
public class PlayerPanel extends JPanel {

    private Player p;

    public PlayerPanel(Player p){

        this.p = p;
        setSize(300, 800);
        setVisible(true);

    }

}
