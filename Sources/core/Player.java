package Sources.core;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Player extends JPanel {

	ArrayList<Token> tokens=new ArrayList<>();
	Token tok1=new Token(50	, 150);

	
	public Player(){
		setPreferredSize(new Dimension(300, 0));
		tokens.add(tok1);
		tok1.makeToken();
		
		
	}

	public ArrayList<Token> getTokens() {
		return tokens;
	}

	public void setTokens(ArrayList<Token> tokens) {
		this.tokens = tokens;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2=(Graphics2D) g;
		for(Token tok:tokens){
			
			tok.drawToken(g2);
		}
		
		
}}
