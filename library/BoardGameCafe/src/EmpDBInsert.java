import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class EmpDBInsert {
	EmpDBInsert(String ename, String eauth,String epw){
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "boardgame";
		String password = "1234";
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("삽입문 연결 성공했음 oracle connection success.\n");
			Statement stmt = conn.createStatement();
			
			
			String empnum = "(SELECT NVL(MAX(enum)+1,0) FROM emp)";
			String sql = "INSERT INTO emp VALUES (" + empnum + ",'" + ename+ "','" +eauth + "','" + epw + "')";
			boolean b = stmt.execute(sql);
			if (!b) {
				System.out.println("Insert success.\n");
				JOptionPane.showMessageDialog(null, "성공적으로 등록했습니다.","성공!",JOptionPane.INFORMATION_MESSAGE);
			} else {
				System.out.println("Insert fail.\n");
			}
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver loading fail.");
		} catch (SQLException e) {
			System.out.println("oracle connection fail.");
		}
		
	}
}
