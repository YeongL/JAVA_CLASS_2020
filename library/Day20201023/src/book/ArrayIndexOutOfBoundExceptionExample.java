package book;

public class ArrayIndexOutOfBoundExceptionExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length == 2)
		{
			System.out.println(args[0]);
			System.out.println(args[1]);
		}
		else
		{
			System.out.println("args안에 값 2개 아니다");
		}
	}

}
