package book;

public class ExceptionEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 100;
		int res = 0;
		for (int i = 0; i < 10; i++) {
			try {
				res = num / (int) (Math.random() * 10);
				System.out.println(res);
			} catch (ArithmeticException e) {
				System.out.println(0);
			}
		}
	}

}
