package Sql_Server;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper {
	private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL = "jdbc:sqlserver://10.34.41.145:1433;databaseName=Grade_Manager";
	private static final String USER = "sa";
	private static final String PASSWD = "123456";
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWD);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
	}
	/*
	public static void main(String args[]) {
		Connection con = null;
		con = getConnection();
		if(con!=null) {
			System.out.println("连接成功");
		}else {
			System.out.println("连接失败");
		}
	} */
}
