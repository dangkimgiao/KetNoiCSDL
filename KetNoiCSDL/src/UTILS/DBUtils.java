package UTILS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
 
 private String db_url = null;
 private String db_user = null;
 private String db_password = null;
 private String db_driver = null;
 private Connection con;
 
 public Connection getConnection(){
	
	 try {
		 
		 db_url = "jdbc:mysql://localhost:3306;databaseNames=test";
		 db_user = "root";
		 db_password = "";
		 db_driver = "";
		 Class.forName(db_driver);
		 System.err.println("Hello");
		 con = DriverManager.getConnection(db_url, db_user, db_password);
	 } catch (ClassNotFoundException e) {
		 System.err.println("Không tìm thấy class.");
	 } catch (SQLException e) {
		 System.err.println("Lỗi kết nối cơ sở dư liệu.");
	 }
	 if (con == null) {
		 throw new NullPointerException("Kết nối không thành công.");
	 }
	 return con;
 }
} 
