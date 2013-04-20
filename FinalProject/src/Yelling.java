import iceworld.given.ICEWorldImmigration;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;

public class Yelling extends JFrame
{
	protected Thread thread;
	protected int delay;
	JFrame talkFrame = new JFrame();	
	JPanel controls; 
	JButton yell;
	JLabel message;
	JTextField content;
	ButtonHandler handle = new ButtonHandler();
	int xPos=0, yPos=0;
	//LoginSever tester = new LoginSever();
	
	public Yelling(){
		//tester.setUsername(user);
		//this.setSize(new Dimension(00,80));
		controls = new JPanel();
		//controls.setSize(1000, 100);
		controls.setLayout(new GridLayout(2,2,5,5));
		
		message = new JLabel("Message: ");
		message.setSize(100, 20);
		controls.add(message);
		content = new JTextField();
		content.setSize(100, 20);
		controls.add(content);
		yell = new JButton("Yell");
		yell.setSize(100,30);
		//talk.setAccelerator(KeyStroke.getKeyStroke((char)(KeyEvent.VK_ENTER)));
		yell.addActionListener(handle);
		controls.add(yell);
		
		add(controls);
	}
	
	class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			LoginSever tester = new LoginSever();
			tester.setUsername(tester.getUsername());
			tester.setIcePortID(248);
			tester.setListeningPort(55555);
			ICEWorldImmigration immigration = new ICEWorldImmigration(tester);
			//immigration.login("9127183");
			immigration.loginAlien();
			
			if(content.getText().equals("")){
				JLabel errorFields = new JLabel("<HTML><FONT COLOR = Red>" +
						"You must enter a message.</FONT></HTML>");
				JOptionPane.showMessageDialog(null,errorFields);
			}
			else if(content.getText().length()>10){
				JLabel errorFields = new JLabel("<HTML><FONT COLOR = Red>" +
						"Message is too long, \n enter a 10 character message.</FONT></HTML>");
				JOptionPane.showMessageDialog(null,errorFields);
			}
			else{
				immigration.yell(content.getText());
				System.out.println(content.getText());
				
			}
		}
	}
}
