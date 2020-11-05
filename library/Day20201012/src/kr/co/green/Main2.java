package kr.co.green;

import java.io.*;
import java.util.*;

import java.util.Scanner;

public class Main2 {
 
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
    	Scanner input = new Scanner(System.in);
    	
    	for(int i=0;i<3;i++)
    	{
    		for(int j=0;j<5;j++)
    		{
    			char alp = input.next().charAt(0);
    			System.out.print((char)(alp-'A'+'a')+" ");
    		}
    		System.out.print("\n");
    	}
        
        
             
        
        
    }
 
}