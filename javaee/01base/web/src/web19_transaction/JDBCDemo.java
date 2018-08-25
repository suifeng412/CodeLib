package web19_transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class JDBCDemo {
public static void main(String[] args) {
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://test", "root", "321");
			
			conn.setAutoCommit(false);
			
			Statement stmt = (Statement) conn.createStatement();
			
			stmt.executeUpdate("update tab1 set user='²âÊÔÐÞ¸Ä' where id=1");
			
			conn.commit();
			
			stmt.close();
			conn.close();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		
		
		
	}
}