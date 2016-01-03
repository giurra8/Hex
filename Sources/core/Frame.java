package Sources.core;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Frame extends JFrame {
	
	private Board board=new Board();
	private Player play1=new Player();
	private Player play2=new Player();
	private PlayerPanel pan1;
	private PlayerPanel pan2;
	private Map<Cell,ArrayList<Cell>> neighborCells = new HashMap<>();
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
		play2.setClr(Color.PINK);
		pan1 = new PlayerPanel(play1);
		pan2 = new PlayerPanel(play2);
		pan1.setBackground(play1.getClr());
		add(board, BorderLayout.CENTER);
		add(pan1, BorderLayout.WEST);
		add(pan2, BorderLayout.EAST);
		fillNeighbors();


		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}


	public Board getBoard() {
		return board;
	}


	public Player getPlay1() {
		return play1;
	}


	public Player getPlay2() {
		return play2;
	}
	
	public void switchPlaya()
	{
		if(currentPlaya==play1)
		{
			pan1.setBackground(UIManager.getColor ( "Panel.background" ));
			pan2.setBackground(play2.getClr());
			pan1.repaint();
			pan2.repaint();
			currentPlaya=play2;
		}
		else
		{
			pan1.setBackground(play1.getClr());
			pan2.setBackground(UIManager.getColor ( "Panel.background" ));
			pan1.repaint();
			pan2.repaint();
			currentPlaya=play1;
		}
	}

	public void fillNeighbors()
	{
		ArrayList<Cell> cells = board.getCells();
		ArrayList<Cell> celovi;
		for(Cell c:cells)
		{
			celovi = new ArrayList<>();
			if(c.getIdx()%2==0)
			{
				celovi.add(getCellById(c.getIdx(),c.getIdy()-1));
				celovi.add(getCellById(c.getIdx(),c.getIdy()+1));
				celovi.add(getCellById(c.getIdx()-1,c.getIdy()));
				celovi.add(getCellById(c.getIdx()-1,c.getIdy()+1));
				celovi.add(getCellById(c.getIdx()+1,c.getIdy()));
				celovi.add(getCellById(c.getIdx()+1,c.getIdy()+1));
			}
			else
			{
				celovi.add(getCellById(c.getIdx(),c.getIdy()-1));
				celovi.add(getCellById(c.getIdx(),c.getIdy()+1));
				celovi.add(getCellById(c.getIdx()-1,c.getIdy()));
				celovi.add(getCellById(c.getIdx()-1,c.getIdy()-1));
				celovi.add(getCellById(c.getIdx()+1,c.getIdy()));
				celovi.add(getCellById(c.getIdx()+1,c.getIdy()-1));
			}
			neighborCells.put(c,celovi);
		}
	}

	public Cell getCellById(int idx,int idy)
	{
		ArrayList<Cell> cells = board.getCells();
		for(Cell c: cells)
		{
			if(c.getIdx()==idx && c.getIdy()==idy)
				return c;
		}
		return null;

	}

	public Map<Cell, ArrayList<Cell>> getNeighborCells() {
		return neighborCells;
	}
}
