package kr.co.green;

import java.util.Scanner;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int num1 =input.nextInt();
		int num2 =input.nextInt();
		int num3 =input.nextInt();
		input.close();
		int min = (num1<num2) ? num1:num2;		
		min = (min<num3) ? min:num3;

		System.out.println(min);
		
		}
	


	

}
