package Sources.core;

import Sources.listeners.BoardListener;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Board extends JPanel{
	
	private ArrayList<Cell> cells = new ArrayList<>();
	private ArrayList<Cell> check = new ArrayList<>();

	private final float width = 300;
	private int all = 0;

	Cell cell1=new Cell(width, 250,3,1);
	Cell cell2=new Cell(width,250+50*Math.sqrt(3),3,2);
	Cell cell3=new Cell(width,250+2*50*Math.sqrt(3),3,3);
	Cell cell4=new Cell(width,250+3*50*Math.sqrt(3),3,4);
	Cell cell5=new Cell(width+75,250+50*Math.sqrt(3)/2,4,1);
	Cell cell6=new Cell(width+75,250+3*50*Math.sqrt(3)/2,4,2);
	Cell cell7=new Cell(width+75,250+5*50*Math.sqrt(3)/2,4,3);
	Cell cell8=new Cell(width+150,250+50*Math.sqrt(3),5,2);
	Cell cell9=new Cell(width+150,250+2*50*Math.sqrt(3),5,3);
	Cell cell10=new Cell(width-75,250+50*Math.sqrt(3)/2,2,1);
	Cell cell11=new Cell(width-75,250+3*50*Math.sqrt(3)/2,2,2);
	Cell cell12=new Cell(width-75,250+5*50*Math.sqrt(3)/2,2,3);
	Cell cell13=new Cell(width-150,250+50*Math.sqrt(3),1,2);
	Cell cell14=new Cell(width-150,250+2*50*Math.sqrt(3),1,3);
	
	
	
	public Board(){
		cells.add(cell1);
		cells.add(cell2);
		cells.add(cell3);
		cells.add(cell4);
		cells.add(cell5);
		cells.add(cell6);
		cells.add(cell7);
		cells.add(cell8);
		cells.add(cell9);
		cells.add(cell10);
		cells.add(cell11);
		cells.add(cell12);
		cells.add(cell13);
		cells.add(cell14);
		addMouseListener(new BoardListener());
		setBackground(Color.DARK_GRAY);
	}

	public ArrayList<Cell> getCells() {
		return cells;
	}


	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D) g;
		
		for(Cell c:cells){
			c.makeCell();
			c.drawCell(g2);
		}

	}
	
	public boolean isFull(){

		for (Cell c: cells) {
			if (c.hasToken()) {
				if (!check.contains(c)) {
					check.add(c);
					all++;
					//System.out.println(all);
				}
			}
		}
		if (all == 14)
			return true;
		else return false;

	}

}