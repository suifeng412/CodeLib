package web19_transaction.utils;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtils {

	private static DataSource dataSource = new ComboPooledDataSource();

	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

	public static DataSource getDataSource() {
		return dataSource;
	}
	
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}

	public static Connection getCurrentConnection() throws SQLException {

		Connection con = tl.get();
		if (con == null) {
			con = dataSource.getConnection();
			tl.set(con);
		}
		return con;
	}

	public static void startTransaction() throws SQLException {
		Connection con = getCurrentConnection();
		if (con != null) {
			con.setAutoCommit(false);
		}
	}

	public static void rollback() throws SQLException {
		Connection con = getCurrentConnection();
		if (con != null) {
			con.rollback();
		}
	}

	public static void commitAndRelease() throws SQLException {
		Connection con = getCurrentConnection();
		if (con != null) {
			con.commit(); 
			con.close();
			tl.remove();
		}
	}

	public static void closeConnection() throws SQLException {
		Connection con = getCurrentConnection();
		if (con != null) {
			con.close();
		}
	}

	public static void closeStatement(Statement st) throws SQLException {
		if (st != null) {
			st.close();
		}
	}

	public static void closeResultSet(ResultSet rs) throws SQLException {
		if (rs != null) {
			rs.close();
		}
	}

}

