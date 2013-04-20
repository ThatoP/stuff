import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Splashpic extends JFrame {
	ImageIcon info;
	JLabel n;
	JButton a;
	MyButtonHandler f = new MyButtonHandler();
	
	public Splashpic() throws InterruptedException{
		this.setLayout(null);
		Dimension d = this.getSize();
		info = new ImageIcon("Splash22.jpg");
		a = new JButton("Start Game");
		n = new JLabel(info);
		this.add(a);
		n.setSize(d.width-400,d.height-400);
		n.setVisible(true);
		a.addActionListener(f);
		n.setBounds(190,20, 1000, 600);
		a.setBounds(580, 630 , 200, 40);
		this.add(n);
		//this.add(a);
		//System.out.print("YYYYYYYYYYYYYYYYYYYYY");
		}
	
	class MyButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent f) {
		close();
		testpanel b = new testpanel();
		b.setVisible(true);	
	}

	private void dispose() {
		// TODO Auto-generated method stub
		removeAll();
		
	}

	private void setVis() {
		// TODO Auto-generated method stub
		setVisible(false);
	}
	}
	public void close() {
		this.dispose();
		
	}
	
}

	