package Sources.core;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Token {

	private Shape shape=new GeneralPath();
	private double x;
	private double y;
	private final double LINE = 50;
	private ArrayList<TokenField> tcells=new ArrayList<>();
	private Player owner;
	private int[] niz;
	private Cell ownerCell;
	private ArrayList<Cell> possibleCells=new ArrayList<>();
	private ArrayList<Integer>  brojpromena=new ArrayList<>();
	private Map<Integer, Cell>  numberToOwn=new HashMap<>();
	private int zbir=0;

	public Token(double x, double y){
		this.x=x;
		this.y=y;		
	}
	
	public void makeToken(){
		((GeneralPath)shape).moveTo(x, y);
		((GeneralPath)shape).lineTo(x-LINE/2, y-(LINE/2*Math.sqrt(3)));
		((GeneralPath)shape).lineTo(x, y-LINE*Math.sqrt(3));
		((GeneralPath)shape).lineTo(x+LINE, y-LINE*Math.sqrt(3));
		((GeneralPath)shape).lineTo(x+1.5*LINE, y-LINE/2*Math.sqrt(3));
		((GeneralPath)shape).lineTo(x+LINE, y);
		((GeneralPath)shape).closePath();

		niz = randomize();

		while(niz==null)
			niz = randomize();

		newToken();

	}
	public void remakeToken(){
		shape = new GeneralPath();
		((GeneralPath)shape).moveTo(x, y);
		((GeneralPath)shape).lineTo(x-LINE/2, y-(LINE/2*Math.sqrt(3)));
		((GeneralPath)shape).lineTo(x, y-LINE*Math.sqrt(3));
		((GeneralPath)shape).lineTo(x+LINE, y-LINE*Math.sqrt(3));
		((GeneralPath)shape).lineTo(x+1.5*LINE, y-LINE/2*Math.sqrt(3));
		((GeneralPath)shape).lineTo(x+LINE, y);
		((GeneralPath)shape).closePath();
		tcells.clear();
		zbir=0;

		newToken();

	}

	public void newToken(){

		for(int i=1;i<4;i++){
			TokenField tc = new TokenField(x + LINE / 2, y - (LINE / 2 * Math.sqrt(3)), i, niz[i-1],this);
			tc.makeTokenField();
			zbir+=tc.getValue();
			tcells.add(tc);
		}

	}

	public int[] randomize() {
		int zbir = 0;
		niz = new int[3];
		for (int i = 0; i < 3; i++) {
			Random r = new Random();
			int b = r.nextInt(10) + 1;
			niz[i] = b;
			zbir += b;
		}

		if (niz[0] != niz[1] || niz[0] != niz[2]) {
			if (zbir >= 10 && zbir < 30)
				return niz;
			else return null;
		}
		else return null;
	}

public void drawToken(Graphics2D g){
		
		g.setStroke(new BasicStroke(4f));
		g.setPaint(Color.black);
		g.draw(shape);
		for(TokenField tc: tcells){
			tc.drawTokenField(g);
		}
	}

	public void setOwnerCell(Cell ownerCell) {
		this.ownerCell = ownerCell;
	}

	public ArrayList<Integer> getBrojpromena() {
		return brojpromena;
	}

	public void setBrojpromena(ArrayList<Integer> brojpromena) {
		this.brojpromena = brojpromena;
	}

	public void setNumberToOwn(Map<Integer, Cell> numberToOwn) {
		this.numberToOwn = numberToOwn;
	}

	public int[] getNiz() {
		return niz;
	}

	public Shape getShape() {
		return shape;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public void setX(double x) {
	this.x = x;
	}

	public void setY(double y) {
	this.y = y;
	}

	public ArrayList<TokenField> getTcells() {
	return tcells;
	}

	public Map<Integer, Cell> getNumberToOwn() {
		return numberToOwn;
	}

	public int getZbir() {
		return zbir;
	}

	public ArrayList<Cell> getPossibleCells() {
		return possibleCells;
	}

}
