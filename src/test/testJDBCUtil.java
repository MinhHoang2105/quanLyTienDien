package test;

import java.sql.Connection;

import database.JDBCUtil;

public class testJDBCUtil {
	public static void main(String[] args) {
		Connection connection = JDBCUtil.getConnection();
		
		JDBCUtil.printInfo(connection);
		
		JDBCUtil.closeConnection(connection);
		
	}
	
	
}