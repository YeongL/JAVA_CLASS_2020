import java.sql.*;
import java.util.*;
public class EmpDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	String user = "boardgame";
	String password = "1234";
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	public ArrayList<EmpVO> list() {
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		try 
		{
			connDB();
			String query = "SELECT * FROM emp";
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				int empnum = rs.getInt("enum");
				String ename = rs.getString("ename");
				String eauth = rs.getString("eauth");
				String epw = rs.getString("epw");
				EmpVO data = new EmpVO(empnum, ename, eauth, epw);
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


