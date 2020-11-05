
public class CarExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car myCar = new Car();
		
		myCar.setSpeed(-20);
		System.out.println(myCar.getSpeed());
		myCar.setSpeed(40);
		System.out.println(myCar.getSpeed());
		
		if(!myCar.isStop())
		{
			myCar.setStop(true);
		}
		System.out.println(myCar.getSpeed());
	}

}
