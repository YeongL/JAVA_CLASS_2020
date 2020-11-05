package pptslides;

public class Phone {
	public String owner;
	
	public Phone(String owner)
	{
		this.owner = owner;
	}
	
	public void turnOn()
	{
		System.out.println("turnonthephone");
	}
	public void turnOff()
	{
		System.out.println("turnoffthephone");
	}
}
