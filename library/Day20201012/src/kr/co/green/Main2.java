package kr.co.green;

import java.io.*;
import java.util.*;

import java.util.Scanner;

public class Main2 {
 
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	
    	String[] l1 = bf.readLine().split(" ");
    	String[] l2 = bf.readLine().split(" ");
        
        int x1 = (Integer.parseInt(l1[3])-Integer.parseInt(l1[1]))/(Integer.parseInt(l1[2])-Integer.parseInt(l1[0]));
        
        int y1 = Integer.parseInt(l1[1])-x1*Integer.parseInt(l1[0]);
        
        int x2 = (Integer.parseInt(l1[3])-Integer.parseInt(l1[1]))/(Integer.parseInt(l1[2])-Integer.parseInt(l1[0]));
        
        int y2 = Integer.parseInt(l2[1])-x2*Integer.parseInt(l2[0]);
        int ans = 0;
        if(x1==x2)
        {
        	ans = 0;
        }
        
    }
 
}