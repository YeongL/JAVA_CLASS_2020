package JeongOl;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
    	Scanner sc = new Scanner(System.in);
        String word = sc.next();
        word = word.toLowerCase();
        int i = 0;
        while(word.length()>i)
        {
        	if((word.charAt(i)>='0' && word.charAt(i)<='9')||(word.charAt(i)>='a' && word.charAt(i)<='z'))
        	{
        		i++;
        		continue;
        	}
        	else
        	{
        		word = word.replace(String.valueOf(word.charAt(i)), "");
        	}
        	
        }
        System.out.println(word);
    	
        
    }
}
