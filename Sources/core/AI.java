package Sources.core;

import Sources.core.aiStuff.CellToken;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by djura on 20-Dec-15.
 */
public class AI extends Player{

    private ArrayList<Token> tokens = new ArrayList<>();
    private Color clr;
    Difficulty dif;
    private Token selected;

    public AI(Difficulty dif) {
        super();
        this.dif = dif;
        selected = super.getSelected();
        tokens = super.getTokens();
    }

    public CellToken doAction() {
        Cell randomCell = null;
        Token randomToken = null;
        ArrayList<Cell> cells = Frame.getInstance().getBoard().getCells();
        Random r = new Random();
        switch (dif) {
            case EASY:
                int index = r.nextInt(cells.size());
                randomCell = cells.get(index);
                while(randomCell.hasToken()) index = r.nextInt(cells.size());
                index = r.nextInt(tokens.size());
                randomToken = tokens.get(index);
                break;

        }
        CellToken ct = new CellToken(randomCell,randomToken);
        return ct;
    }

    public Difficulty getDif() {
        return dif;
    }

    public void setDif(Difficulty dif) {
        this.dif = dif;
    }

    @Override
    public ArrayList<Token> getTokens() {
        return tokens;
    }

    public void setTokens(ArrayList<Token> tokens) {
        this.tokens = tokens;
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
