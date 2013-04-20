import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

import com.thehowtotutorial.splashscreen.*;

public class Splash extends JPanel {
	public JPanel Spanel;
	JSplash Splash;
 public Splash() throws InterruptedException{
	  Splash = new JSplash(this.getClass().getResource("Splash.png"), true, true, false, "V1",null,Color.RED,Color.BLACK);
	  Spanel = new JPanel();
	  Spanel.add(Splash);
	 
	
 }
 public void runSplash() throws InterruptedException{
	 Splash.splashOn();
	 Splash.setProgress(20, "Init");
	 Thread.sleep(2000);
	 Splash.setProgress(40, "Loading..");
	 Thread.sleep(1000);
	 Splash.setProgress(60, "Apply Config");
	 Thread.sleep(1000);
	 Splash.setProgress(80, "Starting..");
	 Thread.sleep(3000);
	 Splash.splashOff();
 }
}
