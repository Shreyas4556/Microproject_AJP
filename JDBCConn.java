import java.sql.*;
public class JDBCConn {
	Connection connection;
	Statement stmt;
	public JDBCConn() {
		try {
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/AJP_MicroProject_ATMSys","root","shreyasshinde@4556");
			stmt=connection.createStatement();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
