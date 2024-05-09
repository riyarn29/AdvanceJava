package in.co.rays.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class TestInsert {
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee1","root","root");
	Statement stmt= conn.createStatement();
	int i = stmt.executeUpdate("insert into marksheet values(6,106,'abc',22,33,44)");
	System.out.println("data inserted="+i);

		
	}

}
