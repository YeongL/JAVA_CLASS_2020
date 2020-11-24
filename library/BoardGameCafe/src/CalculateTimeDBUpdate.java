import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CalculateTimeDBUpdate {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "boardgame";
	String password = "1234";
	private Connection con;
	private Statement stmt;
	
	CalculateTimeDBUpdate(String date, String table,String time, String cusnum, String money){
		java.sql.Timestamp d = java.sql.Timestamp.valueOf(date+".0");
		try {
			connDB();
			
			
			String sql = "UPDATE CalculateTime set tablenum = " + table+
					", timeused = "+time+
					", cusnum = "+cusnum+
					", sales = "+money+
					" where datetime = '" + d+"'";
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
