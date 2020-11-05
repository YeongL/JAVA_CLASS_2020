package kr.co.green;

public class StringConcatExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1= "JAVA";
		String str2 = "JDK";
		String str3 = str1+str2;
		String str4 = str1+" "+str2;
		
		String str5 = str2 + 3 + 3.0;
		
		String str6 = 3+3.0+str2;
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		System.out.println(str4);
		System.out.println(str5);
		System.out.println(str6);
		
		
	}

}
