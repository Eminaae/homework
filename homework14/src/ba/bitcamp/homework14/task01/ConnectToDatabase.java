package ba.bitcamp.homework14.task01;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * ConnectToDatabase class contains Statement connect method to create a connection to a SQLite database
 * file complaint_book.bd which is in the same java project as the class, print some database information. 
 * @author emina.a
 *
 */
public class ConnectToDatabase {
public static String databaseURL ="jdbc:sqlite:book.db";
public static String jdbcDriver = "org.sqlite.JDBC";
public static Connection conn = null;

public static Connection connect() throws ClassNotFoundException {
	try {
		Class.forName("org.sqlite.JDBC");
		System.out.println("Connecting to database...");
		conn = DriverManager.getConnection(databaseURL);
		if (conn != null) {
			System.out.println("Connected to the database.");
			DatabaseMetaData dmd = (DatabaseMetaData) conn.getMetaData();
			System.out.println("Driver name: " + dmd.getDriverName());
			System.out.println("Driver version: " + dmd.getDriverVersion());
			System.out.println("Product name: " + dmd.getDatabaseProductName());
			System.out.println("Product version: " + dmd.getDatabaseProductVersion());
			conn.close();
		}
	} catch (SQLException e) {
		System.out.println("Connection to 'ComplaintBook' database could not be established.");
		System.err.println("Error message: " + e.getMessage());
		System.exit(1);
		}
		return conn;
	}
}