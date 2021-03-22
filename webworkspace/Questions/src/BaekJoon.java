import java.util.*;
public class BaekJoon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        int ans = a.length();
        
        for(int i=0; i<=b.length()-a.length(); i++) {
            int cnt = 0;
            for(int j=0; j<a.length(); j++) {
                if(a.charAt(j) != b.charAt(i+j))
                    cnt++;
            }
            ans = Math.min(cnt, ans);
        }
        System.out.println(ans);

	}

}
