import java.awt.*;
import java.applet.*;
// Helper class
public class Bubble extends Applet
{
	boolean display = false;
	public String text;
	public int x, y;

	public void paint(Graphics g){
		String str = text;
		int i = x, j = y;
		Dimension d = getSize();
		setSize(500, 100);
		g.drawOval(i, j, 400, 60); //speech bubble, x,y coordinates are the position of the Avatar
		g.drawString(str, i+5, j+35); //the text we will be getting from the text field
		//(new showBubble()).start();	
	}
	
	class showBubble extends Thread{
		public void run(){
			try{
				sleep(2000);
				//display = false;
			}catch (InterruptedException e){	
			}
		}
	}
}
