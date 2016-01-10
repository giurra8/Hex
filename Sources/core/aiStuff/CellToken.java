package Sources.core.aiStuff;

import Sources.core.Cell;
import Sources.core.Token;

/**
 * Created by Neonkitza on 1/8/2016.
 */
public class CellToken {
    public Cell cell;
    public Token token;
    public int brojOkrenutih;

    public CellToken(Cell cell,Token token)
    {
        this.cell = cell;
        this.token = token;
    }

    public CellToken(Cell cell,Token token, int zbir)
    {
        this.cell = cell;
        this.token = token;
        this.brojOkrenutih = zbir;
    }


}
