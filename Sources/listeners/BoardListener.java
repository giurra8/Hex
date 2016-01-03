package Sources.listeners;

import Sources.core.Cell;
import Sources.core.Frame;
import Sources.core.Player;
import Sources.core.Token;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created by djura on 03-Jan-16.
 */
public class BoardListener implements MouseListener {


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        Player p = Frame.getInstance().getCurrentPlaya();
        Token t = p.getSelected();
        Point pos = e.getPoint();
        ArrayList<Cell> cells = Frame.getInstance().getBoard().getCells();
        for(Cell c: cells){
            if(c.getShape().contains(pos)){
                if(c.getTok()==null){
                    p.getTokens().remove(t);
                    t.setX(c.getX());
                    t.setY(c.getY());
                    t.remakeToken();
                    c.setTok(t);

                }
            }
        }
        Frame.getInstance().repaint();
        //ovo treba odkomentarisati
        //Frame.getInstance().switchPlaya();

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
