package Component;

public class Tire {
	private int size;
	
	public Tire() {
		System.out.println("Tire constructor");
		size = 0;
	}
	
	public int getSize()
	{
		return size;
	}
	
	public void setSize()
	{
		this.size = size;
	}
}
