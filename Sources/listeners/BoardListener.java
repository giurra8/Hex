package Sources.listeners;

import Sources.core.*;
import Sources.core.Frame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Map;

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
        Map map = Frame.getInstance().getNeighborCells();
        ArrayList<Cell> komsije;

        int i1=0,i2=0,i0=0;

        Token t = p.getSelected();
        Point pos = e.getPoint();
        ArrayList<Cell> cells = Frame.getInstance().getBoard().getCells();
        for(Cell c: cells){
            if(c.getShape().contains(pos)){
                if(c.getTok()==null){
                    for(TokenField field : t.getTcells())
                    {
                        if(field.getId()==1)
                        {
                            if(c.getIdx()%2==0)
                            {
                                i0 = t.getNiz()[0];

                                if(frejm.getCellById(c.getIdx()-1,c.getIdy()).getTok()!=null) {
                                    i1 = frejm.getCellById(c.getIdx() - 1, c.getIdy()).getTok().getNiz()[1];
                                }
                                if(frejm.getCellById(c.getIdx()-1,c.getIdy()+1).getTok()!=null) {
                                    i2 = frejm.getCellById(c.getIdx() - 1, c.getIdy() + 1).getTok().getNiz()[2];
                                }

                                if(i0>i1)
                                {
                                    frejm.getCellById(c.getIdx()-1,c.getIdy()).getTok().setOwner(t.getOwner());
                                }
                                if(i0>i2)
                                {
                                    frejm.getCellById(c.getIdx()-1,c.getIdy()+1).getTok().setOwner(t.getOwner());
                                }

                            }
                            else
                            {
                                i0 = t.getNiz()[0];
                                if(frejm.getCellById(c.getIdx()-1,c.getIdy()-1).getTok()!=null){
                                    i1 = frejm.getCellById(c.getIdx()-1,c.getIdy()-1).getTok().getNiz()[1];
                                }
                                if(frejm.getCellById(c.getIdx()-1,c.getIdy()).getTok()!=null) {
                                    i2 = frejm.getCellById(c.getIdx() - 1, c.getIdy()).getTok().getNiz()[2];
                                }

                                if(i0>i1)
                                {
                                    frejm.getCellById(c.getIdx()-1,c.getIdy()-1).getTok().setOwner(t.getOwner());
                                }
                                if(i0>i2)
                                {
                                    frejm.getCellById(c.getIdx()-1,c.getIdy()).getTok().setOwner(t.getOwner());
                                }
                            }
                        }
                        else if(field.getId()==2)
                        {
                            if(c.getIdx()%2==0)
                            {
                                i0 = frejm.getCellById(c.getIdx()+1,c.getIdy()).getTok().getNiz()[0];
                                i1 = t.getNiz()[1];
                                i2 = frejm.getCellById(c.getIdx(),c.getIdy()+1).getTok().getNiz()[2];

                                if(i0>i1)
                                {
                                    frejm.getCellById(c.getIdx()-1,c.getIdy()).getTok().setOwner(t.getOwner());
                                }
                                if(i0>i2)
                                {
                                    frejm.getCellById(c.getIdx()-1,c.getIdy()+1).getTok().setOwner(t.getOwner());
                                }

                            }
                            else
                            {
                                i0 = frejm.getCellById(c.getIdx()+1,c.getIdy()+1).getTok().getNiz()[0];
                                i1 = t.getNiz()[1];
                                i2 = frejm.getCellById(c.getIdx(),c.getIdy()+1).getTok().getNiz()[2];

                                if(i0>i1)
                                {
                                    frejm.getCellById(c.getIdx()-1,c.getIdy()-1).getTok().setOwner(t.getOwner());
                                }
                                if(i0>i2)
                                {
                                    frejm.getCellById(c.getIdx()-1,c.getIdy()).getTok().setOwner(t.getOwner());
                                }
                            }
                        }
                        else if(field.getId()==3)
                        {
                            if(c.getIdx()%2==0)
                            {
                                i0 = frejm.getCellById(c.getIdx()+1,c.getIdy()).getTok().getNiz()[0];
                                i1 = frejm.getCellById(c.getIdx(),c.getIdy()-1).getTok().getNiz()[1];
                                i2 = t.getNiz()[2];

                                if(i0>i1)
                                {
                                    frejm.getCellById(c.getIdx()-1,c.getIdy()).getTok().setOwner(t.getOwner());
                                }
                                if(i0>i2)
                                {
                                    frejm.getCellById(c.getIdx()-1,c.getIdy()+1).getTok().setOwner(t.getOwner());
                                }

                            }
                            else
                            {
                                i0 = frejm.getCellById(c.getIdx()+1,c.getIdy()-1).getTok().getNiz()[0];
                                i1 = frejm.getCellById(c.getIdx(),c.getIdy()-1).getTok().getNiz()[1];
                                i2 = t.getNiz()[2];

                                if(i0>i1)
                                {
                                    frejm.getCellById(c.getIdx()-1,c.getIdy()-1).getTok().setOwner(t.getOwner());
                                }
                                if(i0>i2)
                                {
                                    frejm.getCellById(c.getIdx()-1,c.getIdy()).getTok().setOwner(t.getOwner());
                                }
                            }
                        }
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
        Frame.getInstance().repaint();
        //ovo treba odkomentarisati
        Frame.getInstance().switchPlaya();

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
