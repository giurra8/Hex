package Sources.core;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Board extends JPanel{
	
	ArrayList<Cell> cells=new ArrayList<>();
	final float width=300;
	Cell cell1=new Cell(width, 250);
	Cell cell2=new Cell(width,250+50*Math.sqrt(3));
	Cell cell3=new Cell(width,250+2*50*Math.sqrt(3));
	Cell cell4=new Cell(width,250+3*50*Math.sqrt(3));
	Cell cell5=new Cell(width+75,250+50*Math.sqrt(3)/2);
	Cell cell6=new Cell(width+75,250+3*50*Math.sqrt(3)/2);
	Cell cell7=new Cell(width+75,250+5*50*Math.sqrt(3)/2);
	Cell cell8=new Cell(width+150,250+50*Math.sqrt(3));
	Cell cell9=new Cell(width+150,250+2*50*Math.sqrt(3));
	Cell cell10=new Cell(width-75,250+50*Math.sqrt(3)/2);
	Cell cell11=new Cell(width-75,250+3*50*Math.sqrt(3)/2);
	Cell cell12=new Cell(width-75,250+5*50*Math.sqrt(3)/2);
	Cell cell13=new Cell(width-150,250+50*Math.sqrt(3));
	Cell cell14=new Cell(width-150,250+2*50*Math.sqrt(3));
	//Token tok=new Token(width,150);
	
	
	
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
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				Point p=e.getPoint();
				for(Cell c: cells){
					if(c.getShape().contains(p)){
						if(c.getTok()==null){						
							Token tok=new Token(c.getX(), c.getY());
							c.setTok(tok);
							Frame.getInstance().getBoard().repaint();
							
						}
					}
				}
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
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
	
	
	
	
}



/*try {
File file=new File("img/tabla.png");
BufferedImage image=ImageIO.read(file);
g.drawImage(image, 0, 0, getParent());

} catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}*/
