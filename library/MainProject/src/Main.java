import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
 
public class Main {
 
    

	public static void main(String[] args)  throws IOException{
        // TODO Auto-generated method stub
    	Scanner input = new Scanner(System.in);
    	System.out.print("Input coin's side... ");
        int coinside = input.nextInt();
        System.out.print("Input coin's number... ");
        int coinnum = input.nextInt();
        input.close();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//¼±¾ð
        StringBuilder sb = new StringBuilder();
        int[] num = new int[(int)Math.pow(coinside, coinnum)];
        int [] ans = new int[coinnum];
        int j = coinnum-1;
        for(int i=0;i<num.length;i++)
        {
        	j = coinnum-1;
        	num[i] = i;
        	while(num[i]>0)
        	{
        		ans[j] = num[i]%coinside;
        		num[i] = num[i]/coinside;
        		j--;
        	}
        	for(int k=0;k<ans.length;k++)
        	{
        		sb.append(ans[k]);
        	}
        	sb.append("\n");
        }
        
        bw.write(sb.toString());
        bw.newLine();
        bw.flush();
        bw.close();

        
    }
    
    
    
    
 
}


