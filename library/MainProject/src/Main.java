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
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringBuilder sb = new StringBuilder();
    	
    	//Scanner input = new Scanner(System.in);
        
        int tc = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> minhp = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxhp = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0;i<tc;i++)
        {
        	int num = Integer.parseInt(bf.readLine());
        	if(num>0)
        	{
        		minhp.offer(num);
        	}
        	else if(num<0)
        	{
        		maxhp.offer(num);
        	}
        	else
        	{
        		if(maxhp.isEmpty()&&minhp.isEmpty())
        		{
        			sb.append(0);
        		}
        		else if(maxhp.isEmpty())
        		{
        			sb.append(minhp.poll());
        		}
        		else if(minhp.isEmpty())
        		{
        			sb.append(maxhp.poll());
        		}
        		else if(Math.abs(minhp.peek()) > Math.abs(maxhp.peek()))
        		{
        			sb.append(maxhp.poll());
        		}
        		else if(Math.abs(minhp.peek()) < Math.abs(maxhp.peek()))
        		{
        			sb.append(minhp.poll());
        		}
        		else if(Math.abs(minhp.peek()) == Math.abs(maxhp.peek()))
        		{
        			sb.append(maxhp.poll());
        		}
        		sb.append("\n");
        	}
        	
        	
        	
        	
        }
        
        
        		

        bw.write(sb.toString());
        bw.newLine();
        bw.flush();
        bw.close();
        
    }
    
    
    
    
 
}


