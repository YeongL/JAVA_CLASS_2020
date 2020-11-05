package book;

public class ThrowsExample {

	public void exceptionMethod() throws Exception
	{
		throw new Exception();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThrowsExample te = new ThrowsExample();
		try {
			te.exceptionMethod();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}

}
