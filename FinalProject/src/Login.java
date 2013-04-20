import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class Login extends JPanel {
	  JTextField user;
	  JPasswordField pass;
	 JLabel Welcome,id,password;
	 static JButton loginb;
	 JPanel a,b,c;
	 String fileName;
	 Dimension d;
	 public static JComboBox loginBox;
		public Login(){
			setLayout(null);
			init();
		}
		public void init(){
			setGUI();
			//addListener();
			//setupMenu();
		}
		public void setGUI(){
		d= this.getSize();	
			Welcome = new JLabel( "WELCOME TO ICE WORLD");
			id = new JLabel("ID");
			password = new JLabel("Password");
			//setsize
			user = new JTextField(15);
			pass = new JPasswordField(15);
	        loginb = new JButton("login");
	        loginBox = new JComboBox();
	        loginBox.addItem("Alien");
	        loginBox.addItem("Inhabitant");
	     
	        id.setForeground(Color.WHITE);
	        password.setForeground(Color.WHITE);
	        this.setLayout(null);
	        loginb.setBounds(580, 550 , 200, 40);		
			this.add(loginb);
			Welcome.setBounds(595, 100, 200, 15);
			Welcome.setForeground(Color.WHITE);
			this.add(Welcome);
			id.setBounds(530, 480 , 50, 20);
			this.add(id);
			user.setBounds(580, 480 , 200, 20);
			this.add(user);
			password.setBounds(510, 510 , 100, 20);
			this.add(password);
			pass.setBounds(580,510, 200, 20);
			this.add(pass);
			loginBox.setBounds(520, 430, 280, 30);
			this.add(loginBox);
	     
		}
		public void paint (Graphics g){

			super.paint(g);
		
		}
		public void paintComponent(Graphics g){
			BufferedImage image = null;
		try {
			image = ImageIO
					.read(new URL(
							"http://www.fuzzywaffle.com/data/526/Food_Wallpaper_Wide_49_.jpg"));
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(image,0,0,this);
		}
	 
}
