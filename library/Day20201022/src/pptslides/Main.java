package pptslides;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int[]arr = new int[6];
		for(int i=0;i<6;i++)
		{
			arr[i]=0;
		}
		for(int i=0;i<10;i++)
		{
			arr[input.nextInt()-1]++;
		}
		
		for(int i=0;i<6;i++)
		{
			System.out.println((i+1)+" : "+arr[i]);
		}
		
//		bw.write(sb.toString());
//        bw.newLine();
//        bw.flush();
//        bw.close();
		
		
	}

}
