package Sources.core;

import java.awt.*;
import java.util.ArrayList;


public class Player {

	private ArrayList<Token> tokens=new ArrayList<>();
	//Token tok1=new Token(50	, 150);
	private String name;
	private Color clr;
	
	public Player(){

		for (int i=0;i<7;i++) {
			Token tk = new Token(50	, 100+i*100);
			tk.makeToken();
			tokens.add(tk);
		}
		//tokens.add(tok1);
		//tok1.makeToken();

	}


	public void setName(String name){

		this.name = name;
	}

	public void setClr(Color clr){

		this.clr = clr;

	}


	public ArrayList<Token> getTokens() {
		return tokens;
	}

	public void setTokens(ArrayList<Token> tokens) {

		this.tokens = tokens;
	}

//	@Override
//	public void paintComponent(Graphics g) {
//		super.paintComponents(g);
//		Graphics2D g2 = (Graphics2D) g;
//		for (Token tok : tokens) {
//
//			tok.drawToken(g2);
//		}
//	}
		
}
