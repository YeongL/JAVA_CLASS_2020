package ThreadEx21;

public class ATMEx {

	public static void main(String[] args) {

		Account account = new Account();
		// 유저 1
		User user1 = new User(account);
		// 유저 2
		User user2 = new User(account);
		
		Thread t1 = new Thread(user1);
		Thread t2 = new Thread(user2);
		
		t1.start();
		t2.start();
	}

}
