package Sources.core;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.Random;

public class Token {

	private Shape shape=new GeneralPath();
	private double x;
	private double y;
	private final double LINE=50;
	private ArrayList<TokenCell> tcells=new ArrayList<>();
	private Player owner;


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

		int[] niz = randomize();

		while(niz==null)
			niz = randomize();

		for(int i=1;i<4;i++){
			TokenCell tc = new TokenCell(x + LINE / 2, y - (LINE / 2 * Math.sqrt(3)), i, niz[i-1]);
			tc.makeTokenCell();
			tcells.add(tc);
		}

	}


	public int[] randomize(){
		int zbir = 0;
		int[] niz = new int[3];

		for(int i=0;i<3;i++){
			Random r = new Random();
			int b=r.nextInt(9)+1;
			niz[i] = b;
			zbir+=b;
		}

		if (zbir>=10 && zbir<30)
			return niz;
		else return null;
	}

public void drawToken(Graphics2D g){
		
		g.setStroke(new BasicStroke(2f));
		g.setPaint(Color.black);
		g.draw(shape);
		for(TokenCell tc: tcells){
			tc.drawTokenCell(g);
		}
	}

public double getX() {
	return x;
}

public void setX(double x) {
	this.x = x;
}

public double getY() {
	return y;
}

public void setY(double y) {
	this.y = y;
}

public ArrayList<TokenCell> getTcells() {
	return tcells;
}

public void setTcells(ArrayList<TokenCell> tcells) {
	this.tcells = tcells;
}



}
