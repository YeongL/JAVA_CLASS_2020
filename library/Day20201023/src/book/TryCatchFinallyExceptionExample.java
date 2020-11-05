package book;

public class TryCatchFinallyExceptionExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			String data1 = args[0];
			String data2 = args[1];
			
			int val1 = Integer.parseInt(data1);
			int val2 = Integer.parseInt(data2);
			System.out.println(val1+val2);
			
		}catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("args �ΰ� �̻� �Է��ض�");
		}catch(NumberFormatException e)
		{
			System.out.println("���ڷ� ��ȯ�� �� ����.");
		}finally {
			System.out.println("�ٽ� �����϶�.");
		}
	}

}
