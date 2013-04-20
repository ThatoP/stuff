import iceworld.given.ICEWorldImmigration;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.*;
public class testpanel extends JFrame {
	public testpanel(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		pack();
		setVisible(true);
		setResizable(true);
		
	}
	
	public void paint(Graphics g){
		g.fillOval(100,100,100, 100);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
LoginSever tester1 = new LoginSever();
//tester1.setUsername("Warumporn.C");
tester1.setIcePortID(248);
tester1.setListeningPort(55555);
ICEWorldImmigration immigration = new ICEWorldImmigration(tester1);
immigration.loginAlien();

if(content.getText().equals("")){
	JLabel errorFields = new JLabel("<HTML><FONT COLOR = Red>" +
			"You must enter a message.</FONT></HTML>");
	JOptionPane.showMessageDialog(null,errorFields);
}
else if(time.getText().equals("")){
	JLabel errorFields = new JLabel("<HTML><FONT COLOR = Red>" +
			"Enter the duration of the message in seconds.</FONT></HTML>");
	JOptionPane.showMessageDialog(null,errorFields);
}
else if(content.getText().length()>100){
	JLabel errorFields = new JLabel("<HTML><FONT COLOR = Red>" +
			"Message is too long, \n enter a 100 character message.</FONT></HTML>");
	JOptionPane.showMessageDialog(null,errorFields);
}
else{
	immigration.talk(content.getText());
	System.out.println(content.getText());
	
}