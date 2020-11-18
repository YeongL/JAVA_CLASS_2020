

import javax.swing.*;
public class Timer {
	int tableNum;
	JPanel timerPanel;
	JLabel Lstopwatch;
	boolean isActive;
	int stop;
	int ssec;//스톱워치에 사용할 변수  초
	int smin;//스톱워치에 사용할 변수  분
	int shour;//스톱워치에 사용할 변수 시간
	
	String listnum = "";
	
	Timer()
	{
		timerPanel = new JPanel();
		this.tableNum = 0;
		isActive = false;
		stop = 0;
		ssec=0;//스톱워치에 사용할 변수  초
		smin=0;//스톱워치에 사용할 변수  분
		shour=0;//스톱워치에 사용할 변수 시간
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
