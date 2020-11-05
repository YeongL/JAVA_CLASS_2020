package kr.co.green;

import java.util.Scanner;

public class Exam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int Score = input.nextInt();
		
		if(Score>=90)
		{
			System.out.println("A");
		}
		else if (Score>=80)
		{
			System.out.println("B");
		}
		else if (Score>=70)
		{
			System.out.println("C");
		}
		else if (Score>=60)
		{
			System.out.println("D");
		}
		else
		{
			System.out.println("F");
		}
	}

}
