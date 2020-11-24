
public class ThreadEx8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadEx8_1 th1 = new ThreadEx8_1();
		ThreadEx8_2 th2 = new ThreadEx8_2();
		th1.setPriority(7);
		th2.setPriority(7);
		th1.start();
		th2.start();
	}

}
