
public class InterruptExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread = new PrintThread2();
		thread.start();
		
		try {
			Thread.sleep(1000);
			
		}catch (InterruptedException e) {}
		
		thread.interrupt();
	}

}
