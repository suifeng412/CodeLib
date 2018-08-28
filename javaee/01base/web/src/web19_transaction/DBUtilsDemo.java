package web19_transaction;


import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import web19_transaction.utils.DataSourceUtils;


public class DBUtilsDemo {

	public static void main(String[] args) {
		
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			
			//runner.update("update account set money=15000 where name='tom'");
			conn = DataSourceUtils.getConnection();
			
			conn.setAutoCommit(false);
			
			runner.update(conn, "update tab1 set user='测试' where id=2");
			conn.commit();
			
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		
		
		
	}
	
}
