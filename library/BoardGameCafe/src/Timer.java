

import javax.swing.*;
public class Timer {
	int tableNum;
	JPanel timerPanel;
	JLabel Lstopwatch;
	boolean isActive;
	int stop;
	int ssec;//�����ġ�� ����� ����  ��
	int smin;//�����ġ�� ����� ����  ��
	int shour;//�����ġ�� ����� ���� �ð�
	
	String listnum = "";
	
	Timer()
	{
		timerPanel = new JPanel();
		this.tableNum = 0;
		isActive = false;
		stop = 0;
		ssec=0;//�����ġ�� ����� ����  ��
		smin=0;//�����ġ�� ����� ����  ��
		shour=0;//�����ġ�� ����� ���� �ð�
		Lstopwatch = new JLabel();
		listnum = "";
	}
	
	public void resetTimes()
	{
		
		isActive = false;
		
		stop = 0;
		smin = 0;
		ssec = 0;
		shour = 0;
		listnum = "";
		timerPanel.repaint();
	}
	
	
}
