import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CalculateMenuDBInsert {
	CalculateMenuDBInsert(String date, int tablenum, String menulist, String epw , int sales){
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "boardgame";
		String password = "1234";
		
		java.sql.Timestamp d = java.sql.Timestamp.valueOf(date+".0");
		
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("삽입문 연결 성공했음 oracle connection success.\n");
			Statement stmt = conn.createStatement();
			
			
			
			String sql = "INSERT INTO CALCULATEMENU VALUES ('" + d + "'," + tablenum+ ",'" +menulist + "','" + epw +"',"+sales +")";
			boolean b = stmt.execute(sql);
			if (!b) {
				System.out.println("Insert success.\n");
			} else {
				System.out.println("Insert fail.\n");
			}
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver loading fail.");
		} catch (SQLException e) {
			System.out.println("oracle connection fail.");
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}
