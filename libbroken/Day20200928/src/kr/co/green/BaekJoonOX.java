package kr.co.green;

import java.util.Scanner;

public class BaekJoonOX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int casenum = input.nextInt();
		String trash = input.nextLine();
		
		for(int i =0;i<casenum;i++)
		{
			String quiz = input.nextLine();
			int result = 0;
			int temp = 0;
			for(int j =0;j<quiz.length();j++)
			{
				if((j!=0) && (quiz.charAt(j) == 'O') && quiz.charAt(j-1) == 'O')
				{
					temp+=1;
					result+=temp;
				}
				else if(quiz.charAt(j) == 'O')
				{
					temp = 1;
					result+=temp;
				}
				
			}
			System.out.println(result);
		}
		
		
		
	}

}
