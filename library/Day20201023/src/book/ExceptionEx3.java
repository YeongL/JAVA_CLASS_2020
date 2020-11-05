package book;

public class ExceptionEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[1];
		
		try {

			System.out.println(arr[1]);
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println(e);
			e.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println("실행에 문제가있다");
		}
		finally {
			System.out.println("다시실행하라");
		}
	}

}
