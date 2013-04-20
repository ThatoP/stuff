import iceworld.given.ICEWorldImmigration;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.applet.*;
import java.util.Calendar;


public class Talking extends JFrame 
{
	protected Thread thread;
	protected int delay;
	JFrame talkFrame = new JFrame();	
	JPanel panel, controls, art; 
	static JButton talk;
	static JLabel duration, message;
	static JTextField time, content;
	//MyHandler handle;
	int xPos=0, yPos=0;
	//LoginSever tester = new LoginSever();
	
	public Talking(String user){
		
	}
	
	public Talking(){
		//tester.setUsername(user);
		//this.setSize(new Dimension(00,80));
		controls = new JPanel();
		//controls.setSize(1000, 100);
		controls.setLayout(new GridLayout(3,2,5,5));
		
		message = new JLabel("Message: ");
		message.setSize(100, 20);
		controls.add(message);
		content = new JTextField();
		content.setSize(100, 20);
		controls.add(content);
		duration = new JLabel("TALK_VISIBLE_DURATION: ");
		duration.setSize(100, 20);
		controls.add(duration);
		time = new JTextField();
		time.setSize(100, 20);
		controls.add(time);
		talk = new JButton("Talk");
		talk.setSize(100,30);
		//talk.setAccelerator(KeyStroke.getKeyStroke((char)(KeyEvent.VK_ENTER)));
		//talk.addActionListener(handle);
		controls.add(talk);
		
		add(controls);
	}
	/*
	class MyHandler implements ActionListener{
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
		}
	}
	*/
	
	public static void main(String[] args){
		Talking newtalkFrame = new Talking();
		newtalkFrame.setVisible(true);
		newtalkFrame.setSize(400,200);
		 
	}
	
	class Bubble extends JPanel{
		String string;
		
		public Bubble(String str){
			string = str;
			setVisible(true);
		}
		
		public void clear(){
			setVisible(false);
		}
		
		public void paintComponent(Graphics g){
			g.setColor(Color.black);
			g.drawOval(xPos, yPos, 150, 100);
			g.setColor(Color.white);
			g.fillOval(xPos, yPos, 150, 100);
			g.setColor(Color.black);
			g.drawString(string, xPos, yPos);
		}
	}
}
