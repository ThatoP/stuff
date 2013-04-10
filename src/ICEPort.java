import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ICEPort extends JFrame
{
	JMenuBar menu = new JMenuBar(); // creating a menu bar
	JMenu file, help, about, exit;
	JMenuItem newWindow, close, closeAll, ex;
	JDesktopPane desktop;
	static int offset = 0;
	
	public ICEPort(){
		super("ICE Port");
		desktop = new JDesktopPane();
		desktop.setBackground(Color.WHITE);
		setContentPane(desktop);
		setJMenuBar(setGUI());
		setPreferredSize(new Dimension(1200,800));
		addListeners();
		desktop.setDragMode(JDesktopPane.LIVE_DRAG_MODE);
	}
	/*
	 * method setGUI
	 * @params:No parameters
	 * @returns:A JMenuBar instance with its respective menu items
	 * This method creates the help, About and Exit menu items
	 */
	protected JMenuBar setGUI(){
		menu.add(file = new JMenu("File"));
		file.add(newWindow = new JMenuItem("New"));
		file.addSeparator();
		file.add(close = new JMenuItem("Close"));
		file.add(closeAll = new JMenuItem("Close All"));
		
		menu.add(help = new JMenu("Help"));
		
		menu.add(about = new JMenu("About"));
		
		menu.add(exit = new JMenu("Exit"));
		exit.add(ex = new JMenuItem("Exit"));
		
		return menu;
	}
	
	protected static void createAndShowGUI(){
		ICEPort frame = new ICEPort();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	protected void createFrame(){
		MyWindow window = new MyWindow();
		UserLogin board = new UserLogin();
		window.add(board.getContentPane());
		window.setVisible(true);
		desktop.add(window);
		try
		  {
		     window.setSelected(true); 
		  }catch (java.beans.PropertyVetoException e) {}
	}
	
	private void addListeners(){
		newWindow.setMnemonic(KeyEvent.VK_N);
        newWindow.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        newWindow.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e){
        		createFrame();
        	}
        });
        
        close.setMnemonic(KeyEvent.VK_W);
        close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
        close.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e){
        		try
        		  {
        			desktop.getSelectedFrame().setClosed(true);
        		  }catch(java.beans.PropertyVetoException v) {}
        		offset -= 1;
        	}
        });
        
        closeAll.setMnemonic(KeyEvent.VK_W);
        closeAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK+ActionEvent.SHIFT_MASK));
        closeAll.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		JInternalFrame[] frame;
        		frame = desktop.getAllFrames();
        		for(int i=0;i<frame.length;i++){
        			try
        			{
        				frame[i].setClosed(true);
        			}catch(java.beans.PropertyVetoException v) {}
        		}
        		offset = 0;
        	}
        });
        
        ex.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		System.exit(0);
        	}
        });
        
        help.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		
        	}
        });
	}
	
	public static void main(String[] args){
		javax.swing.SwingUtilities.invokeLater(new Runnable()
		{
			public void run() 
            {
                createAndShowGUI();
            }
		});
	}
	
	public static class MyWindow extends JInternalFrame 
	{
		static int windowCount = 0;
	    static final int xPart = 30, yPart = 30;
	    
	    public MyWindow(){
	    	super("Ice World-"+(++windowCount),true,true,true,true);
	         setSize(700,700);
	         ++offset;
	         setLocation(xPart*offset, yPart*offset);
	    }
	}
}
