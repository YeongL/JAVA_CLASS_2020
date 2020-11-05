package book;

public class NullPointerExceptionExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String data = null;
			System.out.println(data.toString());
			
		}catch(NullPointerException e)
		{
			e.printStackTrace();
		}
	}

}
