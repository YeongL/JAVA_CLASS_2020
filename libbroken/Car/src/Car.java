
public class Car {
	String model;
	String color;
	int maxSpeed;
	
	Car(String color, int maxSpeed)
	{
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
	
	Car()
	{
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car myCar1 = new Car("Black", 3000);
		Car myCar2 = new Car();

	}

}
