package ppt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ButtonTest implements WindowListener{

	private Frame frame;
	private Button btn;
	
	public ButtonTest()
	{
		frame = new Frame("Login");
		btn = new Button("Ȯ��");
		
		
		       
		
	}
	
	public void startFrame()
	{
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(btn.getLabel().equals("Ȯ��"))
				{
					btn.setLabel("������");
				}
				else
				{
					btn.setLabel("Ȯ��");
				}
				
			}
		});
		btn.setSize(100, 50);        
		btn.setLocation(100, 75);
		frame.add(btn); 
		frame.addWindowListener(this);
		frame.setSize(300, 200);
		frame.setLayout(null); 
		
		frame.setVisible(true); 
		
	}
	public void windowClosing(WindowEvent e) {        
		System.exit(0);    
	}    
	public void windowClosed(WindowEvent e) {    }    
	public void windowActivated(WindowEvent e) {    }   
	public void windowDeactivated(WindowEvent e) {    }    
	public void windowDeiconified(WindowEvent e) {    }    
	public void windowIconified(WindowEvent e) {    }    
	public void windowOpened(WindowEvent e) {    }
	 
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ButtonTest border = new ButtonTest();        
		border.startFrame();
	}
	
	
	

}