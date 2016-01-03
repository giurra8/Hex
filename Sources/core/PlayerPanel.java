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
        setBackground(Color.blue);
        setVisible(true);
        addMouseListener(new PlayerPanelListener());

    }


    public Player getP() {
        return p;
    }

    public void setP(Player p) {
        this.p = p;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Token tok : p.getTokens()) {

            tok.drawToken(g2);

        }
    }

}
