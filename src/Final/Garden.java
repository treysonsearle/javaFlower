package Final;
import java.awt.*;
import java.util.ArrayList;


	
public class Garden {
	public static final int CONTINUE = 0;
	public static final int	WEED = 1;
	public static final int	FLOWER = 2;
	
	protected ArrayList<Plant> plants;
	int x;
	int y = 400;

	
	public Garden() { 
		//the arraylist to hold the flowers and weeds
		plants = new ArrayList<>() ;

		

	}
	//new flower object
	public void newFlower() {
		plants.add(new Flower(x,y));
		x += 50;
		if (y == 400)
			y = 450;
		else
			y = 400;
	}
	//new weed object
	public void newWeed() {
		plants.add(new Weed(x,y));
		x += 50;
		if (y == 400)
			y = 450;
		else
			y = 400;
	}
	//sets plants to 0
	public void clear() {
		x = 0;
		y = 400;
		plants = new ArrayList<>();
	}
	//draws Graphics
	public void draw(Graphics g){
		
		for(int i = 0; i < plants.size(); i++) {
			plants.get(i).draw(g);
		}
			
		
	}
	
}
