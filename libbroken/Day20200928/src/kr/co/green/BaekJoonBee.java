package kr.co.green;

import java.util.Scanner;

public class BaekJoonBee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		int inputnum = input.nextInt();
		int temp = 2;
		int result = 0;
		while(true)
		{
			
			if(inputnum ==1)
			{
				System.out.println(result+1);
				
				break;
			}
			
			else if(temp<=inputnum && inputnum<=((temp+=result*6)-1))
			{
				System.out.println(result+1);
				break;
			}
			
			result++;
			
		}
		
	}

}
