import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

public class CalculateTimeDBInsert {
	CalculateTimeDBInsert(int tablenum, int cusnum, String date, int timeused, String epw, int sales){
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
			
			
			
			String sql = "INSERT INTO CALCULATETIME VALUES (" + tablenum + ",'" + cusnum+ "','" +d + "','" +timeused+"','" + epw +"','"+sales +"')";
			boolean b = stmt.execute(sql);
			if (!b) {
				System.out.println("Insert success.\n");
				JOptionPane.showMessageDialog(null, "성공적으로 정산했습니다.","성공!",JOptionPane.INFORMATION_MESSAGE);
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
