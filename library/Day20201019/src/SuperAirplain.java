
public class SuperAirplain extends Airplain {
	public static final int NORMAL = 1;
	public static final int SUPER = 1;
	
	public int flymode = NORMAL;
	
	public void fly()
	{
		if(flymode == SUPER)
		{
			System.out.println("초음속 비행중");
		}
		else
		{
			super.fly();
		}
	}

}
