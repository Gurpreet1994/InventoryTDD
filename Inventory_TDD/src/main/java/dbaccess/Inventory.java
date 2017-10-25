package dbaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Inventory {
	private Connection myConn; //connection to db
	private ResultSet myRs;
	private PreparedStatement myPstmt;
	private Statement myStmt;
	private int myEu;
	
	public Inventory() throws Exception{
		String dbUrl = "jdbc:mysql://localhost:3306/Inventory";
		String user = "root";
		String password = "";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		myConn = DriverManager.getConnection(dbUrl,user,password);
		myStmt = myConn.createStatement();
		
		myRs = null;
		myPstmt = null;
		myEu=0;
		
	}
//function

	public String SearchItemByCode(int i) {
		String result="";
		try {
			myPstmt = myConn.prepareStatement("Select a.Item_name "
					                        + "From Product a "
					                        + "Where a.Item_Code = ? ");
			myPstmt.setInt(1, i);;
			myRs = myPstmt.executeQuery();

			while(myRs.next()) {
				result = myRs.getString(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int SearchPricebycode(int i) {
		int result= 0;
		try {
			myPstmt = myConn.prepareStatement("Select a.Item_Price "
					                        + "From Product a "
					                        + "Where a.Item_Code = ? ");
			myPstmt.setInt(1, i);;
			myRs = myPstmt.executeQuery();

			while(myRs.next()) {
				result = myRs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public int Searchstockbycode(int i) {
		int result= 0;
		try {
			myPstmt = myConn.prepareStatement("Select a.Item_Stock "
					                        + "From Product a "
					                        + "Where a.Item_Code = ? ");
			myPstmt.setInt(1, i);;
			myRs = myPstmt.executeQuery();

			while(myRs.next()) {
				result = myRs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
