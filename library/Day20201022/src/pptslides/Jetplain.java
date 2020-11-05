package pptslides;


public class Jetplain extends Plain implements Flyable, Soundable {

	

	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("sound of jet");
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("jet flies");
	}

}
