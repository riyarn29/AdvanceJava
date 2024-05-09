package in.co.rays.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTransaction {
public static void main(String[] args) throws Exception {

Connection conn= null;

try {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee1","root", "root");
	
	conn.setAutoCommit(false);
	
	Statement stmt=conn.createStatement();
	int i =stmt.executeUpdate("insert into emp values(13,'yaya',2000,2)");
	i = stmt.executeUpdate("insert into emp values(14,'yaya',2000,2)");
	i= stmt.executeUpdate("insert into emp values(15,'yaya',2000,2)");
	
	System.out.println("data inserted="+i);
	
	conn.commit();
	conn.close();
	
} 
catch (Exception e) {
	conn.rollback();
}
	
}
}
