package kr.co.green;

import java.util.Scanner;

public class BaekjoonLetters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String words = input.nextLine();
		int temp =0;
		words = words.trim();
		for(int i=0;i<words.length();i++)
		{
			
			if(words.charAt(i) == ' ')
			{
				temp +=1;
				
			}
		}
		if(words.isEmpty())
		{
		
			System.out.println(temp);
		}
		else {
			System.out.println(temp+1);
		
		}
		
		
	}

}
