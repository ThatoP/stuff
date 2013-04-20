import iceworld.given.ICEWorldImmigration;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menubar extends JFrame {
	String pass2 = "";
	ActionHandler e = new ActionHandler();
	MyButtonHandler f = new MyButtonHandler();
	MyHandler handle = new MyHandler();
	Login Login2;
	JFrame Main2,Main3,Main4;
	JMenuItem newM, exitM, aboutAction, helpAction1, helpAction2, tlk, yell, custom;
	Splash ss;
	
	public Menubar() {
		this.setTitle(" IceWorld ");

		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);

		JMenu file = new JMenu(" File ");
		JMenu About = new JMenu(" About ");
		JMenu Help = new JMenu(" Help ");
		JMenu settings = new JMenu("Settings");
		menuBar.add(file);
		menuBar.add(About);
		menuBar.add(Help);
		menuBar.add(settings);
		newM = new JMenuItem("New Window");
		exitM = new JMenuItem("Quit");
		newM.addActionListener(e);
		exitM.addActionListener(e);
		aboutAction = new JMenuItem("Members");
		aboutAction.addActionListener(e);
		helpAction1 = new JMenuItem("Help");
		helpAction1.addActionListener(e);
		file.add(newM);
		file.add(exitM);
		About.add(aboutAction);
		Help.add(helpAction1);
		helpAction1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1,0));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		Login2 = new Login();
		Login2.loginb.addActionListener(f);
		this.setContentPane(Login2);
		setResizable(true);
		
		//Talking.talk.addActionListener(handle);
		tlk = new JMenuItem("Talk");
		settings.add(tlk);
		tlk.addActionListener(e);
		
		yell = new JMenuItem("Yell");
		settings.add(yell);
		yell.addActionListener(e);
		
		custom = new JMenuItem("Customize");
		settings.add(custom);
		custom.addActionListener(e);
		
	}


	public void swapJPanels(int panelNumber) throws InterruptedException {
		this.dispose();
		if (panelNumber == 0) {
				Main2 = new Splashpic();
				Main2.setExtendedState(JFrame.MAXIMIZED_BOTH);
				Main2.setVisible(true);
				Talking talk= new Talking();
				Talking.talk.addActionListener(handle);
				talk.setSize(500, 200);
				talk.setVisible(true);
				Yelling yell = new Yelling();
				yell.setSize(500,100);
				yell.setVisible(true);
				//repaint();
			Thread.sleep(1000);
				// TODO Auto-generated catch block		
		}
		
		if(panelNumber ==1){
			Thread.sleep(1000);
			this.setVisible(false);
		}
	}
	

	class MyButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent f) {
			String loginas = (String) Login2.loginBox.getSelectedItem();
			AbstractButton src = (AbstractButton) f.getSource();
			if (src.getText().equals("login")) {
				LoginSever tester = new LoginSever();
				tester.setIcePortID(248);
				tester.setListeningPort(55555);
				ICEWorldImmigration immigration = new ICEWorldImmigration(tester);
				if (loginas.equals("Alien")) {
						System.out.println("Login Alien OK");
						try {
							swapJPanels(0);
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();}
				} else {
					tester.setUsername(Login2.user.getText());
					char[] pass1 = Login2.pass.getPassword();
					for (int i = 0; i < pass1.length; i++) {
						pass2 = pass2 + pass1[i];
					}

					if (immigration.login(pass2)) {
						//tester.setUsername(Login2.user.getText());
						//new Talking(tester.getUsername()).setVisible(true);
						//Talking talk = new Talking();
						//talk.setVisible(true);
						//talk.setSize(500, 200);
						System.out.println("Login OK");
						try {
							swapJPanels(0);
							Thread.sleep(1000);
							} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();}
					}
				}
			}
		}

		private void dispose() {
			
			
		}

		private void setVis() {
			setVisible(false);
			
		}
	}

	class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String source = e.getActionCommand();
			if ("Quit".equals(source)) { // when choose quit in menu bar
				int response = JOptionPane
						.showConfirmDialog(null,
								"Are you sure you want to quit ICE World?",
								null, JOptionPane.OK_CANCEL_OPTION,
								JOptionPane.PLAIN_MESSAGE);
				if (response == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			} else if ("Members".equals(source)) {
				showHelp a = new showHelp();
				a.setVisible(true);
			} else if ("New Window".equals(source)) {
				Menubar a = new Menubar();
				a.pack();
				a.setVisible(true);
			} else if(source.equals("Talk")){
				Talking newtalkFrame = new Talking();
				newtalkFrame.setVisible(true);
				newtalkFrame.setSize(500,150);
			}
		}
	}

	class showHelp extends JDialog {
		public showHelp() {
			
			super(new JFrame(), "Information", true);
			ImageIcon info = new ImageIcon("player.jpg");

			JLabel n = new JLabel(info);
			n.setVisible(true);

			this.add(n, BorderLayout.CENTER);

			// Dimension Dim = this.getSize();
			this.setSize(600, 400);

		}
	}

	public static void main(String[] args) {

		Menubar a = new Menubar();
		a.setBounds(0,0, 1200, 700);
		a.setPreferredSize(new Dimension(1200, 800));
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		a.pack();
		a.setVisible(true);
	}
	
	class MyHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			LoginSever tester = new LoginSever();
			tester.setUsername(tester.getUsername());
			tester.setIcePortID(248);
			tester.setListeningPort(55555);
			ICEWorldImmigration immigration = new ICEWorldImmigration(tester);
			
			if(!pass2.equals("")){
				immigration.login("9127183");
				//immigration.loginAlien();
				
				if(Talking.content.getText().equals("")){
					JLabel errorFields = new JLabel("<HTML><FONT COLOR = Red>" +
							"You must enter a message.</FONT></HTML>");
					JOptionPane.showMessageDialog(null,errorFields);
				}
				else{
					immigration.talk(Talking.content.getText());
					System.out.println(Talking.content.getText());
					
				}
			}
			else{
				immigration.loginAlien();
				
				if(Talking.content.getText().equals("")){
					JLabel errorFields = new JLabel("<HTML><FONT COLOR = Red>" +
							"You must enter a message.</FONT></HTML>");
					JOptionPane.showMessageDialog(null,errorFields);
				}
				else if(Talking.time.getText().equals("")){
					JLabel errorFields = new JLabel("<HTML><FONT COLOR = Red>" +
							"Enter the duration of the message in seconds.</FONT></HTML>");
					JOptionPane.showMessageDialog(null,errorFields);
				}
				else if(Talking.content.getText().length()>100){
					JLabel errorFields = new JLabel("<HTML><FONT COLOR = Red>" +
							"Message is too long, \n enter a 100 character message.</FONT></HTML>");
					JOptionPane.showMessageDialog(null,errorFields);
				}
				else{
					immigration.talk(Talking.content.getText());
					System.out.println(Talking.content.getText());
					
				}
			}
		}
	}
	
}