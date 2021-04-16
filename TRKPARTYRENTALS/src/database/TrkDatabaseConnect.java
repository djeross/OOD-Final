package database;
import java.sql.*;

/**
 * @author Rodje Ross
 *
 */

public class TrkDatabaseConnect{
	private final String url="jdbc:mysql://localhost:3306/trkdatabase?serverTimezone=UTC";
	private final String username="root";
	private final String password="";
	private Connection dbconn;
	private Statement stmt;
	
	
	public TrkDatabaseConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbconn=DriverManager.getConnection(url, username, password);
			stmt= dbconn.createStatement();
			System.out.println("Successful connection to database");
		}
		catch(Exception e){
			System.out.println(e);	
		}
	}


	/**
	 * 
	 * @return
	 */
	public Statement getStmt() {
		return stmt;
	}
	
	/**
	 * 
	 * @return
	 */
	public Connection getDbconn() {
		return dbconn;
	}
	
	

}


	
	



