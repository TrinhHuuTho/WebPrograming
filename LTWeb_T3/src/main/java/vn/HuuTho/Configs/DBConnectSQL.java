package vn.HuuTho.Configs;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnectSQL {
	private final String serverName = "ADMI\\HUUTHO";
	private final String dbName = "LapTrinhWeb";
	private final String portNumber = "1433";
	private final String instance = "";
	private final String userID = "sa";
	private final String password = "12";

	public Connection getConnection() {
	    Connection conn = null;
	    try {
	        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + " ;databaseName=" + dbName;
	        if (instance == null || instance.trim().isEmpty()) {
	            url = "jdbc:sqlserver://" + serverName + " ;databaseName=" + dbName;
	        }
	        conn = DriverManager.getConnection(url, userID, password);

	        if (conn != null) {
	            DatabaseMetaData dm = conn.getMetaData();
	            System.out.println("Driver name:" + dm.getDriverName());
	            System.out.println("Driver version: " + dm.getDriverVersion());
	            System.out.println("Product name: " + dm.getDatabaseProductName());
	            System.out.println("Product version: " + dm.getDatabaseProductVersion());
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return conn;
	}

	
	
	public static void main(String[] args) {
        DBConnectSQL dbConnect = new DBConnectSQL();
        Connection conn = dbConnect.getConnection();
        
        if (conn != null) {
            System.out.println("Kết nối tới cơ sở dữ liệu thành công!");
        } else {
            System.out.println("Kết nối tới cơ sở dữ liệu thất bại.");
        }
    }
	
//	 public void executeQuery(String query) {
//	        Connection conn = null;
//	        Statement stmt = null;
//	        ResultSet rs = null;
//
//	        try {
//	            conn = getConnection();
//	            if (conn != null) {
//	                stmt = (Statement) conn.createStatement();
//	                rs = ((java.sql.Statement) stmt).executeQuery(query);
//
//	                
//	                while (rs.next()) {
//	                    
//	                    int id = rs.getInt("id");
//	                    String name = rs.getString("name");
//	                    String pass = rs.getString("pass");
//	                    String img = rs.getString("img");
//	                    String fullname =rs.getString("fullname");
//	                    // In kết quả ra console
//	                    System.out.println("ID: " + id + ", Name: " + name + "Full name: " + fullname);
//	                }
//	            }
//	        } catch (SQLException ex) {
//	            ex.printStackTrace();
//	        } finally {
//	            try {
//	                if (rs != null) rs.close();
//	                if (stmt != null) ((Connection) stmt).close();
//	                if (conn != null && !conn.isClosed()) conn.close();
//	            } catch (SQLException ex) {
//	                ex.printStackTrace();
//	            }
//	        }
//	    }
//
//	    public static void main(String[] args) {
//	        DBConnectSQL dbConnect = new DBConnectSQL();
//	        String query = "SELECT * FROM GetUser";
//	        dbConnect.executeQuery(query);
//	    }
}


