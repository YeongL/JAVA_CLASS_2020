package kr.co.green;

public class ReferenceCoding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strvar1 = "KSJ";
		String strvar2 = "KSJ";
		if(strvar1 == strvar2)
		{
			System.out.println("참조 같다");
		}
		else {
			System.out.println("참조 다르다");
		}
		
		if(strvar1.equals(strvar2))
		{
			System.out.println("문자열 같다");
		}
		
		String strvar3 = new String("KSJ");
		String strvar4 = new String("KSJ");
		
		if(strvar3 == strvar4)
		{
			System.out.println("참조 같다");
		}
		else {
			System.out.println("참조 다르다");
		}
		
		if(strvar3.equals(strvar4))
		{
			System.out.println("문자열 같다");
		}
	}

}
