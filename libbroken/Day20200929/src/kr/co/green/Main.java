package kr.co.green;


import java.util.Scanner;

public class Main {
	public static int N = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		input.close();
		
		arr= new char [N][N];
		star(0,0,N, false);
		

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		System.out.print(sb);
		
	}
	public static char[][] arr = new char[N][N];
	public static void star(int x, int y,int n,boolean blank)
	{
		if(blank)
		{
			for(int i=x;i<x+n;i++)
			{
				for(int j=y;j<y+n;j++)
				{
					arr[i][j] = ' ';
				}
			}
			return;
		}
		if(n==1)
		{
			arr[x][y] = '*';
			return;
		}
		
		int size = n/3;
		
		int cnt = 0;
		for(int i=x;i<x+n;i+=size)
		{
			for(int j=y;j<y+n;j+=size)
			{
				cnt ++;
				if(cnt == 5)
				{
					star(i,j,size,true);
				}
				else
				{
					star(i,j,size,false);
				}
			}
		}
		
	}
	
	
	
	

}

