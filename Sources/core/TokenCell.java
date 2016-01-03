package Sources.core;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.GeneralPath;

public class TokenCell {

	Shape shape = new GeneralPath();
	double x;
	double y;
	final double LINE = 50;
	int i;
	int value;

	public TokenCell(double x, double y, int i, int a) {
		this.x = x;
		this.i = i;
		this.y = y;
		this.value=a;
	}

	public void makeTokenCell() {

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

	public void drawTokenCell(Graphics2D g) {

		g.setStroke(new BasicStroke(2f));
		g.setPaint(Color.black);
		g.draw(shape);
		
		
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

}
