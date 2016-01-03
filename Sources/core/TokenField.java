package Sources.core;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.GeneralPath;

public class TokenField {

	private Shape shape = new GeneralPath();
	private double x;
	private double y;
	private final double LINE = 50;
	private Token parent;
	private int i;
	private int value;

	public TokenField(double x, double y, int i, int a, Token parent) {
		this.x = x;
		this.i = i;
		this.y = y;
		this.value=a;
		this.parent = parent;
	}

	public void makeTokenField() {

		switch (i) {
		case 1: {
			((GeneralPath) shape).moveTo(x, y);
			((GeneralPath)shape).lineTo(x-LINE/2, y+LINE/2*Math.sqrt(3));
			((GeneralPath)shape).lineTo(x-LINE, y);
			((GeneralPath)shape).lineTo(x-LINE/2, y-LINE/2*Math.sqrt(3));
			((GeneralPath)shape).closePath();
		}
		case 2: {
			((GeneralPath) shape).moveTo(x, y);
			((GeneralPath)shape).lineTo(x-LINE/2, y+LINE/2*Math.sqrt(3));
			((GeneralPath)shape).lineTo(x-LINE/2+LINE, y+LINE/2*Math.sqrt(3));
			((GeneralPath)shape).lineTo(x+LINE, y);
			((GeneralPath)shape).closePath();
		}
		case 3: {
			((GeneralPath) shape).moveTo(x, y);
			((GeneralPath)shape).lineTo(x-LINE/2, y-LINE/2*Math.sqrt(3));
			((GeneralPath)shape).lineTo(x-LINE/2+LINE, y-LINE/2*Math.sqrt(3));
			((GeneralPath)shape).lineTo(x+LINE, y);
			((GeneralPath)shape).closePath();
		}
		}

	}

	public void drawTokenField(Graphics2D g) {

		g.setStroke(new BasicStroke(2f));
		g.setPaint(parent.getOwner().getClr());
		g.fill(shape);
		g.setPaint(Color.white);
		g.draw(shape);
		
		g.setPaint(Color.white);
		if(i==1) {
			g.setFont(new Font("TimesRoman", Font.PLAIN, 24)); 
			g.drawString(""+value,(int) ((int) x-LINE/2-14),(int) y+4);
			}
		if(i==2){ 
			g.setFont(new Font("TimesRoman", Font.PLAIN, 20)); 
			g.drawString(""+value, (int) ((int) x+LINE/2-8),(int) (y+LINE/2+13));
			}
		if(i==3){
			g.setFont(new Font("TimesRoman", Font.PLAIN, 20)); 
			g.drawString(""+value, (int)(x+LINE/2)-9,(int)(y-LINE/2));
			
		}
	}

	public int getId() {
		return i;
	}
}
