package Sources.core;

import java.awt.*;
import java.util.ArrayList;


public class Player {

	private ArrayList<Token> tokens=new ArrayList<>();
	//Token tok1=new Token(50	, 150);
	private Color clr;
	private Token selected;

	public Player(){

		for (int i=0;i<7;i++) {
			Token tk = new Token(50	, 100+i*100);
			tk.makeToken();
			tk.setOwner(this);
			tokens.add(tk);

		}

	}


	public void setClr(Color clr){

		this.clr = clr;

	}


	public Token getSelected() {
		return selected;
	}

	public void setSelected(Token selected) {
		this.selected = selected;
	}

	public ArrayList<Token> getTokens() {
		return tokens;
	}

	public Color getClr() {
		return clr;
	}
}
