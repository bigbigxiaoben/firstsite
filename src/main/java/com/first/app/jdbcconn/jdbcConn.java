package com.first.app.jdbcconn;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class jdbcConn {

	private static final String url = "jdbc:mysql://127.0.0.1/test";
	private static final String name = "com.mysql.jdbc.Driver";
	private static final String user = "root";
	private static final String password = "123456";
	public Connection conn = null;
	public PreparedStatement pst = null;
	public jdbcConn(String sql) throws SQLException{
		 try{   
			 //加载MySql的驱动类   
			 Class.forName(name) ;  
			 conn = DriverManager.getConnection(url, user, password);//获取连接  
	         pst = conn.prepareStatement(sql);//准备执行语句  
		 }catch(ClassNotFoundException e){   
			 System.out.println("找不到驱动程序类 ，加载驱动失败！");   
			 e.printStackTrace() ;   
		 }  
	}
	
	public void close() {  
        try {  
            this.conn.close();  
            this.pst.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  
}
