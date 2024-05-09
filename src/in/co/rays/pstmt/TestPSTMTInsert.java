package in.co.rays.pstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestPSTMTInsert {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee1","root","root");
	PreparedStatement pstmt=conn.prepareStatement("insert into marksheet values(6,106,'preksha',90,90,88)");
	int i=pstmt.executeUpdate();
	System.out.println("data inserted="+i);
	
	}

}
