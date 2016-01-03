package Sources.core;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Frame extends JFrame {
	
	private Board board=new Board();
	private Player1 play1=new Player1();	
	private Player2 play2=new Player2();
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

		//setLocation(450, 100);
		setVisible(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1300,800);
		setLocationRelativeTo(null);
		add(board, BorderLayout.CENTER);
		add(play1, BorderLayout.WEST);
		add(play2, BorderLayout.EAST);
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
