import javax.swing.*;

public class Table {
	JButton table;
	boolean isActive;
	int tableNum;
	String tableTime;
	int customerNumber;
	int tableMin;
	
	Table()
	{
		this.table = new JButton();
		this.isActive = false;
		this.tableNum = 0;
		this.tableTime = "";
		this.customerNumber = 0;
		this.tableMin=0;
	}
	
}
