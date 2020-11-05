
public class CastingTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car1 car = null;
		FireEngine fe = new FireEngine();
		
		FireEngine fe2 = null;
		
		fe.water();
		car = fe;
		fe2 = (FireEngine) car;
		fe.water();
	}

}


class Car1
{
	String color;
	int door;
	void drive()
	{
		System.out.println("drive");
	}
	
	void stop()
	{
		System.out.println("stop");
	}
	
	
}

class FireEngine extends Car1
{
	void water()
	{
		System.out.println("water");
	}
}