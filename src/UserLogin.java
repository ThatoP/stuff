import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import javax.swing.*;
import java.util.*;
import java.applet.*;

public class UserLogin extends JFrame
{
	JLabel username, pass, grpName;
	JButton login;
	JTextField uName;
	JPasswordField password;
	JPanel panel;
	
	public UserLogin(){
		setSize(new Dimension(700,700));
		setGUI();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Ice World"); 
	}
	
	protected void setGUI(){
		Dimension dim = getSize();
		ImagePanel img = new ImagePanel(new ImageIcon("iceLogin4.jpg").getImage());
		getContentPane().add(img);
		
		username = new JLabel("Username: ");
		username.setBounds((dim.width/2)-100, (dim.height/2)+50, 100, 20);
		img.add(username);
		pass = new JLabel("Password: ");
		pass.setBounds((dim.width/2 - 100), (dim.height/2)+80, 100, 20);
		img.add(pass);
		login = new JButton("Login");
		login.setBounds((dim.width/2)-50, (dim.height/2)+110, 70, 30);
		img.add(login);
		uName = new JTextField();
		uName.setBounds((dim.width/2)-30, (dim.height/2)+50, 150, 20);
		img.add(uName);
		password = new JPasswordField();
		password.setBounds((dim.width/2)-30, (dim.height/2)+80, 150, 20);
		img.add(password);
		grpName = new JLabel("Doublemint Group 2013 Copyright, All rights reserved.");
		grpName.setBounds((dim.width/2)-150, dim.height-100, 400,20);
		img.add(grpName);
		
	}
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                UserLogin ex = new UserLogin();
                ex.setVisible(true);
            }
        });
	}
	
	class ImagePanel extends JPanel {

		  private Image img;

		  public ImagePanel(String img) {
		    this(new ImageIcon(img).getImage());
		  }

		  public ImagePanel(Image img) {
		    this.img = img;
		    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		    setPreferredSize(size);
		    setMinimumSize(size);
		    setMaximumSize(size);
		    setSize(size);
		    setLayout(null);
		  }

		  public void paintComponent(Graphics g) {
		    g.drawImage(img, 0, 0, null);
		  }

		}
}
