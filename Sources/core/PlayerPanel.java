package Sources.core;

import Sources.listeners.PlayerPanelListener;

import javax.swing.*;
import java.awt.*;

/**
 * Created by djura on 03-Jan-16.
 */
public class PlayerPanel extends JPanel {

    private Player p;

    public PlayerPanel(Player p){
        this.p = p;
        setPreferredSize(new Dimension(300, 800));

        setVisible(true);
        addMouseListener(new PlayerPanelListener());

    }


    public Player getP() {
        return p;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Token tok : p.getTokens()) {

            tok.drawToken(g2);

        }
    }

}
