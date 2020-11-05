package ppt;

import java.awt.*;
import java.awt.event.*;

public class ListTest extends WindowAdapter{

	private Frame frame;
	private Button btn1,btn2;
	private List selectMany; 
	private List deleteMany; 
	
	public ListTest()
	{
		frame = new Frame("List-Select");
		btn1 = new Button("입력");
		btn2 = new Button("제거");
		selectMany = new List(6,true); 
		selectMany.add("Student");        
		selectMany.add("Teacher");        
		selectMany.add("Driver");        
		selectMany.add("Computer Programmer");        
		selectMany.add("Sales Man");        
		selectMany.add("Musician");        
		selectMany.add("Director");
		deleteMany = new List(6,true); 
		
	}
	
	public void startFrame()
	{
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String[] arr = selectMany.getSelectedItems();
				for(int i=0;i<arr.length;i++)
				{
					deleteMany.add(arr[i]);
				}
				
			}
		});
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String[] arr = deleteMany.getSelectedItems();
				for(int i=0;i<arr.length;i++)
				{
					deleteMany.remove(arr[i]);
				}
				
			}
		});
		btn1.setSize(50, 25);        
		btn1.setLocation(20, 165);
		btn2.setSize(50, 25);        
		btn2.setLocation(150, 165);
		selectMany.setSize(100, 120);
		deleteMany.setSize(100, 120);
		
		selectMany.setLocation(20,40);
		deleteMany.setLocation(150,40);
		
		
		frame.addWindowListener(this);
		frame.setSize(300, 200);
		frame.setLayout(null); 
		frame.add(selectMany);
		
		frame.add(deleteMany);
		frame.add(btn1); 
		frame.add(btn2); 
		frame.setVisible(true); 
		
	}
	public void windowClosing(WindowEvent e) {        
		System.exit(0);    
	}    
	
	 
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListTest border = new ListTest();        
		border.startFrame();
	}

}
