package Sources.core;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Frame extends JFrame {
	
	private Board board=new Board();
	private Player1 play1=new Player1();	
	private Player2 play2=new Player2();
	private PlayerPanel pan1 = new PlayerPanel(play1);
	private PlayerPanel pan2 = new PlayerPanel(play2);

	private static Frame instance;
	private Player currentPlaya=play1;
	private BufferedImage icon = null;
	
	public synchronized static Frame getInstance() {

		if (instance == null) {

			instance = new Frame();
			
		}
		return instance;
	}

	
	
	public Player getCurrentPlaya() {
		return currentPlaya;
	}



	public void setCurrentPlaya(Player currentPlaya) {
		this.currentPlaya = currentPlaya;
	}



	public Frame(){

		try{
			icon = ImageIO.read(getClass().getResource("/hexagon-icon.png"));
		} catch(Exception e){
			e.printStackTrace();
		}

		setTitle("Hex");
		setIconImage(icon);
		setSize(1300,800);
		//setLocation(450, 100);

		setLocationRelativeTo(null);

		play1.setClr(Color.DARK_GRAY);
		play2.setClr(Color.ORANGE);

		add(board, BorderLayout.CENTER);
		add(pan1, BorderLayout.WEST);
		add(pan2, BorderLayout.EAST);


		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}


	public Board getBoard() {
		return board;
	}


	public Player1 getPlay1() {
		return play1;
	}


	public Player2 getPlay2() {
		return play2;
	}
	
	
}
