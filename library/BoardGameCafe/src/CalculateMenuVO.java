
public class CalculateMenuVO {
	private int tablenum;
	private String date;
	private String menulist;
	private String epw;
	private int sales;
	
	public CalculateMenuVO() {
	}
	public CalculateMenuVO(String date,int tablenum, String menulist, String epw, int sales) {
		this.tablenum = tablenum;
		this.date = date;
		this.epw = epw;
		this.menulist = menulist;
		this.sales=sales;
	}
	
	public int getTablenum() {
		return tablenum;
	}
	public String getMenuList() {
		return menulist;
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
