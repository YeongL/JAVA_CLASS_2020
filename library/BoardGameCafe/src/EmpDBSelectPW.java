import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpDBSelectPW {
	boolean isUnique = true;
	String auth;
	int i = 0;
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "boardgame";
	String password = "1234";
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	EmpDBSelectPW(String epw){
		
		try {
			
			
			connDB();
			
			String sql = "SELECT * FROM emp where epw = "+epw;
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				i++;
			}
			if(i == 0)
			{
				isUnique = true;
			}
			else
			{
				isUnique = false;
			}
			auth = rs.getString("eauth");
			
		} catch (Exception e) {
			System.out.println(e);
		} 
		
	}
	public boolean getUnique()
	{
		return this.isUnique;
	}
	
	public String getEauth()
	{
		return this.auth;
	}
	
	
	public void connDB() {
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.");
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			System.out.println("statement create success.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
