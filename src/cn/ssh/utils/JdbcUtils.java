package cn.ssh.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtils {
	public Connection conn;
	public Connection getConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String uri = "jdbc:mysql://localhost:3306/innovationexperiment";
			String user = "root";
			String password = "";
			conn =  DriverManager.getConnection(uri,user,password);
			System.out.println("link success");
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
}
