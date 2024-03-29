package Sources.core;

import Sources.core.aiStuff.CellToken;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by djura on 20-Dec-15.
 */
public class AI extends Player{

    private ArrayList<Token> tokens = new ArrayList<>();
    private Color clr;
    private Difficulty dif;
    private Token selected;
    private boolean full = false;

    public AI(Difficulty dif) {
        super();
        this.dif = dif;
        selected = super.getSelected();
        tokens = super.getTokens();
    }

    public CellToken doAction() {
        Cell randomCell = null;
        Token randomToken = null;
        CellToken randomCellToken=null;
        ArrayList<Cell> cells = Frame.getInstance().getBoard().getCells();
        Random r = new Random();
        switch (dif) {
            case EASY:{
                int index = r.nextInt(cells.size());
                while(cells.get(index).hasToken()) index = r.nextInt(cells.size());
                randomCell = cells.get(index);
                index = r.nextInt(tokens.size());
                randomToken = tokens.get(index);
                break;}

            case HARD:{
                int max=0;
                ArrayList<CellToken> cellToken=new ArrayList<>();
                ArrayList<Cell> enemyCells = enemyCells();
                Map<Cell, ArrayList<Cell>> neighborCells = Frame.getInstance().getNeighborCells();
                for(Cell c:enemyCells) {
                    for(Cell nc : neighborCells.get(c)){
                        if(nc!=null)
                            if(!nc.hasToken()){
                                for(Token t:tokens){
                                    proveraZaToken(nc,t);
                                    for(Integer i:t.getBrojpromena()){
                                        if(max<=i){
                                            max=i;
                                            cellToken.add(new CellToken(nc, t, max));
                                        }

                                    }
                                    t.setBrojpromena(new ArrayList<Integer>());
                                    Map<Integer, Cell> map=new HashMap<>();
                                    t.setNumberToOwn(map);
                                }

                            }
                    }
                    max=0;
                }

                for(CellToken ct:cellToken){
                    if(max<=ct.brojOkrenutih)
                        max=ct.brojOkrenutih;
                }
                int zbir=29;
                for(CellToken ct:cellToken){
                    if(ct.brojOkrenutih==max)
                        if(ct.token.getZbir()<zbir){
                            zbir=ct.token.getZbir();
                            randomCellToken=ct;
                }}

                randomCell=randomCellToken.cell;
                randomToken=randomCellToken.token;



                break;}
            case MEDIUM:{
                int max=0;

                ArrayList<Cell> enemyCells = enemyCells();
                Map<Cell, ArrayList<Cell>> neighborCells = Frame.getInstance().getNeighborCells();
                for(Cell c:enemyCells) {
                    for(Cell nc : neighborCells.get(c)){
                        if(nc!=null)
                        if(!nc.hasToken()){
                            for(Token t:tokens){
                                Map numberToOwn=t.getNumberToOwn();
                                proveraZaToken(nc,t);
                                for(Integer i:t.getBrojpromena()){
                                    if(max<=i){
                                        max=i;
                                        randomToken=t;
                                        randomCell=(Cell)numberToOwn.get(max);

                                     }

                                }
                                t.setBrojpromena(new ArrayList<>());
                                Map<Integer, Cell> map=new HashMap<>();
                                t.setNumberToOwn(map);
                             }
                            //System.out.println(""+max);
                        }
                    }
                    max=0;
                }

                break;
            }
        }
        return new CellToken(randomCell,randomToken);
    }

    public void proveraZaToken(Cell c,Token t)
    {
        int i0=0,i1=0,i2=0;
        Map numberToOwn=t.getNumberToOwn();
        ArrayList<Cell> possibleCellsforToken=t.getPossibleCells();
        possibleCellsforToken.add(c);
        Frame frejm = Frame.getInstance();
        int val=0;

        for(TokenField field:t.getTcells()) {
            if (field.getId() == 1) {
                if (c.getIdx() % 2 == 0) {
                    i0 = t.getNiz()[0];

                    if (frejm.getCellById(c.getIdx() - 1, c.getIdy()) != null && frejm.getCellById(c.getIdx() - 1, c.getIdy()).getTok() != null) {
                        i1 = frejm.getCellById(c.getIdx() - 1, c.getIdy()).getTok().getNiz()[1];
                        if (i0 > i1 && i1 != 0)
                            val++;
                    }
                    if (frejm.getCellById(c.getIdx() - 1, c.getIdy() + 1) != null && frejm.getCellById(c.getIdx() - 1, c.getIdy() + 1).getTok() != null) {
                        i2 = frejm.getCellById(c.getIdx() - 1, c.getIdy() + 1).getTok().getNiz()[2];
                        if (i0 > i2 && i2 != 0)
                            val++;
                    }


                } else {
                    i0 = t.getNiz()[0];
                    if (frejm.getCellById(c.getIdx() - 1, c.getIdy() - 1) != null && frejm.getCellById(c.getIdx() - 1, c.getIdy() - 1).getTok() != null) {
                        i1 = frejm.getCellById(c.getIdx() - 1, c.getIdy() - 1).getTok().getNiz()[1];
                        if (i0 > i1 && i1 != 0)
                            val++;
                    }
                    if (frejm.getCellById(c.getIdx() - 1, c.getIdy()) != null && frejm.getCellById(c.getIdx() - 1, c.getIdy()).getTok() != null) {
                        i2 = frejm.getCellById(c.getIdx() - 1, c.getIdy()).getTok().getNiz()[2];

                        if (i0 > i2 && i2 != 0)
                            val++;
                    }

                }
            } else if (field.getId() == 2) {
                if (c.getIdx() % 2 == 0) {
                    i1 = t.getNiz()[1];
                    if (frejm.getCellById(c.getIdx() + 1, c.getIdy() + 1) != null && frejm.getCellById(c.getIdx() + 1, c.getIdy() + 1).getTok() != null) {
                        i0 = frejm.getCellById(c.getIdx() + 1, c.getIdy() + 1).getTok().getNiz()[0];
                        if (i1 > i0 && i0 != 0)
                            val++;

                    }
                    if (frejm.getCellById(c.getIdx(), c.getIdy() + 1) != null && frejm.getCellById(c.getIdx(), c.getIdy() + 1).getTok() != null) {
                        i2 = frejm.getCellById(c.getIdx(), c.getIdy() + 1).getTok().getNiz()[2];
                        if (i1 > i2 && i2 != 0)
                            val++;
                    }

                } else {
                    i1 = t.getNiz()[1];
                    if (frejm.getCellById(c.getIdx() + 1, c.getIdy()) != null && frejm.getCellById(c.getIdx() + 1, c.getIdy()).getTok() != null) {
                        i0 = frejm.getCellById(c.getIdx() + 1, c.getIdy()).getTok().getNiz()[0];

                        if (i1 > i0 && i0 != 0)
                            val++;

                    }
                    if (frejm.getCellById(c.getIdx(), c.getIdy() + 1) != null && frejm.getCellById(c.getIdx(), c.getIdy() + 1).getTok() != null) {
                        i2 = frejm.getCellById(c.getIdx(), c.getIdy() + 1).getTok().getNiz()[2];
                        if (i1 > i2 && i2 != 0)
                            val++;
                    }

                }
            } else if (field.getId() == 3) {
                if (c.getIdx() % 2 == 0) {


                    i2 = t.getNiz()[2];
                    if (frejm.getCellById(c.getIdx() + 1, c.getIdy()) != null && frejm.getCellById(c.getIdx() + 1, c.getIdy()).getTok() != null) {
                        i0 = frejm.getCellById(c.getIdx() + 1, c.getIdy()).getTok().getNiz()[0];
                        if (i2 > i0 && i0 != 0)
                            val++;
                    }
                    if (frejm.getCellById(c.getIdx(), c.getIdy() - 1) != null && frejm.getCellById(c.getIdx(), c.getIdy() - 1).getTok() != null) {
                        i1 = frejm.getCellById(c.getIdx(), c.getIdy() - 1).getTok().getNiz()[1];
                        if (i2 > i1 && i1 != 0)
                            val++;
                    }


                } else {
                    i2 = t.getNiz()[2];
                    if (frejm.getCellById(c.getIdx() + 1, c.getIdy() - 1) != null && frejm.getCellById(c.getIdx() + 1, c.getIdy() - 1).getTok() != null) {
                        i0 = frejm.getCellById(c.getIdx() + 1, c.getIdy() - 1).getTok().getNiz()[0];
                        if (i2 > i0 && i0 != 0)
                            val++;
                    }
                    if (frejm.getCellById(c.getIdx(), c.getIdy() - 1) != null && frejm.getCellById(c.getIdx(), c.getIdy() - 1).getTok() != null) {
                        i1 = frejm.getCellById(c.getIdx(), c.getIdy() - 1).getTok().getNiz()[1];
                        if (i2 > i1 && i1 != 0)
                            val++;
                    }
                }
            }
        }
        Integer number=val;
        t.getBrojpromena().add(val);
        numberToOwn.put(number, c);

    }

    private ArrayList<Cell> enemyCells(){
        ArrayList<Cell> enemyCells = new ArrayList<>();
        for (Cell c : Frame.getInstance().getBoard().getCells()){
            if(c.hasToken())
                if(c.getTok().getOwner()!=this){
                    enemyCells.add(c);
                }
        }
        return enemyCells;
    }

    public void setDif(Difficulty dif) {
        this.dif = dif;
    }

    @Override
    public ArrayList<Token> getTokens() {
        return tokens;
    }

    @Override
    public Color getClr() {
        return clr;
    }

    @Override
    public void setClr(Color clr) {
        this.clr = clr;
    }

    @Override
    public Token getSelected() {
        return selected;
    }

    @Override
    public void setSelected(Token selected) {
        this.selected = selected;
    }
}
