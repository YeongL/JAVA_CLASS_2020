package kr.co.green;

import java.util.Scanner;

public class BaekJoonSmallerX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		int x = input.nextInt();
		
		int[] array = new int[n];
		
		for(int i =0;i<n;i++)
		{
			array[i] = input.nextInt();
		}
		
		int[] result = new int[n];
		for(int i=0;i<n;i++)
		{
			if(array[i]<x && array[i]!=0)
			{
				System.out.print(array[i] + " ");
			}
		}
	}

}
