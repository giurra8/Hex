package Sources.core;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.GeneralPath;

public class Cell {
	
	private Shape shape=new GeneralPath();
	private double x;
	private double y;
	private final double  LINE = 50;
	private Token tok = null;
	private boolean hasToken = false;
	private int idx,idy;
	public Cell(double x, double y, int idx,int idy){
		this.x=x;
		this.y=y;
		this.idx=idx;
		this.idy=idy;

	}

	public void makeCell(){
		((GeneralPath)shape).moveTo(x, y);
		((GeneralPath)shape).lineTo(x-LINE/2, y-(LINE/2*Math.sqrt(3)));
		((GeneralPath)shape).lineTo(x, y-LINE*Math.sqrt(3));
		((GeneralPath)shape).lineTo(x+LINE, y-LINE*Math.sqrt(3));
		((GeneralPath)shape).lineTo(x+1.5*LINE, y-LINE/2*Math.sqrt(3));
		((GeneralPath)shape).lineTo(x+LINE, y);
		((GeneralPath)shape).closePath();
	}
	
	
	

	public void drawCell(Graphics2D g){
		
		g.setStroke(new BasicStroke(2f));
		g.setPaint(Color.black);
		g.draw(shape);
		if(hasToken) {

			getTok().drawToken(g);
			
		}

		
	}
	
	
	
	
	public boolean hasToken() {
		return hasToken;
	}

	public void setHasToken(boolean hasToken) {
		this.hasToken = hasToken;
	}

	public Token getTok() {
		return tok;
	}

	public void setTok(Token tok) {
		if (tok!=null)
			setHasToken(true);
		this.tok = tok;
	}

	public Shape getShape() {
		return shape;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public int getIdx() {
		return idx;
	}

	public int getIdy() {
		return idy;
	}

}
