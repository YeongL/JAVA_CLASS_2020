package ThreadEx21;

public class User implements Runnable {
	Account account = null;
	
	public User(Account account) {
		this.account = account;
	}

	@Override
	public void run() {
		while(account.balance > 0) {
			int money = (int)(Math.random() * 3 + 1) * 100;
			// ����
			account.withdraw(money);
			System.out.println("���� �ܰ� : " + account.balance);
		}
	}
}