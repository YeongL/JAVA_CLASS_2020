package ppt;

import java.awt.*;
import java.awt.event.*;

public class CanvasTest extends WindowAdapter{
	
	public void windowClosing(WindowEvent e) {        
		System.exit(0);    
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Frame f = new Frame("Canvas Test");        
		 f.setSize(300, 200);        
		 f.setLayout(null);
	     Canvas c = new Canvas();        
	     c.setBackground(Color.pink);        
	     c.setBounds(50, 50, 150, 100);                
	     f.add(c);        
	     f.setVisible(true); 
	}
	
}
