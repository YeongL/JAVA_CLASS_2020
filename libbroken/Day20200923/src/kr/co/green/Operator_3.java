package kr.co.green;

public class Operator_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("논리연산자 || 대소문자 비교");
		char logic1 = 'A';
		String result = "";
		
		result = (logic1>'A' || logic1<'a')?"대문자 A와 소문자 a같다.":"대문자 A와 소문자 a가 아니다.";
		System.out.println(result);
				
	}	

}
