package SingleProj;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;

public class AttendMany extends JFrame {

	private Frame frame;
	private Button btn1,btn2,btn3,btn4,btn5;
	private List nAStudents; 
	private List aStudents; 
	
	public AttendMany()
	{
		frame = new Frame("��� �Ѳ����� ����");
		btn1 = new Button("�⼮");
		btn2 = new Button("�Ἦ");
		btn3 = new Button("Ȯ��");
		btn4 = new Button("���");
		btn5 = new Button("����");
		nAStudents = new List(6,true); 
		String[]  students = new String[20];
		for(int i=0;i<20;i++)
		{
			students[i] = "�̸���"+i;
		}
		for(int i=0;i<20;i++)
		{
			nAStudents.add(students[i]);//���⸦ �����ͺ��̽��� ����
			//�Ἦ�̶� �� �ִ� ģ���鸸 ���� ���� ��
		}
		aStudents = new List(6,true); 
		//�⼮�̶� �� �ִ� ģ������ ���� �ִ´�.
		
	}
	
	public void startFrame()
	{
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String[] arr = nAStudents.getSelectedItems();
				for(int i=0;i<arr.length;i++)
				{
					nAStudents.remove(arr[i]);
				}
				for(int i=0;i<arr.length;i++)
				{
					aStudents.add(arr[i]);
				}
				
				
			}
		});
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String[] arr = aStudents.getSelectedItems();
				for(int i=0;i<arr.length;i++)
				{
					aStudents.remove(arr[i]);
				}
				for(int i=0;i<arr.length;i++)
				{
					nAStudents.add(arr[i]);
				}
			}
		});
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		btn4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		btn1.setSize(50, 25);        
		btn1.setLocation(20, 165);
		btn2.setSize(50, 25);        
		btn2.setLocation(130, 165);
		btn3.setSize(50, 25);        
		btn3.setLocation(240, 40);
		btn4.setSize(50, 25);        
		btn4.setLocation(240, 85);
		btn5.setSize(50, 25);        
		btn5.setLocation(240, 130);
		nAStudents.setSize(100, 115);
		aStudents.setSize(100, 115);
		
		nAStudents.setLocation(20,40);
		aStudents.setLocation(130,40);
		
		
		
		frame.setSize(300, 200);
		frame.setLayout(null); 
		frame.add(nAStudents);
		
		frame.add(aStudents);
		frame.add(btn1); 
		frame.add(btn2); 
		frame.add(btn3); 
		frame.add(btn4); 
		frame.add(btn5); 
		frame.setVisible(true); 
		
	}
	 
	
	 
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AttendMany border = new AttendMany();        
		border.startFrame();
	}

}
