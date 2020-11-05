package kr.co.green;

import java.util.Scanner;

public class BaekJoonStrange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int linenum = input.nextInt();
		
		int x=0;
		int y=0;
		int len =0;
		
		int tempX =0;
		int tempY =0;
		
		for(int i=0;i<linenum;i++)
		{
			x=input.nextInt();
			y=input.nextInt();
			
			if(i!=0)
			{
				if(tempY>=x && tempY<=y)
				{
					len+=(y-tempY);
				}
				else if(tempY<=y)
				{
					len+=(y-x);
				}
				else
				{
					len+=0;
				}
				if(tempY>=y)
				{
					y=tempY;
				}
			}
			else
			{
				len+=y-x;
			}
			
			
			tempX = x;
			tempY = y;
			
		}
		System.out.println(len);
		
	}

}
