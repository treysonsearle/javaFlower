package Final;
import javax.swing.*;
import java.util.Random;


public class Flower extends Plant {

	//Flower images
	private ImageIcon flower1 = new ImageIcon("D:/Java Projects/Final/src/Final/flower1.png");
	private ImageIcon flower2 = new ImageIcon("D:/Java Projects/Final/src/Final/flower2.png");
	private ImageIcon flower3 = new ImageIcon("D:/Java Projects/Final/src/Final/flower3.png");
	private ImageIcon flower4 = new ImageIcon("D:/Java Projects/Final/src/Final/flower4.png");
	
//default Constructor
public Flower(){
	super();

}

//position instructor
public Flower(int x , int y){
	super(x,y);
	Random rand = new Random();
	int  n = rand.nextInt(4) + 1;
	if(n == 1)
		image = flower1;
	else if(n == 2)
		image = flower2;
	else if(n == 3)
		image = flower3;
	else if(n == 4)
		image = flower4;
	else
		image = null;
}

/*public void draw(Graphics g){
	if (image == null)
		g.drawString("Flower", pos.x, pos.y);
	
	System.out.println("flower");
	System.out.println(pos.x);
	image.paintIcon(null,g,pos.x,pos.y);
	
}*/

}