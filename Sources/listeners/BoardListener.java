package Sources.listeners;

import Sources.core.*;
import Sources.core.Frame;
import Sources.core.aiStuff.CellToken;

import javax.swing.*;
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
        Frame frejm = Frame.getInstance();
        int i1=0,i2=0,i0=0;
        Token t = p.getSelected();
        if(t==null) JOptionPane.showMessageDialog(frejm, "Nije selektovan dobar token");
        else if(t.getOwner()!=frejm.getCurrentPlaya()) {
            JOptionPane.showMessageDialog(frejm, "Pogresan igrac");
        }
        else
        {
            Point pos = e.getPoint();
            ArrayList<Cell> cells = Frame.getInstance().getBoard().getCells();
            for (Cell c : cells) {
                if (c.getShape().contains(pos)) {
                    if (c.getTok() == null) {
                        for (TokenField field : t.getTcells()) {
                            provera(field,c,t);
                        }
                        p.getTokens().remove(t);
                        t.setX(c.getX());
                        t.setY(c.getY());
                        t.remakeToken();
                        t.setOwnerCell(c);
                        c.setTok(t);


                    }
                }
            }
            p.setSelected(null);

            //Frame.getInstance().switchPlaya();
            CellToken ct = frejm.getBot().doAction();

            for (TokenField field : t.getTcells()) {
                provera(field,ct.cell,ct.token);
            }
            frejm.getBot().getTokens().remove(ct.token);

            ct.token.setX(ct.cell.getX());
            ct.token.setY(ct.cell.getY());
            ct.token.remakeToken();
            for(Cell c:cells)
            {
                if(c==ct.cell)
                {
                    ct.token.setOwnerCell(c);
                    c.setTok(ct.token);
                }
            }

            Frame.getInstance().repaint();

        }

    }
    public void provera(TokenField field,Cell c,Token t)
    {
        int i0=0,i1=0,i2=0;
        Frame frejm = Frame.getInstance();
        if (field.getId() == 1) {
            if (c.getIdx() % 2 == 0) {
                i0 = t.getNiz()[0];

                if (frejm.getCellById(c.getIdx() - 1, c.getIdy()) != null && frejm.getCellById(c.getIdx() - 1, c.getIdy()).getTok() != null) {
                    i1 = frejm.getCellById(c.getIdx() - 1, c.getIdy()).getTok().getNiz()[1];
                    if (i0 > i1 && i1 != 0) {
                        frejm.getCellById(c.getIdx() - 1, c.getIdy()).getTok().setOwner(t.getOwner());
                    }
                }
                if (frejm.getCellById(c.getIdx() - 1, c.getIdy() + 1) != null && frejm.getCellById(c.getIdx() - 1, c.getIdy() + 1).getTok() != null) {
                    i2 = frejm.getCellById(c.getIdx() - 1, c.getIdy() + 1).getTok().getNiz()[2];
                    if (i0 > i2 && i2 != 0) {
                        frejm.getCellById(c.getIdx() - 1, c.getIdy() + 1).getTok().setOwner(t.getOwner());
                    }
                }


            } else {
                i0 = t.getNiz()[0];
                if (frejm.getCellById(c.getIdx() - 1, c.getIdy() - 1) != null && frejm.getCellById(c.getIdx() - 1, c.getIdy() - 1).getTok() != null) {
                    i1 = frejm.getCellById(c.getIdx() - 1, c.getIdy() - 1).getTok().getNiz()[1];
                    if (i0 > i1 && i1 != 0) {
                        frejm.getCellById(c.getIdx() - 1, c.getIdy() - 1).getTok().setOwner(t.getOwner());
                    }
                }
                if (frejm.getCellById(c.getIdx() - 1, c.getIdy()) != null && frejm.getCellById(c.getIdx() - 1, c.getIdy()).getTok() != null) {
                    i2 = frejm.getCellById(c.getIdx() - 1, c.getIdy()).getTok().getNiz()[2];

                    if (i0 > i2 && i2 != 0) {
                        frejm.getCellById(c.getIdx() - 1, c.getIdy()).getTok().setOwner(t.getOwner());
                    }
                }

            }
        } else if (field.getId() == 2) {
            if (c.getIdx() % 2 == 0) {
                i1 = t.getNiz()[1];
                if (frejm.getCellById(c.getIdx() + 1, c.getIdy() + 1) != null && frejm.getCellById(c.getIdx() + 1, c.getIdy() + 1).getTok() != null) {
                    i0 = frejm.getCellById(c.getIdx() + 1, c.getIdy() + 1).getTok().getNiz()[0];
                    if (i1 > i0 && i0 != 0) {
                        frejm.getCellById(c.getIdx() + 1, c.getIdy() + 1).getTok().setOwner(t.getOwner());
                    }
                }
                if (frejm.getCellById(c.getIdx(), c.getIdy() + 1) != null && frejm.getCellById(c.getIdx(), c.getIdy() + 1).getTok() != null) {
                    i2 = frejm.getCellById(c.getIdx(), c.getIdy() + 1).getTok().getNiz()[2];
                    if (i1 > i2 && i2 != 0) {
                        frejm.getCellById(c.getIdx(), c.getIdy() + 1).getTok().setOwner(t.getOwner());
                    }
                }

            } else {
                i1 = t.getNiz()[1];
                if (frejm.getCellById(c.getIdx() + 1, c.getIdy()) != null && frejm.getCellById(c.getIdx() + 1, c.getIdy()).getTok() != null) {
                    i0 = frejm.getCellById(c.getIdx() + 1, c.getIdy()).getTok().getNiz()[0];

                    if (i1 > i0 && i0 != 0) {
                        frejm.getCellById(c.getIdx() + 1, c.getIdy()).getTok().setOwner(t.getOwner());
                    }
                }
                if (frejm.getCellById(c.getIdx(), c.getIdy() + 1) != null && frejm.getCellById(c.getIdx(), c.getIdy() + 1).getTok() != null) {
                    i2 = frejm.getCellById(c.getIdx(), c.getIdy() + 1).getTok().getNiz()[2];
                    if (i1 > i2 && i2 != 0) {
                        frejm.getCellById(c.getIdx(), c.getIdy() + 1).getTok().setOwner(t.getOwner());
                    }
                }

            }
        } else if (field.getId() == 3) {
            if (c.getIdx() % 2 == 0) {


                i2 = t.getNiz()[2];
                if (frejm.getCellById(c.getIdx() + 1, c.getIdy()) != null && frejm.getCellById(c.getIdx() + 1, c.getIdy()).getTok() != null) {
                    i0 = frejm.getCellById(c.getIdx() + 1, c.getIdy()).getTok().getNiz()[0];
                    if (i2 > i0 && i0 != 0) {
                        frejm.getCellById(c.getIdx() + 1, c.getIdy()).getTok().setOwner(t.getOwner());
                    }
                }
                if (frejm.getCellById(c.getIdx(), c.getIdy() - 1) != null && frejm.getCellById(c.getIdx(), c.getIdy() - 1).getTok() != null) {
                    i1 = frejm.getCellById(c.getIdx(), c.getIdy() - 1).getTok().getNiz()[1];
                    if (i2 > i1 && i1 != 0) {
                        frejm.getCellById(c.getIdx(), c.getIdy() - 1).getTok().setOwner(t.getOwner());
                    }
                }


            } else {
                i2 = t.getNiz()[2];
                if (frejm.getCellById(c.getIdx() + 1, c.getIdy() - 1) != null && frejm.getCellById(c.getIdx() + 1, c.getIdy() - 1).getTok() != null) {
                    i0 = frejm.getCellById(c.getIdx() + 1, c.getIdy() - 1).getTok().getNiz()[0];
                    if (i2 > i0 && i0 != 0) {
                        frejm.getCellById(c.getIdx() + 1, c.getIdy() - 1).getTok().setOwner(t.getOwner());
                    }
                }
                if (frejm.getCellById(c.getIdx(), c.getIdy() - 1) != null && frejm.getCellById(c.getIdx(), c.getIdy() - 1).getTok() != null) {
                    i1 = frejm.getCellById(c.getIdx(), c.getIdy() - 1).getTok().getNiz()[1];
                    if (i2 > i1 && i1 != 0) {
                        frejm.getCellById(c.getIdx(), c.getIdy() - 1).getTok().setOwner(t.getOwner());
                    }
                }
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
