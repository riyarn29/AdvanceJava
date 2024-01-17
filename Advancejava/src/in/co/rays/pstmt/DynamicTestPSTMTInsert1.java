package in.co.rays.pstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DynamicTestPSTMTInsert1 {
public static void main(String[] args) throws Exception {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee1","root", "root");
	PreparedStatement pstmt=conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");
	pstmt.setInt(1,7);
	pstmt.setInt(2,107);
	pstmt.setString(3,"cde");
	pstmt.setInt(4, 88);
	pstmt.setInt(5, 77);
pstmt.setInt(6,66);

int i=pstmt.executeUpdate();
System.out.println("data inserted ="+i);
}
}
