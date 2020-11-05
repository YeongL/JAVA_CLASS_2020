package kr.co.green;

import java.util.Scanner;

public class BaekJoonFraction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		int num = input.nextInt();
		int temp = num;
		int i =0;
		while(temp>0)
		{
			i++;
			temp-=i;
		}
		temp = temp+i;
		if((i+1)%2 ==0)
		{
			System.out.println((i+1-temp)+"/"+temp);
		}
		else {
			System.out.println(temp+"/"+(i+1-temp));
		}
		
	}

}
