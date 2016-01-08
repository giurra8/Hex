package Sources.core;

import Sources.listeners.DifficultyListener;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Frame extends JFrame {
	
	private Board board = new Board();
	private Player play1 = new Player();
	private Player play2 = new Player();
	private AI bot;
	private Difficulty dif;
	private PlayerPanel pan1;
	private PlayerPanel pan2;
	private PlayerPanel botpan;
	private Map<Cell,ArrayList<Cell>> neighborCells = new HashMap<>();
	private static Frame instance;
	private Player currentPlaya = play1;
	private BufferedImage icon = null;
	private JMenuBar mb = new JMenuBar();
	private JMenu menu = new JMenu("Options");
	private JMenu i = new JMenu("Difficulty");
	private JMenuItem e = new JMenuItem("Easy");
	private JMenuItem m = new JMenuItem("Medium");
	private JMenuItem h = new JMenuItem("Hard");
	private ScoreOverlay over = new ScoreOverlay();

	public synchronized static Frame getInstance() {

		if (instance == null) {

			instance = new Frame();
			
		}
		return instance;
	}


	public AI getBot() {
		return bot;
	}

	public void setBot(AI bot) {
		this.bot = bot;
		play2 = bot;
	}

	public void setPlay2(Player play2) {
		this.play2 = play2;
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

		setLocationRelativeTo(null);

		mb.add(menu);
		menu.add(i);
		i.add(e);
		i.add(m);
		i.add(h);
		setJMenuBar(mb);

		bot = new AI(Difficulty.EASY);
		bot.setClr(Color.BLACK);

		play1.setClr(Color.GRAY);
		//play2.setClr(Color.BLACK);
		pan1 = new PlayerPanel(play1);
		pan2 = new PlayerPanel(bot);
		pan1.setBackground(play1.getClr());
		add(board, BorderLayout.CENTER);
		add(pan1, BorderLayout.WEST);
		add(pan2, BorderLayout.EAST);
		fillNeighbors();

		e.addMouseListener(new DifficultyListener(Difficulty.EASY));
		m.addMouseListener(new DifficultyListener(Difficulty.MEDIUM));
		h.addMouseListener(new DifficultyListener(Difficulty.HARD));


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

	public Difficulty getDif() {
		return dif;
	}

	public void setDif(Difficulty dif) {
		this.dif = dif;
	}

	public Cell getCellById(int idx, int idy)
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
