package ThreadEx21;

public class Account {
	int balance = 1000;
	
	// ÀÎÃâ
	public void withdraw(int money) {
		if(balance >= money) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			balance -= money;
		}
	}
}
