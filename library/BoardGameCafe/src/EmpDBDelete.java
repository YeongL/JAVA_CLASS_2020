import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EmpDBDelete {
	EmpDBDelete(String epw){
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "boardgame";
		String password = "1234";
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("������ ���� �������� oracle connection success.\n");
			Statement stmt = conn.createStatement();
			//�����ҰŴϱ� ��������� �� ������Ƿ� ������.
			String sql = "UPDATE CALCULATETIME set epw = '0000'" + " where epw = '" + epw+"'";
			
			stmt.executeQuery(sql);
			stmt.executeQuery("commit");
			
			sql = "DELETE FROM EMP WHERE epw =" +  epw ;
			boolean b = stmt.execute(sql);
			if (!b) {
				System.out.println("Delete success.\n");
				JOptionPane.showMessageDialog(null, "���������� �����߽��ϴ�.","����!",JOptionPane.INFORMATION_MESSAGE);
			} else {
				System.out.println("Delete fail.\n");
			}
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver loading fail.");
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("oracle connection fail.");
		}
		
	}
}