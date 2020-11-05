package pptslides;

public class RemoteControlExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoteControl rc;
		rc = new Audio();
		rc.turnOn();
		rc.turnOff();
		
		RemoteControl rc2 = new RemoteControl() {
			@Override
			public void turnOn() {
				System.out.println("remotecontrol turnon");
			}
			
			@Override
			public void turnOff()
			{
				System.out.println("remotecontrol turnoff");
			}
			
			@Override
			public void setVolume(int volume)
			{
				
			}
		};
		
		rc2.turnOff();
		rc2.turnOn();
		
	}

}
