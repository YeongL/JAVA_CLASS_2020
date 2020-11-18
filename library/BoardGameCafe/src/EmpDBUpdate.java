import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpDBUpdate {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "boardgame";
	String password = "1234";
	private Connection con;
	private Statement stmt;
	EmpDBUpdate(String ename, String eauth){
		
		try {
			connDB();
			
			
			String sql = "UPDATE emp set eauth = '" + eauth+"'" + " where ename = '" + ename+"'";
			stmt.executeQuery(sql);
			stmt.executeQuery("commit");
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
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
