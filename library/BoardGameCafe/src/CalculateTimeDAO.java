import java.sql.*;
import java.util.*;
public class CalculateTimeDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	String user = "boardgame";
	String password = "1234";
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	public ArrayList<CalculateTimeVO> list() {
		ArrayList<CalculateTimeVO> list = new ArrayList<CalculateTimeVO>();
		try 
		{
			connDB();
			String query = "SELECT * FROM CALCULATETIME ORDER BY DATETIME";
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				int tablenum = rs.getInt("tablenum");
				int cusnum = rs.getInt("cusnum");
				java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
				String date = sdf.format(rs.getTimestamp("datetime"));
				int timeused = rs.getInt("timeused");
				String epw = rs.getString("epw");
				int sales = rs.getInt("sales");
				CalculateTimeVO data = new CalculateTimeVO(tablenum, cusnum, date, timeused, epw, sales);
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
