
public class Menu {
	String mname;
	int mcost;
	boolean ison = true;
	
	Menu(String mname, int mcost)
	{
		this.mname = mname;
		this.mcost = mcost;
	}
	
	public boolean isOn()
	{
		return this.ison;
	}
}
