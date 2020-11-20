import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.*;

public class Table {
	JPanel table;
	JPanel one;
	JPanel two;
	JPanel three;
	JLabel tnum;
	boolean isActive;
	int tableNum;
	String tableTime;
	int customerNumber;
	int tableMin;
	
	Table()
	{
		
		this.table = new JPanel();
		table.setLayout(new BoxLayout(table,BoxLayout.Y_AXIS));
		this.one = new JPanel(new FlowLayout(FlowLayout.CENTER));
		this.two = new JPanel(new FlowLayout(FlowLayout.CENTER));
		this.three = new JPanel(new FlowLayout(FlowLayout.CENTER));
		tnum = new JLabel("0");
		table.setBackground(new Color(204, 255, 255));
		one.setBackground(null);
		two.setBackground(null);
		three.setBackground(null);
		this.isActive = false;
		this.tableNum = 0;
		this.tableTime = "";
		this.customerNumber = 0;
		this.tableMin=0;
	}
	
}
