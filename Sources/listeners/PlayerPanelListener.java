package Sources.listeners;

import Sources.core.PlayerPanel;
import Sources.core.Token;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created by djura on 03-Jan-16.
 */
public class PlayerPanelListener implements MouseListener {


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point pos = e.getPoint();
        PlayerPanel pp = (PlayerPanel) e.getSource();
        ArrayList<Token> tok = pp.getP().getTokens();

        for (Token t:tok) {

            if (t.getShape().contains(pos)) {
                pp.getP().setSelected(t);
            }

        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
