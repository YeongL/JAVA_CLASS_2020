package kr.co.green;

public class Logic_Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String id = args[0];
		
		String pw = args[1];
		if(!id.contentEquals("java"))
		{
			System.out.println("우리회원 아니다");
		}
		else if(!pw.equals("java"))
		{
			System.out.println("비밀번호 불일치");
		}
		else {
			System.out.println("환영합니다");
		}
	}

}
