package com.first.app.jdbcconn;

import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcDemo {

	static String sql = null;  
    static jdbcConn db1 = null;  
    static ResultSet ret = null; 
    
	public static void main(String[] args) throws SQLException {
		sql = "select * from booktypes";
		db1 = new jdbcConn(sql);
		try{
			ret = db1.pst.executeQuery();
			while (ret.next()) {
				 String uid = ret.getString(1);  
	             String ufname = ret.getString(2);  
	             System.out.println(uid + "\t" + ufname); 
			}
			ret.close();
			db1.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
