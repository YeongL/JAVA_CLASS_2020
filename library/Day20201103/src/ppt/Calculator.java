package ppt;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Calculator extends JFrame implements WindowListener   {
	
	public int n1=0;
	public boolean plusclicked = true;
	public boolean minusclicked = true;
	public int tmp=0;
	public String lastchecked;
	JPanel jpn1 = new JPanel();
	JPanel jpn2 = new JPanel();
	JPanel jpn3 = new JPanel();
	JFrame frame = new JFrame("Simple Calculator");
	private Button num1,num2,num3,num4,num5,num6,num7,num8,num9,num0;
	private Button clear, plus,minus,delete,answer;
	private TextField tf;
	
	public Calculator()
	{
		
		
		
		num1 = new Button("1");
		num2 = new Button("2");
		num3 = new Button("3");
		num4 = new Button("4");
		num5 = new Button("5");
		num6 = new Button("6");
		num7 = new Button("7");
		num8 = new Button("8");
		num9 = new Button("9");
		num0 = new Button("0");
		
		plus = new Button("+");
		minus = new Button("-");
		delete = new Button("delete");
		answer = new Button("=");
		clear = new Button("C");
		
		tf = new TextField("0");
		
		
	}
	
	public void startFrame()
	{
		Font font = new Font("궁서체",Font.BOLD+Font.ITALIC,15);
		tf.setFont(font);
		tf.setEditable(false);
		tf.setFocusable(false);
		jpn1.setLayout(new BoxLayout(jpn1,BoxLayout.X_AXIS));
		jpn1.add(tf);
		jpn2.setLayout(new GridLayout(5,3));		
		jpn2.add(clear);
		jpn2.add(plus);
		jpn2.add(minus);
		jpn2.add(num7);
		jpn2.add(num8);
		jpn2.add(num9);
		jpn2.add(num4);
		jpn2.add(num5);
		jpn2.add(num6);
		jpn2.add(num1);
		jpn2.add(num2);
		jpn2.add(num3);
		jpn2.add(num0);
		jpn2.add(delete);
		jpn2.add(answer);
		
		jpn3.setLayout(new BoxLayout(jpn3,BoxLayout.Y_AXIS));
		jpn3.add(jpn1);
		jpn3.add(jpn2);
		frame.add(jpn3,BorderLayout.CENTER);
		//버튼동작
		num0.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tmp!=0 && !plusclicked)
				{
					tf.setText("0");
					plusclicked = true;
				}
				else if(tmp!=0 && !minusclicked)
				{
					tf.setText("0");
					minusclicked = true;
				}
				else if(!tf.getText().equals("0"))
				{
					tf.setText(tf.getText()+"0");
				}
				
				
			}
		});
		
		num1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tmp !=0 && !plusclicked)
				{
					tf.setText("1");
					plusclicked = true;
				}
				else if(tmp!=0 && !minusclicked)
				{
					tf.setText("1");
					minusclicked = true;
				}
				else if(!tf.getText().equals("0"))
				{
					tf.setText(tf.getText()+"1");
				}
				else
				{
					tf.setText("1");
				}
				
				
			}
		});
		
		num2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tmp !=0 && !plusclicked)
				{
					tf.setText("2");
					plusclicked = true;
				}
				else if(tmp!=0 && !minusclicked)
				{
					tf.setText("2");
					minusclicked = true;
				}
				else if(!tf.getText().equals("0"))
				{
					tf.setText(tf.getText()+"2");
				}
				else
				{
					tf.setText("2");
				}
				
				
			}
		});
		
		num3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tmp !=0 && !plusclicked)
				{
					tf.setText("3");
					plusclicked = true;
				}
				else if(tmp!=0 && !minusclicked)
				{
					tf.setText("3");
					minusclicked = true;
				}
				else if(!tf.getText().equals("0"))
				{
					tf.setText(tf.getText()+"3");
				}
				else
				{
					tf.setText("3");
				}
				
				
			}
		});
		
		num4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tmp !=0 && !plusclicked)
				{
					tf.setText("4");
					plusclicked = true;
				}
				else if(tmp!=0 && !minusclicked)
				{
					tf.setText("4");
					minusclicked = true;
				}
				else if(!tf.getText().equals("0"))
				{
					tf.setText(tf.getText()+"4");
				}
				else
				{
					tf.setText("4");
				}
				
				
			}
		});
		
		num5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tmp!=0 && !plusclicked)
				{
					tf.setText("5");
					plusclicked = true;
				}
				else if(tmp!=0 && !minusclicked)
				{
					tf.setText("5");
					minusclicked = true;
				}
				else if(!tf.getText().equals("0"))
				{
					tf.setText(tf.getText()+"5");
				}
				else
				{
					tf.setText("5");
				}
				
				
			}
		});
		
		num6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tmp!=0 && !plusclicked)
				{
					tf.setText("6");
					plusclicked = true;
				}
				else if(tmp!=0 && !minusclicked)
				{
					tf.setText("6");
					minusclicked = true;
				}
				else if(!tf.getText().equals("0"))
				{
					tf.setText(tf.getText()+"6");
				}
				else
				{
					tf.setText("6");
				}
				
			}
		});
		
		num7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tmp!=0 && !plusclicked)
				{
					tf.setText("7");
					plusclicked = true;
				}
				else if(tmp!=0 && !minusclicked)
				{
					tf.setText("7");
					minusclicked = true;
				}
				else if(!tf.getText().equals("0"))
				{
					tf.setText(tf.getText()+"7");
				}
				else
				{
					tf.setText("7");
				}
				
				
			}
		});
		
		num8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tmp!=0 && !plusclicked)
				{
					tf.setText("8");
					plusclicked = true;
				}
				else if(tmp!=0 && !minusclicked)
				{
					tf.setText("8");
					minusclicked = true;
				}
				else if(!tf.getText().equals("0"))
				{
					tf.setText(tf.getText()+"8");
				}
				else
				{
					tf.setText("8");
				}
				
			}
		});
		
		num9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tmp!=0 && !plusclicked)
				{
					tf.setText("9");
					plusclicked = true;
				}
				else if(tmp!=0 && !minusclicked)
				{
					tf.setText("9");
					minusclicked = true;
				}
				else if(!tf.getText().equals("0"))
				{
					tf.setText(tf.getText()+"9");
				}
				else
				{
					tf.setText("9");
				}
				
			}
		});
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tf.setText("0");
				tmp=0;
				n1=0;
			}
		});
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!tf.getText().equals("0"))
				{
					tf.setText(tf.getText().substring(0,tf.getText().length()-1));
				}
				if(tf.getText().length()==0)
				{
					tf.setText("0");
				}
				tmp=0;
				n1=0;
				
			}
		});
		plus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tmp=Integer.parseInt(tf.getText());
				
				n1 += tmp;
				tf.setText(Integer.toString(n1));
				plusclicked = false;
				
				lastchecked = "plus";
				
				
			}
		});
		minus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tmp=Integer.parseInt(tf.getText());
				if(n1==0)
				{
					n1=tmp;
				}
				else
				{
					n1 -= tmp;
				}
				
				tf.setText(Integer.toString(n1));
				minusclicked = false;
				
				lastchecked = "minus";
				
				
			}
		});
		answer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				tmp=Integer.parseInt(tf.getText());
				
				if(lastchecked.equals("plus"))
				{
					n1 += tmp;
				}
				else
				{
					n1-=tmp;
				}
				tf.setText(Integer.toString(n1));
				n1=0;
				tmp=0;
				
				
			}
		});
		
		
		
		
		
		frame.addWindowListener(this);
		frame.pack();
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
    public void windowOpened(WindowEvent e){	}
	 
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator cal = new Calculator();        
		cal.startFrame();
	}

}
