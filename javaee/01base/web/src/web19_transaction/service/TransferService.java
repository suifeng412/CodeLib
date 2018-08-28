package web19_transaction.service;

import java.sql.SQLException;

import web19_transaction.dao.TransferDao;
import web19_transaction.utils.MyDataSourceUtils;


public class TransferService {

	public boolean transfer(String out, String in, double money) {
		
		TransferDao dao = new TransferDao();
		
		boolean isTranferSuccess = true;
		//Connection conn = null;
		try {
			
			//conn = DataSourceUtils.getConnection();
			//conn.setAutoCommit(false);
			
			MyDataSourceUtils.startTransaction();
			
			dao.out(out,money);
			//int i = 1/0;
			dao.in(in,money);
			
		} catch (Exception e) {
			isTranferSuccess = false;
			try {
				MyDataSourceUtils.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally{
			try {
				MyDataSourceUtils.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return isTranferSuccess;
		
	}

}
