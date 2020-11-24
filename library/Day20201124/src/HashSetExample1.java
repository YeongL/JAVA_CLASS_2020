import java.util.*;
public class HashSetExample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> set = new HashSet<String>();
		
		set.add("JAVA");
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("Java");
		set.add("iBATIS");
		
		int size = set.size();
		System.out.println(size);
		
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext())
		{
			String element = iterator.next();
			System.out.println("\t"+element);
		}
		
	}

}
