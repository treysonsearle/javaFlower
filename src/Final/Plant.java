package Final;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.*;

public abstract class Plant {
	protected ImageIcon image;
	private Point pos;

	//default constructor
	public Plant(){
		pos = new Point(0,0);
		image = new ImageIcon("");
	}

	//position constructor
	public Plant(int x , int y){
		this();
		pos = new Point(x,y);
	}
	
	//draws if null
	public void draw(Graphics g){
		if (image == null)
			g.drawString("Flower", pos.x, pos.y);
		
		image.paintIcon(null,g,pos.x,pos.y);
	}
}
