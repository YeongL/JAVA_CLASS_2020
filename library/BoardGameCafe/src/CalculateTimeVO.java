
public class CalculateTimeVO {

	private int tablenum;
	private int cusnum;
	private String date;
	private int timeused;
	private String epw;
	private int sales;
	
	public CalculateTimeVO() {
	}
	public CalculateTimeVO(int tablenum, int cusnum, String date, int timeused, String epw, int sales) {
		this.tablenum = tablenum;
		this.cusnum = cusnum;
		this.date = date;
		this.epw = epw;
		this.timeused = timeused;
		this.sales=sales;
	}
	
	public int getTablenum() {
		return tablenum;
	}
	public int getCusnum() {
		return cusnum;
	}
	public int getTimeused() {
		return timeused;
	}
	public int getSales() {
		return sales;
	}
	
	
	public String getEPW() {
		return epw;
	}
	public String getDate() {
		return date;
	}
}
