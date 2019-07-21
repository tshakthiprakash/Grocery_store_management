package DBGUI;
import java.sql.*;
//or you can keep the following instead
//import java.sql.DriverManager;
//import java.sql.Connection;
//import java.sql.SQLException;
 
public class OracleTest {
 
public Connection connectdb() {
 try {
 Class.forName("oracle.jdbc.driver.OracleDriver");
 
	} catch (ClassNotFoundException e) {
 
			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
 
		}
 Connection connection = null;
 
        try {
                  connection = DriverManager.getConnection(
                              "jdbc:oracle:thin:@localhost:1533/cse1.omega.uta.edu", "sxt8113", "Apple123");

           } catch (SQLException e) {
                  return connection;
                  }
                  
		if (connection != null) {
				return connection;
		} else {
			return connection;
		}
}
}

