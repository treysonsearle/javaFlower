package Final;
import javax.swing.ImageIcon;



public class Weed extends Plant {


	//default constructor
	public Weed(){
		super();
		image = new ImageIcon("D:/Java Projects/Final/src/Final/weed.png");

		
	}

	//position constructor
	public Weed(int x , int y){
		
		super(x,y);
		image = new ImageIcon("D:/Java Projects/Final/src/Final/weed.png");
		
	}

	/*public void draw(Graphics g){
		
		image.paintIcon(null,g,pos.x,pos.y);
	}*/
}
