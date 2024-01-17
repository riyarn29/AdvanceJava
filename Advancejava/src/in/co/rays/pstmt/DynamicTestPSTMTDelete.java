package in.co.rays.pstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DynamicTestPSTMTDelete {
public static void main(String[] args)throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee1","root", "root");
PreparedStatement pstmt=conn.prepareStatement("delete from marksheet where id=?");
pstmt.setInt(1,9);
int i=pstmt.executeUpdate();
System.out.println("data deleted ="+i);
}
}
