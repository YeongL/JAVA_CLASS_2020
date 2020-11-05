package pptslides;

public class Television implements RemoteControl {

	public int volume;
	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("turn on TV");
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("turn off TV");
	}

	@Override
	public void setVolume(int volume) {
		// TODO Auto-generated method stub
		if(volume>RemoteControl.MAX_VOLUME)
		{
			this.volume = RemoteControl.MAX_VOLUME;
		}
		else if(volume<RemoteControl.MIN_VOLUME)
		{
			this.volume = RemoteControl.MIN_VOLUME;
		}
		else
		{
			this.volume = volume;
		}
		System.out.println("Volume for TV: "+this.volume);
	}

}
