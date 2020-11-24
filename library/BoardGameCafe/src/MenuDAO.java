import java.sql.*;
import java.util.*;
public class MenuDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	String user = "boardgame";
	String password = "1234";
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	public ArrayList<MenuVO> list() {
		ArrayList<MenuVO> list = new ArrayList<MenuVO>();
		try 
		{
			connDB();
			String query = "SELECT * FROM MENU";
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				
				String mname = rs.getString("mname");
				int mcost = rs.getInt("mcost");
				MenuVO data = new MenuVO(mname, mcost);
				list.add(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
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

