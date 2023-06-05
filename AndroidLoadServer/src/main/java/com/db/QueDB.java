package com.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



import oracle.jdbc.OracleConnection;
import oracle.jdbc.pool.OracleDataSource;

public class QueDB {

	final static String DB_URL = "jdbc:oracle:thin:@capstonedb_medium?TNS_ADMIN=C:/wallet/Wallet_capstoneDB";

	final static String DB_USER = "admin";
	final static String DB_PASSWORD = "Rheodml123!!";
	Connection conn = null;
	Statement stmt = null;
    ResultSet rs = null;
	PreparedStatement pstmt;
	PreparedStatement pstmt2;
	int incrementedValue = 0;
	int currentValue = 0;
	
	private static QueDB instance = new QueDB();
    String returns = "a";
	
	public QueDB(){
		
	}
	
	 public static QueDB getInstance() {
	        return instance;
	 }
	
	public void start() throws SQLException {
		
		Properties info = new Properties();
		info.put(OracleConnection.CONNECTION_PROPERTY_USER_NAME, DB_USER);
		info.put(OracleConnection.CONNECTION_PROPERTY_PASSWORD, DB_PASSWORD);
		info.put(OracleConnection.CONNECTION_PROPERTY_DEFAULT_ROW_PREFETCH, 20);

		OracleDataSource ods = new OracleDataSource();
		ods.setURL(DB_URL);
		ods.setConnectionProperties(info);

		// With AutoCloseable, the connection is closed automatically.
		try (OracleConnection connection = (OracleConnection) ods.getConnection()) {
			// Get the JDBC driver name and version
			DatabaseMetaData dbmd = connection.getMetaData();
			System.out.println("Driver Name: " + dbmd.getDriverName());
			System.out.println("Driver Version: " + dbmd.getDriverVersion());
			// Print some connection properties
			System.out.println("Default Row Prefetch Value is: " + connection.getDefaultRowPrefetch());
			System.out.println("Database Username is: " + connection.getUserName());
			System.out.println();
			// Perform a database operation
		}
	}
	
	
	

	/*
	 * Displays first_name and last_name from the employees table.
	 */
	 public String connectionDB(String name, String result) {
	        try {
	        	Class.forName("oracle.jdbc.driver.OracleDriver");
	        	java.util.Date currentDate = new java.util.Date();
	        	java.util.Date utilDate = new java.util.Date();
	        	java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

	        	
	        	

	        	conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	        	
	        	String sql1 = "SELECT 순번 FROM 문진 ORDER BY 순번 DESC";
	        	stmt = conn.createStatement();
	        	rs = stmt.executeQuery(sql1);

	        	if (rs.next()) {
	        	    currentValue = rs.getInt("순번");
	        	}	       	        	
	        	incrementedValue = currentValue + 1;
	        		     		        
	       	    String sql2 = "INSERT INTO 문진 VALUES(?,?,?,?)";
	        	pstmt2 = conn.prepareStatement(sql2);
	        	pstmt2.setInt(1, incrementedValue);
	        	pstmt2.setDate(2, sqlDate);
	        	pstmt2.setString(3, name);
	        	pstmt2.setString(4, result);
	        	pstmt2.executeUpdate();

	        	returns = "문진 데이터 추가 완료";

	        	rs.close();
	        	conn.close();
	        	stmt.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if (pstmt2 != null)try {pstmt2.close();    } catch (SQLException ex) {}
	            if (pstmt != null)try {pstmt.close();} catch (SQLException ex) {}
	            if (conn != null)try {conn.close();    } catch (SQLException ex) {    }
	        }
	        return returns;
	    }
	 
}
