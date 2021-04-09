package Final;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Random;

public class MathProblem {
	
	private int oper;
	private int num1;
	private int num2;
	private int answer;
	int num3 = 0;    
	int num4 = 0;
	String userInput;
	
	MathProblem(){
		userInput = "";
		
		//number1 1 - 12
		Random rand1 = new Random();
		num1 = rand1.nextInt(12) + 1;
		
		//number2 1 - 12
		Random rand2 = new Random();
		num2 = rand2.nextInt(12) + 1;
		
		//oper is operator type there are 4 types + - / *
		Random rand = new Random();
		oper = rand.nextInt(4) + 1;

		if (num1 < num2)
			num3 = num1;
			num4 = num2;
			num2 = num3;
			num1 = num4;
			
		if (num1 == 0)
			num1 = 1;
		
		if(num2 == 0)
			num2 = 1;
		
		if(oper == 1)
			answer = num1 + num2;
		else if(oper == 2)
			answer = num1 - num2;
		else if(oper == 3)
			answer = num1 / num2;
		
		else if(oper == 4)
			answer = num1 * num2;
			
	}
	
	//Draw method for Math Problem
	public void draw(Graphics g){
		if(oper == 1)
			g.drawString(num1 + " + " + num2 + " = "+ userInput, 400, 300);
		else if(oper == 2)
			g.drawString(num1 + " - " + num2 + " = "+ userInput, 400, 300);
		else if(oper == 3)
			g.drawString(num1 + " \u00F7 " + num2 + " = "+ userInput, 400, 300);
		else if(oper == 4)
			g.drawString(num1 + " \u00D7 " + num2 + " = "+ userInput, 400, 300);
		
		
		
	}
	//this method checks the user input to make sure they only type numbers up to 3 total
	public int receiveUserInput(KeyEvent ke) {
		
		
		char input = ke.getKeyChar();
		
		
		if (Character.isDigit(input) && userInput.length() < 3)
		{
			userInput = userInput + input;
		}
		//if the user presses enter
		if (input == '\n')
		{	
			if(Integer.parseInt(userInput) == answer)
				return Garden.FLOWER; 
			else
				return Garden.WEED;
		}

		if(input == KeyEvent.VK_BACK_SPACE || input == KeyEvent.VK_DELETE)
		{
			if(userInput.length() != 0)
			{
				userInput = userInput.substring(0,userInput.length()-1);
			}
		}
		return Garden.CONTINUE;
		
	}
}


